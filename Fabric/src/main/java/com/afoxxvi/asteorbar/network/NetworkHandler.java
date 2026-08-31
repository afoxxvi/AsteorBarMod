package com.afoxxvi.asteorbar.network;

import com.afoxxvi.asteorbar.AsteorBar;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.FriendlyByteBufs;
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

    public static void init() {
        PayloadTypeRegistry.clientboundPlay().register(NetworkPayload.ID, NetworkPayload.PAYLOAD_CODEC);
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
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
                default:
                    break;
            }
        });
    }


    //avoid sending packets too frequently
    private static final Map<UUID, Float> EXHAUSTION = new HashMap<>();
    private static final Map<UUID, Float> SATURATION = new HashMap<>();

    public record NetworkPayload(FriendlyByteBuf buf) implements CustomPacketPayload {
        public static final StreamCodec<FriendlyByteBuf, NetworkPayload> PAYLOAD_CODEC = CustomPacketPayload.codec(NetworkPayload::write, NetworkPayload::read);
        public static final CustomPacketPayload.Type<NetworkPayload> ID = new CustomPacketPayload.Type<>(CHANNEL);

        @Override
        public @NotNull Type<? extends CustomPacketPayload> type() {
            return ID;
        }

        public static NetworkPayload read(FriendlyByteBuf friendlyByteBuf) {
            return new NetworkPayload(FriendlyByteBufs.create().writeBytes(friendlyByteBuf));
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
            ByteBuf buf = FriendlyByteBufs.create().writeByte(INDEX_EXHAUSTION).writeFloat(exhaustionLevel);
            ServerPlayNetworking.send(player, new NetworkPayload(FriendlyByteBufs.duplicate(buf)));
        }
        float saturationLevel = foodStats.getSaturationLevel();
        Float oldSaturation = SATURATION.get(player.getUUID());
        if (oldSaturation == null || Math.abs(oldSaturation - saturationLevel) >= 0.01F) {
            SATURATION.put(player.getUUID(), saturationLevel);
            ByteBuf buf = FriendlyByteBufs.create().writeByte(INDEX_SATURATION).writeFloat(saturationLevel);
            ServerPlayNetworking.send(player, new NetworkPayload(FriendlyByteBufs.duplicate(buf)));
        }
        if (!initialized) {
            initialized = true;
            AsteorBar.compatibility.init();
        }
    }

    public static Packet<ClientCommonPacketListener> createAbsorptionPacket(int entityId, float absorption) {
        ByteBuf buf = FriendlyByteBufs.create().writeByte(INDEX_ABSORPTION).writeInt(entityId).writeFloat(absorption);
        return ServerPlayNetworking.createClientboundPacket(new NetworkPayload(FriendlyByteBufs.duplicate(buf)));
    }
}
