package com.afoxxvi.asteorbar.mixin;

import com.afoxxvi.asteorbar.overlay.FabricRenderGui;
import com.afoxxvi.asteorbar.overlay.Overlays;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Gui.class)
public abstract class GuiMixin {
    @Invoker("renderPlayerHealth")
    public abstract void renderPlayerHealthRaw(GuiGraphics guiGraphics);

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;renderPlayerHealth(Lnet/minecraft/client/gui/GuiGraphics;)V"), method = "render")
    public void renderPlayerHealth(Gui instance, GuiGraphics guiGraphics) {
        if (Overlays.style == Overlays.STYLE_NONE) {
            renderPlayerHealthRaw(guiGraphics);
            return;
        }
        Overlays.reset();
        var mc = Minecraft.getInstance();
        var tick = 0f;
        var width = mc.getWindow().getGuiScaledWidth();
        var height = mc.getWindow().getGuiScaledHeight();
        var gui = new FabricRenderGui(instance);
        Overlays.PLAYER_HEALTH.render(gui, guiGraphics, tick, width, height);
        Overlays.FOOD_LEVEL.render(gui, guiGraphics, tick, width, height);
        Overlays.MOUNT_HEALTH.render(gui, guiGraphics, tick, width, height);
        FabricRenderGui.DEHYDRATION.render(gui, guiGraphics, tick, width, height);
        Overlays.AIR_LEVEL.render(gui, guiGraphics, tick, width, height);
        Overlays.EXPERIENCE_BAR.render(gui, guiGraphics, tick, width, height);
        Overlays.ARMOR_LEVEL.render(gui, guiGraphics, tick, width, height);
        Overlays.STRING.render(gui, guiGraphics, tick, width, height);
    }

    @Invoker("renderVehicleHealth")
    public abstract void renderVehicleHealthRaw(GuiGraphics guiGraphics);

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;renderVehicleHealth(Lnet/minecraft/client/gui/GuiGraphics;)V"), method = "render")
    public void renderVehicleHealth(Gui instance, GuiGraphics guiGraphics) {
        if (Overlays.style == Overlays.STYLE_NONE) {
            renderVehicleHealthRaw(guiGraphics);
        }
    }


    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;renderExperienceBar(Lnet/minecraft/client/gui/GuiGraphics;I)V"), method = "render")
    public void renderExperienceBar(Gui instance, GuiGraphics guiGraphics, int i) {
        if (Overlays.style == Overlays.STYLE_NONE) {
            instance.renderExperienceBar(guiGraphics, i);
        }
    }
}

