package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.systems.RenderSystem;
import net.dehydration.access.ThirstManagerAccess;
import net.dehydration.init.ConfigInit;
import net.dehydration.init.EffectInit;
import net.dehydration.item.LeatherFlask;
import net.dehydration.misc.ThirstTooltipData;
import net.dehydration.thirst.ThirstManager;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;

public class DehydrationOverlay extends BaseOverlay {
    private int blinkTime = 0;
    private final int[] qualityColor = {0xff36abff, 0xff5a99b0, 0xffc3e71a, 0xff7ec9ff};

    private void draw(GuiGraphics guiGraphics, int left, int top, int right, int bottom, boolean highlight, int thirstColor, int foodLevel, float thirstQuench, int quality, float exhaustion, float alpha, boolean flip) {
        var boundColor = Utils.mixColor(0xff000000, thirstColor, 0.5);
        if (highlight) boundColor = Utils.mixColor(0xffffffff, thirstColor, 0.08);
        drawBound(guiGraphics, left, top, right, bottom, boundColor);
        drawEmptyFill(guiGraphics, left + 1, top + 1, right - 1, bottom - 1, AsteorBar.config.foodEmptyColor());
        final int innerWidth = right - left - 2;
        int foodWidth = (int) (innerWidth * foodLevel / 20.0F);
        drawFillFlip(guiGraphics, left + 1, top + 1, right - 1, bottom - 1, foodWidth, thirstColor, flip);
        if (thirstQuench > 0) {
            int quenchWidth = (int) (innerWidth * (thirstQuench / 20.0F));
            quenchWidth = Math.min(quenchWidth, innerWidth - foodWidth);
            RenderSystem.setShaderColor(1, 1, 1, alpha);
            if (flip) {
                drawFillFlip(guiGraphics, left + 1, top + 1, right - 1 - foodWidth, bottom - 1, quenchWidth, qualityColor[Math.max(0, Math.min(3, quality))], true);
            } else {
                drawFillFlip(guiGraphics, left + 1 + foodWidth, top + 1, right - 1, bottom - 1, quenchWidth, qualityColor[Math.max(0, Math.min(3, quality))], false);
            }
            RenderSystem.setShaderColor(1, 1, 1, 1);
        }
        if (AsteorBar.config.displayExhaustion()) {
            RenderSystem.setShaderTexture(0, TEXTURE);
            int exhaustionWidth = (int) (innerWidth * (Math.min(4.0F, exhaustion) / 4.0F));
            drawTextureFillFlip(guiGraphics, left + 1, top, right - 1, exhaustionWidth, 5, 10, Y_FOOD_EXHAUSTION_FILL, FILL_FULL_WIDTH_LONG, flip);
            RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        }
    }

    @Override
    public void renderOverlay(RenderGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        if (!Overlays.dehydration || !AsteorBar.config.hookDehydration()) return;
        var player = gui.mc().player;
        if (player == null) return;
        ThirstManager thirstManager = ((ThirstManagerAccess) player).getThirstManager();
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
        int thirstQuench = 0;
        int quality = 0;
        float alpha = 1.0F;
        if (ConfigInit.CONFIG.thirst_preview && thirst < 20) {
            ItemStack itemStack = null;
            if (!player.getMainHandItem().isEmpty() && !player.getMainHandItem().getTooltipImage().isEmpty() && player.getMainHandItem().getTooltipImage().get() instanceof ThirstTooltipData) {
                itemStack = player.getMainHandItem();
            } else if (player.getOffhandItem().isEmpty() && !player.getOffhandItem().getTooltipImage().isEmpty() && player.getOffhandItem().getTooltipImage().get() instanceof ThirstTooltipData) {
                itemStack = player.getOffhandItem();
            }
            if (itemStack != null) {
                thirstQuench = ((ThirstTooltipData) itemStack.getTooltipImage().get()).getThirstQuench();
                if (itemStack.getItem() instanceof LeatherFlask) {
                    thirstQuench = ConfigInit.CONFIG.flask_thirst_quench;
                }
                quality = ((ThirstTooltipData) itemStack.getTooltipImage().get()).getDrinkQuality();
                alpha = (float) Math.cos(gui.gui().getGuiTicks() % 40 / 40.0 * Math.PI * 2) * 0.5F + 0.5F;
            }
        }
        switch (Overlays.style) {
            case Overlays.STYLE_NONE -> {

            }
            case Overlays.STYLE_ABOVE_HOT_BAR_LONG, Overlays.STYLE_ABOVE_HOT_BAR_SHORT -> {
                int left = screenWidth / 2 + 10;
                int top = screenHeight - gui.rightHeight() + 4;
                gui.rightHeight(6);
                draw(guiGraphics, left, top, left + BOUND_FULL_WIDTH_SHORT, top + 5, blinkTime > 0, thirstColor, thirst, thirstQuench, quality, dehydration, alpha, true);
            }
            case Overlays.STYLE_TOP_LEFT -> {
                int top = Overlays.vertical;
                int left = Overlays.horizontal;
                draw(guiGraphics, left, top, left + Overlays.length, top + 5, blinkTime > 0, thirstColor, thirst, thirstQuench, quality, dehydration, alpha, false);
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_TOP_RIGHT -> {
                int top = Overlays.vertical;
                int left = screenWidth - Overlays.length - Overlays.horizontal;
                draw(guiGraphics, left, top, left + Overlays.length, top + 5, blinkTime > 0, thirstColor, thirst, thirstQuench, quality, dehydration, alpha, true);
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_BOTTOM_LEFT -> {
                int top = screenHeight - Overlays.vertical;
                int left = Overlays.horizontal;
                draw(guiGraphics, left, top, left + Overlays.length, top + 5, blinkTime > 0, thirstColor, thirst, thirstQuench, quality, dehydration, alpha, false);
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_BOTTOM_RIGHT -> {
                int top = screenHeight - Overlays.vertical;
                int left = screenWidth - Overlays.length - Overlays.horizontal;
                draw(guiGraphics, left, top, left + Overlays.length, top + 5, blinkTime > 0, thirstColor, thirst, thirstQuench, quality, dehydration, alpha, true);
                Overlays.vertical += 6;
            }
        }
    }
}
