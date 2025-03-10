package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.overlay.parts.ToughAsNailsOverlay;

public class ForgeGuiRegistry {
    private ForgeGuiRegistry() {
    }

    private static boolean initialized = false;

    public static void init() {
        if (initialized) return;
        Overlays.registerOverlayAtRecommended(new ToughAsNailsOverlay(), Overlays.Position.UNSPECIFIED);
        initialized = true;
    }
}
