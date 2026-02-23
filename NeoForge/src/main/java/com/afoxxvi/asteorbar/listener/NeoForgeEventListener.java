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

@EventBusSubscriber(modid = AsteorBar.MOD_ID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class NeoForgeEventListener {
    private static final ResourceLocation THIRST_SATURATION = ResourceLocation.fromNamespaceAndPath("thirst", "saturation_overlay");
    private static final ResourceLocation THIRST_EXHAUSTION = ResourceLocation.fromNamespaceAndPath("thirst", "exhaustion_overlay");
    private static final ResourceLocation VAMPIRISM_BLOOD = ResourceLocation.fromNamespaceAndPath("vampirism", "blood_bar");
    private static final ResourceLocation IRONS_SPELLBOOKS_MANA = ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "mana_overlay");
    private static final ResourceLocation LSO_HEALTH = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "health_overhaul");
    private static final ResourceLocation LSO_THIRST = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "thirst");
    private static final ResourceLocation LSO_COLD_HUNGER = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "cold_hunger");

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
        if (AsteorBar.config.overwriteVanillaExperienceBar() && (overlay == VanillaGuiLayers.EXPERIENCE_BAR || overlay == VanillaGuiLayers.EXPERIENCE_LEVEL)) {
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
        if (AsteorBar.compatibility.vampirism && AsteorBar.config.hookVampirism() && overlay.equals(VAMPIRISM_BLOOD)) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.compatibility.ironsSpellbooks && AsteorBar.config.hookIronsSpellbooks() && overlay.equals(IRONS_SPELLBOOKS_MANA)) {
            event.setCanceled(true);
        }
        if (AsteorBar.compatibility.legendarySurvivalOverhaul && AsteorBar.config.hookLegendarySurvivalOverhaul() && (overlay.equals(LSO_HEALTH) || overlay.equals(LSO_THIRST) || overlay.equals(LSO_COLD_HUNGER))) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void handleKeyInput(InputEvent.Key event) {
        KeyBinding.handleKeyInput();
    }
}
