package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.mojang.blaze3d.vertex.PoseStack;

public class AirLevelOverlay extends BaseOverlay {
    private void draw(PoseStack poseStack, int left, int top, int right, int bottom, int air, boolean flip) {
        int airWidth = (right - left - 2) * air / 300;
        drawBound(poseStack, left, top, right, bottom, AsteorBar.config.airBoundColor());
        drawFillFlip(poseStack, left + 1, top + 1, right - 1, bottom - 1, airWidth, AsteorBar.config.airColor(), flip);
    }

    @Override
    public void renderOverlay(RenderGui gui, PoseStack guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        var player = gui.mc().player;
        if (player == null) return;
        int air = player.getAirSupply();
        if (!(AsteorBar.platformAdapter.isEyeInFluid(player) || air < 300)) {
            return;
        }
        switch (Overlays.style) {
            case Overlays.STYLE_NONE -> {

            }
            default -> {
                int left = screenWidth / 2 + 10;
                int top = screenHeight - gui.rightHeight() + 4;
                gui.rightHeight(6);
                draw(guiGraphics, left, top, left + BOUND_FULL_WIDTH_SHORT, top + 5, air, true);
            }
        }
    }
}
