package com.afoxxvi.asteorbar.network;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.AsteorBarForge;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.network.CustomPayloadEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.SimpleChannel;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = AsteorBar.MOD_ID)
public class NetworkHandler {
    private static boolean initialized = false;
    private static final SimpleChannel CHANNEL = ChannelBuilder
            .named(Identifier.fromNamespaceAndPath(AsteorBar.MOD_ID, "network"))
            .networkProtocolVersion(1)
            .optional()
            .acceptedVersions((status, version) -> true)
            .simpleChannel();

    //avoid sending packets too frequently
    private static final Map<UUID, Float> EXHAUSTION = new HashMap<>();
    private static final Map<UUID, Float> SATURATION = new HashMap<>();

    private static final Map<UUID, Float> TOUGH_AS_NAILS_HYDRATION = new HashMap<>();
    private static final Map<UUID, Float> TOUGH_AS_NAILS_EXHAUSTION = new HashMap<>();

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
    public static void onPlayerTick(TickEvent.PlayerTickEvent.Post event) {
        if (event.player() instanceof ServerPlayer player) {
            var foodStats = player.getFoodData();
            float exhaustionLevel = AsteorBar.platformAdapter.getExhaustion(player);
            Float oldExhaustion = EXHAUSTION.get(player.getUUID());
            if (oldExhaustion == null || Math.abs(oldExhaustion - exhaustionLevel) >= 0.01F) {
                EXHAUSTION.put(player.getUUID(), exhaustionLevel);
                CHANNEL.send(new ExhaustionPacket(exhaustionLevel), PacketDistributor.PLAYER.with(player));
            }
            float saturationLevel = foodStats.getSaturationLevel();
            Float oldSaturation = SATURATION.get(player.getUUID());
            if (oldSaturation == null || Math.abs(oldSaturation - saturationLevel) >= 0.01F) {
                SATURATION.put(player.getUUID(), saturationLevel);
                CHANNEL.send(new SaturationPacket(saturationLevel), PacketDistributor.PLAYER.with(player));
            }
            if (!initialized) {
                initialized = true;
                AsteorBar.compatibility.init();
            }
        }
    }

    private static Player getPlayer(CustomPayloadEvent.Context context) {
        return context.isServerSide() ? context.getSender() : Minecraft.getInstance().player;
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

        public static void handle(ActivatePacket packet, CustomPayloadEvent.Context context) {
            context.enqueueWork(() -> {
                AsteorBarForge.LOGGER.info("Received activate packet. Sending back to server.");
                CHANNEL.send(new ActivatePacket(true), PacketDistributor.SERVER.noArg());
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

        public static void handle(SaturationPacket packet, CustomPayloadEvent.Context context) {
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

        public static void handle(ExhaustionPacket packet, CustomPayloadEvent.Context context) {
            context.enqueueWork(() -> {
                var player = getPlayer(context);
                if (player != null) {
                    AsteorBar.platformAdapter.setExhaustion(player, packet.exhaustion);
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

        public static void handle(EntityAbsorptionPacket packet, CustomPayloadEvent.Context context) {
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
