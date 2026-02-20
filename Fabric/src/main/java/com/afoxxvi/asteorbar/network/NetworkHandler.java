package com.afoxxvi.asteorbar.network;

import com.afoxxvi.asteorbar.AsteorBar;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.ClientCommonPacketListener;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import toughasnails.api.thirst.ThirstHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NetworkHandler {
    private static boolean initialized = false;
    private static final Identifier CHANNEL = Identifier.fromNamespaceAndPath("asteorbar", "network");
    private static final int INDEX_EXHAUSTION = 0;
    private static final int INDEX_SATURATION = 1;
    private static final int INDEX_ABSORPTION = 2;
    private static final int INDEX_ACTIVATE = 3;
    private static final int INDEX_TOUGH_AS_NAILS = 64;

    @Environment(EnvType.CLIENT)
    public static void init() {
        PayloadTypeRegistry.playS2C().register(NetworkPayload.ID, NetworkPayload.PAYLOAD_CODEC);
        ClientPlayNetworking.registerGlobalReceiver(NetworkPayload.ID, (payload, context) -> {
            final var buf = payload.buf;
            byte index = buf.readByte();
            final var client = context.client();
            switch (index) {
                case INDEX_EXHAUSTION: {
                    float exhaustion = payload.buf().readFloat();
                    client.execute(() -> {
                        if (client.player != null) {
                            AsteorBar.platformAdapter.setExhaustion(client.player, exhaustion);
                        }
                    });
                }
                break;
                case INDEX_SATURATION:
                    float saturation = payload.buf().readFloat();
                    client.execute(() -> {
                        if (client.player != null) {
                            client.player.getFoodData().setSaturation(saturation);
                        }
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
                        var buffer = Unpooled.buffer(1).writeBoolean(activate);
                        ClientPlayNetworking.send(new NetworkPayload(new FriendlyByteBuf(buffer)));
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
                break;
                default:
                    break;
            }
        });
    }


    //avoid sending packets too frequently
    private static final Map<UUID, Float> EXHAUSTION = new HashMap<>();
    private static final Map<UUID, Float> SATURATION = new HashMap<>();
    private static final Map<UUID, Float> TOUGH_AS_NAILS_HYDRATION = new HashMap<>();
    private static final Map<UUID, Float> TOUGH_AS_NAILS_EXHAUSTION = new HashMap<>();

    public record NetworkPayload(FriendlyByteBuf buf) implements CustomPacketPayload {
        public static final StreamCodec<FriendlyByteBuf, NetworkPayload> PAYLOAD_CODEC = CustomPacketPayload.codec(NetworkPayload::write, NetworkPayload::read);
        public static final CustomPacketPayload.Type<NetworkPayload> ID = new CustomPacketPayload.Type<>(CHANNEL);

        @Override
        public @NotNull Type<? extends CustomPacketPayload> type() {
            return ID;
        }

        public static NetworkPayload read(FriendlyByteBuf friendlyByteBuf) {
            return new NetworkPayload(PacketByteBufs.create().writeBytes(friendlyByteBuf));
        }

        public void write(FriendlyByteBuf friendlyByteBuf) {
            friendlyByteBuf.writeBytes(buf);
        }
    }

    public static void onPlayerTick(ServerPlayer player) {
        var foodStats = player.getFoodData();
        float exhaustionLevel = AsteorBar.platformAdapter.getExhaustion(player);
        Float oldExhaustion = EXHAUSTION.get(player.getUUID());
        if (oldExhaustion == null || Math.abs(oldExhaustion - exhaustionLevel) >= 0.01F) {
            EXHAUSTION.put(player.getUUID(), exhaustionLevel);
            ByteBuf buf = PacketByteBufs.create().writeByte(INDEX_EXHAUSTION).writeFloat(exhaustionLevel);
            ServerPlayNetworking.send(player, new NetworkPayload(PacketByteBufs.duplicate(buf)));
        }
        float saturationLevel = foodStats.getSaturationLevel();
        Float oldSaturation = SATURATION.get(player.getUUID());
        if (oldSaturation == null || Math.abs(oldSaturation - saturationLevel) >= 0.01F) {
            SATURATION.put(player.getUUID(), saturationLevel);
            ByteBuf buf = PacketByteBufs.create().writeByte(INDEX_SATURATION).writeFloat(saturationLevel);
            ServerPlayNetworking.send(player, new NetworkPayload(PacketByteBufs.duplicate(buf)));
        }
        if (!initialized) {
            initialized = true;
            AsteorBar.compatibility.init();
        }
        if (AsteorBar.compatibility.toughAsNails) {
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
                ServerPlayNetworking.send(player, new NetworkPayload(PacketByteBufs.duplicate(buf)));
            }
        }
    }

    public static Packet<ClientCommonPacketListener> createAbsorptionPacket(int entityId, float absorption) {
        ByteBuf buf = PacketByteBufs.create().writeByte(INDEX_ABSORPTION).writeInt(entityId).writeFloat(absorption);
        return ServerPlayNetworking.createS2CPacket(new NetworkPayload(PacketByteBufs.duplicate(buf)));
    }
}
