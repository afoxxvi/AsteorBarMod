package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.overlay.parts.*;
import com.afoxxvi.asteorbar.AsteorBar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;

public class FabricGuiRegistry {
    private FabricGuiRegistry() {
    }

    static {
        if (AsteorBar.compatibility.toughAsNails) {
            Overlays.registerOverlayAtRecommended(new ToughAsNailsOverlay(), Overlays.Position.UNSPECIFIED);
        }
        if (AsteorBar.compatibility.dehydration) {
            Overlays.registerOverlayAtRecommended(new DehydrationOverlay(), Overlays.Position.UNSPECIFIED);
        }
        if (AsteorBar.compatibility.apoli) {
            Overlays.registerOverlayAtRecommended(new OriginsOverlay(), Overlays.Position.UNSPECIFIED);
        }
        if (AsteorBar.compatibility.thermoo) {
            Overlays.registerOverlayAfter(new ThermooOverlays.Independent(), Overlays.PLAYER_HEALTH, Overlays.Position.UNSPECIFIED);
        }
        if (AsteorBar.compatibility.mealApi) {
            Overlays.FOOD_LEVEL.addLayer("afoxxvi:mealapi", new MealAPIOverlay());
        }

    }

    public static void startRender(Gui instance, GuiGraphics guiGraphics) {
        var mc = Minecraft.getInstance();
        var tick = 0f;
        var width = mc.getWindow().getGuiScaledWidth();
        var height = mc.getWindow().getGuiScaledHeight();
        var gui = new FabricRenderGui(instance);
        Overlays.MAIN.renderOverlay(gui, guiGraphics, tick, width, height);
    }
}
