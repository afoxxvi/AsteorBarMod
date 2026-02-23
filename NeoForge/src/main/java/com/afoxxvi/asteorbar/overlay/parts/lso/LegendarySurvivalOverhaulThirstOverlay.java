package com.afoxxvi.asteorbar.overlay.parts.lso;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.parts.SimpleBarOverlay;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;
import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonThirstConsumable;
import sfiomn.legendarysurvivaloverhaul.api.data.manager.ThirstDataManager;
import sfiomn.legendarysurvivaloverhaul.api.thirst.ThirstUtil;
import sfiomn.legendarysurvivaloverhaul.common.attachments.thirst.ThirstAttachment;
import sfiomn.legendarysurvivaloverhaul.common.enchantments.ModEnchantments;
import sfiomn.legendarysurvivaloverhaul.common.items.drink.CanteenItem;
import sfiomn.legendarysurvivaloverhaul.config.Config;
import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;

public class LegendarySurvivalOverhaulThirstOverlay extends SimpleBarOverlay {
    private ThirstAttachment thirstCap = null;
    private @Nullable Item heldItemOnPreview;
    private int heldItemHydration;
    private float heldItemSaturation;
    private boolean heldItemThirst;
    private float exhaustion = 0.0f;
    private int blinkTime = 0;

    @Override
    protected Parameters getParameters(Player player) {
        if (!ThirstUtil.isThirstActive(player)) {
            return null;
        }
        if (thirstCap == null || player.tickCount % 20 == 0) {
            thirstCap = AttachmentUtil.getThirstAttachment(player);
        }
        var currentHeldItemStack = player.getMainHandItem();
        if (Config.Baked.showDrinkPreview) {
            if (player.tickCount % 10 == 0) {
                JsonThirstConsumable jsonThirstConsumable = ThirstDataManager.getConsumable(currentHeldItemStack);
                heldItemHydration = jsonThirstConsumable != null ? jsonThirstConsumable.hydration : 0;
                heldItemSaturation = jsonThirstConsumable != null ? jsonThirstConsumable.saturation : 0.0F;
                heldItemThirst = jsonThirstConsumable != null && jsonThirstConsumable.effects.stream().anyMatch((jsonEffectParameter) -> jsonEffectParameter.name.equals("legendarysurvivaloverhaul:thirst"));
                if (currentHeldItemStack.getItem() instanceof CanteenItem && CanteenItem.canDrink(currentHeldItemStack)) {
                    int refreshingLevel = currentHeldItemStack.getEnchantmentLevel(player.level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ModEnchantments.REFRESHING));
                    if (refreshingLevel > 0) {
                        heldItemHydration += refreshingLevel;
                        heldItemSaturation += Math.max(0, refreshingLevel - 1);
                    }
                }
            }

            boolean currentIsEdible = currentHeldItemStack.has(DataComponents.FOOD);
            boolean previousIsEdible = heldItemOnPreview != null && heldItemOnPreview.components().has(DataComponents.FOOD);
            if (heldItemOnPreview == null || currentIsEdible != previousIsEdible) {
                heldItemOnPreview = currentHeldItemStack.getItem();
            }
        }
        int hydration = thirstCap.getHydrationLevel();
        float saturation = thirstCap.getSaturationLevel();
        exhaustion = thirstCap.getThirstExhaustion();
        var hasThirstEffect = player.hasEffect(MobEffectRegistry.THIRST);
        var hasHeatThirstEffect = player.hasEffect(MobEffectRegistry.HEAT_THIRST);
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
        if (Config.Baked.hydrationSaturationDisplayed) {
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
    protected void drawDecorations(GuiGraphics guiGraphics, int left, int top, int right, int bottom, Parameters parameters, boolean flip) {
        super.drawDecorations(guiGraphics, left, top, right, bottom, parameters, flip);
        int innerWidth = right - left - 2;
        if (Config.Baked.hydrationExhaustionDisplayed) {
            RenderSystem.setShaderTexture(0, TEXTURE);
            int exhaustionWidth = (int) (innerWidth * (Math.min(AsteorBar.config.fullExhaustionValue(), exhaustion) / AsteorBar.config.fullExhaustionValue()));
            drawTextureFillFlip(guiGraphics, left + 1, top, right - 1, exhaustionWidth, 5, 10, Y_FOOD_EXHAUSTION_FILL, FILL_FULL_WIDTH_LONG, flip);
            RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        }
    }

    @Override
    protected boolean shouldRender(Player player) {
        return AsteorBar.config.hookLegendarySurvivalOverhaul() && Config.Baked.thirstEnabled;
    }
}
