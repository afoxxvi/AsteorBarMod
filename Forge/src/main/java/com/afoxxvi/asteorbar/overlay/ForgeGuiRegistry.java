package com.afoxxvi.asteorbar.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphicsExtractor;

public class ForgeGuiRegistry {
    private ForgeGuiRegistry() {
    }

    public static void startRender(Gui instance, GuiGraphicsExtractor guiGraphics) {
        var mc = Minecraft.getInstance();
        var tick = 0f;
        var width = mc.getWindow().getGuiScaledWidth();
        var height = mc.getWindow().getGuiScaledHeight();
        var gui = new ForgeRenderGui(instance);
        Overlays.MAIN.renderOverlay(gui, guiGraphics, tick, width, height);
    }
}
