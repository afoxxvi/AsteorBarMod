package com.afoxxvi.asteorbar.overlay.parts.lso;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.parts.PlayerHealthOverlay;
import net.minecraft.world.entity.player.Player;
import sfiomn.legendarysurvivaloverhaul.config.Config;

public class LegendarySurvivalOverhaulHealthOverlay extends PlayerHealthOverlay {
    @Override
    protected Parameters getParameters(Player player) {
        var parameters = super.getParameters(player);
        return parameters;
    }

    @Override
    protected boolean shouldRender(Player player) {
        return AsteorBar.compatibility.legendarySurvivalOverhaul && AsteorBar.config.hookLegendarySurvivalOverhaul() && Config.Baked.healthOverhaulEnabled;
    }
}
