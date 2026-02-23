package com.afoxxvi.asteorbar.overlay.parts.lso;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.parts.PlayerHealthOverlay;
import net.minecraft.world.entity.player.Player;
import sfiomn.legendarysurvivaloverhaul.api.health.HealthUtil;
import sfiomn.legendarysurvivaloverhaul.common.attachments.health.HealthAttachment;
import sfiomn.legendarysurvivaloverhaul.config.Config;
import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;

public class LegendarySurvivalOverhaulHealthOverlay extends PlayerHealthOverlay {
    private HealthAttachment healthCap = null;

    @Override
    protected float getMaxHealth(Player player) {
        return (float) HealthUtil.getPlayerStableMaxHealth(player);
    }

    @Override
    protected float getAbsorption(Player player) {
        if (healthCap == null || player.tickCount % 20 == 0) {
            healthCap = AttachmentUtil.getHealthAttachment(player);
        }
        return healthCap.getShieldHealth();
    }

    @Override
    protected Parameters getParameters(Player player) {
        var parameters = super.getParameters(player);
        var stableMaxHealth = HealthUtil.getPlayerStableMaxHealth(player);
        var maxHealth = HealthUtil.getPlayerMaxHealth(player);
        if (maxHealth < stableMaxHealth) {
            parameters.coercedValue = 1.0 - Math.clamp(maxHealth / stableMaxHealth, 0.0, 1.0);
            parameters.coercedColor = 0xff7f7f7f;
        }
        return parameters;
    }

    @Override
    public boolean shouldOverride() {
        return AsteorBar.compatibility.legendarySurvivalOverhaul && AsteorBar.config.hookLegendarySurvivalOverhaul() && Config.Baked.healthOverhaulEnabled;
    }

    @Override
    protected boolean shouldRender(Player player) {
        return AsteorBar.compatibility.legendarySurvivalOverhaul && AsteorBar.config.hookLegendarySurvivalOverhaul() && Config.Baked.healthOverhaulEnabled;
    }
}
