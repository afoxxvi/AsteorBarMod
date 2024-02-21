package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.overlay.parts.BaseOverlay;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.IIngameOverlay;

public class ForgeRenderGui extends RenderGui implements IIngameOverlay {
    private ForgeIngameGui gui;
    private final BaseOverlay overlay;
    private final boolean survival;

    public ForgeRenderGui(BaseOverlay overlay) {
        this(overlay, true);
    }

    public ForgeRenderGui(BaseOverlay overlay, boolean survival) {
        this.overlay = overlay;
        this.survival = survival;
    }

    @Override
    public int leftHeight() {
        return gui.left_height;
    }

    @Override
    public int rightHeight() {
        return gui.right_height;
    }

    @Override
    public void leftHeight(int i) {
        gui.left_height += i;
    }

    @Override
    public void rightHeight(int i) {
        gui.right_height += i;
    }

    @Override
    public Gui gui() {
        return gui;
    }

    @Override
    public void render(ForgeIngameGui forgeGui, PoseStack poseStack, float v, int i, int i1) {
        this.gui = forgeGui;
        if (!Minecraft.getInstance().options.hideGui && (!survival || gui.shouldDrawSurvivalElements())) {
            forgeGui.setupOverlayRenderState(true, false);
            overlay.render(this, poseStack, v, i, i1);
        }
    }
}
