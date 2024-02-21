package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.dehydration.access.ThirstManagerAccess;
import net.dehydration.init.EffectInit;
import net.dehydration.thirst.ThirstManager;

public class DehydrationOverlay extends BaseOverlay {
    private int blinkTime = 0;

    private void draw(PoseStack poseStack, int left, int top, int right, int bottom, boolean highlight, int thirstColor, int foodLevel, float exhaustion, boolean flip) {
        var boundColor = Utils.mixColor(0xff000000, thirstColor, 0.5);
        if (highlight) boundColor = Utils.mixColor(0xffffffff, thirstColor, 0.08);
        drawBound(poseStack, left, top, right, bottom, boundColor);
        drawEmptyFill(poseStack, left + 1, top + 1, right - 1, bottom - 1, AsteorBar.config.foodEmptyColor());
        final int innerWidth = right - left - 2;
        int foodWidth = (int) (innerWidth * foodLevel / 20.0F);
        drawFillFlip(poseStack, left + 1, top + 1, right - 1, bottom - 1, foodWidth, thirstColor, flip);
        if (AsteorBar.config.displayExhaustion()) {
            RenderSystem.setShaderTexture(0, TEXTURE);
            int exhaustionWidth = (int) (innerWidth * (Math.min(4.0F, exhaustion) / 4.0F));
            drawTextureFillFlip(poseStack, left + 1, top, right - 1, exhaustionWidth, 5, 10, Y_FOOD_EXHAUSTION_FILL, FILL_FULL_WIDTH_LONG, flip);
            RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        }
    }

    @Override
    public void renderOverlay(RenderGui gui, PoseStack poseStack, float partialTick, int screenWidth, int screenHeight) {
        if (!Overlays.dehydration || !AsteorBar.config.hookDehydration()) return;
        var player = gui.mc().player;
        if (player == null) return;
        ThirstManager thirstManager = ((ThirstManagerAccess) player).getThirstManager(player);
        if (!thirstManager.hasThirst()) return;
        int thirst = thirstManager.getThirstLevel();
        float dehydration = thirstManager.dehydration;
        int thirstColor = 0xff1aafe7;
        if (player.hasEffect(EffectInit.THIRST)) {
            thirstColor = 0xffc3e71a;
        }
        if (player.getTicksFrozen() > 0) {
            thirstColor = 0xff7ec9ff;
        }
        if (AsteorBar.config.enableFoodBlink()) {
            if (thirstManager.dehydration >= 4.0F && gui.gui().getGuiTicks() % (thirst * 3 + 1) == 0) {
                blinkTime = 2;
            }
            if (blinkTime > 0) {
                blinkTime--;
            }
        }
        switch (Overlays.style) {
            case Overlays.STYLE_NONE -> {

            }
            case Overlays.STYLE_ABOVE_HOT_BAR_LONG, Overlays.STYLE_ABOVE_HOT_BAR_SHORT -> {
                int left = screenWidth / 2 + 10;
                int top = screenHeight - gui.rightHeight() + 4;
                gui.rightHeight(6);
                draw(poseStack, left, top, left + BOUND_FULL_WIDTH_SHORT, top + 5, blinkTime > 0, thirstColor, thirst, dehydration, true);
            }
            case Overlays.STYLE_TOP_LEFT -> {
                int top = Overlays.vertical;
                int left = Overlays.horizontal;
                draw(poseStack, left, top, left + Overlays.length, top + 5, blinkTime > 0, thirstColor, thirst, dehydration, false);
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_TOP_RIGHT -> {
                int top = Overlays.vertical;
                int left = screenWidth - Overlays.length - Overlays.horizontal;
                draw(poseStack, left, top, left + Overlays.length, top + 5, blinkTime > 0, thirstColor, thirst, dehydration, true);
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_BOTTOM_LEFT -> {
                int top = screenHeight - Overlays.vertical;
                int left = Overlays.horizontal;
                draw(poseStack, left, top, left + Overlays.length, top + 5, blinkTime > 0, thirstColor, thirst, dehydration, false);
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_BOTTOM_RIGHT -> {
                int top = screenHeight - Overlays.vertical;
                int left = screenWidth - Overlays.length - Overlays.horizontal;
                draw(poseStack, left, top, left + Overlays.length, top + 5, blinkTime > 0, thirstColor, thirst, dehydration, true);
                Overlays.vertical += 6;
            }
        }
    }
}
