package com.afoxxvi.asteorbar.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import squeek.appleskin.api.event.HUDOverlayEvent;
import squeek.appleskin.client.HUDOverlayHandler;
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
        FoodData stats = player.getFoodData();
        FoodHelper.QueriedFoodResult result = HUDOverlayHandler.INSTANCE.heldFood.result(Minecraft.getInstance().gui.getGuiTicks(), player);
        if (result == null) {
            return null;
        }
        HUDOverlayEvent.HungerRestored hungerRenderEvent = new HUDOverlayEvent.HungerRestored(stats.getFoodLevel(), result.itemStack, result.modifiedFoodComponent, 0, 0, null);
        HUDOverlayEvent.HungerRestored.EVENT.invoker().interact(hungerRenderEvent);
        int foodHunger = result.modifiedFoodComponent.nutrition();
        float foodSaturationIncrement = result.modifiedFoodComponent.saturation();
        float foodHealthIncrement = FoodHelper.getEstimatedHealthIncrement(player, new ConsumableFood(result.modifiedFoodComponent, result.consumableComponent));
        return new PlatformAdapter.AppleSkinFoodValues(foodHunger, foodSaturationIncrement, foodHealthIncrement);
    }
}
