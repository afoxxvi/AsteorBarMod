package com.afoxxvi.asteorbar.utils;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

public interface PlatformAdapter {
    boolean isBoss(LivingEntity livingEntity);

    boolean isEyeInFluid(Player player);

    RenderType getRenderType();

    boolean isModLoaded(String modId);

    @Nullable
    AppleSkinFoodValues getAppleSkinFoodValues(Player player);

    record AppleSkinFoodValues(int hungerIncrement, float saturationIncrement, float healthIncrement) {
    }
}
