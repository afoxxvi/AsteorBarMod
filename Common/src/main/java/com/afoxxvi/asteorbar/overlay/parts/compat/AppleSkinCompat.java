package com.afoxxvi.asteorbar.overlay.parts.compat;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.parts.PlayerHealthOverlay;
import com.afoxxvi.asteorbar.overlay.parts.SimpleBarOverlay;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;

import java.util.function.BiConsumer;

public class AppleSkinCompat {
    private static final BiConsumer<Player, SimpleBarOverlay.Parameters> APPLE_SKIN_HEALTH_POST_PROCESSOR = (player, parameters) -> {
        float maxHealth = player.getMaxHealth();
        float health = player.getHealth();
        float absorb = player.getAbsorptionAmount();
        double healthIncrement = 0;
        if (AsteorBar.compatibility.appleskin) {
            final var foodValues = AsteorBar.platformAdapter.getAppleSkinFoodValues(player);
            if (foodValues != null) {
                healthIncrement = foodValues.healthIncrement();
            }
            healthIncrement = Math.min(healthIncrement, maxHealth - health);
        }
        int i = AsteorBar.config.displayAbsorptionMethod();
        if (AsteorBar.config.enableStackHealthBar()) {
            i = PlayerHealthOverlay.ABSORPTION_MODE_BOUND;
        }
        if (i == PlayerHealthOverlay.ABSORPTION_MODE_TOGETHER) {
            double full = maxHealth + absorb;
            parameters.valueIncrement = healthIncrement / full;
        } else {
            if (AsteorBar.config.enableStackHealthBar()) {
                final int unit = AsteorBar.config.fullHealthValue();
                if (healthIncrement > 0 && health < maxHealth) {
                    if ((health % unit) + healthIncrement >= unit) {
                        parameters.valueIncrement = 1 - parameters.value;
                        parameters.secondValueIncrement = (parameters.value + healthIncrement / unit) % 1;
                    } else {
                        healthIncrement = Math.min(healthIncrement, maxHealth - health);
                        parameters.valueIncrement = healthIncrement / unit;
                    }
                }
            } else {
                if (healthIncrement > 0 && health < maxHealth) {
                    parameters.valueIncrement = Math.min(maxHealth - health, healthIncrement) / maxHealth;
                }
            }
        }
    };

    private static final BiConsumer<Player, SimpleBarOverlay.Parameters> APPLE_SKIN_FOOD_POST_PROCESSOR = (player, parameters) -> {
        FoodData stats = player.getFoodData();
        int level = stats.getFoodLevel();
        float saturation = stats.getSaturationLevel();
        int foodIncrement = 0;
        float saturationIncrement = 0F;
        if (AsteorBar.compatibility.appleskin) {
            final var foodValues = AsteorBar.platformAdapter.getAppleSkinFoodValues(player);
            if (foodValues != null) {
                foodIncrement = foodValues.hungerIncrement();
                saturationIncrement = foodValues.saturationIncrement();
            }
        }
        if (foodIncrement > 0 && level < AsteorBar.config.fullFoodLevelValue()) {
            if (level + foodIncrement >= AsteorBar.config.fullFoodLevelValue()) {
                parameters.valueIncrement = (level + foodIncrement) / (double) AsteorBar.config.fullFoodLevelValue() % 1;
            } else {
                parameters.valueIncrement = foodIncrement / (double) AsteorBar.config.fullFoodLevelValue();
            }
        }
        if (AsteorBar.config.displaySaturation()) {
            if (foodIncrement > 0 && saturationIncrement > 0 && saturation < AsteorBar.config.fullSaturationValue()) {
                if (saturation + saturationIncrement >= AsteorBar.config.fullSaturationValue()) {
                    parameters.boundValueIncrement = (saturation + saturationIncrement) / AsteorBar.config.fullSaturationValue() % 1;
                } else {
                    parameters.boundValueIncrement = saturationIncrement / AsteorBar.config.fullSaturationValue();
                }
            }
        }
    };

    private static boolean initialized = false;

    public static void init() {
        if (initialized) {
            return;
        }
        initialized = true;
        if (!AsteorBar.compatibility.appleskin) {
            return;
        }
        Overlays.PLAYER_HEALTH.addParametersProcessor("afoxxvi:apple_skin", APPLE_SKIN_HEALTH_POST_PROCESSOR);
        Overlays.FOOD_LEVEL.addParametersProcessor("afoxxvi:apple_skin", APPLE_SKIN_FOOD_POST_PROCESSOR);
    }
}
