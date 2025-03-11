package com.afoxxvi.asteorbar.utils;

import com.afoxxvi.asteorbar.mixin.third.AppleSkinMixin;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import squeek.appleskin.helpers.ConsumableFood;
import squeek.appleskin.helpers.FoodHelper;

public class AppleSkinAdapter {
    private static final AppleSkinAdapter INSTANCE = new AppleSkinAdapter();

    private AppleSkinAdapter() {
    }

    public static AppleSkinAdapter getInstance() {
        return INSTANCE;
    }

    public PlatformAdapter.AppleSkinFoodValues getAppleSkinFoodValues(Player player) {
        FoodHelper.QueriedFoodResult result = AppleSkinMixin.getHeldFood().result(Minecraft.getInstance().gui.getGuiTicks(), player);
        if (result == null) {
            return null;
        }
        int foodHunger = result.modifiedFoodProperties.nutrition();
        float foodSaturationIncrement = result.modifiedFoodProperties.saturation();
        float foodHealthIncrement = FoodHelper.getEstimatedHealthIncrement(player, new ConsumableFood(result.modifiedFoodProperties, result.consumable));
        return new PlatformAdapter.AppleSkinFoodValues(foodHunger, foodSaturationIncrement, foodHealthIncrement);
    }
}
