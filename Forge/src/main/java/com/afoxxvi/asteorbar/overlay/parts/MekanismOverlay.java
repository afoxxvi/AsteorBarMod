package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.afoxxvi.asteorbar.utils.Utils;
import mekanism.api.energy.IEnergyContainer;
import mekanism.api.math.FloatingLong;
import mekanism.common.item.gear.ItemMekaSuitArmor;
import mekanism.common.util.StorageUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class MekanismOverlay extends SimpleBarOverlay {
    @Override
    protected Parameters getParameters(Player player) {
        FloatingLong capacity = FloatingLong.ZERO;
        FloatingLong stored = FloatingLong.ZERO;
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
            return null;
        }
        double length = stored.divide(capacity).doubleValue();
        final var parameters = new Parameters();
        parameters.capacity = 1;
        parameters.value = length;
        parameters.fillColor = 0xff3bfb98;
        parameters.boundColor = AsteorBar.config.armorBoundColor();
        parameters.emptyColor = Utils.mixColor(0xff114229, AsteorBar.config.armorEmptyColor(), 0.5);
        return parameters;
    }

    @Override
    protected boolean isLeftSide() {
        return true;
    }

    @Override
    protected boolean shouldRender(Player player) {
        return Overlays.mekanism && AsteorBar.config.hookMekanism();
    }
}
