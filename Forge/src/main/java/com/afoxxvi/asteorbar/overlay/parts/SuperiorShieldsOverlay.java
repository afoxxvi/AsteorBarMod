package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.utils.Utils;
import dev.epicsquid.superiorshields.registry.CapabilityRegistry;
import net.minecraft.world.entity.player.Player;

public class SuperiorShieldsOverlay extends SimpleBarOverlay {
    @Override
    protected Parameters getParameters(Player player) {
        int shieldHp = CapabilityRegistry.INSTANCE.getShield(player).getHp();
        int shieldCapacity = CapabilityRegistry.INSTANCE.getShield(player).getCapacity();
        if (shieldCapacity <= 0) return null;
        final var parameters = new Parameters();
        parameters.value = shieldHp;
        parameters.capacity = shieldCapacity;
        parameters.fillColor = 0xff68fff9;
        parameters.emptyColor = 0x7f68fff9;
        parameters.boundColor = 0xff327a77;
        if (AsteorBar.config.displayHealthText()) {
            parameters.centerText = Utils.formatNumber(shieldHp) + "/" + Utils.formatNumber(shieldCapacity);
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
