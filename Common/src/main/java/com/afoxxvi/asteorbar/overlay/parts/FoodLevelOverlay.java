package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodData;

@SuppressWarnings("DuplicatedCode")
public class FoodLevelOverlay extends BaseOverlay {
    private int foodBlinkTime = 0;

    private void draw(GuiGraphics guiGraphics, int left, int top, int right, int bottom, boolean highlight, int foodColor, int foodLevel, float saturation, float exhaustion, int foodIncrement, float saturationIncrement, int tick, boolean flip) {
        RenderSystem.enableBlend();
        var boundColor = highlight ? AsteorBar.config.foodBoundColorBlink() : AsteorBar.config.foodBoundColor();
        drawBound(guiGraphics, left, top, right, bottom, boundColor);
        drawEmptyFill(guiGraphics, left + 1, top + 1, right - 1, bottom - 1, AsteorBar.config.foodEmptyColor());
        final int innerWidth = right - left - 2;
        int foodWidth = (int) (innerWidth * (double) foodLevel / AsteorBar.config.fullFoodLevelValue());
        drawFillFlip(guiGraphics, left + 1, top + 1, right - 1, bottom - 1, foodWidth, foodColor, flip);
        float alpha = (float) Math.cos(tick % 40 / 40.0 * Math.PI * 2) * 0.5F + 0.5F;
        if (foodIncrement > 0 && foodLevel < AsteorBar.config.fullFoodLevelValue()) {
            int incrementWidth;
            if (foodLevel + foodIncrement >= AsteorBar.config.fullFoodLevelValue()) {
                incrementWidth = innerWidth - foodWidth;
            } else {
                incrementWidth = (int) (innerWidth * (double) foodIncrement / AsteorBar.config.fullFoodLevelValue());
            }
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, alpha);
            drawFillFlipConcat(guiGraphics, left + 1, top + 1, right - 1, bottom - 1, foodWidth, incrementWidth, foodColor, flip);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        }
        if (AsteorBar.config.displaySaturation()) {
            int saturationWidth = (int) ((right - left) * (saturation / AsteorBar.config.fullSaturationValue()));
            drawBoundFlip(guiGraphics, left, top, right, bottom, saturationWidth, AsteorBar.config.saturationColor(), flip);
            if (foodIncrement > 0 && saturationIncrement > 0 && saturation < AsteorBar.config.fullSaturationValue()) {
                int incrementWidth;
                if (saturation + saturationIncrement >= AsteorBar.config.fullSaturationValue()) {
                    incrementWidth = right - left - saturationWidth;
                } else {
                    incrementWidth = (int) ((right - left) * (saturationIncrement / AsteorBar.config.fullSaturationValue()));
                }
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, alpha);
                drawBoundFlipConcat(guiGraphics, left, top, right, bottom, saturationWidth, incrementWidth, AsteorBar.config.saturationColor(), flip);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            }
        }
        if (AsteorBar.config.displayExhaustion()) {
            RenderSystem.setShaderTexture(0, TEXTURE);
            int exhaustionWidth = (int) (innerWidth * (Math.min(AsteorBar.config.fullExhaustionValue(), exhaustion) / AsteorBar.config.fullExhaustionValue()));
            drawTextureFillFlip(guiGraphics, left + 1, top, right - 1, exhaustionWidth, 5, 10, Y_FOOD_EXHAUSTION_FILL, FILL_FULL_WIDTH_LONG, flip);
            RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        }
        RenderSystem.disableBlend();
    }

    @Override
    public void renderOverlay(RenderGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        var player = gui.mc().player;
        if (player == null) return;
        FoodData stats = player.getFoodData();
        int level = stats.getFoodLevel();
        float saturation = stats.getSaturationLevel();
        float exhaustion = stats.getExhaustionLevel();
        int foodType = AsteorBar.config.foodColorNormal();
        if (player.hasEffect(MobEffects.HUNGER)) {
            foodType = AsteorBar.config.foodColorHunger();
        }
        int foodIncrement = 0;
        float saturationIncrement = 0F;
        if (Overlays.appleskin) {
            final var foodValues = AsteorBar.platformAdapter.getAppleSkinFoodValues(player);
            if (foodValues != null) {
                foodIncrement = foodValues.hungerIncrement();
                saturationIncrement = foodValues.saturationIncrement();
            }
        }
        if (AsteorBar.config.enableFoodBlink()) {
            if (player.getFoodData().getSaturationLevel() <= 0.0F && gui.gui().getGuiTicks() % (Math.max(4, level) * 3L + 1) == 0) {
                foodBlinkTime = 2;
            }
            if (foodBlinkTime > 0) {
                foodBlinkTime--;
            }
        }
        int left, top, right;
        boolean flip = false;
        switch (Overlays.style) {
            default -> {
                return;
            }
            case Overlays.STYLE_ABOVE_HOT_BAR_LONG -> {
                left = screenWidth / 2 - 91;
                top = screenHeight - gui.rightHeight() + 4;
                right = left + BOUND_FULL_WIDTH_LONG;
                gui.rightHeight(12);
            }
            case Overlays.STYLE_ABOVE_HOT_BAR_SHORT -> {
                left = screenWidth / 2 + 10;
                top = screenHeight - gui.rightHeight() + 4;
                right = left + BOUND_FULL_WIDTH_SHORT;
                flip = true;
                gui.rightHeight(6);
            }
            case Overlays.STYLE_TOP_LEFT -> {
                top = Overlays.vertical;
                left = Overlays.horizontal;
                right = left + Overlays.length;
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
        draw(guiGraphics, left, top, right, top + 5, foodBlinkTime > 0, foodType, level, saturation, exhaustion, foodIncrement, saturationIncrement, gui.gui().getGuiTicks(), flip);
    }
}
