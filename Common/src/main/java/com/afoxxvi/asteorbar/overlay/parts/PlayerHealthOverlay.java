package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.Util;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;


public class PlayerHealthOverlay extends SimpleBarOverlay {
    public static final int ABSORPTION_MODE_TOGETHER = 0;
    public static final int ABSORPTION_MODE_STACK = 1;
    public static final int ABSORPTION_MODE_BOUND = 2;
    public static final int ABSORPTION_MODES = 3;
    public static final int ABSORPTION_TEXT_MODE_TOGETHER = 0;
    public static final int ABSORPTION_TEXT_MODE_SEPARATE = 1;
    public static final int ABSORPTION_TEXT_MODES = 2;
    private long healthBlinkTime = 0;
    private long lastHealthTime;
    private float lastHealth;
    private boolean highlight;
    private int regenerationOffset;
    private float flashAlpha;
    private final int[] shift = new int[]{0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1};

    private int[] getStackColor(int low, int num) {
        final var colors = AsteorBar.config.stackHealthBarColors().split(",");
        final var color1 = low == 0 ? "#00000000" : colors[(low - 1) % colors.length];
        final var color2 = colors[low % colors.length];
        if (num == 2) return new int[]{Utils.parseHexColor(color1), Utils.parseHexColor(color2)};
        return new int[]{Utils.parseHexColor(color1), Utils.parseHexColor(color2), Utils.parseHexColor(colors[(low + 1) % colors.length])};
    }

    @Override
    protected Parameters getParameters(Player player) {
        float health = player.getHealth();
        highlight = false;
        if (AsteorBar.config.enableHealthBlink()) {
            highlight = (healthBlinkTime > tick) && ((healthBlinkTime - tick) / 3L % 2L == 1L);
            if (health < lastHealth && player.invulnerableTime > 0) {
                lastHealthTime = Util.getMillis();
                healthBlinkTime = tick + 20L;
            } else if (health > lastHealth && player.invulnerableTime > 0) {
                lastHealthTime = Util.getMillis();
                healthBlinkTime = tick + 10L;
            }
            if (Util.getMillis() - lastHealthTime > 1000L) {
                lastHealth = health;
                lastHealthTime = Util.getMillis();
            }
            lastHealth = health;
        }
        regenerationOffset = -1;
        if (player.hasEffect(MobEffects.REGENERATION)) {
            regenerationOffset = tick % 30 * 6;
        }
        float maxHealth = player.getMaxHealth();
        float absorb = player.getAbsorptionAmount();
        flashAlpha = -1F;
        if (health < maxHealth * AsteorBar.config.lowHealthRate() && !highlight) {
            int margin = Math.abs(tick % 20 - 10);
            flashAlpha = 0.08F * margin;
        }
        Parameters parameters = new Parameters();
        if (health < maxHealth * AsteorBar.config.lowHealthRate()) {
            parameters.verticalShift = shift[tick % shift.length];
        }
        parameters.boundColor = AsteorBar.config.healthBoundColor();
        parameters.emptyColor = AsteorBar.config.healthEmptyColor();
        int healthColor = AsteorBar.config.healthColorNormal();
        if (player.hasEffect(MobEffects.POISON)) {
            healthColor = AsteorBar.config.healthColorPoison();
        } else if (player.hasEffect(MobEffects.WITHER)) {
            healthColor = AsteorBar.config.healthColorWither();
        } else if (player.isFullyFrozen()) {
            healthColor = AsteorBar.config.healthColorFrozen();
        }
        parameters.fillColor = healthColor;
        parameters.boundFillColor = AsteorBar.config.absorptionColor();
        parameters.secondFillColor = AsteorBar.config.absorptionColor();
        int i = AsteorBar.config.displayAbsorptionMethod();
        if (AsteorBar.config.enableStackHealthBar()) {
            i = ABSORPTION_MODE_BOUND;
        }
        double healthIncrement = 0;
        if (AsteorBar.compatibility.appleskin) {
            final var foodValues = AsteorBar.platformAdapter.getAppleSkinFoodValues(player);
            if (foodValues != null) {
                healthIncrement = foodValues.healthIncrement();
            }
            healthIncrement = Math.min(healthIncrement, maxHealth - health);
        }
        if (i == ABSORPTION_MODE_TOGETHER) {
            //draw health
            double full = maxHealth + absorb;
            parameters.value = 1 - (maxHealth - health) / full - parameters.secondValue;
            parameters.valueIncrement = healthIncrement / full;
            parameters.secondValue = absorb / full;
            parameters.secondValueOffset = parameters.value;
            parameters.secondFillColor = AsteorBar.config.absorptionColor();
            parameters.secondFillAlpha = 0.66F;
        } else {
            //draw health
            parameters.value = health / maxHealth;
            if (AsteorBar.config.enableStackHealthBar()) {
                final int unit = AsteorBar.config.fullHealthValue();
                parameters.value = (health % unit) / unit;
                parameters.secondValue = 0;
                if (healthIncrement > 0 && health < maxHealth) {
                    if ((health % unit) + healthIncrement >= unit) {
                        parameters.valueIncrement = 1 - parameters.value;
                        parameters.secondValueIncrement = (parameters.value + healthIncrement / unit) % 1;
                    } else {
                        healthIncrement = Math.min(healthIncrement, maxHealth - health);
                        parameters.valueIncrement = healthIncrement / unit;
                    }
                }
                final var colors = getStackColor((int) (health / unit), parameters.secondValueIncrement > 0 ? 3 : 2);
                if (health >= unit) parameters.emptyColor = colors[0];
                parameters.fillColor = colors[1];
                parameters.secondFillColor = colors[2];
                if (healthColor != AsteorBar.config.healthColorNormal()) {//might be with poison or wither
                    parameters.emptyColor = Utils.mixColor(parameters.emptyColor, healthColor, 0.33F);
                    parameters.fillColor = Utils.mixColor(parameters.fillColor, healthColor, 0.33F);
                    parameters.secondFillColor = Utils.mixColor(parameters.secondFillColor, healthColor, 0.33F);
                }
            } else {
                parameters.value = health / maxHealth;
                if (healthIncrement > 0 && health < maxHealth) {
                    parameters.valueIncrement = Math.min(maxHealth - health, healthIncrement) / maxHealth;
                }
            }
            //draw absorption
            final var fullAbsorb = AsteorBar.config.enableStackHealthBar() ? AsteorBar.config.fullHealthValue() : maxHealth;
            var displayAbsorb = absorb % fullAbsorb;
            if (displayAbsorb == 0 && absorb > 0) {
                displayAbsorb = fullAbsorb;
            }
            if (i == ABSORPTION_MODE_STACK) {
                parameters.secondValue = displayAbsorb / fullAbsorb;
                parameters.secondFillColor = AsteorBar.config.absorptionColor();
                parameters.secondFillAlpha = 0.66F;
            } else if (i == ABSORPTION_MODE_BOUND) {
                parameters.boundFillColor = AsteorBar.config.absorptionColor();
                parameters.boundValue = displayAbsorb / fullAbsorb;
                parameters.boundAlpha = 0.9F;
            }
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            if (absorb > fullAbsorb && (AsteorBar.config.enableStackHealthBar() || AsteorBar.config.displayAbsorptionDivMaxHealth())) {
                int absorbTimes = (int) (absorb / fullAbsorb);
                if (absorb % fullAbsorb == 0) absorbTimes--;
                parameters.leftOuterText = "×" + absorbTimes;
                parameters.leftOuterColor = 0xFFFF00;
            }
        }
        if (AsteorBar.config.displayHealthText()) {
            String hp;
            if (AsteorBar.config.displayAbsorptionTextMethod() == ABSORPTION_TEXT_MODE_TOGETHER && absorb > 0.0F) {
                hp = (Utils.formatNumber(health) + "(+" + Utils.formatNumber(absorb) + ")/" + Utils.formatNumber(maxHealth));
            } else {
                hp = (Utils.formatNumber(health) + "/" + Utils.formatNumber(maxHealth));
            }
            parameters.centerText = hp;
            parameters.centerColor = 0xFFFFFF;
            if (AsteorBar.config.displayAbsorptionTextMethod() == ABSORPTION_TEXT_MODE_SEPARATE && absorb > 0.0F) {
                parameters.leftText = Utils.formatNumber(absorb);
                parameters.leftColor = 0xFFFF00;
            }
        }
        return parameters;
    }

