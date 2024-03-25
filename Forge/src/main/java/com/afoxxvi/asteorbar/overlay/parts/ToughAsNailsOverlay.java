package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import toughasnails.api.potion.TANEffects;
import toughasnails.api.thirst.IThirst;
import toughasnails.api.thirst.ThirstHelper;
import toughasnails.init.ModConfig;

public class ToughAsNailsOverlay extends SimpleBarOverlay {
    private int thirstBlinkTime = 0;
    private float exhaustion = 0;

    @Override
    protected Parameters getParameters(Player player) {
        IThirst thirst = ThirstHelper.getThirst(player);
        if (thirst == null) return null;
        int level = thirst.getThirst();
        float hydration = thirst.getHydration();
        exhaustion = thirst.getExhaustion();
        final Parameters parameters = new Parameters();
        parameters.fillColor = 0xff1c5ee4;
        if (player.hasEffect(TANEffects.THIRST)) {
            parameters.fillColor = 0xff76db4c;
        }
        if (AsteorBar.config.enableFoodBlink()) {
            if (hydration <= 0.0F && tick % (Math.max(4, level) * 3L + 1) == 0) {
                thirstBlinkTime = 2;
            }
            if (thirstBlinkTime > 0) {
                thirstBlinkTime--;
            }
        }
        parameters.boundColor = Utils.mixColor(0xff000000, parameters.fillColor, 0.5);
        if (thirstBlinkTime > 0) parameters.boundColor = Utils.mixColor(0xffffffff, parameters.fillColor, 0.2);
        parameters.emptyColor = AsteorBar.config.foodEmptyColor();
        parameters.value = thirst.getThirst();
        parameters.capacity = 20;
        if (AsteorBar.config.displaySaturation()) {
            parameters.boundFillColor = 0xff2d65d6;
            parameters.boundValue = hydration;
            parameters.boundCapacity = 10;
        }
        return parameters;
    }

    @Override
    protected void drawDecorations(GuiGraphics guiGraphics, int left, int top, int right, int bottom, Parameters parameters, boolean flip) {
        super.drawDecorations(guiGraphics, left, top, right, bottom, parameters, flip);
        if (AsteorBar.config.displayExhaustion()) {
            RenderSystem.setShaderTexture(0, TEXTURE);
            var cap = ModConfig.thirst.thirstExhaustionThreshold;
            int exhaustionWidth = (int) ((right - left - 2) * (Math.min(cap, exhaustion) / cap));
            drawTextureFillFlip(guiGraphics, left + 1, top, right - 1, exhaustionWidth, 5, 10, Y_FOOD_EXHAUSTION_FILL, FILL_FULL_WIDTH_LONG, flip);
            RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        }
    }

    @Override
    protected boolean shouldRender(Player player) {
        return Overlays.toughAsNails && AsteorBar.config.hookToughAsNails() && ThirstHelper.isThirstEnabled();
    }
}
