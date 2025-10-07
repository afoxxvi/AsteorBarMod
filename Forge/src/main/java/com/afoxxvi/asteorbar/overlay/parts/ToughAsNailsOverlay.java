package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import toughasnails.api.potion.TANEffects;
import toughasnails.api.thirst.IThirst;
import toughasnails.api.thirst.ThirstHelper;
import toughasnails.init.ModConfig;
import toughasnails.temperature.TemperatureOverlayRenderer;

public class ToughAsNailsOverlay extends SimpleBarOverlay {
    private int thirstBlinkTime = 0;
    private float exhaustion;

    @Override
    protected Parameters getParameters(Player player) {
        var parameters = new Parameters();
        IThirst thirst = ThirstHelper.getThirst(player);
        int level = thirst.getThirst();
        float hydration = thirst.getHydration();
        exhaustion = thirst.getExhaustion();
        int thirstColor = 0xff1c5ee4;
        if (player.hasEffect(TANEffects.THIRST)) {
            thirstColor = 0xff76db4c;
        }
        if (level <= 4) {
            parameters.verticalShift = FoodLevelOverlay.SHIFT[tick / (level + 1) % FoodLevelOverlay.SHIFT.length];
        }
        if (AsteorBar.config.enableFoodBlink()) {
            if (hydration <= 0.0F && tick % (Math.max(4, level) * 3L + 1) == 0) {
                thirstBlinkTime = 2;
            }
            if (thirstBlinkTime > 0) {
                thirstBlinkTime--;
            }
        }
        boolean highlight = thirstBlinkTime > 0;
        parameters.boundColor = highlight ? Utils.mixColor(0xffffffff, thirstColor, 0.2) : Utils.mixColor(0xff000000, thirstColor, 0.5);
        parameters.emptyColor = AsteorBar.config.foodEmptyColor();
        parameters.fillColor = thirstColor;
        parameters.capacity = 20;
        parameters.value = level;
        if (AsteorBar.config.displaySaturation()) {
            parameters.boundFillColor = 0xff2d65d6;
            parameters.boundValue = hydration;
            parameters.boundCapacity = 10;
        }
        if (AsteorBar.config.displayFoodText()) {
            parameters.centerText = Utils.formatNumber(level) + "/" + Utils.formatNumber(20);
            parameters.centerColor = 0xFFFFFF;
        }
        return parameters;
    }

    @Override
    protected boolean shouldRender(Player player) {
        return AsteorBar.compatibility.toughAsNails && AsteorBar.config.hookToughAsNails() && ThirstHelper.isThirstEnabled();
    }


    @Override
    protected void drawDecorations(GuiGraphics guiGraphics, int left, int top, int right, int bottom, Parameters parameters, boolean flip) {
        super.drawDecorations(guiGraphics, left, top, right, bottom, parameters, flip);
        int innerWidth = right - left - 2;
        if (AsteorBar.config.displayExhaustion()) {
            var cap = ModConfig.thirst.thirstExhaustionThreshold;
            int exhaustionWidth = (int) (innerWidth * (Math.min(cap, exhaustion) / cap));
            drawTextureFillFlip(guiGraphics, left + 1, top, right - 1, exhaustionWidth, 5, 10, Y_FOOD_EXHAUSTION_FILL, FILL_FULL_WIDTH_LONG, flip);
        }
    }

    @Override
    public void renderOverlay(RenderGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        if (!AsteorBar.compatibility.toughAsNails || !AsteorBar.config.hookToughAsNails()) return;
        TemperatureOverlayRenderer.renderTemperature(guiGraphics, partialTick, screenWidth, screenHeight);
        super.renderOverlay(gui, guiGraphics, partialTick, screenWidth, screenHeight);
    }
}
