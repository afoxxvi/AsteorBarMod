package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.vertex.PoseStack;
import de.teamlapen.vampirism.modcompat.IMCHandler;
import de.teamlapen.vampirism.player.vampire.VampirePlayer;
import de.teamlapen.vampirism.util.Helper;
import net.minecraft.client.Minecraft;

public class VampirismOverlay extends BaseOverlay {
    private void draw(PoseStack poseStack, int left, int top, int right, int bottom, int valueLevel, int maxLevel, boolean flip) {
        if (maxLevel <= 0) return;
        drawBound(poseStack, left, top, right, bottom, 0xff490000);
        drawEmptyFill(poseStack, left + 1, top + 1, right - 1, bottom - 1, 0xff1e0000);
        final int innerWidth = right - left - 2;
        int color = 0xffa80000;
        while (valueLevel > 0) {
            int width = innerWidth * valueLevel / 20;
            drawFillFlip(poseStack, left + 1, top + 1, right - 1, bottom - 1, width, color, flip);
            valueLevel -= 20;
            color = Utils.mixColor(0xffff0000, color, 0.4);
        }
    }

    @Override
    public void renderOverlay(RenderGui gui, PoseStack poseStack, float partialTick, int screenWidth, int screenHeight) {
        var player = gui.mc().player;
        if (player == null) return;
        final var opt = VampirePlayer.getOpt(player).map(VampirePlayer::getBloodStats);
        if (opt.isEmpty()) return;
        final var stats = opt.get();
        int level = stats.getBloodLevel();
        int maxLevel = stats.getMaxBlood();
        int left, top, right;
        boolean flip = false;
        switch (Overlays.style) {
            default -> {
                return;
            }
            case Overlays.STYLE_ABOVE_HOT_BAR_LONG -> {
                left = screenWidth / 2 - 91;
                top = screenHeight - gui.rightHeight() + 4;
                right = left + BOUND_FULL_WIDTH_LONG;
                gui.rightHeight(12);
            }
            case Overlays.STYLE_ABOVE_HOT_BAR_SHORT -> {
                left = screenWidth / 2 + 10;
                top = screenHeight - gui.rightHeight() + 4;
                right = left + BOUND_FULL_WIDTH_SHORT;
                flip = true;
                gui.rightHeight(6);
            }
            case Overlays.STYLE_TOP_LEFT -> {
                top = Overlays.vertical;
                left = Overlays.horizontal;
                right = left + Overlays.length;
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_TOP_RIGHT -> {
                top = Overlays.vertical;
                left = screenWidth - Overlays.length - Overlays.horizontal;
                right = left + Overlays.length;
                flip = true;
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_BOTTOM_LEFT -> {
                top = screenHeight - Overlays.vertical;
                left = Overlays.horizontal;
                right = left + Overlays.length;
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_BOTTOM_RIGHT -> {
                top = screenHeight - Overlays.vertical;
                left = screenWidth - Overlays.length - Overlays.horizontal;
                right = left + Overlays.length;
                flip = true;
                Overlays.vertical += 6;
            }
        }
        draw(poseStack, left, top, right, top + 5, level, maxLevel, flip);
    }

    @Override
    public boolean shouldOverride() {
        if (!Overlays.vampirism || !AsteorBar.config.hookVampirism()) return false;
        final var mc = Minecraft.getInstance();
        var player = mc.player;
        if (player == null) return false;
        return Helper.isVampire(player) && !IMCHandler.requestedToDisableBloodbar && mc.gameMode != null && mc.gameMode.hasExperience() && player.isAlive();
    }
}
