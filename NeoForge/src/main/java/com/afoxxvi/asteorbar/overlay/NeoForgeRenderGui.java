package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.overlay.parts.BaseOverlay;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.neoforge.client.gui.overlay.ExtendedGui;
import net.neoforged.neoforge.client.gui.overlay.IGuiOverlay;

public class NeoForgeRenderGui extends RenderGui implements IGuiOverlay {
    private ExtendedGui gui;
    private final BaseOverlay overlay;
    private final boolean survival;

    public NeoForgeRenderGui(BaseOverlay overlay) {
        this(overlay, true);
    }

    public NeoForgeRenderGui(BaseOverlay overlay, boolean survival) {
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
    public void render(ExtendedGui gui, GuiGraphics guiGraphics, float v, int i, int i1) {
        this.gui = gui;
        if (!this.gui.getMinecraft().options.hideGui && (!survival || this.gui.shouldDrawSurvivalElements())) {
            overlay.render(this, guiGraphics, v, i, i1);
        }
    }
}
