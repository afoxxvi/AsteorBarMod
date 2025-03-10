package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.overlay.parts.LightShieldOverlay;
import com.afoxxvi.asteorbar.overlay.parts.ToughAsNailsOverlay;
import com.afoxxvi.asteorbar.overlay.parts.VampirismOverlay;

public class NeoforgeGuiRegistry {
    private NeoforgeGuiRegistry() {
    }

    private static boolean initialized = false;

    public static void init() {
        if (initialized) return;
        initialized = true;
        Overlays.registerOverlayAtRecommended(new ToughAsNailsOverlay(), Overlays.Position.UNSPECIFIED);
        Overlays.FOOD_LEVEL.setOverrideOverlay(new VampirismOverlay());
        Overlays.PLAYER_HEALTH.addLayer("luoyu.lightshield", new LightShieldOverlay());
    }
}
