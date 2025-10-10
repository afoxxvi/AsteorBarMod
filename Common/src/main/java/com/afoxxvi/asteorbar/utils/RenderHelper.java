package com.afoxxvi.asteorbar.utils;

import com.afoxxvi.asteorbar.AsteorBar;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;

public class RenderHelper {
    public static void submitString(SubmitNodeCollector submitNodeCollector, PoseStack poseStack, String string, float left, float top, int color, boolean shadow) {
        //color = applyAlpha(color);
        submitNodeCollector.submitText(poseStack, left, top, FormattedCharSequence.forward(string, Style.EMPTY), shadow, Font.DisplayMode.NORMAL, 0xF000F0, color, 0, 0);
    }

    public static void submitString(SubmitNodeCollector submitNodeCollector, PoseStack poseStack, String string, int left, int top, int color) {
        submitString(submitNodeCollector, poseStack, string, left, top, color, false);
    }

    public static void submitCenteredString(SubmitNodeCollector submitNodeCollector, PoseStack poseStack, String string, int left, int top, int color) {
        submitString(submitNodeCollector, poseStack, string, left - Minecraft.getInstance().font.width(string) / 2.0f, top, color, false);
    }

    public static void submitStringShadow(SubmitNodeCollector submitNodeCollector, PoseStack poseStack, String string, int left, int top, int color) {
        submitString(submitNodeCollector, poseStack, string, left, top, color, true);
    }

    public static void submitCenteredStringShadow(SubmitNodeCollector submitNodeCollector, PoseStack poseStack, String string, int left, int top, int color) {
        submitString(submitNodeCollector, poseStack, string, left - Minecraft.getInstance().font.width(string) / 2.0f, top, color, true);
    }

    public static void submitSolid(SubmitNodeCollector submitNodeCollector, PoseStack poseStack, int left, int top, int right, int bottom, int color, float z) {
        submitNodeCollector.submitCustomGeometry(poseStack, AsteorBar.platformAdapter.getRenderType(), (pose, vertexConsumer) ->
                GuiHelper.renderSolid(vertexConsumer, pose.pose(), left, top, right, bottom, color, z));
    }

    public static void submitSolidGradient(SubmitNodeCollector submitNodeCollector, PoseStack poseStack, int left, int top, int right, int bottom, int color, float z) {
        submitNodeCollector.submitCustomGeometry(poseStack, AsteorBar.platformAdapter.getRenderType(), (pose, vertexConsumer) ->
                GuiHelper.renderSolidGradient(vertexConsumer, pose.pose(), left, top, right, bottom, color, z));
    }

    public static void submitSolidGradientUpDown(SubmitNodeCollector submitNodeCollector, PoseStack poseStack, int left, int top, int right, int bottom, int color, float z) {
        submitNodeCollector.submitCustomGeometry(poseStack, AsteorBar.platformAdapter.getRenderType(), (pose, vertexConsumer) ->
                GuiHelper.renderSolidGradientUpDown(vertexConsumer, pose.pose(), left, top, right, bottom, color, z));
    }

    public static void submitBound(SubmitNodeCollector submitNodeCollector, PoseStack poseStack, int left, int top, int right, int bottom, int width, int boundWidth, int colorFill, int colorEmpty, boolean vertex, float z) {
        //colorFill = applyAlpha(colorFill);
        //colorEmpty = applyAlpha(colorEmpty);
        int cut = 0;
        int expand = vertex ? boundWidth : 0;
        if (width > 0) {//left bound, vertex included
            int part = Math.min(width, boundWidth);
            cut += part;
            submitSolid(submitNodeCollector, poseStack, left - boundWidth, top - expand, left - boundWidth + part, bottom + expand, colorFill, z);
            if (part < boundWidth) {
                submitSolid(submitNodeCollector, poseStack, left - boundWidth + part, top - expand, left, bottom + expand, colorEmpty, z);
            }
        } else {
            submitSolid(submitNodeCollector, poseStack, left - boundWidth, top - expand, left, bottom + expand, colorEmpty, z);
        }
        if (width > right - left + boundWidth) {//right bound, vertex included
            int part = Math.min(width, boundWidth);
            cut += part;
            submitSolid(submitNodeCollector, poseStack, right, top - expand, right + part, bottom + expand, colorFill, z);
            if (part < boundWidth) {
                submitSolid(submitNodeCollector, poseStack, right + part, top - expand, right + boundWidth, bottom + expand, colorEmpty, z);
            }
        } else {
            submitSolid(submitNodeCollector, poseStack, right, top - expand, right + boundWidth, bottom + expand, colorEmpty, z);
        }
        width -= cut;
        if (width > 0) {//upper and lower bound, vertex excluded
            submitSolid(submitNodeCollector, poseStack, left, top - boundWidth, left + width, top, colorFill, z);
            submitSolid(submitNodeCollector, poseStack, left, bottom, left + width, bottom + boundWidth, colorFill, z);
        }
        if (width < right - left) {
            submitSolid(submitNodeCollector, poseStack, left + width, top - boundWidth, right, top, colorEmpty, z);
            submitSolid(submitNodeCollector, poseStack, left + width, bottom, right, bottom + boundWidth, colorEmpty, z);
        }
    }
}
