package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.parts.ToughAsNailsOverlay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;

public class ForgeGuiRegistry {
    private ForgeGuiRegistry() {
    }

    private static boolean initialized = false;

    public static void init() {
        if (initialized) return;
        if (AsteorBar.compatibility.toughAsNails) {
            Overlays.registerOverlayAtRecommended(new ToughAsNailsOverlay(), Overlays.Position.UNSPECIFIED);
        }
        initialized = true;
    }

    public static void startRender(Gui instance, GuiGraphics guiGraphics) {
        init();
        var mc = Minecraft.getInstance();
        var tick = 0f;
        var width = mc.getWindow().getGuiScaledWidth();
        var height = mc.getWindow().getGuiScaledHeight();
        var gui = new ForgeRenderGui(instance);
        Overlays.MAIN.renderOverlay(gui, guiGraphics, tick, width, height);
    }
}
