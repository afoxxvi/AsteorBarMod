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
        drawTexturedRect(guiGraphics, left, top, left + width, top + height, textureX, textureY, textureX + width, textureY + height, 256, 256);
    }

    public static void drawTexturedRectColor(GuiGraphics guiGraphics, int left, int top, int textureX, int textureY, int width, int height, int color) {
        drawTexturedRectColor(guiGraphics, left, top, left + width, top + height, textureX, textureY, textureX + width, textureY + height, 256, 256, color);
    }

    public static void drawTexturedRect(GuiGraphics guiGraphics, int left, int top, int right, int bottom, float uvLeft, float uvTop, float uvRight, float uvBottom, int textureWidth, int textureHeight) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.enableBlend();
        BufferBuilder builder = Tesselator.getInstance().getBuilder();
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        var matrix = guiGraphics.pose().last().pose();
        var z = 0;
        var uv_left = uvLeft / textureWidth;
        var uv_top = uvTop / textureHeight;
        var uv_right = uvRight / textureWidth;
        var uv_bottom = uvBottom / textureHeight;
        builder.vertex(matrix, (float) left, (float) top, (float) z).uv(uv_left, uv_top).endVertex();
        builder.vertex(matrix, (float) left, (float) bottom, (float) z).uv(uv_left, uv_bottom).endVertex();
        builder.vertex(matrix, (float) right, (float) bottom, (float) z).uv(uv_right, uv_bottom).endVertex();
        builder.vertex(matrix, (float) right, (float) top, (float) z).uv(uv_right, uv_top).endVertex();
        BufferUploader.drawWithShader(builder.end());
        RenderSystem.disableBlend();
    }

    public static void drawTexturedRectColor(GuiGraphics guiGraphics, int left, int top, int right, int bottom, float uvLeft, float uvTop, float uvRight, float uvBottom, int textureWidth, int textureHeight, int color) {
        RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
        RenderSystem.enableBlend();
        BufferBuilder builder = Tesselator.getInstance().getBuilder();
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR_TEX);
        var matrix = guiGraphics.pose().last().pose();
        var uv_left = uvLeft / textureWidth;
        var uv_top = uvTop / textureHeight;
        var uv_right = uvRight / textureWidth;
        var uv_bottom = uvBottom / textureHeight;
        builder.vertex(matrix, (float) left, (float) top, (float) 0).color(color).uv(uv_left, uv_top).endVertex();
        builder.vertex(matrix, (float) left, (float) bottom, (float) 0).color(color).uv(uv_left, uv_bottom).endVertex();
        builder.vertex(matrix, (float) right, (float) bottom, (float) 0).color(color).uv(uv_right, uv_bottom).endVertex();
        builder.vertex(matrix, (float) right, (float) top, (float) 0).color(color).uv(uv_right, uv_top).endVertex();
        BufferUploader.drawWithShader(builder.end());
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
        RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
        RenderSystem.enableBlend();
        BufferBuilder builder = Tesselator.getInstance().getBuilder();
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR_TEX);
        renderSolidGradient(builder, poseStack, left, top, right, bottom, color, 0);
        BufferUploader.drawWithShader(builder.end());
        RenderSystem.disableBlend();
    }

    public static void drawSolidGradientUpDown(PoseStack poseStack, int left, int top, int right, int bottom, int color) {
        RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
        RenderSystem.enableBlend();
        BufferBuilder builder = Tesselator.getInstance().getBuilder();
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR_TEX);
        renderSolidGradientUpDown(builder, poseStack, left, top, right, bottom, color, 0);
        BufferUploader.drawWithShader(builder.end());
        RenderSystem.disableBlend();
    }

    //left < right, top < bottom
    public static void renderSolid(VertexConsumer vertexConsumer, PoseStack poseStack, int left, int top, int right, int bottom, int color, float z) {
        vertexConsumer.vertex(poseStack.last().pose(), left, top, z).color(color).uv(0, 0).endVertex();
        vertexConsumer.vertex(poseStack.last().pose(), left, bottom, z).color(color).uv(0, 0.125f).endVertex();
        vertexConsumer.vertex(poseStack.last().pose(), right, bottom, z).color(color).uv(1, 0.125f).endVertex();
        vertexConsumer.vertex(poseStack.last().pose(), right, top, z).color(color).uv(1, 0).endVertex();
    }

    public static void renderSolidGradient(VertexConsumer vertexConsumer, PoseStack poseStack, int left, int top, int right, int bottom, int color, float z) {
        vertexConsumer.vertex(poseStack.last().pose(), left, top, z).color(color).uv(0, 0.625f).endVertex();
        vertexConsumer.vertex(poseStack.last().pose(), left, bottom, z).color(color).uv(0, 1).endVertex();
        vertexConsumer.vertex(poseStack.last().pose(), right, bottom, z).color(color).uv(1, 1).endVertex();
        vertexConsumer.vertex(poseStack.last().pose(), right, top, z).color(color).uv(1, 0.625f).endVertex();
    }

    public static void renderSolidGradientUpDown(VertexConsumer vertexConsumer, PoseStack poseStack, int left, int top, int right, int bottom, int color, float z) {
        vertexConsumer.vertex(poseStack.last().pose(), left, top, z).color(color).uv(0, 0).endVertex();
        vertexConsumer.vertex(poseStack.last().pose(), left, bottom, z).color(color).uv(0, 0.375f).endVertex();
        vertexConsumer.vertex(poseStack.last().pose(), right, bottom, z).color(color).uv(1, 0.375f).endVertex();
        vertexConsumer.vertex(poseStack.last().pose(), right, top, z).color(color).uv(1, 0).endVertex();
    }

    public static void renderString(PoseStack poseStack, MultiBufferSource buffer, String string, float left, float top, int color, boolean shadow) {
        Minecraft.getInstance().font.drawInBatch(string, left, top, color, shadow, poseStack.last().pose(), buffer,
                Font.DisplayMode.NORMAL, 0, 0xF000F0);
    }

    public static void renderString(PoseStack poseStack, MultiBufferSource buffer, String string, int left, int top, int color) {
        renderString(poseStack, buffer, string, (float) left, (float) top, color, false);
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
