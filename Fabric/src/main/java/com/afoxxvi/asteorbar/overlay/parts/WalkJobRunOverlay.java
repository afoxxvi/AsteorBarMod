package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.utils.GuiHelper;
import com.minenash.walk_jog_run.WalkJogRunClient;
import com.minenash.walk_jog_run.config.ClientConfig;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;

public class WalkJobRunOverlay implements SimpleBarOverlay.Layer {
    private static void disableTheirOverlay() {
        if (ClientConfig.showStaminaInHungerBar) {
            ClientConfig.showStaminaInHungerBar = false;
        }
    }

    @Override
    public void drawLayer(Player player, GuiGraphics guiGraphics, int left, int top, int right, int bottom, SimpleBarOverlay.Parameters parameters, boolean flip) {
        disableTheirOverlay();
        // I don't know what this magic value is, just copied from the original code
        final double stamina = WalkJogRunClient.stamina / 8.888;
        final double full = 90;
        final double percent = 1.0 - Math.min(Math.max(0, stamina / full), 1);
        final int innerWidth = right - left - 2;
        final int width = (int) (innerWidth * percent);
        final int color = 0xC07F7F7F;
        final int height = Math.max(1, (bottom - top - 2) / 3);
        if (flip) {
            GuiHelper.drawSolidColor(guiGraphics, right - 1 - width, top + 1, right - 1, top + 1 + height, color);
            GuiHelper.drawSolidColor(guiGraphics, right - 1 - width, bottom - 1 - height, right - 1, bottom - 1, color);
        } else {
            GuiHelper.drawSolidColor(guiGraphics, left + 1, top + 1, left + 1 + width, top + 1 + height, color);
            GuiHelper.drawSolidColor(guiGraphics, left + 1, bottom - 1 - height, left + 1 + width, bottom - 1, color);
        }
    }
}
