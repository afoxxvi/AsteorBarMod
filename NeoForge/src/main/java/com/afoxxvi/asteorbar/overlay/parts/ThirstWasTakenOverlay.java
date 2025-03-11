package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.ghen.thirst.foundation.common.capability.IThirst;
import dev.ghen.thirst.foundation.common.capability.ModAttachment;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import toughasnails.init.ModConfig;

public class ThirstWasTakenOverlay extends SimpleBarOverlay {
    private int thirstBlinkTime = 0;
    private float exhaustion;

    @Override
    protected Parameters getParameters(Player player) {
        var parameters = new Parameters();
        IThirst thirst = player.getData(ModAttachment.PLAYER_THIRST);
        int level = thirst.getThirst();
        float quenched = thirst.getQuenched();
        exhaustion = thirst.getExhaustion();
        int thirstColor = 0xff37bac4;
        if (AsteorBar.config.enableFoodBlink()) {
            if (quenched <= 0.0F && tick % (Math.max(4, level) * 3L + 1) == 0) {
                thirstBlinkTime = 2;
            }
            if (thirstBlinkTime > 0) {
                thirstBlinkTime--;
            }
        }
        var highlight = thirstBlinkTime > 0;
        parameters.boundColor = highlight ? Utils.mixColor(0xffffffff, thirstColor, 0.08) : Utils.mixColor(0xff000000, thirstColor, 0.5);
        parameters.emptyColor = AsteorBar.config.foodEmptyColor();
        if (level <= 4) {
            parameters.verticalShift = FoodLevelOverlay.SHIFT[tick / (level + 1) % FoodLevelOverlay.SHIFT.length];
        }
        parameters.fillColor = thirstColor;
        parameters.capacity = 20;
        parameters.value = level;
        if (AsteorBar.config.displaySaturation()) {
            parameters.boundFillColor = 0xff2d65d6;
            parameters.boundValue = quenched;
            parameters.boundCapacity = 10;
        }
        if (AsteorBar.config.displayFoodText()) {
            parameters.centerText = Utils.formatNumber(level) + "/" + Utils.formatNumber(20);
            parameters.centerColor = 0xFFFFFF;
        }
        return parameters;
    }

    @Override
    protected void drawDecorations(GuiGraphics guiGraphics, int left, int top, int right, int bottom, Parameters parameters, boolean flip) {
        super.drawDecorations(guiGraphics, left, top, right, bottom, parameters, flip);
        int innerWidth = right - left - 2;
        if (AsteorBar.config.displayExhaustion()) {
            RenderSystem.setShaderTexture(0, TEXTURE);
            var cap = ModConfig.thirst.thirstExhaustionThreshold;
            int exhaustionWidth = (int) (innerWidth * (Math.min(cap, exhaustion) / cap));
            drawTextureFillFlip(guiGraphics, left + 1, top, right - 1, exhaustionWidth, 5, 10, Y_FOOD_EXHAUSTION_FILL, FILL_FULL_WIDTH_LONG, flip);
            RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        }
    }

    @Override
    protected boolean shouldRender(Player player) {
        return AsteorBar.compatibility.thirst && AsteorBar.config.hookThirstWasTaken();
    }
}
