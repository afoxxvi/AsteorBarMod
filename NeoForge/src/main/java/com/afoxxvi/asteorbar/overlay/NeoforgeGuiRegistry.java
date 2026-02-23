package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.parts.IronsSpellbooksOverlay;
import com.afoxxvi.asteorbar.overlay.parts.ThirstWasTakenOverlay;
import com.afoxxvi.asteorbar.overlay.parts.ToughAsNailsOverlay;
import com.afoxxvi.asteorbar.overlay.parts.VampirismOverlay;
import com.afoxxvi.asteorbar.overlay.parts.lso.LegendarySurvivalOverhaulFoodOverlay;
import com.afoxxvi.asteorbar.overlay.parts.lso.LegendarySurvivalOverhaulHealthOverlay;
import com.afoxxvi.asteorbar.overlay.parts.lso.LegendarySurvivalOverhaulThirstOverlay;

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
        if (AsteorBar.compatibility.thirst) {
            Overlays.registerOverlayAtRecommended(new ThirstWasTakenOverlay(), Overlays.Position.UNSPECIFIED);
        }
        if (AsteorBar.compatibility.ironsSpellbooks) {
            Overlays.registerOverlayAtRecommended(new IronsSpellbooksOverlay(), Overlays.Position.UNSPECIFIED);
        }
        if (AsteorBar.compatibility.vampirism) {
            Overlays.FOOD_LEVEL.addOverrideOverlay(new VampirismOverlay());
        }
        if (AsteorBar.compatibility.legendarySurvivalOverhaul) {
            Overlays.registerOverlayAtRecommended(new LegendarySurvivalOverhaulThirstOverlay(), Overlays.Position.UNSPECIFIED);
            Overlays.PLAYER_HEALTH.addOverrideOverlay(new LegendarySurvivalOverhaulHealthOverlay());
            Overlays.FOOD_LEVEL.addOverrideOverlay(new LegendarySurvivalOverhaulFoodOverlay());
        }
    }
}
