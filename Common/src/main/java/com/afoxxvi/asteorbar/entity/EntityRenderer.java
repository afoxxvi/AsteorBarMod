package com.afoxxvi.asteorbar.entity;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.render.IHealthBarFeature;
import com.afoxxvi.asteorbar.utils.RenderHelper;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import org.joml.Quaternionf;

import java.util.ArrayList;
import java.util.List;

public class EntityRenderer {
    //reserved for third party mods
    public static final List<ExtraRenderer> EXTRA_RENDERERS = new ArrayList<>();
    public static final List<ExtraTextRenderer> EXTRA_TEXT_RENDERERS = new ArrayList<>();
    public static final Quaternionf FLIP_Y = new Quaternionf().rotationY((float) Math.PI);

    public static void extraSubmit(LivingEntityRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector, float halfWidth, float halfHeight, float boundWidth) {
        EXTRA_RENDERERS.forEach(extraRenderer -> extraRenderer.render(renderState, poseStack, nodeCollector, halfWidth, halfHeight, boundWidth));
    }

    public static void extraTextSubmit(LivingEntityRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector, float halfWidth, float halfHeight, float boundWidth, float textScale) {
        EXTRA_TEXT_RENDERERS.forEach(extraTextRenderer -> extraTextRenderer.render(renderState, poseStack, nodeCollector, halfWidth, halfHeight, boundWidth, textScale));
    }

    public static boolean shouldRender(LivingEntity entity, Player player) {
        if (entity == null || player == null) return false;
        return check(entity, player) == 0;
    }

    private static int check(LivingEntity entity, Player player) {
        if (entity.isInvisible()) return 1;
        if (entity.distanceTo(player) > AsteorBar.config.maxDistance()) return 2;
        if (entity.isInvisibleTo(player)) return 3;
        if (entity.isSpectator()) return 4;
        if (!AsteorBar.config.showOnSelf() && entity == player) return 5;
        if (!AsteorBar.config.showOnPlayers() && (entity instanceof Player)) return 6;
        if (!AsteorBar.config.showOnBosses() && AsteorBar.platformAdapter.isBoss(entity)) return 7;
        if (!AsteorBar.config.showOnArmorStands() && entity instanceof ArmorStand) return 11;
        if (entity.getMaxHealth() == entity.getHealth()) {
            if (!AsteorBar.config.showOnFullHealthWithAbsorption() && entity.getAbsorptionAmount() > 0) return 8;
            if (!AsteorBar.config.showOnFullHealthWithoutAbsorption() && entity.getAbsorptionAmount() == 0) return 9;
        }
        if (!entity.hasLineOfSight(player)) return 10;
        return 0;
    }

    private static int modifyAlpha(int color, int alpha) {
        if (alpha == 0) return color;
        return (color & 0x00ffffff) | (alpha << 24);
    }

