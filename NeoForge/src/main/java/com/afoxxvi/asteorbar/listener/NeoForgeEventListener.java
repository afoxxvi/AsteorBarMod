package com.afoxxvi.asteorbar.listener;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.key.KeyBinding;
import com.afoxxvi.asteorbar.overlay.NeoforgeGuiRegistry;
import com.afoxxvi.asteorbar.overlay.Overlays;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

@EventBusSubscriber(modid = AsteorBar.MOD_ID, value = Dist.CLIENT)
public class NeoForgeEventListener {
    private static final ResourceLocation THIRST_SATURATION = ResourceLocation.fromNamespaceAndPath("thirst", "saturation_overlay");
    private static final ResourceLocation THIRST_EXHAUSTION = ResourceLocation.fromNamespaceAndPath("thirst", "exhaustion_overlay");

    @SubscribeEvent
    public static void disableVanillaOverlays(RenderGuiLayerEvent.Pre event) {
        if (!AsteorBar.config.enableOverlay()) return;
        ResourceLocation overlay = event.getName();
        if (overlay == VanillaGuiLayers.PLAYER_HEALTH) {
            Overlays.reset();
            NeoforgeGuiRegistry.init();
        }
        if (overlay == VanillaGuiLayers.PLAYER_HEALTH) {
            event.setCanceled(true);
            return;
        }
        if (overlay == VanillaGuiLayers.FOOD_LEVEL) {
            event.setCanceled(true);
            return;
        }
        if (overlay == VanillaGuiLayers.AIR_LEVEL) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.config.overwriteVanillaExperienceBar() && (overlay == VanillaGuiLayers.CONTEXTUAL_INFO_BAR_BACKGROUND || overlay == VanillaGuiLayers.EXPERIENCE_LEVEL)) {
            event.setCanceled(true);
            return;
        }
        if (overlay == VanillaGuiLayers.VEHICLE_HEALTH) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.config.overwriteVanillaArmorBar() && overlay == VanillaGuiLayers.ARMOR_LEVEL) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.compatibility.thirst && AsteorBar.config.hookThirstWasTaken() && (overlay.equals(THIRST_SATURATION) || overlay.equals(THIRST_EXHAUSTION))) {
            event.setCanceled(true);
            return;
        }
    }

    @SubscribeEvent
    public static void handleKeyInput(InputEvent.Key event) {
        KeyBinding.handleKeyInput();
    }
}
