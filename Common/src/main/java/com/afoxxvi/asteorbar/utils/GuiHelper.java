package com.afoxxvi.asteorbar.utils;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;

@SuppressWarnings("unused")
public class GuiHelper {
    public static void drawTexturedRect(GuiGraphics guiGraphics, int left, int top, int textureX, int textureY, int width, int height) {
        drawTexturedRect(guiGraphics, left, top, left + width, top + height, textureX, textureY, textureX + (float) width, textureY + (float) height, 256, 256);
    }

    public static void drawTexturedRectColor(GuiGraphics guiGraphics, int left, int top, int textureX, int textureY, int width, int height, int color) {
        drawTexturedRectColor(guiGraphics, left, top, left + width, top + height, textureX, textureY, textureX + (float) width, textureY + (float) height, 256, 256, color);
    }

    public static void drawTexturedRect(GuiGraphics guiGraphics, int left, int top, int right, int bottom, float uvLeft, float uvTop, float uvRight, float uvBottom, int textureWidth, int textureHeight) {
        //RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.enableBlend();
        BufferBuilder builder = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        var matrix = guiGraphics.pose().last().pose();
        var z = 0;
        var uv_left = uvLeft / textureWidth;
        var uv_top = uvTop / textureHeight;
        var uv_right = uvRight / textureWidth;
        var uv_bottom = uvBottom / textureHeight;
        builder.addVertex(matrix, left, top, z).setUv(uv_left, uv_top);
        builder.addVertex(matrix, left, bottom, z).setUv(uv_left, uv_bottom);
        builder.addVertex(matrix, right, bottom, z).setUv(uv_right, uv_bottom);
        builder.addVertex(matrix, right, top, z).setUv(uv_right, uv_top);
        BufferUploader.drawWithShader(builder.buildOrThrow());
        RenderSystem.disableBlend();
    }

    public static void drawTexturedRectColor(GuiGraphics guiGraphics, int left, int top, int right, int bottom, float uvLeft, float uvTop, float uvRight, float uvBottom, int textureWidth, int textureHeight, int color) {
        //RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.enableBlend();
        BufferBuilder builder = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
        var matrix = guiGraphics.pose().last().pose();
        var uv_left = uvLeft / textureWidth;
        var uv_top = uvTop / textureHeight;
        var uv_right = uvRight / textureWidth;
        var uv_bottom = uvBottom / textureHeight;
        builder.addVertex(matrix, left, top, 0).setColor(color).setUv(uv_left, uv_top);
        builder.addVertex(matrix, left, bottom, 0).setColor(color).setUv(uv_left, uv_bottom);
        builder.addVertex(matrix, right, bottom, 0).setColor(color).setUv(uv_right, uv_bottom);
        builder.addVertex(matrix, right, top, 0).setColor(color).setUv(uv_right, uv_top);
        BufferUploader.drawWithShader(builder.buildOrThrow());
        RenderSystem.disableBlend();
    }

    public static void drawSolidColor(GuiGraphics guiGraphics, int left, int top, int right, int bottom, int color) {
        guiGraphics.fill(left, top, right, bottom, color);
    }

    public static void drawString(GuiGraphics guiGraphics, String string, int left, int top, int color) {
        drawString(guiGraphics, string, left, top, color, true);
    }

    public static void drawString(GuiGraphics guiGraphics, String string, int left, int top, int color, boolean shadow) {
        guiGraphics.drawString(Minecraft.getInstance().font, string, left, top, color, shadow);
    }

    public static void drawSolidGradient(PoseStack poseStack, int left, int top, int right, int bottom, int color) {
        //RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.enableBlend();
        BufferBuilder builder = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
        renderSolidGradient(builder, poseStack, left, top, right, bottom, color, 0);
        BufferUploader.drawWithShader(builder.buildOrThrow());
        RenderSystem.disableBlend();
    }

    public static void drawSolidGradientUpDown(PoseStack poseStack, int left, int top, int right, int bottom, int color) {
        //RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.enableBlend();
        BufferBuilder builder = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
        renderSolidGradientUpDown(builder, poseStack, left, top, right, bottom, color, 0);
        BufferUploader.drawWithShader(builder.buildOrThrow());
        RenderSystem.disableBlend();
    }

    public static void renderBound(VertexConsumer vertexConsumer, PoseStack poseStack, int left, int top, int right, int bottom, int width, int boundWidth, int colorFill, int colorEmpty, boolean vertex, float z) {
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
        vertexConsumer.addVertex(poseStack.last().pose(), left, top, z).setColor(color).setUv(0, 0).setUv2(0xff, 0xff);
        vertexConsumer.addVertex(poseStack.last().pose(), left, bottom, z).setColor(color).setUv(0, 0.125f).setUv2(0xff, 0xff);
        vertexConsumer.addVertex(poseStack.last().pose(), right, bottom, z).setColor(color).setUv(1, 0.125f).setUv2(0xff, 0xff);
        vertexConsumer.addVertex(poseStack.last().pose(), right, top, z).setColor(color).setUv(1, 0).setUv2(0xff, 0xff);
    }

    public static void renderSolidGradient(VertexConsumer vertexConsumer, PoseStack poseStack, int left, int top, int right, int bottom, int color, float z) {
        vertexConsumer.addVertex(poseStack.last().pose(), left, top, z).setColor(color).setUv(0, 0.625f).setUv2(0xff, 0xff);
        vertexConsumer.addVertex(poseStack.last().pose(), left, bottom, z).setColor(color).setUv(0, 1).setUv2(0xff, 0xff);
        vertexConsumer.addVertex(poseStack.last().pose(), right, bottom, z).setColor(color).setUv(1, 1).setUv2(0xff, 0xff);
        vertexConsumer.addVertex(poseStack.last().pose(), right, top, z).setColor(color).setUv(1, 0.625f).setUv2(0xff, 0xff);
    }

    public static void renderSolidGradientUpDown(VertexConsumer vertexConsumer, PoseStack poseStack, int left, int top, int right, int bottom, int color, float z) {
        vertexConsumer.addVertex(poseStack.last().pose(), left, top, z).setColor(color).setUv(0, 0).setUv2(0xff, 0xff);
        vertexConsumer.addVertex(poseStack.last().pose(), left, bottom, z).setColor(color).setUv(0, 0.375f).setUv2(0xff, 0xff);
        vertexConsumer.addVertex(poseStack.last().pose(), right, bottom, z).setColor(color).setUv(1, 0.375f).setUv2(0xff, 0xff);
        vertexConsumer.addVertex(poseStack.last().pose(), right, top, z).setColor(color).setUv(1, 0).setUv2(0xff, 0xff);
    }

    public static void renderString(PoseStack poseStack, MultiBufferSource buffer, String string, float left, float top, int color, boolean shadow) {
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
