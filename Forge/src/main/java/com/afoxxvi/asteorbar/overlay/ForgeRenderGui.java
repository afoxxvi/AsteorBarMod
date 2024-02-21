package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.overlay.parts.BaseOverlay;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ForgeRenderGui extends RenderGui implements IGuiOverlay {
    private ForgeGui gui;
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
        return gui.leftHeight;
    }

    @Override
    public int rightHeight() {
        return gui.rightHeight;
    }

    @Override
    public void leftHeight(int i) {
        gui.leftHeight += i;
    }

    @Override
    public void rightHeight(int i) {
        gui.rightHeight += i;
    }

    @Override
    public Gui gui() {
        return gui;
    }

    @Override
    public void render(ForgeGui forgeGui, PoseStack poseStack, float v, int i, int i1) {
        this.gui = forgeGui;
        if (!gui.getMinecraft().options.hideGui && (!survival || gui.shouldDrawSurvivalElements())) {
            forgeGui.setupOverlayRenderState(true, false);
            overlay.render(this, poseStack, v, i, i1);
        }
    }
}
