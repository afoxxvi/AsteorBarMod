package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class ArmorLevelOverlay extends BaseOverlay {
    private void draw(PoseStack poseStack, int left, int top, int right, int bottom, int armor, double armorToughness, boolean flip) {
        int armorWidth = (int) ((right - left - 2) * Math.min(1.0, armor / 20f));
        drawBound(poseStack, left, top, right, bottom, AsteorBar.config.armorBoundColor());
        if (armor < 20) {
            drawEmptyFill(poseStack, left + 1, top + 1, right - 1, bottom - 1, AsteorBar.config.armorEmptyColor());
        }
        drawFillFlip(poseStack, left + 1, top + 1, right - 1, bottom - 1, armorWidth, AsteorBar.config.armorColor(), flip);
        if (armor > 20) {
            Overlays.addStringRender((left + right) / 2, top - 2, 0xFFFFFF, String.valueOf(armor), Overlays.ALIGN_CENTER, true);
        }
        if (armorToughness > 0) {
            int armorToughnessWidth = (int) ((right - left) * Math.min(1.0, armorToughness / 12.0));
            drawBoundFlip(poseStack, left, top, right, bottom, AsteorBar.config.armorToughnessColor(), armorToughnessWidth, flip);
            if (armorToughness > 12) {
                if (flip) {
                    Overlays.addStringRender(right - 2, top - 2, 0xdeecff, Utils.formatNumber(armorToughness), Overlays.ALIGN_RIGHT, true);
                } else {
                    Overlays.addStringRender(left + 2, top - 2, 0xdeecff, Utils.formatNumber(armorToughness), Overlays.ALIGN_LEFT, true);
                }
            }
        }
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void renderOverlay(RenderGui gui, PoseStack guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        if (AsteorBar.config.overwriteVanillaArmorBar()) {
            var player = gui.mc().player;
            if (player == null) return;
            int armor = player.getArmorValue();
            if (armor <= 0) return;
            double armorToughness = 0;
            if (AsteorBar.config.displayArmorToughness()) {
                var attr = player.getAttribute(Attributes.ARMOR_TOUGHNESS);
                if (attr != null) {
                    armorToughness = attr.getValue();
                }
            }
            switch (Overlays.style) {
                case Overlays.STYLE_NONE -> {

                }
                case Overlays.STYLE_ABOVE_HOT_BAR_LONG, Overlays.STYLE_ABOVE_HOT_BAR_SHORT -> {
                    int left = screenWidth / 2 - 91;
                    int top = screenHeight - gui.leftHeight() + 4;
                    gui.leftHeight(6);
                    draw(guiGraphics, left, top, left + BOUND_FULL_WIDTH_SHORT, top + 5, armor, armorToughness, false);
                }
                case Overlays.STYLE_TOP_LEFT -> {
                    int top = Overlays.vertical;
                    int left = Overlays.horizontal;
                    draw(guiGraphics, left, top, left + Overlays.length, top + 5, armor, armorToughness, false);
                    Overlays.vertical += 6;
                }
                case Overlays.STYLE_TOP_RIGHT -> {
                    int top = Overlays.vertical;
                    int left = screenWidth - Overlays.length - Overlays.horizontal;
                    draw(guiGraphics, left, top, left + Overlays.length, top + 5, armor, armorToughness, true);
                    Overlays.vertical += 6;
                }
                case Overlays.STYLE_BOTTOM_LEFT -> {
                    int top = screenHeight - Overlays.vertical;
                    int left = Overlays.horizontal;
                    draw(guiGraphics, left, top, left + Overlays.length, top + 5, armor, armorToughness, false);
                    Overlays.vertical += 6;
                }
                case Overlays.STYLE_BOTTOM_RIGHT -> {
                    int top = screenHeight - Overlays.vertical;
                    int left = screenWidth - Overlays.length - Overlays.horizontal;
                    draw(guiGraphics, left, top, left + Overlays.length, top + 5, armor, armorToughness, true);
                    Overlays.vertical += 6;
                }
            }
        }
    }
}
