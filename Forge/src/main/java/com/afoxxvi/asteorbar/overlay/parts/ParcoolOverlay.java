package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.utils.Utils;
import com.alrex.parcool.common.capability.IStamina;
import com.alrex.parcool.common.capability.Parkourability;
import com.alrex.parcool.config.ParCoolConfig;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;

public class ParcoolOverlay extends SimpleBarOverlay {
    @Override
    protected Parameters getParameters(Player player) {
        IStamina iStamina = IStamina.get(player);
        Parkourability parkourability = Parkourability.get(player);
        if (iStamina == null || parkourability == null) return null;
        if (!ParCoolConfig.Client.Booleans.HideStaminaHUDWhenStaminaIsInfinite.get() || !parkourability.getActionInfo().isStaminaInfinite(player.isCreative() || player.isSpectator())) {
            final Parameters parameters = new Parameters();
            if (iStamina.isExhausted()) {
                parameters.fillColor = 0xffff5454;
                parameters.boundColor = 0xff600000;
                parameters.emptyColor = 0xff200000;
            } else {
                parameters.fillColor = 0xffffff1c;
                parameters.boundColor = 0xff606000;
                parameters.emptyColor = 0xff202000;
            }
            parameters.value = iStamina.get();
            parameters.capacity = iStamina.getActualMaxStamina();
            return parameters;
        }
        return null;
    }

    @Override
    protected void drawDecorations(GuiGraphics guiGraphics, int left, int top, int right, int bottom, Parameters parameters, boolean flip) {
        super.drawDecorations(guiGraphics, left, top, right, bottom, parameters, flip);
        final var innerWidth = right - left - 2;
        final var fillWidth = (int) (innerWidth * parameters.value / parameters.capacity);
        final var color = Utils.mixColor(0xFFFFFFFF, parameters.fillColor, 0.5);
        RenderSystem.setShaderTexture(0, TEXTURE);
        if (flip) {
            drawTextureFillColor(guiGraphics, right - 1 - fillWidth, top, fillWidth, 5,
                    10 + 180 - fillWidth, Y_RIGHT_DECORATION, fillWidth, 5, color);
        } else {
            drawTextureFillColor(guiGraphics, left + 1, top, fillWidth, 5,
                    10, Y_LEFT_DECORATION, fillWidth, 5, color);
        }
        RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
    }

    @Override
    protected boolean shouldRender(Player player) {
        return Overlays.parcool && AsteorBar.config.hookParcool();
    }
}
