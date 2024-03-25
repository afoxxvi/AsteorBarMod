package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.utils.Utils;
import epicsquid.superiorshields.capability.shield.CapabilityRegistry;
import net.minecraft.world.entity.player.Player;

public class SuperiorShieldsOverlay extends SimpleBarOverlay {
    static class Info {
        float value = 0;
        float capacity = 0;
    }

    @Override
    protected Parameters getParameters(Player player) {
        Info info = new Info();
        CapabilityRegistry.getShield(player).ifPresent(shield -> {
            info.value = shield.getCurrentHp();
            info.capacity = shield.getMaxHp();
        });
        if (info.capacity <= 0) return null;
        final var parameters = new Parameters();
        parameters.value = info.value;
        parameters.capacity = info.capacity;
        parameters.fillColor = 0xff68fff9;
        parameters.emptyColor = 0x7f68fff9;
        parameters.boundColor = 0xff327a77;
        if (AsteorBar.config.displayHealthText()) {
            parameters.centerText = Utils.formatNumber(info.value) + "/" + Utils.formatNumber(info.capacity);
            parameters.centerColor = 0xffebfffe;
        }
        return parameters;
    }

    @Override
    protected boolean isLeftSide() {
        return true;
    }

    @Override
    protected boolean shouldRender(Player player) {
        return Overlays.superiorshields && AsteorBar.config.hookSuperiorShields();
    }
}
