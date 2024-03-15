package com.afoxxvi.asteorbar.entity;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.utils.GuiHelper;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.List;

public class EntityRenderer {
    //reserved for third party mods
    public static final List<ExtraRenderer> EXTRA_RENDERERS = new ArrayList<>();
    public static final List<ExtraTextRenderer> EXTRA_TEXT_RENDERERS = new ArrayList<>();

    public static void extraRender(LivingEntity entity, PoseStack poseStack, MultiBufferSource multiBufferSource, float halfWidth, float halfHeight, float boundWidth) {
        EXTRA_RENDERERS.forEach(extraRenderer -> extraRenderer.render(entity, poseStack, multiBufferSource, halfWidth, halfHeight, boundWidth));
    }

    public static void extraTextRender(LivingEntity entity, PoseStack poseStack, MultiBufferSource multiBufferSource, float halfWidth, float halfHeight, float boundWidth, float textScale) {
        EXTRA_TEXT_RENDERERS.forEach(extraTextRenderer -> extraTextRenderer.render(entity, poseStack, multiBufferSource, halfWidth, halfHeight, boundWidth, textScale));
    }

    private static int check(LivingEntity entity, Player player) {
        if (entity.isInvisible()) return 1;
        if (entity.distanceTo(player) > AsteorBar.config.maxDistance()) return 2;
        if (entity.isInvisibleTo(player)) return 3;
        if (entity.isSpectator()) return 4;
        if (!AsteorBar.config.showOnSelf() && entity == player) return 5;
        if (!AsteorBar.config.showOnPlayers() && (entity instanceof Player)) return 6;
        if (!AsteorBar.config.showOnBosses() && AsteorBar.platformAdapter.isBoss(entity)) return 7;
        if (entity.getMaxHealth() == entity.getHealth()) {
            if (!AsteorBar.config.showOnFullHealthWithAbsorption() && entity.getAbsorptionAmount() > 0) return 8;
            if (!AsteorBar.config.showOnFullHealthWithoutAbsorption() && entity.getAbsorptionAmount() == 0) return 9;
        }
        if (!entity.hasLineOfSight(player)) return 10;
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
        RenderSystem.enableBlend();
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
            final var boundWidth = AsteorBar.config.healthBarBoundWidth();
            {//render absorption bar and bound
                final var colorAbsorption = AsteorBar.config.healthBarAbsorptionColor();
                final var colorBound = AsteorBar.config.healthBarBoundColor();
                final var includeVertex = AsteorBar.config.healthBarBoundVertex();
                var absorptionRate = entity.getAbsorptionAmount() / entity.getMaxHealth();
                var absorptionNum = Math.floor(absorptionRate);
                absorptionRate -= (float) absorptionNum;
                var absorptionWidth = Math.round((halfWidth * 2 + boundWidth * 2) * absorptionRate);
                if (absorptionWidth == 0 && absorptionNum > 0) {//special situation: absorption is equal to max health
                    absorptionWidth = 2 * halfWidth + boundWidth * 2;
                    absorptionNum--;
                }
                GuiHelper.renderBound(bufferBuilder, poseStack, -halfWidth, -halfHeight, halfWidth, halfHeight, absorptionWidth, boundWidth, colorAbsorption, colorBound, includeVertex, layerDist);
                if (absorptionNum * 2 * boundWidth > halfWidth) {//too long while using dot, use multiplier number
                    renderAbsorptionMultiplier = (int) absorptionNum;
                    //GuiHelper.renderSolid(bufferBuilder, poseStack, -halfWidth - expand, halfHeight + boundWidth * 2, -halfWidth - expand + boundWidth, halfHeight + boundWidth * 3, colorAbsorption, layerDist);
                } else {
                    final var expand = includeVertex ? boundWidth : 0;
                    for (int i = 0; i < absorptionNum; i++) {//render absorption / max health
                        GuiHelper.renderSolid(bufferBuilder, poseStack, -halfWidth - expand + i * boundWidth * 2, halfHeight + boundWidth * 2, -halfWidth - expand + i * boundWidth * 2 + boundWidth, halfHeight + boundWidth * 3, colorAbsorption, layerDist);
                    }
                }
            }
            extraRender(entity, poseStack, multiBufferSource, halfWidth, halfHeight, boundWidth);
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
                extraTextRender(entity, poseStack, multiBufferSource, halfWidth, halfHeight, boundWidth, textScale);
                poseStack.popPose();
            }
            poseStack.popPose();
        }
        poseStack.popPose();
        RenderSystem.disableBlend();
    }

    public interface ExtraRenderer {
        void render(LivingEntity entity, PoseStack poseStack, MultiBufferSource multiBufferSource, float halfWidth, float halfHeight, float boundWidth);
    }

    public interface ExtraTextRenderer {
        void render(LivingEntity entity, PoseStack poseStack, MultiBufferSource multiBufferSource, float halfWidth, float halfHeight, float boundWidth, float textScale);
    }

}
