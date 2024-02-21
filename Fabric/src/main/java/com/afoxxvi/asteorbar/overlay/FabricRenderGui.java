package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.overlay.parts.ToughAsNailsOverlay;
import net.minecraft.client.gui.Gui;

public class FabricRenderGui extends RenderGui {
    private final Gui gui;

    public static final ToughAsNailsOverlay TOUGH_AS_NAILS = new ToughAsNailsOverlay();

    public FabricRenderGui(Gui gui) {
        this.gui = gui;
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
    public Gui gui() {
        return gui;
    }
}
