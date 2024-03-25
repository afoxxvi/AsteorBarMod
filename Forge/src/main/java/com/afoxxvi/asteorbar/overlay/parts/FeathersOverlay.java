package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.elenai.feathers.client.ClientFeathersData;
import com.elenai.feathers.effect.FeathersEffects;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.player.Player;

public class FeathersOverlay extends SimpleBarOverlay {
    int times = 0;
    int regenerationOffset = -1;
    int tickCount = 0;

    @Override
    public void renderOverlay(RenderGui gui, PoseStack poseStack, float partialTick, int screenWidth, int screenHeight) {
        tickCount = gui.gui().getGuiTicks();
        super.renderOverlay(gui, poseStack, partialTick, screenWidth, screenHeight);
    }

    @Override
    protected Parameters getParameters(Player player) {
        final var parameters = new Parameters();
        parameters.boundColor = ClientFeathersData.isCold() ? 0xff1c4652 : 0xff202020;
        parameters.fillColor = ClientFeathersData.isCold() ? 0xffa8f7ff : 0xff22a5f0;
        parameters.emptyColor = ClientFeathersData.isCold() ? 0xff265d6c : 0xff083d5a;
        parameters.value = ClientFeathersData.getFeathers();
        parameters.capacity = ClientFeathersData.getMaxFeathers();
        if (ClientFeathersData.getEnduranceFeathers() > 0) {
            parameters.boundFillColor = 0xffd4af37;
            int capacity = ClientFeathersData.getMaxFeathers();
            int value = ClientFeathersData.getEnduranceFeathers();
            if (capacity < value) {
                if (value % capacity == 0) {
                    times = value / capacity - 1;
                    value = capacity;
                } else {
                    times = value / capacity;
                    value = value % capacity;
                }
            }
            parameters.boundCapacity = capacity;
            parameters.boundValue = value;
        } else {
            times = 0;
        }
        if (player.hasEffect(FeathersEffects.ENERGIZED.get())) {
            regenerationOffset = tickCount % 30 * 6;
        } else {
            regenerationOffset = -1;
        }
        return parameters;
    }

    @Override
    protected void drawDecorations(PoseStack poseStack, int left, int top, int right, int bottom, Parameters parameters, boolean flip) {
        super.drawDecorations(poseStack, left, top, right, bottom, parameters, flip);
        final int innerWidth = right - left - 2;
        final int fillWidth = innerWidth * ClientFeathersData.getWeight() / ClientFeathersData.getMaxFeathers();
        drawFillFlip(poseStack, left + 1, top + 1, right - 1, bottom - 1, fillWidth, 0xffb8b9c4, flip);
        if (times > 0) {
            if (flip) {
                Overlays.addStringRender(right, top - 2, 0xd4af37, "×" + times, Overlays.ALIGN_LEFT, true);
            } else {
                Overlays.addStringRender(left, top - 2, 0xd4af37, times + "×", Overlays.ALIGN_RIGHT, true);
            }
        }
        if (regenerationOffset >= 0) {
            int textureLeft = flip ? regenerationOffset - 180 : -regenerationOffset;
            int textureRight = textureLeft + right - left - 2;
            RenderSystem.setShaderTexture(0, TEXTURE);
            if (textureRight > 0) {
                drawTextureFillColor(poseStack, left + 1, top, -textureLeft, 5, 10 + 180 + textureLeft, Y_REGENERATION_FILL, -textureLeft, 5, 0xffbedcfa);
                drawTextureFillColor(poseStack, left + 1 - textureLeft, top, textureRight, 5, 10, Y_REGENERATION_FILL, textureRight, 5, 0xffbedcfa);
            } else {
                drawTextureFillColor(poseStack, left + 1, top, right - left - 2, 5, 10 + 180 + textureLeft, Y_REGENERATION_FILL, right - left - 2, 5, 0xffbedcfa);
            }
            RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        }
    }

    @Override
    protected boolean shouldRender(Player player) {
        return Overlays.feathers && AsteorBar.config.hookFeathers() && !(ClientFeathersData.getMaxFeathers() <= 0 & ClientFeathersData.getEnduranceFeathers() == 0);
    }
}
