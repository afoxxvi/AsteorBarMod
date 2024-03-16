package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.Util;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.effect.MobEffects;


public class PlayerHealthOverlay extends BaseOverlay {
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

    private int[] getStackColor(int low) {
        final var colors = AsteorBar.config.stackHealthBarColors().split(",");
        final var color1 = low == 0 ? "#00000000" : colors[(low - 1) % colors.length];
        final var color2 = colors[low % colors.length];
        return new int[]{Utils.parseHexColor(color1), Utils.parseHexColor(color2)};
    }

    private void draw(PoseStack poseStack, int left, int top, int right, int bottom, boolean highlight, int healthColor, float health, float absorb, float maxHealth, float flashAlpha, int regenerationOffset, boolean flip) {
        //draw bound
        drawBound(poseStack, left, top, right, bottom, AsteorBar.config.healthBoundColor());
        drawEmptyFill(poseStack, left + 1, top + 1, right - 1, bottom - 1, AsteorBar.config.healthEmptyColor());
        final var outerLength = right - left;
        final var innerLength = outerLength - 2;
        int i = AsteorBar.config.displayAbsorptionMethod();
        if (AsteorBar.config.enableStackHealthBar()) {
            i = ABSORPTION_MODE_BOUND;
        }
        if (i == ABSORPTION_MODE_TOGETHER) {
            //draw health
            int healthLength = (int) (innerLength * health / (maxHealth + absorb));
            int emptyLength = (int) (innerLength * (maxHealth - health) / (maxHealth + absorb));
            int absorbLength = innerLength - healthLength - emptyLength;
            if (absorb <= 0.0F) {
                healthLength += absorbLength;
                absorbLength = 0;
            }
            healthLength += innerLength - emptyLength - absorbLength - healthLength;
            drawFillFlip(poseStack, left + 1, top + 1, right - 1, bottom - 1, healthLength, healthColor, flip);
            //draw absorption
            if (absorbLength > 0) {
                if (flip) {
                    drawFillFlip(poseStack, left + 1, top + 1, right - 1 - healthLength, bottom - 1, absorbLength, AsteorBar.config.absorptionColor(), true);
                } else {
                    drawFillFlip(poseStack, left + 1 + healthLength, top + 1, right - 1, bottom - 1, absorbLength, AsteorBar.config.absorptionColor(), false);
                }
            }
        } else {
            //draw health
            int healthLength = (int) (innerLength * health / maxHealth);
            if (AsteorBar.config.enableStackHealthBar()) {
                final int unit = AsteorBar.config.fullHealthValue();
                healthLength = (int) (innerLength * (health % unit) / unit);
                final var colors = getStackColor((int) (health / unit));
                if (colors[0] != 0) drawFillFlip(poseStack, left + 1, top + 1, right - 1, bottom - 1, innerLength, colors[0], flip);
                if (colors[1] != 0) drawFillFlip(poseStack, left + 1, top + 1, right - 1, bottom - 1, healthLength, colors[1], flip);
                if (healthColor != AsteorBar.config.healthColorNormal()) {
                    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.66F);
                    drawFillFlip(poseStack, left + 1, top + 1, right - 1, bottom - 1, innerLength, healthColor, flip);
                    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                }
            } else {
                drawFillFlip(poseStack, left + 1, top + 1, right - 1, bottom - 1, healthLength, healthColor, flip);
            }
            //draw absorption
            final var fullAbsorb = AsteorBar.config.enableStackHealthBar() ? AsteorBar.config.fullHealthValue() : maxHealth;
            var displayAbsorb = absorb % fullAbsorb;
            if (displayAbsorb == 0 && absorb > 0) {
                displayAbsorb = fullAbsorb;
            }
            if (i == ABSORPTION_MODE_STACK) {
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.66F);
                int absorbLength = (int) (innerLength * displayAbsorb / maxHealth);
                drawFillFlip(poseStack, left + 1, top + 1, right - 1, bottom - 1, absorbLength, AsteorBar.config.absorptionColor(), flip);
            } else if (i == ABSORPTION_MODE_BOUND) {
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.9F);
                int absorbLength = (int) (outerLength * displayAbsorb / maxHealth);
                drawBoundFlip(poseStack, left, top, right, bottom, absorbLength, AsteorBar.config.absorptionColor(), flip);
            }
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            if (absorb > fullAbsorb && (AsteorBar.config.enableStackHealthBar() || AsteorBar.config.displayAbsorptionDivMaxHealth())) {
                int absorbTimes = (int) (absorb / fullAbsorb);
                if (absorb % fullAbsorb == 0) absorbTimes--;
                if (flip) {
                    Overlays.addStringRender(right, top - 2, 0xFFFF00, "×" + absorbTimes, Overlays.ALIGN_LEFT, true);
                } else {
                    Overlays.addStringRender(left, top - 2, 0xFFFF00, absorbTimes + "×", Overlays.ALIGN_RIGHT, true);
                }
            }
        }
        //draw regeneration
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
                drawTextureFill(poseStack, left + 1, top, -textureLeft, 5, 10 + 180 + textureLeft, Y_REGENERATION_FILL);
                drawTextureFill(poseStack, left + 1 - textureLeft, top, textureRight, 5, 10, Y_REGENERATION_FILL);
            } else {
                drawTextureFill(poseStack, left + 1, top, right - left - 2, 5, 10 + 180 + textureLeft, Y_REGENERATION_FILL);
            }
            RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        }
        if (AsteorBar.config.displayHealthText()) {
            String hp;
            if (AsteorBar.config.displayAbsorptionTextMethod() == ABSORPTION_TEXT_MODE_TOGETHER && absorb > 0.0F) {
                hp = (Utils.formatNumber(health) + "(+" + Utils.formatNumber(absorb) + ")/" + Utils.formatNumber(maxHealth));
            } else {
                hp = (Utils.formatNumber(health) + "/" + Utils.formatNumber(maxHealth));
            }
            Overlays.addStringRender((left + right) / 2, top - 2, 0xFFFFFF, hp, Overlays.ALIGN_CENTER, true);
            if (AsteorBar.config.displayAbsorptionTextMethod() == ABSORPTION_TEXT_MODE_SEPARATE && absorb > 0.0F) {
                if (flip) {
                    Overlays.addStringRender(right - 2, top - 2, 0xFFFF00, Utils.formatNumber(absorb), Overlays.ALIGN_RIGHT, true);
                } else {
                    Overlays.addStringRender(left + 2, top - 2, 0xFFFF00, Utils.formatNumber(absorb), Overlays.ALIGN_LEFT, true);
                }
            }
        }
        if (highlight) {
            drawBound(poseStack, left, top, right, bottom, AsteorBar.config.healthBoundColorBlink());
        } else if (flashAlpha > 0) {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, flashAlpha);
            RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            drawBound(poseStack, left, top, right, bottom, AsteorBar.config.healthBoundColorLow());
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    @Override
    public void renderOverlay(RenderGui gui, PoseStack guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        RenderSystem.enableBlend();
        var mc = gui.mc();
        var player = mc.player;
        if (player == null) return;
        float health = player.getHealth();
        boolean highlight = false;
        long tickCount = gui.gui().getGuiTicks();
        if (AsteorBar.config.enableHealthBlink()) {
            highlight = healthBlinkTime > tickCount && (healthBlinkTime - tickCount) / 3L % 2L == 1L;
            if (health < lastHealth && player.invulnerableTime > 0) {
                lastHealthTime = Util.getMillis();
                healthBlinkTime = tickCount + 20L;
            } else if (health > lastHealth && player.invulnerableTime > 0) {
                lastHealthTime = Util.getMillis();
                healthBlinkTime = tickCount + 10L;
            }
            if (Util.getMillis() - lastHealthTime > 1000L) {
                lastHealth = health;
                lastHealthTime = Util.getMillis();
            }
            lastHealth = health;
        }
        float maxHealth = player.getMaxHealth();
        float absorb = player.getAbsorptionAmount();
        int healthType = AsteorBar.config.healthColorNormal();
        if (player.hasEffect(MobEffects.POISON)) {
            healthType = AsteorBar.config.healthColorPoison();
        } else if (player.hasEffect(MobEffects.WITHER)) {
            healthType = AsteorBar.config.healthColorWither();
        } else if (player.isFullyFrozen()) {
            healthType = AsteorBar.config.healthColorFrozen();
        }
        var flashAlpha = -1F;
        if (health < maxHealth * AsteorBar.config.lowHealthRate() && !highlight) {
            int margin = Math.abs((int) tickCount % 20 - 10);
            flashAlpha = 0.08F * margin;
        }
        var regenerationOffset = -1;
        if (player.hasEffect(MobEffects.REGENERATION)) {
            regenerationOffset = (int) (tickCount % 30 * 6);
        }
        switch (Overlays.style) {
            case Overlays.STYLE_NONE -> {

            }
            case Overlays.STYLE_ABOVE_HOT_BAR_LONG -> {
                int top = screenHeight - gui.leftHeight() - 2;
                int left = screenWidth / 2 - 91;
                gui.leftHeight(12);
                draw(guiGraphics, left, top, left + BOUND_FULL_WIDTH_LONG, top + 5, highlight, healthType, health, absorb, maxHealth, flashAlpha, regenerationOffset, false);
            }
            case Overlays.STYLE_ABOVE_HOT_BAR_SHORT -> {
                int top = screenHeight - gui.leftHeight() + 4;
                int left = screenWidth / 2 - 91;
                gui.leftHeight(6);
                draw(guiGraphics, left, top, left + BOUND_FULL_WIDTH_SHORT, top + 5, highlight, healthType, health, absorb, maxHealth, flashAlpha, regenerationOffset, false);
            }
            case Overlays.STYLE_TOP_LEFT -> {
                int top = Overlays.vertical;
                int left = Overlays.horizontal;
                draw(guiGraphics, left, top, left + Overlays.length, top + 5, highlight, healthType, health, absorb, maxHealth, flashAlpha, regenerationOffset, false);
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_TOP_RIGHT -> {
                int top = Overlays.vertical;
                int left = screenWidth - Overlays.length - Overlays.horizontal;
                draw(guiGraphics, left, top, left + Overlays.length, top + 5, highlight, healthType, health, absorb, maxHealth, flashAlpha, regenerationOffset, true);
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_BOTTOM_LEFT -> {
                int top = screenHeight - Overlays.vertical;
                int left = Overlays.horizontal;
                draw(guiGraphics, left, top, left + Overlays.length, top + 5, highlight, healthType, health, absorb, maxHealth, flashAlpha, regenerationOffset, false);
                Overlays.vertical += 6;
            }
            case Overlays.STYLE_BOTTOM_RIGHT -> {
                int top = screenHeight - Overlays.vertical;
                int left = screenWidth - Overlays.length - Overlays.horizontal;
                draw(guiGraphics, left, top, left + Overlays.length, top + 5, highlight, healthType, health, absorb, maxHealth, flashAlpha, regenerationOffset, true);
                Overlays.vertical += 6;
            }
        }
        RenderSystem.disableBlend();
    }
}
