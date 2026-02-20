package com.afoxxvi.asteorbar.utils;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.AsteorBarFabric;
import com.afoxxvi.asteorbar.entity.AsteorBarRenderType;
import com.afoxxvi.asteorbar.mixin.FoodDataMixin;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.slf4j.Logger;

public class FabricPlatformAdapter implements PlatformAdapter {
    @Override
    public Logger getLogger() {
        return AsteorBarFabric.LOGGER;
    }

    @Override
    public boolean isBoss(LivingEntity livingEntity) {
        var type = livingEntity.getType();
        return type == EntityType.ENDER_DRAGON || type == EntityType.WITHER;
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
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public AppleSkinFoodValues getAppleSkinFoodValues(Player player) {
        if (!AsteorBar.compatibility.appleskin) {
            return null;
        }
        // if not using third adapter, the game will crash if appleskin is not loaded
        return AppleSkinAdapter.getInstance().getAppleSkinFoodValues(player);
    }

    @Override
    public float getExhaustion(Player player) {
        return ((FoodDataMixin) player.getFoodData()).getExhaustionLevel();
    }

    @Override
    public void setExhaustion(Player player, float exhaustion) {
        ((FoodDataMixin) player.getFoodData()).setExhaustionLevel(exhaustion);
    }
}