    @Override
    protected void drawDecorations(GuiGraphics guiGraphics, int left, int top, int right, int bottom, Parameters parameters, boolean flip) {
        super.drawDecorations(guiGraphics, left, top, right, bottom, parameters, flip);
        if (regenerationOffset >= 0) {
            int textureLeft;
            int textureRight;
            if (flip) {
                textureLeft = regenerationOffset - 180;
            } else {
                textureLeft = -regenerationOffset;
            }
            textureRight = textureLeft + right - left - 2;
            RenderSystem.setShaderTexture(0, TEXTURE);
            if (textureRight > 0) {
                drawTextureFill(guiGraphics, left + 1, top, -textureLeft, 5, 10 + 180 + textureLeft, Y_REGENERATION_FILL);
                drawTextureFill(guiGraphics, left + 1 - textureLeft, top, textureRight, 5, 10, Y_REGENERATION_FILL);
            } else {
                drawTextureFill(guiGraphics, left + 1, top, right - left - 2, 5, 10 + 180 + textureLeft, Y_REGENERATION_FILL);
            }
            RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        }
        if (highlight) {
            drawBound(guiGraphics, left, top, right, bottom, AsteorBar.config.healthBoundColorBlink());
        } else if (flashAlpha > 0) {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, flashAlpha);
            drawBound(guiGraphics, left, top, right, bottom, AsteorBar.config.healthBoundColorLow());
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    @Override
    protected boolean shouldRender(Player player) {
        return true;
    }
}
