package com.afoxxvi.asteorbar.network;


import com.afoxxvi.asteorbar.overlay.Overlays;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import toughasnails.api.thirst.ThirstHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NetworkHandler {
    private static final ResourceLocation CHANNEL = new ResourceLocation("asteorbar", "network");
    private static final int INDEX_EXHAUSTION = 0;
    private static final int INDEX_SATURATION = 1;
    private static final int INDEX_ABSORPTION = 2;
    private static final int INDEX_ACTIVATE = 3;
    private static final int INDEX_TOUGH_AS_NAILS = 64;

    @Environment(EnvType.CLIENT)
    public static void init() {
        ClientPlayNetworking.registerGlobalReceiver(CHANNEL, (client, handler, buf, responseSender) -> {
            byte index = buf.readByte();
            switch (index) {
                case INDEX_EXHAUSTION: {
                    float exhaustion = buf.readFloat();
                    client.execute(() -> {
                        if (client.player != null) client.player.getFoodData().setExhaustion(exhaustion);
                    });
                }
                break;
                case INDEX_SATURATION:
                    float saturation = buf.readFloat();
                    client.execute(() -> {
                        if (client.player != null) client.player.getFoodData().setSaturation(saturation);
                    });
                    break;
                case INDEX_ABSORPTION: {
                    int entityId = buf.readInt();
                    float absorption = buf.readFloat();
                    client.execute(() -> {
                        if (client.level != null) {
                            var entity = client.level.getEntity(entityId);
                            if (entity instanceof LivingEntity livingEntity) {
                                livingEntity.setAbsorptionAmount(absorption);
                            }
                        }
                    });
                }
                break;
                case INDEX_ACTIVATE: {
                    boolean activate = buf.readBoolean();
                    client.execute(() -> {
                        var buffer = Unpooled.buffer(1).writeBoolean(true);
                        ClientPlayNetworking.send(CHANNEL, new FriendlyByteBuf(buffer));
                    });
                }
                break;
                case INDEX_TOUGH_AS_NAILS: {
                    float hydration = buf.readFloat();
                    float exhaustion = buf.readFloat();
                    client.execute(() -> {
                        if (client.player != null) {
                            var thirst = ThirstHelper.getThirst(client.player);
                            thirst.setHydration(hydration);
                            thirst.setExhaustion(exhaustion);
                        }
                    });
                }
            }
        });
    }


    //avoid sending packets too frequently
    private static final Map<UUID, Float> EXHAUSTION = new HashMap<>();
    private static final Map<UUID, Float> SATURATION = new HashMap<>();
    private static final Map<UUID, Float> TOUGH_AS_NAILS_HYDRATION = new HashMap<>();
    private static final Map<UUID, Float> TOUGH_AS_NAILS_EXHAUSTION = new HashMap<>();

    public static void onPlayerTick(ServerPlayer player) {
        var foodStats = player.getFoodData();
        float exhaustionLevel = foodStats.getExhaustionLevel();
        Float oldExhaustion = EXHAUSTION.get(player.getUUID());
        if (oldExhaustion == null || Math.abs(oldExhaustion - exhaustionLevel) >= 0.01F) {
            EXHAUSTION.put(player.getUUID(), exhaustionLevel);
            ByteBuf buf = PacketByteBufs.create().writeByte(INDEX_EXHAUSTION).writeFloat(exhaustionLevel);
            var packet = ServerPlayNetworking.createS2CPacket(CHANNEL, PacketByteBufs.duplicate(buf));
            player.connection.send(packet);
        }
        float saturationLevel = foodStats.getSaturationLevel();
        Float oldSaturation = SATURATION.get(player.getUUID());
        if (oldSaturation == null || Math.abs(oldSaturation - saturationLevel) >= 0.01F) {
            SATURATION.put(player.getUUID(), saturationLevel);
            ByteBuf buf = PacketByteBufs.create().writeByte(INDEX_SATURATION).writeFloat(saturationLevel);
            var packet = ServerPlayNetworking.createS2CPacket(CHANNEL, PacketByteBufs.duplicate(buf));
            player.connection.send(packet);
        }
        if (Overlays.toughAsNails) {
            var thirst = ThirstHelper.getThirst(player);
            boolean send = false;
            float hydration = thirst.getHydration();
            Float oldHydration = TOUGH_AS_NAILS_HYDRATION.get(player.getUUID());
            if (oldHydration == null || Math.abs(oldHydration - hydration) >= 0.01F) {
                TOUGH_AS_NAILS_HYDRATION.put(player.getUUID(), hydration);
                send = true;
            }
            float exhaustion = thirst.getExhaustion();
            Float oldToughAsNailsExhaustion = TOUGH_AS_NAILS_EXHAUSTION.get(player.getUUID());
            if (oldToughAsNailsExhaustion == null || Math.abs(oldToughAsNailsExhaustion - exhaustion) >= 0.01F) {
                TOUGH_AS_NAILS_EXHAUSTION.put(player.getUUID(), exhaustion);
                send = true;
            }
            if (send) {
                ByteBuf buf = PacketByteBufs.create().writeByte(INDEX_TOUGH_AS_NAILS).writeFloat(hydration).writeFloat(exhaustion);
                var packet = ServerPlayNetworking.createS2CPacket(CHANNEL, PacketByteBufs.duplicate(buf));
                player.connection.send(packet);
            }
        }
    }
}
