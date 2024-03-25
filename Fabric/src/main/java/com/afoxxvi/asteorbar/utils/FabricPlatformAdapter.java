package com.afoxxvi.asteorbar.utils;

import com.afoxxvi.asteorbar.entity.AsteorBarRenderType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import squeek.appleskin.ModConfig;
import squeek.appleskin.api.event.FoodValuesEvent;
import squeek.appleskin.api.food.FoodValues;
import squeek.appleskin.helpers.FoodHelper;

public class FabricPlatformAdapter implements PlatformAdapter {
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
        ItemStack heldItem = player.getMainHandItem();
        if (ModConfig.INSTANCE.showFoodValuesHudOverlayWhenOffhand && !FoodHelper.canConsume(heldItem, player)) {
            heldItem = player.getOffhandItem();
        }
        if (heldItem.isEmpty() || !FoodHelper.canConsume(heldItem, player)) {
            return null;
        }
        FoodValues modifiedFoodValues = FoodHelper.getModifiedFoodValues(heldItem, player);
        FoodValuesEvent foodValuesEvent = new FoodValuesEvent(player, heldItem, FoodHelper.getDefaultFoodValues(heldItem), modifiedFoodValues);
        FoodValuesEvent.EVENT.invoker().interact(foodValuesEvent);
        modifiedFoodValues = foodValuesEvent.modifiedFoodValues;
        return new AppleSkinFoodValues(modifiedFoodValues.hunger, modifiedFoodValues.getSaturationIncrement(), FoodHelper.getEstimatedHealthIncrement(heldItem, modifiedFoodValues, player));
    }
}
