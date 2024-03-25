package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import dev.ghen.thirst.content.thirst.PlayerThirst;
import dev.ghen.thirst.foundation.common.capability.IThirst;
import dev.ghen.thirst.foundation.common.capability.ModCapabilities;
import net.minecraft.world.entity.player.Player;

public class ThirstOverlay extends SimpleBarOverlay {
    private int thirstBlinkTime = 0;
    private float exhaustion = 0.0F;

    @Override
    protected Parameters getParameters(Player player) {
        final var thirstLazyOptional = player.getCapability(ModCapabilities.PLAYER_THIRST);
        if (!thirstLazyOptional.isPresent()) {
            return null;
        }
        IThirst thirst = thirstLazyOptional.orElse(new PlayerThirst());
        int level = thirst.getThirst();
        float quenched = thirst.getQuenched();
        exhaustion = thirst.getExhaustion();
        final var parameters = new Parameters();
        parameters.value = level;
        parameters.capacity = 20;
        parameters.fillColor = 0xff37bac4;
        parameters.emptyColor = AsteorBar.config.foodEmptyColor();
        parameters.boundColor = Utils.mixColor(0xff000000, parameters.fillColor, 0.5);
        if (thirstBlinkTime > 0) {
            parameters.boundColor = Utils.mixColor(0xffffffff, parameters.fillColor, 0.08);
        }
        if (AsteorBar.config.displaySaturation()) {
            parameters.boundFillColor = 0xff2d65d6;
            parameters.boundCapacity = 10;
            parameters.boundValue = quenched;
        }
        if (AsteorBar.config.enableFoodBlink()) {
            if (quenched <= 0.0F && tick % (Math.max(4, level) * 3L + 1) == 0) {
                thirstBlinkTime = 2;
            }
            if (thirstBlinkTime > 0) {
                thirstBlinkTime--;
            }
        }
        return parameters;
    }

    @Override
    protected void drawDecorations(PoseStack poseStack, int left, int top, int right, int bottom, Parameters parameters, boolean flip) {
        super.drawDecorations(poseStack, left, top, right, bottom, parameters, flip);
        if (AsteorBar.config.displayExhaustion()) {
            RenderSystem.setShaderTexture(0, TEXTURE);
            var cap = 4.0F;
            int exhaustionWidth = (int) ((right - left - 2) * (Math.min(cap, exhaustion) / cap));
            drawTextureFillFlip(poseStack, left + 1, top, right - 1, exhaustionWidth, 5, 10, Y_FOOD_EXHAUSTION_FILL, FILL_FULL_WIDTH_LONG, flip);
            RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        }
    }

    @Override
    protected boolean shouldRender(Player player) {
        return Overlays.thirst && AsteorBar.config.hookThirstWasTaken();
    }
}
