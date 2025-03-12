package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.systems.RenderSystem;
import net.dehydration.access.ThirstManagerAccess;
import net.dehydration.init.ConfigInit;
import net.dehydration.init.EffectInit;
import net.dehydration.item.LeatherFlask;
import net.dehydration.misc.ThirstTooltipData;
import net.dehydration.thirst.ThirstManager;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class DehydrationOverlay extends SimpleBarOverlay {
    private int blinkTime = 0;
    private final int[] qualityColor = {0xff36abff, 0xff5a99b0, 0xffc3e71a, 0xff7ec9ff};
    private float dehydration = 0.0F;

    @Override
    protected Parameters getParameters(Player player) {
        ThirstManager thirstManager = ((ThirstManagerAccess) player).getThirstManager();
        if (!thirstManager.hasThirst()) return null;
        var parameters = new Parameters();
        int thirst = thirstManager.getThirstLevel();
        dehydration = thirstManager.dehydration;
        int thirstColor = 0xff1aafe7;
        if (player.hasEffect(EffectInit.THIRST)) {
            thirstColor = 0xffc3e71a;
        }
        if (player.getTicksFrozen() > 0) {
            thirstColor = 0xff7ec9ff;
        }
        if (AsteorBar.config.enableFoodBlink()) {
            if (thirstManager.dehydration >= 4.0F && tick % (thirst * 3 + 1) == 0) {
                blinkTime = 2;
            }
            if (blinkTime > 0) {
                blinkTime--;
            }
        }
        int thirstQuench = 0;
        int quality = 0;
        float alpha = 1.0F;
        if (ConfigInit.CONFIG.thirst_preview && thirst < 20) {
            ItemStack itemStack = null;
            if (!player.getMainHandItem().isEmpty() && !player.getMainHandItem().getTooltipImage().isEmpty() && player.getMainHandItem()
                    .getTooltipImage().get() instanceof ThirstTooltipData) {
                itemStack = player.getMainHandItem();
            } else if (player.getOffhandItem().isEmpty() && !player.getOffhandItem().getTooltipImage().isEmpty() && player.getOffhandItem()
                    .getTooltipImage().get() instanceof ThirstTooltipData) {
                itemStack = player.getOffhandItem();
            }
            if (itemStack != null) {
                thirstQuench = ((ThirstTooltipData) itemStack.getTooltipImage().get()).getThirstQuench();
                if (itemStack.getItem() instanceof LeatherFlask) {
                    thirstQuench = ConfigInit.CONFIG.flask_thirst_quench;
                }
                quality = ((ThirstTooltipData) itemStack.getTooltipImage().get()).getDrinkQuality();
                alpha = (float) Math.cos(tick % 40 / 40.0 * Math.PI * 2) * 0.5F + 0.5F;
            }
        }
        boolean highlight = blinkTime > 0;
        parameters.boundColor = highlight ? Utils.mixColor(0xffffffff, thirstColor, 0.08) : Utils.mixColor(0xff000000, thirstColor, 0.5);
        parameters.emptyColor = AsteorBar.config.foodEmptyColor();

        parameters.value = thirst;
        parameters.capacity = 20;

        if (thirstQuench > 0) {
            parameters.secondValue = thirstQuench;
            parameters.secondValueOffset = thirst;
            parameters.secondFillColor = qualityColor[Math.max(0, Math.min(3, quality))];
            parameters.secondFillAlpha = alpha;
        }
        return parameters;
    }

    @Override
    protected void drawDecorations(GuiGraphics guiGraphics, int left, int top, int right, int bottom, Parameters parameters, boolean flip) {
        super.drawDecorations(guiGraphics, left, top, right, bottom, parameters, flip);
        if (AsteorBar.config.displayExhaustion()) {
            int innerWidth = right - left - 2;
            RenderSystem.setShaderTexture(0, TEXTURE);
            int exhaustionWidth = (int) (innerWidth * (Math.min(4.0F, dehydration) / 4.0F));
            drawTextureFillFlip(guiGraphics, left + 1, top, right - 1, exhaustionWidth, 5, 10, Y_FOOD_EXHAUSTION_FILL, FILL_FULL_WIDTH_LONG, flip);
            RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        }
    }

    @Override
    protected boolean shouldRender(Player player) {
        return AsteorBar.compatibility.dehydration && AsteorBar.config.hookDehydration();
    }
}
