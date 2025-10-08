package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.overlay.parts.BaseOverlay;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;

public class NeoForgeRenderGui extends RenderGui implements LayeredDraw.Layer {
    private Gui gui;
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
    public void render(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
        final Minecraft mc = Minecraft.getInstance();
        this.gui = mc.gui;
        if (!mc.options.hideGui && (!survival || mc.gameMode.canHurtPlayer())) {
            overlay.render(this, guiGraphics, deltaTracker.getGameTimeDeltaPartialTick(true), guiGraphics.guiWidth(), guiGraphics.guiHeight());
        }
    }
}
