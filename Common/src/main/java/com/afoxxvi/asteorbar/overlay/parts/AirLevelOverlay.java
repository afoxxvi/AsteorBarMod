package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import net.minecraft.world.entity.player.Player;

public class AirLevelOverlay extends SimpleBarOverlay {
    @Override
    protected Parameters getParameters(Player player) {
        final var parameters = new Parameters();
        final var air = player.getAirSupply();
        parameters.fillColor = AsteorBar.config.airColor();
        parameters.boundColor = AsteorBar.config.airBoundColor();
        parameters.value = air;
        parameters.capacity = 300;
        return parameters;
    }

    @Override
    protected boolean shouldRender(Player player) {
        int air = player.getAirSupply();
        return AsteorBar.platformAdapter.isEyeInFluid(player) || air < 300;
    }

    @Override
    protected boolean alwaysLow() {
        return true;
    }
}
