package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.overlay.parts.BaseOverlay;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.Hud;
import net.neoforged.neoforge.client.gui.GuiLayer;

public class NeoForgeRenderGui extends RenderGui implements GuiLayer {
    private Hud hud;
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
        return hud.leftHeight;
    }

    @Override
    public int rightHeight() {
        return hud.rightHeight;
    }

    @Override
    public void leftHeight(int i) {
        hud.leftHeight += i;
    }

    @Override
    public void rightHeight(int i) {
        hud.rightHeight += i;
    }

    @Override
    public Hud gui() {
        return hud;
    }

    @Override
    public void render(GuiGraphicsExtractor guiGraphics, DeltaTracker deltaTracker) {
        final Minecraft mc = Minecraft.getInstance();
        this.hud = mc.gui.hud;
        if (!hud.isHidden() && (!survival || mc.gameMode.canHurtPlayer())) {
            overlay.render(this, guiGraphics, deltaTracker.getGameTimeDeltaPartialTick(true), guiGraphics.guiWidth(), guiGraphics.guiHeight());
        }
    }
}
