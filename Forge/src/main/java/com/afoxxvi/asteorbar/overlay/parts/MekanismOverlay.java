package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.vertex.PoseStack;
import mekanism.api.energy.IEnergyContainer;
import mekanism.api.math.FloatingLong;
import mekanism.common.item.gear.ItemMekaSuitArmor;
import mekanism.common.util.StorageUtils;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("DuplicatedCode")
public class MekanismOverlay extends BaseOverlay {
    private void draw(PoseStack poseStack, int left, int top, int right, int bottom, double length, boolean flip) {
        int energyLength = (int) ((right - left - 2) * length);
        drawBound(poseStack, left, top, right, bottom, AsteorBar.config.armorBoundColor());
        int emptyColor = Utils.mixColor(0xff114229, AsteorBar.config.armorEmptyColor(), 0.5);
        drawEmptyFill(poseStack, left + 1, top + 1, right - 1, bottom - 1, emptyColor);
        drawFillFlip(poseStack, left + 1, top + 1, right - 1, bottom - 1, energyLength, 0xff3bfb98, flip);
    }

    @Override
    public void renderOverlay(RenderGui gui, PoseStack poseStack, float partialTick, int screenWidth, int screenHeight) {
        if (!Overlays.mekanism || !AsteorBar.config.hookMekanism()) return;
        FloatingLong capacity = FloatingLong.ZERO;
        FloatingLong stored = FloatingLong.ZERO;
        var player = gui.mc().player;
        if (player == null) return;
        for (ItemStack stack : player.getArmorSlots()) {
            if (stack.getItem() instanceof ItemMekaSuitArmor) {
                IEnergyContainer container = StorageUtils.getEnergyContainer(stack, 0);
                if (container != null) {
                    capacity = capacity.plusEqual(container.getMaxEnergy());
                    stored = stored.plusEqual(container.getEnergy());
                }
            }
        }
        if (capacity.isZero()) {
            return;
        }
        double length = stored.divide(capacity).doubleValue();
        switch (Overlays.style) {
            case Overlays.STYLE_NONE -> {

            }
            case Overlays.STYLE_ABOVE_HOT_BAR_LONG, Overlays.STYLE_ABOVE_HOT_BAR_SHORT -> {
                int left = screenWidth / 2 - 91;
                int top = screenHeight - gui.leftHeight() + 4;
                gui.leftHeight(6);
                draw(poseStack, left, top, left + BOUND_FULL_WIDTH_SHORT, top + 5, length, false);
            }
            case Overlays.STYLE_TOP_LEFT -> {
                int top = Overlays.vertical;
                int left = Overlays.horizontal;
                draw(poseStack, left, top, left + Overlays.length, top + 5, length, false);
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_TOP_RIGHT -> {
                int top = Overlays.vertical;
                int left = screenWidth - Overlays.length - Overlays.horizontal;
                draw(poseStack, left, top, left + Overlays.length, top + 5, length, true);
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_BOTTOM_LEFT -> {
                int top = screenHeight - Overlays.vertical;
                int left = Overlays.horizontal;
                draw(poseStack, left, top, left + Overlays.length, top + 5, length, false);
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_BOTTOM_RIGHT -> {
                int top = screenHeight - Overlays.vertical;
                int left = screenWidth - Overlays.length - Overlays.horizontal;
                draw(poseStack, left, top, left + Overlays.length, top + 5, length, true);
                Overlays.vertical += 6;
            }
        }
    }
}
