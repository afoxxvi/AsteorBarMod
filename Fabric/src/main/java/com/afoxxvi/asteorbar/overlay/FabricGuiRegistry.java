package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.overlay.parts.BaseOverlay;
import com.afoxxvi.asteorbar.overlay.parts.DehydrationOverlay;
import com.afoxxvi.asteorbar.overlay.parts.OriginsOverlay;
import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.parts.ToughAsNailsOverlay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;

public class FabricGuiRegistry {
    private FabricGuiRegistry() {
    }

    static {
        if (AsteorBar.compatibility.toughAsNails) {
            Overlays.registerOverlayAtRecommended(new ToughAsNailsOverlay(), Overlays.Position.UNSPECIFIED);
        }
        Overlays.registerOverlayAtRecommended(new ToughAsNailsOverlay(), Overlays.Position.UNSPECIFIED);
        REGISTRY.add(Overlays.PLAYER_HEALTH);
        REGISTRY.add(Overlays.FOOD_LEVEL);
        REGISTRY.add(Overlays.MOUNT_HEALTH);
        REGISTRY.add(new DehydrationOverlay());
        REGISTRY.add(Overlays.AIR_LEVEL);
        REGISTRY.add(Overlays.EXPERIENCE_BAR);
        REGISTRY.add(Overlays.ARMOR_LEVEL);
        REGISTRY.add(new OriginsOverlay());
        REGISTRY.add(Overlays.STRING);

    }

    public static void startRender(Gui instance, GuiGraphics guiGraphics) {
        var mc = Minecraft.getInstance();
        var tick = 0f;
        var width = mc.getWindow().getGuiScaledWidth();
        var height = mc.getWindow().getGuiScaledHeight();
        var gui = new FabricRenderGui(instance);
        Overlays.MAIN.renderOverlay(gui, guiGraphics, tick, width, height);
    }
}
