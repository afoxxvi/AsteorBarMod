package com.afoxxvi.asteorbar.mixin.thrid;

import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import toughasnails.temperature.TemperatureOverlayRenderer;

@Mixin(value = TemperatureOverlayRenderer.class, remap = false)
public interface ToughAsNailsTemperatureMixin {
    @Invoker("renderTemperature")
    static void invokeRenderTemperature(GuiGraphics guiGraphics, float partialTicks, int width, int height) {
        throw new AssertionError();
    }
}
