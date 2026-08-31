package com.afoxxvi.asteorbar.overlay;

import net.minecraft.client.gui.Hud;

public class ForgeRenderGui extends RenderGui {
    private final Hud hud;

    public ForgeRenderGui(Hud hud) {
        this.hud = hud;
    }

    @Override
    public int leftHeight() {
        return Overlays.leftHeight;
    }

    @Override
    public int rightHeight() {
        return Overlays.rightHeight;
    }

    @Override
    public void leftHeight(int i) {
        Overlays.leftHeight += i;
    }

    @Override
    public void rightHeight(int i) {
        Overlays.rightHeight += i;
    }

    @Override
    public Hud gui() {
        return hud;
    }
}
