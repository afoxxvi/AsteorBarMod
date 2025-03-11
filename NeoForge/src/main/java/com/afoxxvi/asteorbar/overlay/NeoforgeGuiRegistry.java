package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.AsteorBar;
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
        if (AsteorBar.compatibility.toughAsNails) {
            Overlays.registerOverlayAtRecommended(new ToughAsNailsOverlay(), Overlays.Position.UNSPECIFIED);
        }
        if (AsteorBar.compatibility.vampirism) {
            Overlays.FOOD_LEVEL.setOverrideOverlay(new VampirismOverlay());
        }
        if (AsteorBar.compatibility.lightshield) {
            Overlays.PLAYER_HEALTH.addLayer("afoxxvi:luoyu.lightshield", new LightShieldOverlay());
        }
    }
}
