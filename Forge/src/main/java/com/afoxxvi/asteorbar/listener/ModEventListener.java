package com.afoxxvi.asteorbar.listener;

import com.afoxxvi.asteorbar.AsteorBarForge;
import com.afoxxvi.asteorbar.overlay.ForgeRenderGui;
import com.afoxxvi.asteorbar.overlay.parts.MekanismOverlay;
import com.afoxxvi.asteorbar.overlay.parts.ThirstOverlay;
import com.afoxxvi.asteorbar.overlay.parts.ToughAsNailsOverlay;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.OverlayRegistry;

import static com.afoxxvi.asteorbar.overlay.Overlays.*;

public class ModEventListener {
    public static boolean registerOverlay = false;
    public static void registerOverlays() {
        AsteorBarForge.LOGGER.info("Registering Overlays");
        OverlayRegistry.registerOverlayBelow(ForgeIngameGui.PLAYER_HEALTH_ELEMENT, "player_health", new ForgeRenderGui(PLAYER_HEALTH));
        OverlayRegistry.registerOverlayBelow(ForgeIngameGui.PLAYER_HEALTH_ELEMENT, "food_level", new ForgeRenderGui(FOOD_LEVEL));
        OverlayRegistry.registerOverlayBelow(ForgeIngameGui.PLAYER_HEALTH_ELEMENT, "mount_health", new ForgeRenderGui(MOUNT_HEALTH));
        OverlayRegistry.registerOverlayBelow(ForgeIngameGui.PLAYER_HEALTH_ELEMENT, "tough_as_nails", new ForgeRenderGui(new ToughAsNailsOverlay()));
        OverlayRegistry.registerOverlayBelow(ForgeIngameGui.PLAYER_HEALTH_ELEMENT, "thirst", new ForgeRenderGui(new ThirstOverlay()));
        OverlayRegistry.registerOverlayBelow(ForgeIngameGui.PLAYER_HEALTH_ELEMENT, "experience_bar", new ForgeRenderGui(EXPERIENCE_BAR));
        OverlayRegistry.registerOverlayBelow(ForgeIngameGui.PLAYER_HEALTH_ELEMENT, "armor_level", new ForgeRenderGui(ARMOR_LEVEL));
        OverlayRegistry.registerOverlayBelow(ForgeIngameGui.PLAYER_HEALTH_ELEMENT, "mekanism", new ForgeRenderGui(new MekanismOverlay()));
        OverlayRegistry.registerOverlayBelow(ForgeIngameGui.AIR_LEVEL_ELEMENT, "air_level", new ForgeRenderGui(AIR_LEVEL));
        OverlayRegistry.registerOverlayAbove(ForgeIngameGui.EXPERIENCE_BAR_ELEMENT, "string", new ForgeRenderGui(STRING));
        registerOverlay = true;
    }
}
