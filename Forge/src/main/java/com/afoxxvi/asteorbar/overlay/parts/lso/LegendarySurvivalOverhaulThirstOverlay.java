package com.afoxxvi.asteorbar.overlay.parts.lso;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.parts.SimpleBarOverlay;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;
import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonThirstConsumable;
import sfiomn.legendarysurvivaloverhaul.api.data.manager.ThirstDataManager;
import sfiomn.legendarysurvivaloverhaul.api.thirst.ThirstUtil;
import sfiomn.legendarysurvivaloverhaul.common.capabilities.thirst.ThirstCapability;
import sfiomn.legendarysurvivaloverhaul.config.Config;
import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
import sfiomn.legendarysurvivaloverhaul.util.CapabilityUtil;

public class LegendarySurvivalOverhaulThirstOverlay extends SimpleBarOverlay {
    private ThirstCapability thirstCap = null;
    private @Nullable Item heldItemOnPreview;
    private int heldItemHydration;
    private float heldItemSaturation;
    private boolean heldItemThirst;
    private int blinkTime = 0;

    @Override
    protected Parameters getParameters(Player player) {
        if (!ThirstUtil.isThirstActive(player)) {
            return null;
        }
        if (thirstCap == null || player.tickCount % 20 == 0) {
            thirstCap = CapabilityUtil.getThirstCapability(player);
        }
        var currentHeldItemStack = player.getMainHandItem();
        if (Config.Baked.showDrinkPreview) {
            if (player.tickCount % 10 == 0) {
                JsonThirstConsumable jsonThirstConsumable = ThirstDataManager.getConsumable(currentHeldItemStack);
                heldItemHydration = jsonThirstConsumable != null ? jsonThirstConsumable.hydration : 0;
                heldItemSaturation = jsonThirstConsumable != null ? jsonThirstConsumable.saturation : 0.0F;
                heldItemThirst = jsonThirstConsumable != null && jsonThirstConsumable.effects.stream().anyMatch((jsonEffectParameter) -> jsonEffectParameter.name.equals("legendarysurvivaloverhaul:thirst"));
            }

            if (heldItemOnPreview == null || currentHeldItemStack.isEdible() != heldItemOnPreview.isEdible()) {
                heldItemOnPreview = currentHeldItemStack.getItem();
            }
        }
        int hydration = thirstCap.getHydrationLevel();
        float saturation = thirstCap.getSaturationLevel();
        var hasThirstEffect = player.hasEffect(MobEffectRegistry.THIRST.get());
        var hasHeatThirstEffect = player.hasEffect(MobEffectRegistry.HEAT_THIRST.get());
        if (Config.Baked.showVanillaBarAnimationOverlay && saturation <= 0.0F && player.tickCount % (hydration * 3 + 1) == 0) {
            blinkTime = 2;
        }
        if (blinkTime > 0) {
            blinkTime--;
        }
        var parameters = new Parameters();
        parameters.capacity = 20;
        parameters.value = hydration;
        parameters.fillColor = 0xff3db9e7;
        parameters.boundColor = 0xff092532;
        parameters.emptyColor = 0xff0a3650;
        parameters.valueIncrement = Math.max(0.0F, heldItemHydration) / parameters.capacity;

        if (hasThirstEffect) {
            parameters.fillColor = 0xff8ffe36;
            parameters.boundColor = 0xff112f0c;
            parameters.emptyColor = 0xff214019;
        }
        if (hasHeatThirstEffect) {
            if (hasThirstEffect) {
                parameters.fillColor2 = 0xffcae00a;
            } else {
                parameters.fillColor2 = 0xffea8c15;
            }
        }
        if (Config.Baked.thirstSaturationDisplayed) {
            parameters.boundValue = saturation;
            parameters.boundCapacity = 20;
            parameters.boundFillColor = 0xff68fefe;
            parameters.boundValueIncrement = Math.max(0.0F, heldItemSaturation / parameters.boundCapacity);
            if (heldItemThirst) {
                if (hasHeatThirstEffect) {
                    parameters.boundColor2 = 0xffff542a;
                } else {
                    parameters.boundColor2 = 0xfff0fd67;
                }
            }
        }
        return parameters;
    }

    @Override
    protected boolean shouldRender(Player player) {
        return AsteorBar.config.hookLegendarySurvivalOverhaul() && Config.Baked.thirstEnabled;
    }
}
