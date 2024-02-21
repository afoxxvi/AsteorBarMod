package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class MountHealthOverlay extends BaseOverlay {
    private void draw(PoseStack poseStack, int left, int top, int right, int bottom, float health, float healthMax, boolean flip) {
        int healthWidth = (int) ((right - left - 2) * health / healthMax);
        drawBound(poseStack, left, top, right, bottom, AsteorBar.config.mountHealthBoundColor(), AsteorBar.config.mountHealthBoundColor2());
        drawEmptyFill(poseStack, left + 1, top + 1, right - 1, bottom - 1, AsteorBar.config.mountHealthEmptyColor());
        drawFillFlip(poseStack, left + 1, top + 1, right - 1, bottom - 1, healthWidth, AsteorBar.config.mountHealthColor(), AsteorBar.config.mountHealthColor2(), flip);
        if (AsteorBar.config.displayHealthText()) {
            Overlays.addStringRender((right + left) / 2, top - 2, 0xFFFFFF, Utils.formatNumber(health) + "/" + Utils.formatNumber(healthMax), Overlays.ALIGN_CENTER, true);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void renderOverlay(RenderGui gui, PoseStack poseStack, float partialTick, int screenWidth, int screenHeight) {
        Player player = (Player) gui.mc().getCameraEntity();
        if (player == null) return;
        Entity tmp = player.getVehicle();
        if (tmp instanceof LivingEntity mount) {
            int health = (int) Math.ceil(mount.getHealth());
            float healthMax = mount.getMaxHealth();
            switch (Overlays.style) {
                case Overlays.STYLE_NONE -> {

                }
                case Overlays.STYLE_ABOVE_HOT_BAR_LONG -> {
                    int left = screenWidth / 2 - 91;
                    int top = screenHeight - gui.rightHeight() + 4;
                    gui.rightHeight(12);
                    draw(poseStack, left, top, left + BOUND_FULL_WIDTH_LONG, top + 5, health, healthMax, false);
                }
                case Overlays.STYLE_ABOVE_HOT_BAR_SHORT -> {
                    int left = screenWidth / 2 + 10;
                    int top = screenHeight - gui.rightHeight() + 4;
                    gui.rightHeight(6);
                    draw(poseStack, left, top, left + BOUND_FULL_WIDTH_SHORT, top + 5, health, healthMax, true);
                }
                case Overlays.STYLE_TOP_LEFT -> {
                    int top = Overlays.vertical;
                    int left = Overlays.horizontal;
                    draw(poseStack, left, top, left + Overlays.length, top + 5, health, healthMax, false);
                    Overlays.vertical += 6;
                }
                case Overlays.STYLE_TOP_RIGHT -> {
                    int top = Overlays.vertical;
                    int left = screenWidth - Overlays.length - Overlays.horizontal;
                    draw(poseStack, left, top, left + Overlays.length, top + 5, health, healthMax, true);
                    Overlays.vertical += 6;
                }
                case Overlays.STYLE_BOTTOM_LEFT -> {
                    int top = screenHeight - Overlays.vertical;
                    int left = Overlays.horizontal;
                    draw(poseStack, left, top, left + Overlays.length, top + 5, health, healthMax, false);
                    Overlays.vertical += 6;
                }
                case Overlays.STYLE_BOTTOM_RIGHT -> {
                    int top = screenHeight - Overlays.vertical;
                    int left = screenWidth - Overlays.length - Overlays.horizontal;
                    draw(poseStack, left, top, left + Overlays.length, top + 5, health, healthMax, true);
                    Overlays.vertical += 6;
                }
            }
        }
    }
}
