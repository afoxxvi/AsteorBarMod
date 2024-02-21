package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.mixin.thrid.ToughAsNailsTemperatureMixin;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import toughasnails.api.potion.TANEffects;
import toughasnails.api.thirst.IThirst;
import toughasnails.api.thirst.ThirstHelper;
import toughasnails.init.ModConfig;

public class ToughAsNailsOverlay extends BaseOverlay {
    private int thirstBlinkTime = 0;

    @SuppressWarnings("DuplicatedCode")
    private void draw(GuiGraphics guiGraphics, int left, int top, int right, int bottom, boolean highlight, int thirstColor, int thirstLevel, float hydration, float exhaustion, boolean flip) {
        var boundColor = Utils.mixColor(0xff000000, thirstColor, 0.5);
        if (highlight) boundColor = Utils.mixColor(0xffffffff, thirstColor, 0.2);
        drawBound(guiGraphics, left, top, right, bottom, boundColor);
        drawEmptyFill(guiGraphics, left + 1, top + 1, right - 1, bottom - 1, AsteorBar.config.foodEmptyColor());
        final int innerWidth = right - left - 2;
        int thirstWidth = (int) (innerWidth * thirstLevel / 20.0F);
        drawFillFlip(guiGraphics, left + 1, top + 1, right - 1, bottom - 1, thirstWidth, thirstColor, flip);
        if (AsteorBar.config.displaySaturation()) {
            int saturationWidth = (int) ((right - left) * (hydration / 10.0));
            drawBoundFlip(guiGraphics, left, top, right, bottom, saturationWidth, 0xff2d65d6, flip);
        }
        if (AsteorBar.config.displayExhaustion()) {
            RenderSystem.setShaderTexture(0, TEXTURE);
            var cap = ModConfig.thirst.thirstExhaustionThreshold;
            int exhaustionWidth = (int) (innerWidth * (Math.min(cap, exhaustion) / cap));
            drawTextureFillFlip(guiGraphics, left + 1, top, right - 1, exhaustionWidth, 5, 10, Y_FOOD_EXHAUSTION_FILL, FILL_FULL_WIDTH_LONG, flip);
            RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void renderOverlay(RenderGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        if (!Overlays.toughAsNails || !AsteorBar.config.hookToughAsNails()) return;
        ToughAsNailsTemperatureMixin.invokeRenderTemperature(guiGraphics, partialTick, screenWidth, screenHeight);
        if (!ThirstHelper.isThirstEnabled()) return;
        RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        var player = gui.mc().player;
        if (player == null) return;
        IThirst thirst = ThirstHelper.getThirst(player);
        int level = thirst.getThirst();
        float hydration = thirst.getHydration();
        float exhaustion = thirst.getExhaustion();
        int thirstColor = 0xff1c5ee4;
        if (player.hasEffect(TANEffects.THIRST)) {
            thirstColor = 0xff76db4c;
        }
        if (AsteorBar.config.enableFoodBlink()) {
            if (hydration <= 0.0F && gui.gui().getGuiTicks() % (Math.max(4, level) * 3L + 1) == 0) {
                thirstBlinkTime = 2;
            }
            if (thirstBlinkTime > 0) {
                thirstBlinkTime--;
            }
        }
        switch (Overlays.style) {
            case Overlays.STYLE_NONE -> {

            }
            case Overlays.STYLE_ABOVE_HOT_BAR_LONG, Overlays.STYLE_ABOVE_HOT_BAR_SHORT -> {
                int left = screenWidth / 2 + 10;
                int top = screenHeight - gui.rightHeight() + 4;
                gui.rightHeight(6);
                draw(guiGraphics, left, top, left + BOUND_FULL_WIDTH_SHORT, top + 5, thirstBlinkTime > 0, thirstColor, level, hydration, exhaustion, true);
            }
            case Overlays.STYLE_TOP_LEFT -> {
                int top = Overlays.vertical;
                int left = Overlays.horizontal;
                draw(guiGraphics, left, top, left + Overlays.length, top + 5, thirstBlinkTime > 0, thirstColor, level, hydration, exhaustion, false);
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_TOP_RIGHT -> {
                int top = Overlays.vertical;
                int left = screenWidth - Overlays.length - Overlays.horizontal;
                draw(guiGraphics, left, top, left + Overlays.length, top + 5, thirstBlinkTime > 0, thirstColor, level, hydration, exhaustion, true);
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_BOTTOM_LEFT -> {
                int top = screenHeight - Overlays.vertical;
                int left = Overlays.horizontal;
                draw(guiGraphics, left, top, left + Overlays.length, top + 5, thirstBlinkTime > 0, thirstColor, level, hydration, exhaustion, false);
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_BOTTOM_RIGHT -> {
                int top = screenHeight - Overlays.vertical;
                int left = screenWidth - Overlays.length - Overlays.horizontal;
                draw(guiGraphics, left, top, left + Overlays.length, top + 5, thirstBlinkTime > 0, thirstColor, level, hydration, exhaustion, true);
                Overlays.vertical += 6;
            }
        }
    }
}
