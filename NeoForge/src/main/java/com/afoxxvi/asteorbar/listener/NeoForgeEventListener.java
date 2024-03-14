package com.afoxxvi.asteorbar.listener;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.key.KeyBinding;
import com.afoxxvi.asteorbar.overlay.Overlays;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RenderGuiOverlayEvent;
import net.neoforged.neoforge.client.gui.overlay.NamedGuiOverlay;
import net.neoforged.neoforge.client.gui.overlay.VanillaGuiOverlay;
import net.neoforged.neoforge.event.TickEvent;

@Mod.EventBusSubscriber(modid = AsteorBar.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class NeoForgeEventListener {
    public static long tickCount = 0L;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (!Minecraft.getInstance().isPaused()) {
            tickCount++;
        }
    }

    @SubscribeEvent
    public static void disableVanillaOverlays(RenderGuiOverlayEvent.Pre event) {
        if (!AsteorBar.config.enableOverlay()) return;
        NamedGuiOverlay overlay = event.getOverlay();
        if (overlay == VanillaGuiOverlay.VIGNETTE.type()) {
            Overlays.reset();
        }
        if (overlay == VanillaGuiOverlay.PLAYER_HEALTH.type()
                || overlay == VanillaGuiOverlay.FOOD_LEVEL.type()
                || overlay == VanillaGuiOverlay.AIR_LEVEL.type()
                || (AsteorBar.config.overwriteVanillaExperienceBar() && overlay == VanillaGuiOverlay.EXPERIENCE_BAR.type())
                || overlay == VanillaGuiOverlay.MOUNT_HEALTH.type()
                || (AsteorBar.config.overwriteVanillaArmorBar() && overlay == VanillaGuiOverlay.ARMOR_LEVEL.type())
                || overlay.id().getNamespace().equals("lightshield")
        ) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void handleKeyInput(InputEvent.Key event) {
        KeyBinding.handleKeyInput();
    }
}
