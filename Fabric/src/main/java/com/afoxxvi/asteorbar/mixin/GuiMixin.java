package com.afoxxvi.asteorbar.mixin;

import com.afoxxvi.asteorbar.overlay.FabricGuiRegistry;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Gui.class)
public abstract class GuiMixin {
    @Invoker("renderPlayerHealth")
    public abstract void renderPlayerHealthRaw(PoseStack poseStack);

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;renderPlayerHealth(Lcom/mojang/blaze3d/vertex/PoseStack;)V"), method = "render")
    public void renderPlayerHealth(Gui instance, PoseStack poseStack) {
        Overlays.reset();
        if (Overlays.style == Overlays.STYLE_NONE) {
            renderPlayerHealthRaw(poseStack);
            return;
        }
        FabricGuiRegistry.startRender(instance, poseStack);
    }

    @Invoker("renderVehicleHealth")
    public abstract void renderVehicleHealthRaw(PoseStack poseStack);

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;renderVehicleHealth(Lcom/mojang/blaze3d/vertex/PoseStack;)V"), method = "render")
    public void renderVehicleHealth(Gui instance, PoseStack poseStack) {
        if (Overlays.style == Overlays.STYLE_NONE) {
            renderVehicleHealthRaw(poseStack);
        }
    }


    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;renderExperienceBar(Lcom/mojang/blaze3d/vertex/PoseStack;I)V"), method = "render")
    public void renderExperienceBar(Gui instance, PoseStack poseStack, int i) {
        if (Overlays.style == Overlays.STYLE_NONE) {
            instance.renderExperienceBar(poseStack, i);
        }
    }
}

