package com.afoxxvi.asteorbar.listener;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.key.KeyBinding;
import com.afoxxvi.asteorbar.overlay.ForgeGuiRegistry;
import com.afoxxvi.asteorbar.overlay.Overlays;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.NamedGuiOverlay;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AsteorBar.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeEventListener {
    public static final ResourceLocation PARCOOL_STAMINA = new ResourceLocation("parcool", "hud.stamina.host");

    @SubscribeEvent
    public static void disableVanillaOverlays(RenderGuiOverlayEvent.Pre event) {
        if (!AsteorBar.config.enableOverlay()) return;
        NamedGuiOverlay overlay = event.getOverlay();
        if (overlay == VanillaGuiOverlay.VIGNETTE.type()) {
            Overlays.reset();
            ForgeGuiRegistry.init();
        }
        if (overlay == VanillaGuiOverlay.PLAYER_HEALTH.type()) {
            event.setCanceled(true);
            return;
        }
        if (overlay == VanillaGuiOverlay.FOOD_LEVEL.type()) {
            event.setCanceled(true);
            return;
        }
        if (overlay == VanillaGuiOverlay.AIR_LEVEL.type()) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.config.overwriteVanillaExperienceBar() && overlay == VanillaGuiOverlay.EXPERIENCE_BAR.type()) {
            event.setCanceled(true);
            return;
        }
        if (overlay == VanillaGuiOverlay.MOUNT_HEALTH.type()) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.config.overwriteVanillaArmorBar() && overlay == VanillaGuiOverlay.ARMOR_LEVEL.type()) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.compatibility.parcool && AsteorBar.config.hookParcool() && overlay.id().equals(PARCOOL_STAMINA)) {
            event.setCanceled(true);
            return;
        }
    }

    @SubscribeEvent
    public static void handleKeyInput(InputEvent.Key event) {
        KeyBinding.handleKeyInput();
    }
}
