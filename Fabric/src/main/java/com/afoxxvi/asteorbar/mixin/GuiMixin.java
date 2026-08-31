package com.afoxxvi.asteorbar.mixin;

import com.afoxxvi.asteorbar.overlay.FabricGuiRegistry;
import com.afoxxvi.asteorbar.overlay.Overlays;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public abstract class GuiMixin {
    @Invoker("extractPlayerHealth")
    public abstract void extractPlayerHealthRaw(GuiGraphicsExtractor guiGraphics);

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;extractPlayerHealth(Lnet/minecraft/client/gui/GuiGraphicsExtractor;)V"), method = "extractHotbarAndDecorations")
    public void extractPlayerHealth(Gui instance, GuiGraphicsExtractor guiGraphics) {
        Overlays.reset();
        if (Overlays.style == Overlays.STYLE_NONE) {
            extractPlayerHealthRaw(guiGraphics);
            return;
        }
        FabricGuiRegistry.startRender(instance, guiGraphics);
    }

    @Inject(method = "extractVehicleHealth", at = @At("HEAD"), cancellable = true)
    public void extractVehicleHealth(GuiGraphicsExtractor guiGraphics, CallbackInfo ci) {
        if (Overlays.style != Overlays.STYLE_NONE) {
            ci.cancel();
        }
    }
}

