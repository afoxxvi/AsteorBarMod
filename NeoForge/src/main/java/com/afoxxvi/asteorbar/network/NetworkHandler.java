package com.afoxxvi.asteorbar.network;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.AsteorBarNeoForge;
import com.afoxxvi.asteorbar.overlay.Overlays;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;
import org.jetbrains.annotations.NotNull;
import toughasnails.api.thirst.ThirstHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NetworkHandler {
    //avoid sending packets too frequently
    private static final Map<UUID, Float> EXHAUSTION = new HashMap<>();
    private static final Map<UUID, Float> SATURATION = new HashMap<>();

    private static final Map<UUID, Float> TOUGH_AS_NAILS_HYDRATION = new HashMap<>();
    private static final Map<UUID, Float> TOUGH_AS_NAILS_EXHAUSTION = new HashMap<>();

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlerEvent event) {
        final IPayloadRegistrar registrar = event.registrar(AsteorBar.MOD_ID);
        registrar.play(ActivatePacket.ID, ActivatePacket::new, ActivatePacket::handle);
        registrar.play(SaturationPacket.ID, SaturationPacket::new, SaturationPacket::handle);
        registrar.play(ExhaustionPacket.ID, ExhaustionPacket::new, ExhaustionPacket::handle);
        registrar.play(EntityAbsorptionPacket.ID, EntityAbsorptionPacket::new, EntityAbsorptionPacket::handle);
        registrar.play(ToughAsNailsPacket.ID, ToughAsNailsPacket::new, ToughAsNailsPacket::handle);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.player instanceof ServerPlayer player) {
            var foodStats = player.getFoodData();
            float exhaustionLevel = foodStats.getExhaustionLevel();
            Float oldExhaustion = EXHAUSTION.get(player.getUUID());
            if (oldExhaustion == null || Math.abs(oldExhaustion - exhaustionLevel) >= 0.01F) {
                EXHAUSTION.put(player.getUUID(), exhaustionLevel);
                PacketDistributor.PLAYER.with(player).send(new ExhaustionPacket(exhaustionLevel));
            }
            float saturationLevel = foodStats.getSaturationLevel();
            Float oldSaturation = SATURATION.get(player.getUUID());
            if (oldSaturation == null || Math.abs(oldSaturation - saturationLevel) >= 0.01F) {
                SATURATION.put(player.getUUID(), saturationLevel);
                PacketDistributor.PLAYER.with(player).send(new SaturationPacket(saturationLevel));
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
                    PacketDistributor.PLAYER.with(player).send(new ToughAsNailsPacket(hydration, exhaustion));
                }
            }
        }
    }

    private static Player getPlayer(PlayPayloadContext context) {
        return context.player().orElse(Minecraft.getInstance().player);
    }

    public static class ActivatePacket implements CustomPacketPayload {
        public static final ResourceLocation ID = new ResourceLocation(AsteorBar.MOD_ID, "activate");

        public boolean activate;

        public ActivatePacket(boolean activate) {
            this.activate = activate;
        }

        public ActivatePacket(final FriendlyByteBuf buffer) {
            this.activate = buffer.readBoolean();
        }

        public static void handle(ActivatePacket packet, PlayPayloadContext context) {
            context.workHandler().submitAsync(() -> {
                AsteorBarNeoForge.LOGGER.info("Received activate packet. Sending back to server.");
                PacketDistributor.SERVER.noArg().send(new ActivatePacket(true));
            });
        }

        @Override
        public void write(FriendlyByteBuf friendlyByteBuf) {
            friendlyByteBuf.writeBoolean(activate);
        }

        @Override
        public @NotNull ResourceLocation id() {
            return ID;
        }
    }

    public static class SaturationPacket implements CustomPacketPayload {
        public static final ResourceLocation ID = new ResourceLocation(AsteorBar.MOD_ID, "saturation");
        public float saturation;

        public SaturationPacket(float saturation) {
            this.saturation = saturation;
        }

        public SaturationPacket(final FriendlyByteBuf buffer) {
            this.saturation = buffer.readFloat();
        }

        public static void handle(SaturationPacket packet, PlayPayloadContext context) {
            context.workHandler().submitAsync(() -> {
                var player = getPlayer(context);
                if (player != null) {
                    var foodStats = player.getFoodData();
                    foodStats.setSaturation(packet.saturation);
                }
            });
        }

        @Override
        public void write(FriendlyByteBuf friendlyByteBuf) {
            friendlyByteBuf.writeFloat(saturation);
        }

        @Override
        public @NotNull ResourceLocation id() {
            return ID;
        }
    }

    public static class ExhaustionPacket implements CustomPacketPayload {
        public static final ResourceLocation ID = new ResourceLocation(AsteorBar.MOD_ID, "exhaustion");
        public float exhaustion;

        public ExhaustionPacket(float exhaustion) {
            this.exhaustion = exhaustion;
        }

        public ExhaustionPacket(final FriendlyByteBuf buffer) {
            this.exhaustion = buffer.readFloat();
        }

        public static void handle(ExhaustionPacket packet, PlayPayloadContext context) {
            context.workHandler().submitAsync(() -> {
                var player = getPlayer(context);
                if (player != null) {
                    var foodStats = player.getFoodData();
                    foodStats.setExhaustion(packet.exhaustion);
                }
            });
        }


        @Override
        public void write(FriendlyByteBuf friendlyByteBuf) {
            friendlyByteBuf.writeFloat(exhaustion);
        }

        @Override
        public @NotNull ResourceLocation id() {
            return ID;
        }
    }

    public static class EntityAbsorptionPacket implements CustomPacketPayload {
        public static final ResourceLocation ID = new ResourceLocation(AsteorBar.MOD_ID, "entity_absorption");
        public int entityId;
        public float absorption;

        public EntityAbsorptionPacket(int entityId, float absorption) {
            this.entityId = entityId;
            this.absorption = absorption;
        }

        public EntityAbsorptionPacket(final FriendlyByteBuf buffer) {
            this.entityId = buffer.readInt();
            this.absorption = buffer.readFloat();
        }

        public static void handle(EntityAbsorptionPacket packet, PlayPayloadContext context) {
            context.workHandler().submitAsync(() -> {
                var player = getPlayer(context);
                if (player != null) {
                    var entity = player.level().getEntity(packet.entityId);
                    if (entity instanceof LivingEntity livingEntity) {
                        livingEntity.setAbsorptionAmount(packet.absorption);
                    }
                }
            });
        }

        @Override
        public void write(FriendlyByteBuf friendlyByteBuf) {
            friendlyByteBuf.writeInt(entityId);
            friendlyByteBuf.writeFloat(absorption);
        }

        @Override
        public @NotNull ResourceLocation id() {
            return ID;
        }
    }

    public static class ToughAsNailsPacket implements CustomPacketPayload {
        public static final ResourceLocation ID = new ResourceLocation(AsteorBar.MOD_ID, "tough_as_nails");
        public float hydration;
        public float exhaustion;

        public ToughAsNailsPacket(float hydration, float exhaustion) {
            this.hydration = hydration;
            this.exhaustion = exhaustion;
        }

        public ToughAsNailsPacket(final FriendlyByteBuf buffer) {
            this.hydration = buffer.readFloat();
            this.exhaustion = buffer.readFloat();
        }

        public static void handle(ToughAsNailsPacket packet, PlayPayloadContext context) {
            context.workHandler().submitAsync(() -> {
                var player = getPlayer(context);
                if (player != null) {
                    var thirst = ThirstHelper.getThirst(player);
                    thirst.setHydration(packet.hydration);
                    thirst.setExhaustion(packet.exhaustion);
                }
            });
        }

        @Override
        public void write(FriendlyByteBuf friendlyByteBuf) {
            friendlyByteBuf.writeFloat(hydration);
            friendlyByteBuf.writeFloat(exhaustion);
        }

        @Override
        public @NotNull ResourceLocation id() {
            return ID;
        }
    }
}
