package com.afoxxvi.asteorbar.mixin;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.contextualbar.ExperienceBarRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ExperienceBarRenderer.class)
abstract class ExperienceBarRendererMixin {
    @Inject(method = "renderBackground", at = @At("HEAD"), cancellable = true)
    public void render(GuiGraphics guiGraphics, DeltaTracker deltaTracker, CallbackInfo ci) {
        if (Overlays.style != Overlays.STYLE_NONE && AsteorBar.config.overwriteVanillaExperienceBar()) {
            ci.cancel();
        }
    }
}
