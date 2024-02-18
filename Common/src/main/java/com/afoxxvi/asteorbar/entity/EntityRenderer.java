package com.afoxxvi.asteorbar.entity;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.utils.GuiHelper;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class EntityRenderer {
    private static int check(LivingEntity entity, Player player) {
        if (entity.isInvisible()) return 1;
        if (entity.distanceTo(player) > AsteorBar.config.maxDistance()) return 2;
        if (entity.isInvisibleTo(player)) return 3;
        if (entity.isSpectator()) return 4;
        if (!AsteorBar.config.showOnPlayers() && (entity instanceof Player)) return 5;
        if (!AsteorBar.config.showOnBosses() && AsteorBar.platformAdapter.isBoss(entity)) return 6;
        if (entity.getMaxHealth() == entity.getHealth()) {
            if (!AsteorBar.config.showOnFullHealthWithAbsorption() && entity.getAbsorptionAmount() > 0) return 7;
            if (!AsteorBar.config.showOnFullHealthWithoutAbsorption() && entity.getAbsorptionAmount() == 0) return 8;
        }
        if (!entity.hasLineOfSight(player)) return 9;
        return 0;
    }

    public static void render(LivingEntity entity, PoseStack poseStack, MultiBufferSource multiBufferSource) {
        var player = Minecraft.getInstance().player;
        if (player == null) return;
        var check = check(entity, player);
        if (check > 0) {
            //AsteorBar.LOGGER.info("check failed" + check);
            return;
        }
        var dist = entity.distanceTo(player);
        //The layers will start to flash if too close
        var layerDist = Math.max(0.002F, dist * 0.002F);
        poseStack.pushPose();
        poseStack.translate(0, entity.getBbHeight() + AsteorBar.config.healthBarOffsetY(), 0);
        poseStack.mulPose(Minecraft.getInstance().getEntityRenderDispatcher().cameraOrientation());
        {//render health bar
            poseStack.pushPose();
            var scale = (float) AsteorBar.config.healthBarScale();
            var halfWidth = AsteorBar.config.healthBarHalfWidth();
            var halfHeight = AsteorBar.config.healthBarHalfHeight();
            poseStack.scale(-scale, -scale, scale);
            var bufferBuilder = multiBufferSource.getBuffer(AsteorBar.platformAdapter.getRenderType());
            {//render health bar
                var healthRate = Math.min(entity.getHealth() / entity.getMaxHealth(), 1.0);
                var healthWidth = (int) (halfWidth * 2 * healthRate);
                int colorHealth;
                if (AsteorBar.config.healthBarHealthColorDynamic()) {
                    colorHealth = Utils.mixColor(AsteorBar.config.healthBarHealthColorFull(), AsteorBar.config.healthBarHealthColorEmpty(), healthRate);
                } else {
                    colorHealth = AsteorBar.config.healthBarHealthColor();
                }
                final var colorEmpty = AsteorBar.config.healthBarEmptyColor();
                if (healthWidth > 0) {
                    GuiHelper.renderSolidGradient(bufferBuilder, poseStack, -halfWidth, -halfHeight, -halfWidth + healthWidth, halfHeight, colorHealth, layerDist);
                }
                if (healthWidth < 2 * halfWidth) {
                    GuiHelper.renderSolidGradientUpDown(bufferBuilder, poseStack, -halfWidth + healthWidth, -halfHeight, halfWidth, halfHeight, colorEmpty, layerDist);
                }
            }
            int renderAbsorptionMultiplier = -1;
            {//render absorption bar and bound
                final var colorAbsorption = AsteorBar.config.healthBarAbsorptionColor();
                final var colorBound = AsteorBar.config.healthBarBoundColor();
                var absorptionRate = entity.getAbsorptionAmount() / entity.getMaxHealth();
                var absorptionNum = Math.floor(absorptionRate);
                absorptionRate -= (float) absorptionNum;
                var absorptionWidth = Math.round((halfWidth * 2 + 2) * absorptionRate);
                if (absorptionWidth == 0 && absorptionNum > 0) {
                    absorptionWidth = 2 * halfWidth + 2;
                    absorptionNum--;
                }
                var cut = 0;
                final var boundWidth = AsteorBar.config.healthBarBoundWidth();
                var expand = AsteorBar.config.healthBarBoundVertex() ? boundWidth : 0;
                if (absorptionWidth > 0) {//left bound, vertex included
                    cut++;
                    GuiHelper.renderSolid(bufferBuilder, poseStack, -halfWidth - boundWidth, -halfHeight - expand, -halfWidth, halfHeight + expand, colorAbsorption, layerDist);
                } else {
                    GuiHelper.renderSolid(bufferBuilder, poseStack, -halfWidth - boundWidth, -halfHeight - expand, -halfWidth, halfHeight + expand, colorBound, layerDist);
                }
                if (absorptionWidth >= 2 * halfWidth + 2) {//right bound, vertex included
                    cut++;
                    GuiHelper.renderSolid(bufferBuilder, poseStack, halfWidth, -halfHeight - expand, halfWidth + boundWidth, halfHeight + expand, colorAbsorption, layerDist);
                } else {
                    GuiHelper.renderSolid(bufferBuilder, poseStack, halfWidth, -halfHeight - expand, halfWidth + boundWidth, halfHeight + expand, colorBound, layerDist);
                }
                absorptionWidth -= cut;
                if (absorptionWidth > 0) {//upper and lower bound, vertex excluded
                    GuiHelper.renderSolid(bufferBuilder, poseStack, -halfWidth, -halfHeight - boundWidth, -halfWidth + absorptionWidth, -halfHeight, colorAbsorption, layerDist);
                    GuiHelper.renderSolid(bufferBuilder, poseStack, -halfWidth, halfHeight, -halfWidth + absorptionWidth, halfHeight + boundWidth, colorAbsorption, layerDist);
                }
                if (absorptionWidth < 2 * halfWidth) {
                    GuiHelper.renderSolid(bufferBuilder, poseStack, -halfWidth + absorptionWidth, -halfHeight - boundWidth, halfWidth, -halfHeight, colorBound, layerDist);
                    GuiHelper.renderSolid(bufferBuilder, poseStack, -halfWidth + absorptionWidth, halfHeight, halfWidth, halfHeight + boundWidth, colorBound, layerDist);
                }
                if (absorptionNum * 2 * boundWidth > halfWidth) {
                    renderAbsorptionMultiplier = (int) absorptionNum;
                    //GuiHelper.renderSolid(bufferBuilder, poseStack, -halfWidth - expand, halfHeight + boundWidth * 2, -halfWidth - expand + boundWidth, halfHeight + boundWidth * 3, colorAbsorption, layerDist);
                } else {
                    for (int i = 0; i < absorptionNum; i++) {//render absorption / max health
                        GuiHelper.renderSolid(bufferBuilder, poseStack, -halfWidth - expand + i * boundWidth * 2, halfHeight + boundWidth * 2, -halfWidth - expand + i * boundWidth * 2 + boundWidth, halfHeight + boundWidth * 3, colorAbsorption, layerDist);
                    }
                }
            }
            {//render text
                float textScale = (float) AsteorBar.config.healthBarTextScale();
                var textOffset = AsteorBar.config.healthBarTextOffsetY();
                poseStack.pushPose();
                poseStack.translate(0, textOffset, 0);
                poseStack.scale(textScale, textScale, textScale);
                var font = Minecraft.getInstance().font;
                //health
                var healthStr = Utils.formatNumber(entity.getHealth()) + "/" + Utils.formatNumber(entity.getMaxHealth());
                GuiHelper.renderCenteredString(poseStack, multiBufferSource, healthStr, 0, 0, 0xffffff);
                //absorption
                if (entity.getAbsorptionAmount() > 0) {
                    var absStr = Utils.formatNumber(entity.getAbsorptionAmount());
                    GuiHelper.renderString(poseStack, multiBufferSource, absStr, (int) ((-halfWidth + 1) / textScale), 0, 0xffff00);
                }
                if (renderAbsorptionMultiplier > 0) {
                    var absStr = renderAbsorptionMultiplier + "×";
                    GuiHelper.renderString(poseStack, multiBufferSource, absStr, (int) ((-halfWidth - 1 - font.width(absStr)) / textScale), 0, 0xffff00);
                }
                poseStack.popPose();
            }
            poseStack.popPose();
        }
        poseStack.popPose();
    }
}
