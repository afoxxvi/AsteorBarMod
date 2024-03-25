package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.afoxxvi.asteorbar.utils.GuiHelper;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

public abstract class BaseOverlay {
    public static final ResourceLocation TEXTURE = new ResourceLocation(AsteorBar.MOD_ID, "textures/gui/overlay.png");
    public static final ResourceLocation LIGHTMAP_TEXTURE = new ResourceLocation(AsteorBar.MOD_ID, "textures/ui/lightmap.png");
    public static final int FILL_FULL_WIDTH_LONG = 180;
    public static final int BOUND_FULL_WIDTH_LONG = 182;
    public static final int BOUND_FULL_WIDTH_SHORT = 81;
    public static final int Y_REGENERATION_FILL = 0;
    public static final int Y_FOOD_EXHAUSTION_FILL = 9;
    public static final int Y_EXPERIENCE_DECORATION = 18;
    public static final int Y_RIGHT_DECORATION = 27;
    public static final int Y_LEFT_DECORATION = 36;

    public BaseOverlay overrideOverlay = null;

    public boolean shouldOverride() {
        return false;
    }

    protected void drawTextureFill(GuiGraphics guiGraphics, int left, int top, int width, int height, int textureX, int textureY) {
        GuiHelper.drawTexturedRect(guiGraphics, left, top, textureX, textureY, width, height);
    }

    protected void drawTextureFillColor(GuiGraphics guiGraphics, int left, int top, int width, int height, int textureX, int textureY, int textureWidth, int textureHeight, int color) {
        GuiHelper.drawTexturedRectColor(guiGraphics, left, top, left + width, top + height, textureX, textureY, textureX + textureWidth, textureY + textureHeight, 256, 256, color);
    }

    protected void drawTextureFillFlip(GuiGraphics guiGraphics, int left, int top, int right, int width, int height, int textureX, int textureY, int textureFullWidth, boolean flip) {
        if (flip) {
            GuiHelper.drawTexturedRect(guiGraphics, right - width, top, textureX + textureFullWidth - width, textureY, width, height);
        } else {
            GuiHelper.drawTexturedRect(guiGraphics, left, top, textureX, textureY, width, height);
        }
    }

    protected void drawEmptyFill(GuiGraphics guiGraphics, int left, int top, int right, int bottom, int color) {
        GuiHelper.drawSolidGradient(guiGraphics.pose(), left, top, right, bottom, color);
    }

    protected void drawFillFlipConcat(GuiGraphics guiGraphics, int left, int top, int right, int bottom, int has, int width, int color, boolean flip) {
        if (has == 0) {
            drawFillFlip(guiGraphics, left, top, right, bottom, width, color, flip);
            return;
        }
        width = Math.max(0, Math.min(right - left - has, width));
        if (flip) {
            GuiHelper.drawSolidGradientUpDown(guiGraphics.pose(), right - has - width, top, right - has, bottom, color);
        } else {
            GuiHelper.drawSolidGradientUpDown(guiGraphics.pose(), left + has, top, left + has + width, bottom, color);
        }
    }

    protected void drawFillFlip(GuiGraphics guiGraphics, int left, int top, int right, int bottom, int width, int color, boolean flip) {
        width = Math.max(0, Math.min(right - left, width));
        if (flip) {
            GuiHelper.drawSolidGradientUpDown(guiGraphics.pose(), right - width, top, right, bottom, color);
        } else {
            GuiHelper.drawSolidGradientUpDown(guiGraphics.pose(), left, top, left + width, bottom, color);
        }
    }

    protected void drawFillFlip(GuiGraphics guiGraphics, int left, int top, int right, int bottom, int width, int color, int color2, boolean flip) {
        width = Math.max(0, Math.min(right - left, width));
        drawFillFlip(guiGraphics, left, top, right, bottom, width, color, flip);
        if (flip) {
            GuiHelper.drawSolidColor(guiGraphics, right - width, bottom - 1, right, bottom, color2);
        } else {
            GuiHelper.drawSolidColor(guiGraphics, left, bottom - 1, left + width, bottom, color2);
        }
    }

