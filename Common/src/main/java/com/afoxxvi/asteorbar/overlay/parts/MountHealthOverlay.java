package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.afoxxvi.asteorbar.utils.Utils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class MountHealthOverlay extends SimpleBarOverlay {
    @Override
    protected Parameters getParameters(Player player) {
        Entity tmp = player.getVehicle();
        if (!(tmp instanceof LivingEntity mount)) return null;
        final var parameters = new Parameters();
        parameters.fillColor = AsteorBar.config.mountHealthColor();
        parameters.fillColor2 = AsteorBar.config.mountHealthColor2();
        parameters.boundColor = AsteorBar.config.mountHealthBoundColor();
        parameters.boundColor2 = AsteorBar.config.mountHealthBoundColor2();
        parameters.emptyColor = AsteorBar.config.mountHealthEmptyColor();
        parameters.value = mount.getHealth();
        parameters.capacity = mount.getMaxHealth();
        if (AsteorBar.config.displayHealthText()) {
            parameters.centerText = Utils.formatNumber(mount.getHealth()) + "/" + Utils.formatNumber(mount.getMaxHealth());
            parameters.centerColor = 0xFFFFFF;
        }
        return parameters;
    }

    @Override
    protected boolean shouldRender(Player player) {
        Entity tmp = player.getVehicle();
        if (tmp instanceof LivingEntity mount) {
            return mount.getHealth() > 0;
        }
        return false;
    }
}
