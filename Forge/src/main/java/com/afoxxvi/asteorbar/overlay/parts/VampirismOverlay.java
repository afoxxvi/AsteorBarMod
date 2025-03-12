package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.utils.Utils;
import de.teamlapen.vampirism.api.entity.player.vampire.IBloodStats;
import de.teamlapen.vampirism.entity.player.vampire.VampirePlayer;
import de.teamlapen.vampirism.modcompat.IMCHandler;
import de.teamlapen.vampirism.util.Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

public class VampirismOverlay extends SimpleBarOverlay {
    @Override
    protected Parameters getParameters(Player player) {
        var parameters = new Parameters();
        IBloodStats stats = VampirePlayer.get(player).getBloodStats();
        int level = stats.getBloodLevel();
        int maxLevel = stats.getMaxBlood();
        if (maxLevel <= 0) return null;
        parameters.boundColor = 0xff490000;
        parameters.emptyColor = 0xff1e0000;
        parameters.fillColor = 0xffa80000;
        parameters.capacity = 20;
        parameters.value = level;
        while (parameters.value > parameters.capacity) {
            parameters.value -= parameters.capacity;
            parameters.emptyColor = parameters.fillColor;
            parameters.fillColor = Utils.mixColor(0xffff0000, parameters.fillColor, 0.4);
        }
        return parameters;
    }

    @Override
    protected boolean shouldRender(Player player) {
        return Helper.isVampire(player) && !IMCHandler.requestedToDisableBloodbar;
    }

    @Override
    public boolean shouldOverride() {
        if (!AsteorBar.compatibility.vampirism || !AsteorBar.config.hookVampirism()) return false;
        final var mc = Minecraft.getInstance();
        var player = mc.player;
        if (player == null) return false;
        return Helper.isVampire(player) && !IMCHandler.requestedToDisableBloodbar && mc.gameMode != null && mc.gameMode.hasExperience() && player.isAlive();
    }
}
