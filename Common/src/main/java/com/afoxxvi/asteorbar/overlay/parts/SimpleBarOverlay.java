package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;

public abstract class SimpleBarOverlay extends BaseOverlay {
    public static class Parameters {
        public int fillColor = 0;
        public int boundColor = 0;
        public int emptyColor = 0;
        public double value = 0;
        public double capacity = 1;
        public int boundFillColor = 0;
        public double boundValue = 0;
        public double boundCapacity = 1;

        public Parameters() {
        }
    }

    protected void drawDecorations(GuiGraphics guiGraphics, int left, int top, int right, int bottom, Parameters parameters, boolean flip) {
    }

    private void draw(GuiGraphics guiGraphics, int left, int top, int right, int bottom, Parameters parameters, boolean flip) {
        if (parameters == null) return;
        drawBound(guiGraphics, left, top, right, bottom, parameters.boundColor);
        drawEmptyFill(guiGraphics, left + 1, top + 1, right - 1, bottom - 1, parameters.emptyColor);
        final int innerWidth = right - left - 2;
        final int fillWidth = (int) (innerWidth * parameters.value / parameters.capacity);
        drawFillFlip(guiGraphics, left + 1, top + 1, right - 1, bottom - 1, fillWidth, parameters.fillColor, flip);
        if (parameters.boundFillColor != 0) {
            final int boundFillWidth = (int) (innerWidth * parameters.boundValue / parameters.boundCapacity);
            drawBoundFlip(guiGraphics, left, top, right, bottom, boundFillWidth, parameters.boundFillColor, flip);
        }
        drawDecorations(guiGraphics, left, top, right, bottom, parameters, flip);
    }

    protected abstract Parameters getParameters(Player player);

    protected abstract boolean shouldRender(Player player);

    protected boolean isLeftSide() {
        return false;
    }

    @Override
    public void renderOverlay(RenderGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        var player = gui.mc().player;
        if (player == null) return;
        if (!shouldRender(player)) return;
        var parameters = getParameters(player);
        if (parameters == null) return;
        int left, top, right;
        boolean flip;
        switch (Overlays.style) {
            default -> {
                return;
            }
            case Overlays.STYLE_ABOVE_HOT_BAR_LONG, Overlays.STYLE_ABOVE_HOT_BAR_SHORT -> {
                if (isLeftSide()) {
                    left = screenWidth / 2 - 91;
                    top = screenHeight - gui.leftHeight() + 4;
                    right = left + BOUND_FULL_WIDTH_SHORT;
                    flip = false;
                    gui.leftHeight(6);
                } else {
                    left = screenWidth / 2 + 10;
                    top = screenHeight - gui.rightHeight() + 4;
                    right = left + BOUND_FULL_WIDTH_SHORT;
                    flip = true;
                    gui.rightHeight(6);
                    draw(guiGraphics, left, top, left + BOUND_FULL_WIDTH_SHORT, top + 5, parameters, true);
                }
            }
            case Overlays.STYLE_TOP_LEFT -> {
                top = Overlays.vertical;
                left = Overlays.horizontal;
                right = left + Overlays.length;
                flip = false;
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_TOP_RIGHT -> {
                top = Overlays.vertical;
                left = screenWidth - Overlays.length - Overlays.horizontal;
                right = left + Overlays.length;
                flip = true;
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_BOTTOM_LEFT -> {
                top = screenHeight - Overlays.vertical;
                left = Overlays.horizontal;
                right = left + Overlays.length;
                flip = false;
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_BOTTOM_RIGHT -> {
                top = screenHeight - Overlays.vertical;
                left = screenWidth - Overlays.length - Overlays.horizontal;
                right = left + Overlays.length;
                flip = true;
                Overlays.vertical += 6;
            }
        }
        draw(guiGraphics, left, top, right, top + 5, parameters, flip);
    }
}
