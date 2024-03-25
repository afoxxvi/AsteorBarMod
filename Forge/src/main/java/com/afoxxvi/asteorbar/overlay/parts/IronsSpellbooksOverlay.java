package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.utils.Utils;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import io.redspace.ironsspellbooks.config.ClientConfigs;
import io.redspace.ironsspellbooks.gui.overlays.ManaBarOverlay;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import io.redspace.ironsspellbooks.registries.AttributeRegistry;
import net.minecraft.world.entity.player.Player;

//technically not able to be compatible with the current version of the mod
public class IronsSpellbooksOverlay extends SimpleBarOverlay {
    @Override
    protected Parameters getParameters(Player player) {
        int maxMana = (int) player.getAttributeValue(AttributeRegistry.MAX_MANA.get());
        int mana = ClientMagicData.getPlayerMana();
        final Parameters parameters = new Parameters();
        parameters.fillColor = 0xff00b7ec;
        parameters.boundColor = 0xff003a4a;
        parameters.emptyColor = 0xff003949;
        parameters.value = mana;
        parameters.capacity = maxMana;
        return parameters;
    }

    @Override
    protected void drawDecorations(PoseStack poseStack, int left, int top, int right, int bottom, Parameters parameters, boolean flip) {
        super.drawDecorations(poseStack, left, top, right, bottom, parameters, flip);
        final var innerWidth = right - left - 2;
        int textureWidth = Math.min(179, Math.max(0, (innerWidth + 5) / 10 - 1) * 10 + 9);
        RenderSystem.setShaderTexture(0, TEXTURE);
        drawTextureFillColor(poseStack, left + 1, top, innerWidth, 5, 10, Y_EXPERIENCE_DECORATION, textureWidth, 5, parameters.fillColor);
        RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        if (ClientConfigs.MANA_BAR_TEXT_VISIBLE.get()) {
            Overlays.addStringRender((left + right) / 2, top - 2, 0x55FFFF, Utils.formatNumber(parameters.value) + "/" + Utils.formatNumber(parameters.capacity), Overlays.ALIGN_CENTER, true);
        }
    }

    @Override
    protected boolean shouldRender(Player player) {
        return Overlays.ironsSpellbooks && AsteorBar.config.hookIronsSpellbooks() && ManaBarOverlay.shouldShowManaBar(player);
    }
}
