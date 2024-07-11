package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;

public class ExperienceBarOverlay extends SimpleBarOverlay {
    int level;
    int need;
    int has;

    @Override
    protected Parameters getParameters(Player player) {
        level = player.experienceLevel;
        need = player.getXpNeededForNextLevel();
        has = (int) (player.experienceProgress * player.getXpNeededForNextLevel());
        Parameters parameters = new Parameters();
        parameters.fillColor = AsteorBar.config.experienceColor();
        parameters.boundColor = AsteorBar.config.experienceBoundColor();
        parameters.emptyColor = AsteorBar.config.experienceEmptyColor();
        parameters.value = player.experienceProgress;
        return parameters;
    }

    @Override
    protected void drawDecorations(GuiGraphics guiGraphics, int left, int top, int right, int bottom, Parameters parameters, boolean flip) {
        super.drawDecorations(guiGraphics, left, top, right, bottom, parameters, flip);
        int innerWidth = right - left - 2;
        int textureWidth = Math.min(179, Math.max(0, (innerWidth + 5) / 10 - 1) * 10 + 9);
        RenderSystem.setShaderTexture(0, TEXTURE);
        drawTextureFillColor(guiGraphics, left + 1, top, innerWidth, 5, 10, Y_EXPERIENCE_DECORATION, textureWidth, 5, AsteorBar.config.experienceColor());
        RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        if (AsteorBar.config.displayExperienceLevel()) {
            int x = (right + left) / 2;
            int y = top - 2;
            Overlays.addStringRender(x, y, 0x80FF20, String.valueOf(level), Overlays.ALIGN_CENTER, false, true, 0);
        }
        if (AsteorBar.config.displayExperienceProgress()) {
            int x, y;
            int len = (right - left) / 2;
            x = left + len;
            y = top - 2;
            boolean inside = len < 180;
            if (x >= 0 && y >= 0) {
                if (inside) {
                    Overlays.addStringRender(x - len + 2, y, 0xFFFFFF, String.valueOf(has), Overlays.ALIGN_LEFT, true);
                    Overlays.addStringRender(x + len - 2, y, 0xFFFFFF, String.valueOf(need), Overlays.ALIGN_RIGHT, true);
                } else {
                    Overlays.addStringRender(x - len, y, 0xFFFFFF, String.valueOf(has), Overlays.ALIGN_RIGHT, true);
                    Overlays.addStringRender(x + len, y, 0xFFFFFF, String.valueOf(need), Overlays.ALIGN_LEFT, true);
                }
            }
        }
    }

    @Override
    protected boolean shouldRender(Player player) {
        return true;
    }
}
