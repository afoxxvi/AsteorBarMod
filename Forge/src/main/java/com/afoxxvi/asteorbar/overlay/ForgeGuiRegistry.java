package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.parts.*;
import com.afoxxvi.asteorbar.overlay.parts.tfc.TFCExperienceOverlay;
import com.afoxxvi.asteorbar.overlay.parts.tfc.TFCFoodOverlay;
import com.afoxxvi.asteorbar.overlay.parts.tfc.TFCHealthOverlay;
import com.afoxxvi.asteorbar.overlay.parts.tfc.TFCThirstOverlay;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;

public class ForgeGuiRegistry {
    private ForgeGuiRegistry() {
    }

    private static boolean initialized = false;

    public static void init() {
        if (initialized) return;
        if (AsteorBar.compatibility.lightshield) {
            Overlays.PLAYER_HEALTH.addLayer("afoxxvi:light_shield", new LightShieldOverlay());
        }
        if (AsteorBar.compatibility.tfc) {
            Overlays.registerOverlayAtRecommended(new TFCThirstOverlay(), Overlays.Position.UNSPECIFIED);
            Overlays.PLAYER_HEALTH.addOverrideOverlay(new TFCHealthOverlay());
            Overlays.FOOD_LEVEL.addOverrideOverlay(new TFCFoodOverlay());
            Overlays.EXPERIENCE_BAR.addOverrideOverlay(new TFCExperienceOverlay());
        }
        if (AsteorBar.compatibility.toughAsNails) {
            Overlays.registerOverlayAtRecommended(new ToughAsNailsOverlay(), Overlays.Position.UNSPECIFIED);
        }
        if (AsteorBar.compatibility.thirst) {
            Overlays.registerOverlayAtRecommended(new ThirstOverlay(), Overlays.Position.UNSPECIFIED);
        }
        if (AsteorBar.compatibility.homeostatic) {
            Overlays.registerOverlayAtRecommended(new HomeostaticOverlay(), Overlays.Position.UNSPECIFIED);
        }
        if (AsteorBar.compatibility.feathers) {
            Overlays.registerOverlayAtRecommended(new FeathersOverlay(), Overlays.Position.UNSPECIFIED);
        }
        if (AsteorBar.compatibility.botania) {
            Overlays.registerOverlayAtRecommended(new BotaniaOverlay(), Overlays.Position.UNSPECIFIED);
        }
        if (AsteorBar.compatibility.ironsSpellbooks) {
            Overlays.registerOverlayAtRecommended(new IronsSpellbooksOverlay(), Overlays.Position.UNSPECIFIED);
        }
        if (AsteorBar.compatibility.arsNouveau) {
            Overlays.registerOverlayAtRecommended(new ArsNouveauOverlay(), Overlays.Position.UNSPECIFIED);
        }
        if (AsteorBar.compatibility.parcool) {
            Overlays.registerOverlayAtRecommended(new ParcoolOverlay(), Overlays.Position.UNSPECIFIED);
        }
        if (AsteorBar.compatibility.mekanism) {
            Overlays.registerOverlayAtRecommended(new MekanismOverlay(), Overlays.Position.UNSPECIFIED);
        }
        if (AsteorBar.compatibility.superiorshields) {
            Overlays.registerOverlayAtRecommended(new SuperiorShieldsOverlay(), Overlays.Position.UNSPECIFIED);
        }
        if (AsteorBar.compatibility.vampirism) {
            Overlays.FOOD_LEVEL.addOverrideOverlay(new VampirismOverlay());
        }
        initialized = true;
    }
}
