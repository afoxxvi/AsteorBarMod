package com.afoxxvi.asteorbar.network;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.AsteorBarNeoForge;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.LogicalSide;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.network.NetworkEvent;
import net.neoforged.neoforge.network.NetworkRegistry;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.simple.SimpleChannel;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NetworkHandler {
    private static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(AsteorBar.MOD_ID, "network"))
            .networkProtocolVersion(() -> "1")
            .clientAcceptedVersions(s -> true)
            .serverAcceptedVersions(s -> true)
            .simpleChannel();

    //avoid sending packets too frequently
    private static final Map<UUID, Float> EXHAUSTION = new HashMap<>();
    private static final Map<UUID, Float> SATURATION = new HashMap<>();

    public static void init() {
        CHANNEL.messageBuilder(ExhaustionPacket.class, 0)
                .encoder(ExhaustionPacket::encode)
                .decoder(ExhaustionPacket::decode)
                .consumerNetworkThread(ExhaustionPacket::handle)
                .add();
        CHANNEL.messageBuilder(SaturationPacket.class, 1)
                .encoder(SaturationPacket::encode)
                .decoder(SaturationPacket::decode)
                .consumerNetworkThread(SaturationPacket::handle)
                .add();
        CHANNEL.messageBuilder(EntityAbsorptionPacket.class, 2)
                .encoder(EntityAbsorptionPacket::encode)
                .decoder(EntityAbsorptionPacket::decode)
                .consumerNetworkThread(EntityAbsorptionPacket::handle)
                .add();
        CHANNEL.messageBuilder(ActivatePacket.class, 3)
                .encoder(ActivatePacket::encode)
                .decoder(ActivatePacket::decode)
                .consumerNetworkThread(ActivatePacket::handle)
                .add();
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.player instanceof ServerPlayer player) {
            var foodStats = player.getFoodData();
            float exhaustionLevel = foodStats.getExhaustionLevel();
            Float oldExhaustion = EXHAUSTION.get(player.getUUID());
            if (oldExhaustion == null || Math.abs(oldExhaustion - exhaustionLevel) >= 0.01F) {
                EXHAUSTION.put(player.getUUID(), exhaustionLevel);
                CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), new ExhaustionPacket(exhaustionLevel));
            }
            float saturationLevel = foodStats.getSaturationLevel();
            Float oldSaturation = SATURATION.get(player.getUUID());
            if (oldSaturation == null || Math.abs(oldSaturation - saturationLevel) >= 0.01F) {
                SATURATION.put(player.getUUID(), saturationLevel);
                CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), new SaturationPacket(saturationLevel));
            }
        }
    }

    private static Player getPlayer(NetworkEvent.Context context) {
        return context.getDirection().getReceptionSide() == LogicalSide.SERVER ? context.getSender() : Minecraft.getInstance().player;
    }

    public static class ActivatePacket {
        public boolean activate;

        public ActivatePacket(boolean activate) {
            this.activate = activate;
        }

        public static void encode(ActivatePacket packet, FriendlyByteBuf buffer) {
            buffer.writeBoolean(packet.activate);
        }

        public static ActivatePacket decode(FriendlyByteBuf buffer) {
            return new ActivatePacket(buffer.readBoolean());
        }

        public static void handle(ActivatePacket packet, NetworkEvent.Context context) {
            context.enqueueWork(() -> {
                AsteorBarNeoForge.LOGGER.info("Received activate packet. Sending back to server.");
                CHANNEL.send(PacketDistributor.SERVER.noArg(), new ActivatePacket(true));
            });
            context.setPacketHandled(true);
        }
    }

    public static class SaturationPacket {
        public float saturation;

        public SaturationPacket(float saturation) {
            this.saturation = saturation;
        }

        public static void encode(SaturationPacket packet, FriendlyByteBuf buffer) {
            buffer.writeFloat(packet.saturation);
        }

        public static SaturationPacket decode(FriendlyByteBuf buffer) {
            return new SaturationPacket(buffer.readFloat());
        }

        public static void handle(SaturationPacket packet, NetworkEvent.Context context) {
            context.enqueueWork(() -> {
                var player = getPlayer(context);
                if (player != null) {
                    var foodStats = player.getFoodData();
                    foodStats.setSaturation(packet.saturation);
                }
            });
            context.setPacketHandled(true);
        }
    }

    public static class ExhaustionPacket {
        public float exhaustion;

        public ExhaustionPacket(float exhaustion) {
            this.exhaustion = exhaustion;
        }

        public static void encode(ExhaustionPacket packet, FriendlyByteBuf buffer) {
            buffer.writeFloat(packet.exhaustion);
        }

        public static ExhaustionPacket decode(FriendlyByteBuf buffer) {
            return new ExhaustionPacket(buffer.readFloat());
        }

        public static void handle(ExhaustionPacket packet, NetworkEvent.Context context) {
            context.enqueueWork(() -> {
                var player = getPlayer(context);
                if (player != null) {
                    var foodStats = player.getFoodData();
                    foodStats.setExhaustion(packet.exhaustion);
                }
            });
            context.setPacketHandled(true);
        }
    }

    public static class EntityAbsorptionPacket {
        public int entityId;
        public float absorption;

        public EntityAbsorptionPacket(int entityId, float absorption) {
            this.entityId = entityId;
            this.absorption = absorption;
        }

        public static void encode(EntityAbsorptionPacket packet, FriendlyByteBuf buffer) {
            buffer.writeInt(packet.entityId);
            buffer.writeFloat(packet.absorption);
        }

        public static EntityAbsorptionPacket decode(FriendlyByteBuf buffer) {
            return new EntityAbsorptionPacket(buffer.readInt(), buffer.readFloat());
        }

        public static void handle(EntityAbsorptionPacket packet, NetworkEvent.Context context) {
            context.enqueueWork(() -> {
                var player = getPlayer(context);
                if (player != null) {
                    var entity = player.level().getEntity(packet.entityId);
                    if (entity instanceof LivingEntity livingEntity) {
                        livingEntity.setAbsorptionAmount(packet.absorption);
                    }
                }
            });
            context.setPacketHandled(true);
        }
    }
}
