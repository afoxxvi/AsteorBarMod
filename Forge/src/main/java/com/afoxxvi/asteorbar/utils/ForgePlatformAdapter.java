package com.afoxxvi.asteorbar.utils;

import com.afoxxvi.asteorbar.entity.AsteorBarRenderType;
import com.afoxxvi.asteorbar.overlay.Overlays;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.ModList;

public class ForgePlatformAdapter implements PlatformAdapter {
    @Override
    public boolean isBoss(LivingEntity livingEntity) {
        return livingEntity.getType() == EntityType.WITHER || livingEntity.getType() == EntityType.ENDER_DRAGON;
    }

    @Override
    public boolean isEyeInFluid(Player player) {
        return player.isEyeInFluid(FluidTags.WATER);
    }

    @Override
    public RenderType getRenderType() {
        return AsteorBarRenderType.RENDER_TYPE;
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public AppleSkinFoodValues getAppleSkinFoodValues(Player player) {
        if (!Overlays.appleskin) {
            return null;
        }
        // if not using third adapter, the game will crash if appleskin is not loaded
        return AppleSkinAdapter.getInstance().getAppleSkinFoodValues(player);
    }
}
