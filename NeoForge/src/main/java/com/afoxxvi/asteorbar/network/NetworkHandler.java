package com.afoxxvi.asteorbar.network;

import com.afoxxvi.asteorbar.AsteorBar;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.jetbrains.annotations.NotNull;
import toughasnails.api.thirst.ThirstHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NetworkHandler {
    private static boolean initialized = false;
    //avoid sending packets too frequently
    private static final ResourceLocation CHANNEL = ResourceLocation.fromNamespaceAndPath("asteorbar", "network");
    private static final byte INDEX_EXHAUSTION = 0;
    private static final byte INDEX_SATURATION = 1;
    private static final byte INDEX_ABSORPTION = 2;
    private static final byte INDEX_ACTIVATE = 3;
    private static final byte INDEX_TOUGH_AS_NAILS = 64;
    private static final Map<UUID, Float> EXHAUSTION = new HashMap<>();
    private static final Map<UUID, Float> SATURATION = new HashMap<>();

    private static final Map<UUID, Float> TOUGH_AS_NAILS_HYDRATION = new HashMap<>();
    private static final Map<UUID, Float> TOUGH_AS_NAILS_EXHAUSTION = new HashMap<>();

    public record NetworkPayload(byte index, float f1, float f2, int i1) implements CustomPacketPayload {
        public static final StreamCodec<FriendlyByteBuf, NetworkPayload> PAYLOAD_CODEC = CustomPacketPayload.codec(NetworkPayload::write, NetworkPayload::read);
        public static final CustomPacketPayload.Type<NetworkPayload> ID = new CustomPacketPayload.Type<>(CHANNEL);

        @Override
        public @NotNull Type<? extends CustomPacketPayload> type() {
            return ID;
        }

        public static NetworkPayload read(FriendlyByteBuf friendlyByteBuf) {
            return new NetworkPayload(friendlyByteBuf.readByte(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readInt());
        }

        public void write(FriendlyByteBuf friendlyByteBuf) {
            friendlyByteBuf.writeByte(index).writeFloat(f1).writeFloat(f2).writeInt(i1);
        }
    }

    public static void handle(NetworkPayload payload, IPayloadContext context) {
        byte index = payload.index;
        switch (index) {
            case INDEX_EXHAUSTION: {
                float exhaustion = payload.f1;
                context.enqueueWork(() -> AsteorBar.platformAdapter.setExhaustion(context.player(), exhaustion));
            }
            break;
            case INDEX_SATURATION:
                float saturation = payload.f1;
                context.enqueueWork(() -> context.player().getFoodData().setSaturation(saturation));
                break;
            case INDEX_ABSORPTION: {
                int entityId = payload.i1;
                float absorption = payload.f1;
                context.enqueueWork(() -> {
                    var entity = context.player().level().getEntity(entityId);
                    if (entity instanceof LivingEntity livingEntity) {
                        livingEntity.setAbsorptionAmount(absorption);
                    }
                });
            }
            break;
            case INDEX_ACTIVATE: {
                boolean activate = payload.i1 != 0;
                context.enqueueWork(() -> PacketDistributor.sendToServer(new NetworkPayload(INDEX_ACTIVATE, 0F, 0F, activate ? 1 : 0)));
            }
            break;
            case INDEX_TOUGH_AS_NAILS: {
                float hydration = payload.f1;
                float exhaustion = payload.f2;
                context.enqueueWork(() -> {
                    var thirst = ThirstHelper.getThirst(context.player());
                    thirst.setHydration(hydration);
                    thirst.setExhaustion(exhaustion);
                });
            }
            break;
            default:
                break;
        }
    }

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(AsteorBar.MOD_ID).optional();
        registrar.playToClient(NetworkPayload.ID, NetworkPayload.PAYLOAD_CODEC, NetworkHandler::handle);
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Pre event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            var foodStats = player.getFoodData();
            float exhaustionLevel = AsteorBar.platformAdapter.getExhaustion(player);
            Float oldExhaustion = EXHAUSTION.get(player.getUUID());
            if (oldExhaustion == null || Math.abs(oldExhaustion - exhaustionLevel) >= 0.01F) {
                EXHAUSTION.put(player.getUUID(), exhaustionLevel);
                PacketDistributor.sendToPlayer(player, new NetworkPayload(INDEX_EXHAUSTION, exhaustionLevel, 0F, 0));
            }
            float saturationLevel = foodStats.getSaturationLevel();
            Float oldSaturation = SATURATION.get(player.getUUID());
            if (oldSaturation == null || Math.abs(oldSaturation - saturationLevel) >= 0.01F) {
                SATURATION.put(player.getUUID(), saturationLevel);
                PacketDistributor.sendToPlayer(player, new NetworkPayload(INDEX_SATURATION, saturationLevel, 0F, 0));
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
                    PacketDistributor.sendToPlayer(player, new NetworkPayload(INDEX_TOUGH_AS_NAILS, hydration, exhaustion, 0));
                }
            }
        }
    }
}