    protected void drawBoundFlipConcat(GuiGraphics guiGraphics, int left, int top, int right, int bottom, int has, int width, int color, boolean flip) {
        if (has == 0) {
            drawBoundFlip(guiGraphics, left, top, right, bottom, width, color, flip);
            return;
        }
        width = Math.max(0, Math.min(right - left - has, width));
        if (width == 0) return;
        if (flip) {
            if (has + width >= right - left) {
                GuiHelper.drawSolidColor(guiGraphics, left, top + 1, left + 1, bottom - 1, color);
                width--;
            }
            //note that 1 pixel of 'has' is drawn as right bound
            GuiHelper.drawSolidColor(guiGraphics, right - has - width, top, right - has, top + 1, color);
            GuiHelper.drawSolidColor(guiGraphics, right - has - width, bottom - 1, right - has, bottom, color);
        } else {
            if (has + width >= right - left) {
                GuiHelper.drawSolidColor(guiGraphics, right - 1, top + 1, right, bottom - 1, color);
                width--;
            }
            GuiHelper.drawSolidColor(guiGraphics, left + has, top, left + has + width, top + 1, color);
            GuiHelper.drawSolidColor(guiGraphics, left + has, bottom - 1, left + has + width, bottom, color);
        }
    }

    protected void drawBoundFlip(GuiGraphics guiGraphics, int left, int top, int right, int bottom, int width, int color, boolean flip) {
        width = Math.max(0, Math.min(right - left, width));
        if (width == 0) return;
        if (width == right - left) {
            drawBound(guiGraphics, left, top, right, bottom, color);
            return;
        }
        if (flip) {
            GuiHelper.drawSolidColor(guiGraphics, right - 1, top + 1, right, bottom - 1, color);
            if (width > 1) {
                GuiHelper.drawSolidColor(guiGraphics, right - 1 - width + 1, top, right - 1, top + 1, color);
                GuiHelper.drawSolidColor(guiGraphics, right - 1 - width + 1, bottom - 1, right - 1, bottom, color);
            }
        } else {
            GuiHelper.drawSolidColor(guiGraphics, left, top + 1, left + 1, bottom - 1, color);
            if (width > 1) {
                GuiHelper.drawSolidColor(guiGraphics, left + 1, top, left + 1 + width - 1, top + 1, color);
                GuiHelper.drawSolidColor(guiGraphics, left + 1, bottom - 1, left + 1 + width - 1, bottom, color);
            }
        }
    }

    protected void drawBound(GuiGraphics guiGraphics, int left, int top, int right, int bottom, int color) {
        GuiHelper.drawSolidColor(guiGraphics, left, top + 1, left + 1, bottom - 1, color);
        GuiHelper.drawSolidColor(guiGraphics, right - 1, top + 1, right, bottom - 1, color);
        GuiHelper.drawSolidColor(guiGraphics, left + 1, top, right - 1, top + 1, color);
        GuiHelper.drawSolidColor(guiGraphics, left + 1, bottom - 1, right - 1, bottom, color);
    }

    protected void drawBound(GuiGraphics guiGraphics, int left, int top, int right, int bottom, int color, int color2) {
        GuiHelper.drawSolidColor(guiGraphics, left, top + 1, left + 1, bottom - 2, color);
        GuiHelper.drawSolidColor(guiGraphics, right - 1, top + 1, right, bottom - 2, color);
        GuiHelper.drawSolidColor(guiGraphics, left + 1, top, right - 1, top + 1, color);
        GuiHelper.drawSolidColor(guiGraphics, left, bottom - 2, left + 1, bottom - 1, color2);
        GuiHelper.drawSolidColor(guiGraphics, right - 1, bottom - 2, right, bottom - 1, color2);
        GuiHelper.drawSolidColor(guiGraphics, left + 1, bottom - 1, right - 1, bottom, color2);
    }

    public void render(RenderGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        if (AsteorBar.config.enableOverlay()) {
            RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
            if (overrideOverlay != null && overrideOverlay.shouldOverride()) {
                overrideOverlay.render(gui, guiGraphics, partialTick, screenWidth, screenHeight);
            } else {
                renderOverlay(gui, guiGraphics, partialTick, screenWidth, screenHeight);
            }
        }
    }

    public abstract void renderOverlay(RenderGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight);
}
