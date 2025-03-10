package com.afoxxvi.asteorbar.listener;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.AsteorBarNeoForge;
import com.afoxxvi.asteorbar.key.KeyBinding;
import com.afoxxvi.asteorbar.overlay.NeoForgeRenderGui;
import com.afoxxvi.asteorbar.overlay.Overlays;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterGuiOverlaysEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.gui.overlay.VanillaGuiOverlay;

@Mod.EventBusSubscriber(modid = AsteorBar.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventListener {
    @SubscribeEvent
    public static void registerOverlay(RegisterGuiOverlaysEvent event) {
        AsteorBarNeoForge.LOGGER.info("Registering Overlays");
        event.registerBelow(VanillaGuiOverlay.PLAYER_HEALTH.id(), new ResourceLocation(AsteorBar.MOD_ID, "main"), new NeoForgeRenderGui(Overlays.MAIN));
    }

    @SubscribeEvent
    public static void registerKeyMapping(RegisterKeyMappingsEvent event) {
        event.register(KeyBinding.TOGGLE_OVERLAY);
        event.register(KeyBinding.TOGGLE_MOB_BAR);
    }
}
