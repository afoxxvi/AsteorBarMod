package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodData;

@SuppressWarnings("DuplicatedCode")
public class FoodLevelOverlay extends BaseOverlay {
    private int foodBlinkTime = 0;

    private void draw(PoseStack poseStack, int left, int top, int right, int bottom, boolean highlight, int foodColor, int foodLevel, float saturation, float exhaustion, boolean flip) {
        var boundColor = highlight ? AsteorBar.config.foodBoundColorBlink() : AsteorBar.config.foodBoundColor();
        drawBound(poseStack, left, top, right, bottom, boundColor);
        drawEmptyFill(poseStack, left + 1, top + 1, right - 1, bottom - 1, AsteorBar.config.foodEmptyColor());
        final int innerWidth = right - left - 2;
        int foodWidth = (int) (innerWidth * foodLevel / 20.0F);
        drawFillFlip(poseStack, left + 1, top + 1, right - 1, bottom - 1, foodWidth, foodColor, flip);
        if (AsteorBar.config.displaySaturation()) {
            int saturationWidth = (int) ((right - left) * (saturation / 20.0F));
            drawBoundFlip(poseStack, left, top, right, bottom, saturationWidth, AsteorBar.config.saturationColor(), flip);
        }
        if (AsteorBar.config.displayExhaustion()) {
            RenderSystem.setShaderTexture(0, TEXTURE);
            int exhaustionWidth = (int) (innerWidth * (Math.min(4.0F, exhaustion) / 4.0F));
            drawTextureFillFlip(poseStack, left + 1, top, right - 1, exhaustionWidth, 5, 10, Y_FOOD_EXHAUSTION_FILL, FILL_FULL_WIDTH_LONG, flip);
            RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        }
    }

    @Override
    public void renderOverlay(RenderGui gui, PoseStack poseStack, float partialTick, int screenWidth, int screenHeight) {
        var player = gui.mc().player;
        if (player == null) return;
        boolean isMounted = player.getVehicle() instanceof LivingEntity;
        if (!isMounted && !gui.mc().options.hideGui) {
            FoodData stats = player.getFoodData();
            int level = stats.getFoodLevel();
            float saturation = stats.getSaturationLevel();
            float exhaustion = stats.getExhaustionLevel();
            int foodType = AsteorBar.config.foodColorNormal();
            if (player.hasEffect(MobEffects.HUNGER)) {
                foodType = AsteorBar.config.foodColorHunger();
            }
            if (AsteorBar.config.enableFoodBlink()) {
                if (player.getFoodData().getSaturationLevel() <= 0.0F && gui.gui().getGuiTicks() % (Math.max(4, level) * 3L + 1) == 0) {
                    foodBlinkTime = 2;
                }
                if (foodBlinkTime > 0) {
                    foodBlinkTime--;
                }
            }
            switch (Overlays.style) {
                case Overlays.STYLE_NONE -> {

                }
                case Overlays.STYLE_ABOVE_HOT_BAR_LONG -> {
                    int left = screenWidth / 2 - 91;
                    int top = screenHeight - gui.rightHeight() + 4;
                    gui.rightHeight(12);
                    draw(poseStack, left, top, left + BOUND_FULL_WIDTH_LONG, top + 5, foodBlinkTime > 0, foodType, level, saturation, exhaustion, false);
                }
                case Overlays.STYLE_ABOVE_HOT_BAR_SHORT -> {
                    int left = screenWidth / 2 + 10;
                    int top = screenHeight - gui.rightHeight() + 4;
                    gui.rightHeight(6);
                    draw(poseStack, left, top, left + BOUND_FULL_WIDTH_SHORT, top + 5, foodBlinkTime > 0, foodType, level, saturation, exhaustion, true);
                }
                case Overlays.STYLE_TOP_LEFT -> {
                    int top = Overlays.vertical;
                    int left = Overlays.horizontal;
                    draw(poseStack, left, top, left + Overlays.length, top + 5, foodBlinkTime > 0, foodType, level, saturation, exhaustion, false);
                    Overlays.vertical += 6;
                }
                case Overlays.STYLE_TOP_RIGHT -> {
                    int top = Overlays.vertical;
                    int left = screenWidth - Overlays.length - Overlays.horizontal;
                    draw(poseStack, left, top, left + Overlays.length, top + 5, foodBlinkTime > 0, foodType, level, saturation, exhaustion, true);
                    Overlays.vertical += 6;
                }
                case Overlays.STYLE_BOTTOM_LEFT -> {
                    int top = screenHeight - Overlays.vertical;
                    int left = Overlays.horizontal;
                    draw(poseStack, left, top, left + Overlays.length, top + 5, foodBlinkTime > 0, foodType, level, saturation, exhaustion, false);
                    Overlays.vertical += 6;
                }
                case Overlays.STYLE_BOTTOM_RIGHT -> {
                    int top = screenHeight - Overlays.vertical;
                    int left = screenWidth - Overlays.length - Overlays.horizontal;
                    draw(poseStack, left, top, left + Overlays.length, top + 5, foodBlinkTime > 0, foodType, level, saturation, exhaustion, true);
                    Overlays.vertical += 6;
                }
            }
        }
    }
}
