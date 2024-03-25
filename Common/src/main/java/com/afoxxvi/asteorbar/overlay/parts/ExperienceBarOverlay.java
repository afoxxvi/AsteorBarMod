package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

public class ExperienceBarOverlay extends BaseOverlay {
    private void draw(PoseStack poseStack, int left, int top, int right, int bottom, float exp, String levelStr, boolean flip) {
        drawBound(poseStack, left, top, right, bottom, AsteorBar.config.experienceBoundColor());
        drawEmptyFill(poseStack, left + 1, top + 1, right - 1, bottom - 1, AsteorBar.config.experienceEmptyColor());
        int innerWidth = right - left - 2;
        int expWidth = (int) (innerWidth * exp);
        if (expWidth > 0) {
            drawFillFlip(poseStack, left + 1, top + 1, right - 1, bottom - 1, expWidth, AsteorBar.config.experienceColor(), flip);
        }
        int textureWidth = Math.min(179, Math.max(0, (innerWidth + 5) / 10 - 1) * 10 + 9);
        RenderSystem.setShaderTexture(0, TEXTURE);
        drawTextureFillColor(poseStack, left + 1, top, innerWidth, 5, 10, Y_EXPERIENCE_DECORATION, textureWidth, 5, AsteorBar.config.experienceColor());
        RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        if (AsteorBar.config.displayExperienceLevel()) {
            int x = (right + left) / 2;
            int y = top - 2;
            Overlays.addStringRender(x, y, 0x80FF20, levelStr, Overlays.ALIGN_CENTER, false, true, 0);
        }
    }

    @Override
    public void renderOverlay(RenderGui gui, PoseStack poseStack, float partialTick, int screenWidth, int screenHeight) {
        var mc = gui.mc();
        var player = mc.player;
        if (player == null || player.jumpableVehicle() != null || gui.mc().options.hideGui) {
            return;
        }
        if (mc.gameMode == null || !mc.gameMode.hasExperience()) {
            return;
        }
        if (AsteorBar.config.overwriteVanillaExperienceBar()) {
            String levelStr = String.valueOf(player.experienceLevel);
            switch (Overlays.style) {
                case Overlays.STYLE_NONE -> {

                }
                case Overlays.STYLE_ABOVE_HOT_BAR_LONG, Overlays.STYLE_ABOVE_HOT_BAR_SHORT -> {
                    int top = screenHeight - 29;
                    int left = screenWidth / 2 - 91;
                    draw(poseStack, left, top, left + BOUND_FULL_WIDTH_LONG, top + 5, player.experienceProgress, levelStr, false);
                }
                case Overlays.STYLE_TOP_LEFT -> {
                    int top = Overlays.vertical;
                    int left = Overlays.horizontal;
                    draw(poseStack, left, top, left + Overlays.length, top + 5, player.experienceProgress, levelStr, false);
                    Overlays.vertical += 6;
                }
                case Overlays.STYLE_TOP_RIGHT -> {
                    int top = Overlays.vertical;
                    int left = screenWidth - Overlays.length - Overlays.horizontal;
                    draw(poseStack, left, top, left + Overlays.length, top + 5, player.experienceProgress, levelStr, true);
                    Overlays.vertical += 6;
                }
                case Overlays.STYLE_BOTTOM_LEFT -> {
                    int top = screenHeight - Overlays.vertical;
                    int left = Overlays.horizontal;
                    draw(poseStack, left, top, left + Overlays.length, top + 5, player.experienceProgress, levelStr, false);
                    Overlays.vertical += 6;
                }
                case Overlays.STYLE_BOTTOM_RIGHT -> {
                    int top = screenHeight - Overlays.vertical;
                    int left = screenWidth - Overlays.length - Overlays.horizontal;
                    draw(poseStack, left, top, left + Overlays.length, top + 5, player.experienceProgress, levelStr, true);
                    Overlays.vertical += 6;
                }
            }
        }

        if (AsteorBar.config.displayExperienceProgress()) {
            var need = String.valueOf(player.getXpNeededForNextLevel());
            var has = String.valueOf((int) (player.experienceProgress * player.getXpNeededForNextLevel()));
            int x = -1, y = -1;
            int len = 0;
            boolean inside = false;
            int style = Overlays.style;
            if (!AsteorBar.config.overwriteVanillaExperienceBar()) style = Overlays.STYLE_ABOVE_HOT_BAR_LONG;
            switch (style) {
                case Overlays.STYLE_NONE -> {

                }
                case Overlays.STYLE_ABOVE_HOT_BAR_LONG, Overlays.STYLE_ABOVE_HOT_BAR_SHORT -> {
                    x = screenWidth / 2;
                    y = screenHeight - 31;
                    len = 91;
                }
                case Overlays.STYLE_TOP_LEFT -> {
                    y = Overlays.vertical - 8;
                    len = Overlays.length / 2;
                    x = Overlays.horizontal + len;
                    inside = true;
                }
                case Overlays.STYLE_TOP_RIGHT -> {
                    y = Overlays.vertical - 8;
                    len = Overlays.length / 2;
                    x = screenWidth - Overlays.horizontal - len;
                    inside = true;
                }
                case Overlays.STYLE_BOTTOM_LEFT -> {
                    y = screenHeight - Overlays.vertical + 4;
                    len = Overlays.length / 2;
                    x = Overlays.horizontal + len;
                    inside = true;
                }
                case Overlays.STYLE_BOTTOM_RIGHT -> {
                    y = screenHeight - Overlays.vertical + 4;
                    len = Overlays.length / 2;
                    x = screenWidth - Overlays.horizontal - len;
                    inside = true;
                }
            }
            if (x >= 0 && y >= 0) {
                if (inside) {
                    Overlays.addStringRender(x - len + 2, y, 0xFFFFFF, has, Overlays.ALIGN_LEFT, true);
                    Overlays.addStringRender(x + len - 2, y, 0xFFFFFF, need, Overlays.ALIGN_RIGHT, true);
                } else {
                    Overlays.addStringRender(x - len, y, 0xFFFFFF, has, Overlays.ALIGN_RIGHT, true);
                    Overlays.addStringRender(x + len, y, 0xFFFFFF, need, Overlays.ALIGN_LEFT, true);
                }
            }
        }
    }
}
