package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import net.minecraft.client.gui.GuiGraphics;

public class MainOverlay extends BaseOverlay {
    @Override
    public void renderOverlay(RenderGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        final var style = AsteorBar.config.overlayLayoutStyle();
        if (style == Overlays.STYLE_NONE) return;
        gui.leftHeight(-6);
        gui.rightHeight(-6);
        final var list = Overlays.ORDER.get(style);
        list.forEach(pair -> pair.getA().renderAtPosition(gui, guiGraphics, partialTick, screenWidth, screenHeight, pair.getB()));
        Overlays.STRING.renderOverlay(gui, guiGraphics, partialTick, screenWidth, screenHeight);
    }
}
