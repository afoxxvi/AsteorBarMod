package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.overlay.parts.BaseOverlay;
import com.afoxxvi.asteorbar.overlay.parts.DehydrationOverlay;
import com.afoxxvi.asteorbar.overlay.parts.OriginsOverlay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;

import java.util.ArrayList;
import java.util.List;

public class FabricGuiRegistry {
    private static final List<BaseOverlay> REGISTRY = new ArrayList<>();

    static {
        register(Overlays.PLAYER_HEALTH);
        register(Overlays.FOOD_LEVEL);
        register(Overlays.MOUNT_HEALTH);
        register(new DehydrationOverlay());
        register(Overlays.AIR_LEVEL);
        register(Overlays.EXPERIENCE_BAR);
        register(Overlays.ARMOR_LEVEL);
        register(new OriginsOverlay());
    }

    public static void startRender(Gui instance, GuiGraphics guiGraphics) {
        var mc = Minecraft.getInstance();
        var tick = 0f;
        var width = mc.getWindow().getGuiScaledWidth();
        var height = mc.getWindow().getGuiScaledHeight();
        var gui = new FabricRenderGui(instance);
        REGISTRY.forEach(baseOverlay -> baseOverlay.render(gui, guiGraphics, tick, width, height));
        Overlays.STRING.render(gui, guiGraphics, tick, width, height);// This overlay must be rendered at last.
    }

    public static void register(BaseOverlay overlay) {
        REGISTRY.add(overlay);
    }
}
