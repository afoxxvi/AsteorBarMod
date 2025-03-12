package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import io.github.foundationgames.mealapi.MealAPI;
import io.github.foundationgames.mealapi.config.MealAPIConfig;
import io.github.foundationgames.mealapi.impl.MealItemRegistryImpl;
import io.github.foundationgames.mealapi.impl.PlayerFullnessUtilImpl;
import io.github.foundationgames.mealapi.util.MAUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class MealAPIOverlay implements SimpleBarOverlay.Layer {
    private static final Bar BAR = new Bar();

    @Override
    public void drawLayer(Player player, GuiGraphics guiGraphics, int left, int top, int right, int bottom, SimpleBarOverlay.Parameters parameters, boolean flip) {
        var params = BAR.getParameters(player);
        BAR.draw(guiGraphics, left, top, right, bottom, params, flip);
    }

    private static class Bar extends SimpleBarOverlay {
        @Override
        protected Parameters getParameters(Player player) {
            var parameters = new Parameters();
            MealAPIConfig cfg = MealAPI.getConfig();
            float opacity = (float) cfg.getValues().fullnessBarOpacityPct / 100.0F;
            int fullness = PlayerFullnessUtilImpl.INSTANCE.getClientFullness();
            int maxFullness = PlayerFullnessUtilImpl.INSTANCE.getMaxFullness();
            parameters.value = fullness;
            parameters.capacity = maxFullness;
            boolean poisoned = player.hasEffect(MobEffects.HUNGER);
            parameters.fillColor = poisoned ? 0xff94ab50 : 0xfff6f892;
            parameters.fillColor = (int) (opacity * 255) << 24 | parameters.fillColor & 0xffffff;
            boolean border = cfg.getValues().fullnessIconBorders == MealAPIConfig.DefaultedYesNo.YES || cfg.getValues().fullnessIconBorders == MealAPIConfig.DefaultedYesNo.DEFAULT && !MAUtil.appleSkin();
            if (cfg.getValues().showFlashingFullnessPreview == MealAPIConfig.DefaultedYesNo.YES || cfg.getValues().showFlashingFullnessPreview == MealAPIConfig.DefaultedYesNo.DEFAULT && MAUtil.appleSkin()) {
                ItemStack previewStack = player.getItemInHand(InteractionHand.MAIN_HAND);
                if (MealItemRegistryImpl.INSTANCE.getFullness(player, player.getItemInHand(InteractionHand.MAIN_HAND)) <= 0) {
                    previewStack = player.getItemInHand(InteractionHand.OFF_HAND);
                }

                if (MealItemRegistryImpl.INSTANCE.getFullness(player, previewStack) > 0) {
                    int potentialFull = Math.min(fullness + PlayerFullnessUtilImpl.INSTANCE.getHealedFullness(player, previewStack), PlayerFullnessUtilImpl.INSTANCE.getMaxFullness());
                    parameters.valueIncrement = potentialFull - fullness;
                }
            }
            if (border) {
                parameters.boundFillColor = poisoned ? 0xff48390f : 0xffb26411;
                parameters.boundFillColor = (int) (opacity * 255) << 24 | parameters.boundFillColor & 0xffffff;
                parameters.boundValue = fullness;
                parameters.boundCapacity = maxFullness;
                parameters.boundValueIncrement = parameters.valueIncrement;
            }
            return parameters;
        }

        @Override
        protected boolean shouldRender(Player player) {
            return AsteorBar.compatibility.mealApi && AsteorBar.config.hookMealApi();
        }
    }
}
