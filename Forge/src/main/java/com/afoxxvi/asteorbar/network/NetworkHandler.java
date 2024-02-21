package com.afoxxvi.asteorbar.network;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.AsteorBarForge;
import com.afoxxvi.asteorbar.overlay.Overlays;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import toughasnails.api.thirst.ThirstHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

public class NetworkHandler {
    private static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(AsteorBar.MOD_ID, "network"), () -> "1.0", s -> true, s -> true
    );


    //avoid sending packets too frequently
    private static final Map<UUID, Float> EXHAUSTION = new HashMap<>();
    private static final Map<UUID, Float> SATURATION = new HashMap<>();

    private static final Map<UUID, Float> TOUGH_AS_NAILS_HYDRATION = new HashMap<>();
    private static final Map<UUID, Float> TOUGH_AS_NAILS_EXHAUSTION = new HashMap<>();

    public static void init() {
        CHANNEL.registerMessage(0, ExhaustionPacket.class, ExhaustionPacket::encode, ExhaustionPacket::decode, ExhaustionPacket::handle);
        CHANNEL.registerMessage(1, SaturationPacket.class, SaturationPacket::encode, SaturationPacket::decode, SaturationPacket::handle);
        CHANNEL.registerMessage(2, EntityAbsorptionPacket.class, EntityAbsorptionPacket::encode, EntityAbsorptionPacket::decode, EntityAbsorptionPacket::handle);
        CHANNEL.registerMessage(3, ActivatePacket.class, ActivatePacket::encode, ActivatePacket::decode, ActivatePacket::handle);

        //third party mod
        CHANNEL.registerMessage(64, ToughAsNailsPacket.class, ToughAsNailsPacket::encode, ToughAsNailsPacket::decode, ToughAsNailsPacket::handle);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.player instanceof ServerPlayer player) {
            var foodStats = player.getFoodData();
            float exhaustionLevel = foodStats.getExhaustionLevel();
            Float oldExhaustion = EXHAUSTION.get(player.getUUID());
            if (oldExhaustion == null || Math.abs(oldExhaustion - exhaustionLevel) >= 0.01F) {
                EXHAUSTION.put(player.getUUID(), exhaustionLevel);
                CHANNEL.sendTo(new ExhaustionPacket(exhaustionLevel), player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
            }
            float saturationLevel = foodStats.getSaturationLevel();
            Float oldSaturation = SATURATION.get(player.getUUID());
            if (oldSaturation == null || Math.abs(oldSaturation - saturationLevel) >= 0.01F) {
                SATURATION.put(player.getUUID(), saturationLevel);
                CHANNEL.sendTo(new SaturationPacket(saturationLevel), player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
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
                    CHANNEL.sendTo(new ToughAsNailsPacket(hydration, exhaustion), player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
                }
            }
        }
    }

    private static Player getPlayer(NetworkEvent.Context context) {
        return context.getDirection() == NetworkDirection.PLAY_TO_SERVER ? context.getSender() : Minecraft.getInstance().player;
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

        public static void handle(ActivatePacket packet, Supplier<NetworkEvent.Context> context) {
            context.get().enqueueWork(() -> {
                AsteorBarForge.LOGGER.info("Received activate packet. Sending back to server.");
                CHANNEL.sendToServer(new ActivatePacket(true));
            });
            context.get().setPacketHandled(true);
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

        public static void handle(SaturationPacket packet, Supplier<NetworkEvent.Context> context) {
            context.get().enqueueWork(() -> {
                var player = getPlayer(context.get());
                if (player != null) {
                    var foodStats = player.getFoodData();
                    foodStats.setSaturation(packet.saturation);
                }
            });
            context.get().setPacketHandled(true);
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

        public static void handle(ExhaustionPacket packet, Supplier<NetworkEvent.Context> context) {
            context.get().enqueueWork(() -> {
                var player = getPlayer(context.get());
                if (player != null) {
                    var foodStats = player.getFoodData();
                    foodStats.setExhaustion(packet.exhaustion);
                }
            });
            context.get().setPacketHandled(true);
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

        public static void handle(EntityAbsorptionPacket packet, Supplier<NetworkEvent.Context> context) {
            context.get().enqueueWork(() -> {
                var player = getPlayer(context.get());
                if (player != null) {
                    var entity = player.level().getEntity(packet.entityId);
                    if (entity instanceof LivingEntity livingEntity) {
                        livingEntity.setAbsorptionAmount(packet.absorption);
                    }
                }
            });
            context.get().setPacketHandled(true);
        }
    }

    public static class ToughAsNailsPacket {
        float hydration;
        float exhaustion;

        public ToughAsNailsPacket(float hydration, float exhaustion) {
            this.hydration = hydration;
            this.exhaustion = exhaustion;
        }

        public static void encode(ToughAsNailsPacket packet, FriendlyByteBuf buffer) {
            buffer.writeFloat(packet.hydration);
            buffer.writeFloat(packet.exhaustion);
        }

        public static ToughAsNailsPacket decode(FriendlyByteBuf buffer) {
            return new ToughAsNailsPacket(buffer.readFloat(), buffer.readFloat());
        }

        public static void handle(ToughAsNailsPacket packet, Supplier<NetworkEvent.Context> context) {
            context.get().enqueueWork(() -> {
                var player = getPlayer(context.get());
                if (player != null && Overlays.toughAsNails) {
                    var thirst = ThirstHelper.getThirst(player);
                    thirst.setHydration(packet.hydration);
                    thirst.setExhaustion(packet.exhaustion);
                }
            });
            context.get().setPacketHandled(true);
        }
    }
}
