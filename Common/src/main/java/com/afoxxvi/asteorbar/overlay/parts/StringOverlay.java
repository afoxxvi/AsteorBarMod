package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import net.minecraft.client.gui.GuiGraphicsExtractor;

public class StringOverlay extends BaseOverlay {
    @Override
    public void renderOverlay(RenderGui gui, GuiGraphicsExtractor guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        Overlays.renderString(guiGraphics);
    }
}
