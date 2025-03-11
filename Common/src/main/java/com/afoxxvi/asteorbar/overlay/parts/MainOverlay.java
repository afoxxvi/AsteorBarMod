package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import net.minecraft.client.gui.GuiGraphics;

public class MainOverlay extends BaseOverlay {
    @Override
    public void renderOverlay(RenderGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        if (Overlays.style == Overlays.STYLE_NONE) return;
        gui.leftHeight(-6);
        gui.rightHeight(-6);
        final var list = Overlays.getCurrentOrder();
        list.forEach(pair -> {
            if (pair.getA() instanceof SimpleBarOverlay simpleBarOverlay) {
                simpleBarOverlay.setDefinedPosition(pair.getB());
            }
            pair.getA().render(gui, guiGraphics, partialTick, screenWidth, screenHeight);
        });
        Overlays.STRING.render(gui, guiGraphics, partialTick, screenWidth, screenHeight);
    }
}
