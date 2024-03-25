package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.afoxxvi.asteorbar.utils.Utils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

public class ArmorLevelOverlay extends SimpleBarOverlay {
    @Override
    protected Parameters getParameters(Player player) {
        final var parameters = new Parameters();
        final var armor = player.getArmorValue();
        parameters.fillColor = AsteorBar.config.armorColor();
        parameters.boundColor = AsteorBar.config.armorBoundColor();
        parameters.emptyColor = AsteorBar.config.armorEmptyColor();
        parameters.value = armor;
        parameters.capacity = AsteorBar.config.fullArmorValue();
        if (armor > AsteorBar.config.fullArmorValue()) {
            parameters.centerText = String.valueOf(armor);
            parameters.centerColor = 0xFFFFFF;
        }
        if (AsteorBar.config.displayArmorToughness()) {
            var attr = player.getAttribute(Attributes.ARMOR_TOUGHNESS);
            if (attr != null) {
                parameters.boundFillColor = AsteorBar.config.armorToughnessColor();
                parameters.boundValue = attr.getValue();
                parameters.boundCapacity = AsteorBar.config.fullArmorToughnessValue();
                if (attr.getValue() > AsteorBar.config.fullArmorToughnessValue()) {
                    parameters.leftText = Utils.formatNumber(attr.getValue());
                    parameters.leftColor = 0xdeecff;
                }
            }
        }
        return parameters;
    }

    @Override
    protected boolean isLeftSide() {
        return true;
    }

    @Override
    protected boolean shouldRender(Player player) {
        if (!AsteorBar.config.overwriteVanillaArmorBar()) return false;
        int armor = player.getArmorValue();
        return armor > 0;
    }
}
