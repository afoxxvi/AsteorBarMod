package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.parts.ToughAsNailsOverlay;

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
    }
}
