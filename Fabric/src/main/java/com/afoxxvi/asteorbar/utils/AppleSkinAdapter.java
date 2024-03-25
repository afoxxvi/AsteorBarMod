package com.afoxxvi.asteorbar.utils;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import squeek.appleskin.ModConfig;
import squeek.appleskin.api.event.FoodValuesEvent;
import squeek.appleskin.api.food.FoodValues;
import squeek.appleskin.helpers.FoodHelper;

public class AppleSkinAdapter {
    private static final AppleSkinAdapter INSTANCE = new AppleSkinAdapter();

    private AppleSkinAdapter() {
    }

    public static AppleSkinAdapter getInstance() {
        return INSTANCE;
    }

    public PlatformAdapter.AppleSkinFoodValues getAppleSkinFoodValues(Player player) {
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
        return new PlatformAdapter.AppleSkinFoodValues(modifiedFoodValues.hunger, modifiedFoodValues.getSaturationIncrement(), FoodHelper.getEstimatedHealthIncrement(heldItem, modifiedFoodValues, player));
    }
}
