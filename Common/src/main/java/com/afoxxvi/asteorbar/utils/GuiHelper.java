package com.afoxxvi.asteorbar.utils;

import com.afoxxvi.asteorbar.AsteorBar;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unused")
public class GuiHelper {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(AsteorBar.MOD_ID, "textures/gui/overlay.png");
    public static final ResourceLocation LIGHTMAP_TEXTURE = ResourceLocation.fromNamespaceAndPath(AsteorBar.MOD_ID, "textures/ui/lightmap.png");
    public static final int LIGHT = 0xFF00FF;
    private static float globalAlpha = 1.0f;

    public static void setGlobalAlpha(float alpha) {
        globalAlpha = Math.clamp(alpha, 0, 1);
    }

    private static int applyAlpha(int color) {
        if (globalAlpha >= 0.999f) return color;
        int alpha = (color >>> 24) & 0xFF;
        alpha = (int) (alpha * globalAlpha);
        return (color & 0x00FFFFFF) | (alpha << 24);
    }

    public static void drawTexturedRect(GuiGraphics guiGraphics, int left, int top, int textureX, int textureY, int width, int height) {
        drawTexturedRect(guiGraphics, left, top, left + width, top + height, textureX, textureY, textureX + (float) width, textureY + (float) height, 256, 256);
    }

    public static void drawTexturedRectColor(GuiGraphics guiGraphics, int left, int top, int textureX, int textureY, int width, int height, int color) {
        drawTexturedRectColor(guiGraphics, left, top, left + width, top + height, textureX, textureY, textureX + (float) width, textureY + (float) height, 256, 256, color);
    }

    public static void drawTexturedRect(GuiGraphics guiGraphics, int left, int top, int right, int bottom, float uvLeft, float uvTop, float uvRight, float uvBottom, int textureWidth, int textureHeight) {
        drawTexturedRectColor(guiGraphics, left, top, right, bottom, uvLeft, uvTop, uvRight, uvBottom, textureWidth, textureHeight, -1);
    }

