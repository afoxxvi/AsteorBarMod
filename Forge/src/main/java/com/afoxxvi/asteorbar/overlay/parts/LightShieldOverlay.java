package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.afoxxvi.asteorbar.utils.Utils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;

public class LightShieldOverlay extends BaseOverlay implements SimpleBarOverlay.Layer {
    @Override
    public void drawLayer(Player player, GuiGraphics guiGraphics, int left, int top, int right, int bottom, SimpleBarOverlay.Parameters parameters, boolean flip) {
        var shield = luoyu.lightshield.Api.getShieldAmount(player);
        var maxShield = AsteorBar.config.displayAbsorptionDivMaxHealth() ? player.getMaxHealth() : luoyu.lightshield.Api.getMaxShieldAmount(player);
        final int innerWidth = right - left - 2;
        var displayShield = shield % maxShield;
        if (displayShield == 0 && shield > 0) {
            displayShield = maxShield;
        }
        var shieldWidth = (int) (displayShield * innerWidth / maxShield);
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
        if (shield > maxShield) {
            int absorbTimes = (int) (shield / maxShield);
            if (shield % maxShield == 0) absorbTimes--;
            if (flip) {
                Overlays.addStringRender(left, top - 2, 0xb6c8c1, "×" + absorbTimes, Overlays.ALIGN_RIGHT, true);
            } else {
                Overlays.addStringRender(right, top - 2, 0xb6c8c1, absorbTimes + "×", Overlays.ALIGN_LEFT, true);
            }
        }
    }

    @Override
    public void renderOverlay(RenderGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
    }
}