    public static void submit(IHealthBarFeature feature, LivingEntityRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector) {
        var dist = Math.sqrt(renderState.distanceToCameraSq);
        //The layers will start to flash if too close
        var layerDist = Math.max(0.002F, (float) dist * 0.002F);
        final var alpha = AsteorBar.config.healthBarAlpha();
        poseStack.pushPose();
        poseStack.translate(0, renderState.boundingBoxHeight + AsteorBar.config.healthBarOffsetY(), 0);
        /*
         * What's wrong with rotation?
         * Old code:
         * poseStack.mulPose(Minecraft.getInstance().getEntityRenderDispatcher().cameraOrientation());
         */
        // Start Of Rotation
        if (!feature.asteorBar$inInventory()) {
            final var camera = Minecraft.getInstance().getEntityRenderDispatcher().camera;
            if (camera != null) {
                poseStack.mulPose(Minecraft.getInstance().getEntityRenderDispatcher().camera.rotation());
                poseStack.mulPose(FLIP_Y);
            }
        }
        // End Of Rotation

        {//render health bar
            poseStack.pushPose();
            var scale = (float) AsteorBar.config.healthBarScale();
            var halfWidth = AsteorBar.config.healthBarHalfWidth();
            var halfHeight = AsteorBar.config.healthBarHalfHeight();
            poseStack.scale(-scale, -scale, scale);
            {//render health bar
                var healthRate = Math.min(feature.asteorBar$getHealth() / feature.asteorBar$getMaxHealth(), 1.0);
                var healthWidth = (int) (halfWidth * 2 * healthRate);
                int colorHealth;
                if (AsteorBar.config.healthBarHealthColorDynamic()) {
                    colorHealth = Utils.mixColor(AsteorBar.config.healthBarHealthColorFull(), AsteorBar.config.healthBarHealthColorEmpty(), healthRate);
                } else {
                    colorHealth = AsteorBar.config.healthBarHealthColor();
                }
                colorHealth = modifyAlpha(colorHealth, alpha);
                final var colorEmpty = modifyAlpha(AsteorBar.config.healthBarEmptyColor(), alpha);
                if (healthWidth > 0) {
                    RenderHelper.submitSolidGradient(nodeCollector, poseStack, -halfWidth, -halfHeight, -halfWidth + healthWidth, halfHeight, colorHealth, layerDist);
                }
                if (healthWidth < 2 * halfWidth) {
                    RenderHelper.submitSolidGradientUpDown(nodeCollector, poseStack, -halfWidth + healthWidth, -halfHeight, halfWidth, halfHeight, colorEmpty, layerDist);
                }
            }
            int renderAbsorptionMultiplier = -1;
            final var boundWidth = AsteorBar.config.healthBarBoundWidth();
            {//render absorption bar and bound
                final var colorAbsorption = modifyAlpha(AsteorBar.config.healthBarAbsorptionColor(), alpha);
                final var colorBound = modifyAlpha(AsteorBar.config.healthBarBoundColor(), alpha);
                final var includeVertex = AsteorBar.config.healthBarBoundVertex();
                var absorptionRate = feature.asteorBar$getAbsorptionAmount() / feature.asteorBar$getMaxHealth();
                var absorptionNum = Math.floor(absorptionRate);
                absorptionRate -= (float) absorptionNum;
                var absorptionWidth = (int) Math.round((halfWidth * 2 + boundWidth * 2) * absorptionRate);
                if (absorptionWidth == 0 && absorptionNum > 0) {//special situation: absorption is equal to max health
                    absorptionWidth = 2 * halfWidth + boundWidth * 2;
                    absorptionNum--;
                }
                RenderHelper.submitBound(nodeCollector, poseStack, -halfWidth, -halfHeight, halfWidth, halfHeight, absorptionWidth, boundWidth, colorAbsorption, colorBound, includeVertex, layerDist);
                if (absorptionNum * 2 * boundWidth > halfWidth) {//too long while using dot, use multiplier number
                    renderAbsorptionMultiplier = (int) absorptionNum;
                } else {
                    final var expand = includeVertex ? boundWidth : 0;
                    for (int i = 0; i < absorptionNum; i++) {//render absorption / max health
                        RenderHelper.submitSolid(nodeCollector, poseStack, -halfWidth - expand + i * boundWidth * 2, halfHeight + boundWidth * 2, -halfWidth - expand + i * boundWidth * 2 + boundWidth, halfHeight + boundWidth * 3, colorAbsorption, layerDist);
                    }
                }
            }
            extraSubmit(renderState, poseStack, nodeCollector, halfWidth, halfHeight, boundWidth);
            {//render text
                float textScale = (float) AsteorBar.config.healthBarTextScale();
                var textOffset = AsteorBar.config.healthBarTextOffsetY();
                poseStack.pushPose();
                poseStack.translate(0, textOffset, 0);
                poseStack.scale(textScale, textScale, textScale);
                var font = Minecraft.getInstance().font;
                //health
                var healthStr = Utils.formatNumber(feature.asteorBar$getHealth()) + "/" + Utils.formatNumber(feature.asteorBar$getMaxHealth());
                RenderHelper.submitCenteredString(nodeCollector, poseStack, healthStr, 0, 0, 0xffffffff);
                //absorption
                if (feature.asteorBar$getAbsorptionAmount() > 0) {
                    var absStr = Utils.formatNumber(feature.asteorBar$getAbsorptionAmount());
                    RenderHelper.submitString(nodeCollector, poseStack, absStr, (int) ((-halfWidth + 1) / textScale), 0, 0xffffff00);
                }
                if (renderAbsorptionMultiplier > 0) {
                    var absStr = renderAbsorptionMultiplier + "×";
                    RenderHelper.submitString(nodeCollector, poseStack, absStr, (int) ((-halfWidth - 1 - font.width(absStr)) / textScale), 0, 0xffffff00);
                }
                extraTextSubmit(renderState, poseStack, nodeCollector, halfWidth, halfHeight, boundWidth, textScale);
                poseStack.popPose();
            }
            poseStack.popPose();
        }
        poseStack.popPose();
    }

    public interface ExtraRenderer {
        void render(LivingEntityRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector, float halfWidth, float halfHeight, float boundWidth);
    }

    public interface ExtraTextRenderer {
        void render(LivingEntityRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector, float halfWidth, float halfHeight, float boundWidth, float textScale);
    }

}
