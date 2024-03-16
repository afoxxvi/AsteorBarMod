package com.afoxxvi.asteorbar.entity;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.utils.GuiHelper;
import com.afoxxvi.asteorbar.utils.Utils;
import luoyu.lightshield.Api;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

public class LightShieldRenderer {
    private static boolean init = false;

    public static void init() {
        if (init) return;
        if (!Overlays.lightShield) return;
        init = true;
        EntityRenderer.EXTRA_RENDERERS.add((entity, poseStack, multiBufferSource, halfWidth, halfHeight, boundWidth) -> {
            if (entity instanceof Player player) {
                final var shield = Api.getShieldAmount(player);
                final var maxHealth = player.getMaxHealth();
                if (shield <= 0) return;
                var bufferBuilder = multiBufferSource.getBuffer(AsteorBar.platformAdapter.getRenderType());
                {//render absorption bar and bound
                    final var colorShield = 0xff8cb3ca;
                    final var includeVertex = AsteorBar.config.healthBarBoundVertex();
                    var shieldRate = shield / maxHealth;
                    var shieldNum = Math.floor(shieldRate);
                    final var expand = includeVertex ? boundWidth : 0;
                    shieldRate -= (float) shieldNum;
                    var shieldWidth = Math.round((halfWidth * 2 + expand * 2) * shieldRate);
                    if (shieldWidth == 0 && shieldNum > 0) {//special situation: absorption is equal to max health
                        shieldWidth = (int) (2 * halfWidth + expand * 2);
                        shieldNum--;
                    }
                    GuiHelper.renderSolid(bufferBuilder, poseStack, (int) (-halfWidth - expand), (int) (halfHeight), (int) (-halfWidth - expand + shieldWidth), (int) (halfHeight + boundWidth), colorShield, -0.1F);
                    if (shieldNum * 2 * boundWidth <= halfWidth) {
                        for (int i = 0; i < shieldNum; i++) {//render absorption / max health
                            GuiHelper.renderSolid(bufferBuilder, poseStack, (int) (halfWidth + expand - i * boundWidth * 2 - boundWidth), (int) (halfHeight + boundWidth * 2), (int) (halfWidth + expand - i * boundWidth * 2), (int) (halfHeight + boundWidth * 3), colorShield, -0.1F);
                        }
                    }
                }

            }
        });
        EntityRenderer.EXTRA_TEXT_RENDERERS.add((entity, poseStack, multiBufferSource, halfWidth, halfHeight, boundWidth, textScale) -> {
            if (entity instanceof Player player) {
                final var shield = Api.getShieldAmount(player);
                final var maxHealth = player.getMaxHealth();
                if (shield <= 0) return;
                var shieldRate = shield / maxHealth;
                var shieldNum = Math.floor(shieldRate);
                var str = Utils.formatNumber(shield);
                if (shieldRate - shieldNum == 0.0 && shieldNum > 0) {//special situation: absorption is equal to max health
                    shieldNum--;
                }
                GuiHelper.renderString(poseStack, multiBufferSource, str, (int) ((halfWidth - 1 - Minecraft.getInstance().font.width(str)) / textScale), 0, 0x00ffff);
                if (shieldNum * 2 * boundWidth > halfWidth) {//too long while using dot, use multiplier number
                    final var renderAbsorptionMultiplier = (int) shieldNum;
                    var absStr = "×" + renderAbsorptionMultiplier;
                    GuiHelper.renderString(poseStack, multiBufferSource, absStr, (int) ((halfWidth + boundWidth + 1) / textScale), 0, 0x00ffff);
                }
            }
        });
    }
}
