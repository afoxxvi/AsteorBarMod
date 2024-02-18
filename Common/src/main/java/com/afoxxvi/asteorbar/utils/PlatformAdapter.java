package com.afoxxvi.asteorbar.utils;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public interface PlatformAdapter {
    boolean isBoss(LivingEntity livingEntity);

    boolean isEyeInFluid(Player player);

    RenderType getRenderType();

    boolean isModLoaded(String modId);
}
