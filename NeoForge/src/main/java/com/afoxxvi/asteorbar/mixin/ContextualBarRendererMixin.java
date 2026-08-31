package com.afoxxvi.asteorbar.mixin;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.contextualbar.ContextualBarRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ContextualBarRenderer.class)
interface ContextualBarRendererMixin {
    @Inject(method = "extractExperienceLevel", at = @At("HEAD"), cancellable = true)
    private static void extractExperienceLevel(GuiGraphicsExtractor guiGraphics, Font font, int i, CallbackInfo ci) {
        if (Overlays.style != Overlays.STYLE_NONE && AsteorBar.config.overwriteVanillaExperienceBar()) {
            ci.cancel();
        }
    }
}
