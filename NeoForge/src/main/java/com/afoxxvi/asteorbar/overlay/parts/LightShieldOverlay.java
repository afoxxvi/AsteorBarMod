package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.afoxxvi.asteorbar.utils.Utils;
import net.minecraft.client.gui.GuiGraphics;

public class LightShieldOverlay extends BaseOverlay {
    private void draw(GuiGraphics guiGraphics, int left, int top, int right, int bottom, float shield, float maxShield, boolean flip) {
        final int innerWidth = right - left - 2;
        var shieldWidth = (int) (shield * innerWidth / maxShield);
        drawFillFlip(guiGraphics, left + 1, top + 3, right - 1, bottom - 1, shieldWidth, 0xff8cb3ca, flip);
        drawFillFlip(guiGraphics, left + 1, bottom - 1, right - 1, bottom, shieldWidth, 0xff7097ae, flip);
        var text = Utils.formatNumber(shield);
        if (AsteorBar.config.displayHealthText()) {
            if (flip) {
                Overlays.addStringRender(left + 2, top - 2, 0xb6c8c1, text, Overlays.ALIGN_LEFT, true);
            } else {
                Overlays.addStringRender(right - 2, top - 2, 0xb6c8c1, text, Overlays.ALIGN_RIGHT, true);
            }
        }
    }

    @Override
    public void renderOverlay(RenderGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        if (!Overlays.lightShield) return;
        var player = gui.mc().player;
        if (player == null) return;
        var shield = luoyu.lightshield.Api.getShieldAmount(player);
        var maxShield = luoyu.lightshield.Api.getMaxShieldAmount(player);
        switch (Overlays.style) {
            case Overlays.STYLE_NONE -> {

            }
            case Overlays.STYLE_ABOVE_HOT_BAR_LONG -> {
                int top = screenHeight - (gui.leftHeight() - 12) - 2;
                int left = screenWidth / 2 - 91;
                draw(guiGraphics, left, top, left + BOUND_FULL_WIDTH_LONG, top + 5, shield, maxShield, false);
            }
            case Overlays.STYLE_ABOVE_HOT_BAR_SHORT -> {
                int top = screenHeight - (gui.leftHeight() - 6) + 4;
                int left = screenWidth / 2 - 91;
                draw(guiGraphics, left, top, left + BOUND_FULL_WIDTH_SHORT, top + 5, shield, maxShield, false);
            }
            case Overlays.STYLE_TOP_LEFT -> {
                int top = Overlays.vertical - 6;
                int left = Overlays.horizontal;
                draw(guiGraphics, left, top, left + Overlays.length, top + 5, shield, maxShield, false);
            }
            case Overlays.STYLE_TOP_RIGHT -> {
                int top = Overlays.vertical - 6;
                int left = screenWidth - Overlays.length - Overlays.horizontal;
                draw(guiGraphics, left, top, left + Overlays.length, top + 5, shield, maxShield, true);
            }
            case Overlays.STYLE_BOTTOM_LEFT -> {
                int top = screenHeight - (Overlays.vertical - 6);
                int left = Overlays.horizontal;
                draw(guiGraphics, left, top, left + Overlays.length, top + 5, shield, maxShield, false);
            }
            case Overlays.STYLE_BOTTOM_RIGHT -> {
                int top = screenHeight - (Overlays.vertical - 6);
                int left = screenWidth - Overlays.length - Overlays.horizontal;
                draw(guiGraphics, left, top, left + Overlays.length, top + 5, shield, maxShield, true);
            }
        }
    }
}