    public static void drawTexturedRectColor(GuiGraphics guiGraphics, int left, int top, int right, int bottom, float uvLeft, float uvTop, float uvRight, float uvBottom, int textureWidth, int textureHeight, int color) {
        color = applyAlpha(color);
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, left, top, uvLeft, uvTop, right - left, bottom - top, (int) (uvRight - uvLeft), (int) (uvBottom - uvTop), textureWidth, textureHeight, color);
    }

    public static void drawLightmapRectColor(GuiGraphics guiGraphics, int left, int top, int right, int bottom, float uvLeft, float uvTop, float uvRight, float uvBottom, int color) {
        color = applyAlpha(color);
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, LIGHTMAP_TEXTURE, left, top, uvLeft, uvTop, right - left, bottom - top, (int) (uvRight - uvLeft), (int) (uvBottom - uvTop), 32, 32, color);
    }

    public static void drawSolidColor(GuiGraphics guiGraphics, int left, int top, int right, int bottom, int color) {
        color = applyAlpha(color);
        guiGraphics.fill(left, top, right, bottom, color);
    }

    public static void drawString(GuiGraphics guiGraphics, String string, int left, int top, int color) {
        color = applyAlpha(color);
        drawString(guiGraphics, string, left, top, color, true);
    }

    public static void drawString(GuiGraphics guiGraphics, String string, int left, int top, int color, boolean shadow) {
        color = applyAlpha(color);
        guiGraphics.drawString(Minecraft.getInstance().font, string, left, top, color, shadow);
    }

    public static void drawSolidGradient(GuiGraphics guiGraphics, int left, int top, int right, int bottom, int color) {
        drawLightmapRectColor(guiGraphics, left, top, right, bottom, 0, 20, 32, 32, color);
    }

    public static void drawSolidGradientUpDown(GuiGraphics guiGraphics, int left, int top, int right, int bottom, int color) {
        drawLightmapRectColor(guiGraphics, left, top, right, bottom, 0, 0, 32, 12, color);
    }

    public static void renderBound(VertexConsumer vertexConsumer, PoseStack poseStack, int left, int top, int right, int bottom, int width, int boundWidth, int colorFill, int colorEmpty, boolean vertex, float z) {
        colorFill = applyAlpha(colorFill);
        colorEmpty = applyAlpha(colorEmpty);
        int cut = 0;
        int expand = vertex ? boundWidth : 0;
        if (width > 0) {//left bound, vertex included
            int part = Math.min(width, boundWidth);
            cut += part;
            GuiHelper.renderSolid(vertexConsumer, poseStack, left - boundWidth, top - expand, left - boundWidth + part, bottom + expand, colorFill, z);
            if (part < boundWidth) {
                GuiHelper.renderSolid(vertexConsumer, poseStack, left - boundWidth + part, top - expand, left, bottom + expand, colorEmpty, z);
            }
        } else {
            GuiHelper.renderSolid(vertexConsumer, poseStack, left - boundWidth, top - expand, left, bottom + expand, colorEmpty, z);
        }
        if (width > right - left + boundWidth) {//right bound, vertex included
            int part = Math.min(width, boundWidth);
            cut += part;
            GuiHelper.renderSolid(vertexConsumer, poseStack, right, top - expand, right + part, bottom + expand, colorFill, z);
            if (part < boundWidth) {
                GuiHelper.renderSolid(vertexConsumer, poseStack, right + part, top - expand, right + boundWidth, bottom + expand, colorEmpty, z);
            }
        } else {
            GuiHelper.renderSolid(vertexConsumer, poseStack, right, top - expand, right + boundWidth, bottom + expand, colorEmpty, z);
        }
        width -= cut;
        if (width > 0) {//upper and lower bound, vertex excluded
            GuiHelper.renderSolid(vertexConsumer, poseStack, left, top - boundWidth, left + width, top, colorFill, z);
            GuiHelper.renderSolid(vertexConsumer, poseStack, left, bottom, left + width, bottom + boundWidth, colorFill, z);
        }
        if (width < right - left) {
            GuiHelper.renderSolid(vertexConsumer, poseStack, left + width, top - boundWidth, right, top, colorEmpty, z);
            GuiHelper.renderSolid(vertexConsumer, poseStack, left + width, bottom, right, bottom + boundWidth, colorEmpty, z);
        }

    }

    //left < right, top < bottom
    public static void renderSolid(VertexConsumer vertexConsumer, PoseStack poseStack, int left, int top, int right, int bottom, int color, float z) {
        color = applyAlpha(color);
        vertexConsumer.addVertex(poseStack.last().pose(), left, top, z).setColor(color).setUv(0, 0).setLight(LIGHT).setOverlay(OverlayTexture.NO_OVERLAY).setNormal(poseStack.last(), 0, 0, 0);
        vertexConsumer.addVertex(poseStack.last().pose(), left, bottom, z).setColor(color).setUv(0, 0.125f).setLight(LIGHT).setOverlay(OverlayTexture.NO_OVERLAY).setNormal(poseStack.last(), 0, 0, 0);
        vertexConsumer.addVertex(poseStack.last().pose(), right, bottom, z).setColor(color).setUv(1, 0.125f).setLight(LIGHT).setOverlay(OverlayTexture.NO_OVERLAY).setNormal(poseStack.last(), 0, 0, 0);
        vertexConsumer.addVertex(poseStack.last().pose(), right, top, z).setColor(color).setUv(1, 0).setLight(LIGHT).setOverlay(OverlayTexture.NO_OVERLAY).setNormal(poseStack.last(), 0, 0, 0);
    }

    public static void renderSolidGradient(VertexConsumer vertexConsumer, PoseStack poseStack, int left, int top, int right, int bottom, int color, float z) {
        color = applyAlpha(color);
        vertexConsumer.addVertex(poseStack.last().pose(), left, top, z).setColor(color).setUv(0, 0.625f).setLight(LIGHT).setOverlay(OverlayTexture.NO_OVERLAY).setNormal(poseStack.last(), 0, 0, 0);
        vertexConsumer.addVertex(poseStack.last().pose(), left, bottom, z).setColor(color).setUv(0, 1).setLight(LIGHT).setOverlay(OverlayTexture.NO_OVERLAY).setNormal(poseStack.last(), 0, 0, 0);
        vertexConsumer.addVertex(poseStack.last().pose(), right, bottom, z).setColor(color).setUv(1, 1).setLight(LIGHT).setOverlay(OverlayTexture.NO_OVERLAY).setNormal(poseStack.last(), 0, 0, 0);
        vertexConsumer.addVertex(poseStack.last().pose(), right, top, z).setColor(color).setUv(1, 0.625f).setLight(LIGHT).setOverlay(OverlayTexture.NO_OVERLAY).setNormal(poseStack.last(), 0, 0, 0);
    }

    public static void renderSolidGradientUpDown(VertexConsumer vertexConsumer, PoseStack poseStack, int left, int top, int right, int bottom, int color, float z) {
        color = applyAlpha(color);
        vertexConsumer.addVertex(poseStack.last().pose(), left, top, z).setColor(color).setUv(0, 0).setLight(LIGHT).setOverlay(OverlayTexture.NO_OVERLAY).setNormal(poseStack.last(), 0, 0, 0);
        vertexConsumer.addVertex(poseStack.last().pose(), left, bottom, z).setColor(color).setUv(0, 0.375f).setLight(LIGHT).setOverlay(OverlayTexture.NO_OVERLAY).setNormal(poseStack.last(), 0, 0, 0);
        vertexConsumer.addVertex(poseStack.last().pose(), right, bottom, z).setColor(color).setUv(1, 0.375f).setLight(LIGHT).setOverlay(OverlayTexture.NO_OVERLAY).setNormal(poseStack.last(), 0, 0, 0);
        vertexConsumer.addVertex(poseStack.last().pose(), right, top, z).setColor(color).setUv(1, 0).setLight(LIGHT).setOverlay(OverlayTexture.NO_OVERLAY).setNormal(poseStack.last(), 0, 0, 0);
    }

    public static void renderString(PoseStack poseStack, MultiBufferSource buffer, String string, float left, float top, int color, boolean shadow) {
        color = applyAlpha(color);
        Minecraft.getInstance().font.drawInBatch(string, left, top, color, shadow, poseStack.last().pose(), buffer, Font.DisplayMode.NORMAL, 0, 0xF000F0);
    }

    public static void renderString(PoseStack poseStack, MultiBufferSource buffer, String string, int left, int top, int color) {
        renderString(poseStack, buffer, string, left, top, color, false);
    }

    public static void renderCenteredString(PoseStack poseStack, MultiBufferSource buffer, String string, int left, int top, int color) {
        renderString(poseStack, buffer, string, left - Minecraft.getInstance().font.width(string) / 2.0f, top, color, false);
    }

    public static void renderStringShadow(PoseStack poseStack, MultiBufferSource buffer, String string, int left, int top, int color) {
        renderString(poseStack, buffer, string, left, top, color, true);
    }

    public static void renderCenteredStringShadow(PoseStack poseStack, MultiBufferSource buffer, String string, int left, int top, int color) {
        renderString(poseStack, buffer, string, left - Minecraft.getInstance().font.width(string) / 2.0f, top, color, true);
    }
}
