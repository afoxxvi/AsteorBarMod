package com.afoxxvi.asteorbar.overlay.parts.lso;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.parts.FoodLevelOverlay;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;

public class LegendarySurvivalOverhaulFoodOverlay extends FoodLevelOverlay {
    @Override
    protected Parameters getParameters(Player player) {
        var parameters = super.getParameters(player);
        if (!player.hasEffect(MobEffectRegistry.COLD_HUNGER)) {
            return parameters;
        }
        parameters.fillColor = 0xffa3cfff;
        parameters.boundColor = 0xff4578b4;
        if (player.hasEffect(MobEffects.HUNGER)) {
            parameters.fillColor2 = 0xff37b09e;
        }
        return parameters;
    }

    @Override
    public boolean shouldOverride() {
        return AsteorBar.compatibility.legendarySurvivalOverhaul && AsteorBar.config.hookLegendarySurvivalOverhaul();
    }
}
