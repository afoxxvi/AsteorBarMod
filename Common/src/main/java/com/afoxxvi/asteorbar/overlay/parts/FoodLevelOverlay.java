package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;

@SuppressWarnings("DuplicatedCode")
public class FoodLevelOverlay extends SimpleBarOverlay {
    private int foodBlinkTime = 0;
    private final int[] shift = new int[]{0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1};

    float saturation;
    float exhaustion;
    int foodIncrement;
    float saturationIncrement;

    @Override
    protected Parameters getParameters(Player player) {
        FoodData stats = player.getFoodData();
        int level = stats.getFoodLevel();
        saturation = stats.getSaturationLevel();
        exhaustion = stats.getExhaustionLevel();
        int foodType = AsteorBar.config.foodColorNormal();
        if (player.hasEffect(MobEffects.HUNGER)) {
            foodType = AsteorBar.config.foodColorHunger();
        }
        foodIncrement = 0;
        saturationIncrement = 0F;
        if (AsteorBar.compatibility.appleskin) {
            final var foodValues = AsteorBar.platformAdapter.getAppleSkinFoodValues(player);
            if (foodValues != null) {
                foodIncrement = foodValues.hungerIncrement();
                saturationIncrement = foodValues.saturationIncrement();
            }
        }
        if (AsteorBar.config.enableFoodBlink()) {
            if (player.getFoodData().getSaturationLevel() <= 0.0F && tick % (Math.max(4, level) * 3L + 1) == 0) {
                foodBlinkTime = 2;
            }
            if (foodBlinkTime > 0) {
                foodBlinkTime--;
            }
        }
        Parameters parameters = new Parameters();
        if (level <= 4) {
            parameters.verticalShift = shift[tick / (level + 1) % shift.length];
        }
        parameters.boundColor = foodBlinkTime > 0 ? AsteorBar.config.foodBoundColorBlink() : AsteorBar.config.foodBoundColor();
        parameters.emptyColor = AsteorBar.config.foodEmptyColor();
        if (AsteorBar.config.displayFoodText()) {
            parameters.centerText = Utils.formatNumber(level) + "/" + Utils.formatNumber(AsteorBar.config.fullFoodLevelValue());
            parameters.centerColor = 0xFFFFFF;
        }
        parameters.value = (double) level / AsteorBar.config.fullFoodLevelValue();
        parameters.fillColor = foodType;
        if (foodIncrement > 0 && level < AsteorBar.config.fullFoodLevelValue()) {
            if (level + foodIncrement >= AsteorBar.config.fullFoodLevelValue()) {
                parameters.valueIncrement = (level + foodIncrement) / (double) AsteorBar.config.fullFoodLevelValue() % 1;
            } else {
                parameters.valueIncrement = foodIncrement / (double) AsteorBar.config.fullFoodLevelValue();
            }
        }
        if (AsteorBar.config.displaySaturation()) {
            parameters.boundValue = saturation / AsteorBar.config.fullSaturationValue();
            parameters.boundFillColor = AsteorBar.config.saturationColor();
            if (foodIncrement > 0 && saturationIncrement > 0 && saturation < AsteorBar.config.fullSaturationValue()) {
                if (saturation + saturationIncrement >= AsteorBar.config.fullSaturationValue()) {
                    parameters.boundValueIncrement = (saturation + saturationIncrement) / AsteorBar.config.fullSaturationValue() % 1;
                } else {
                    parameters.boundValueIncrement = saturationIncrement / AsteorBar.config.fullSaturationValue();
                }
            }
        }
        return parameters;
    }

    @Override
    protected void drawDecorations(GuiGraphics guiGraphics, int left, int top, int right, int bottom, Parameters parameters, boolean flip) {
        super.drawDecorations(guiGraphics, left, top, right, bottom, parameters, flip);
        int innerWidth = right - left - 2;
        if (AsteorBar.config.displayExhaustion()) {
            RenderSystem.setShaderTexture(0, TEXTURE);
            int exhaustionWidth = (int) (innerWidth * (Math.min(AsteorBar.config.fullExhaustionValue(), exhaustion) / AsteorBar.config.fullExhaustionValue()));
            drawTextureFillFlip(guiGraphics, left + 1, top, right - 1, exhaustionWidth, 5, 10, Y_FOOD_EXHAUSTION_FILL, FILL_FULL_WIDTH_LONG, flip);
            RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        }
    }

    @Override
    protected boolean shouldRender(Player player) {
        return true;
    }
}
