package com.afoxxvi.asteorbar.mixin;

import com.afoxxvi.asteorbar.render.IHealthBarFeature;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(InventoryScreen.class)
public abstract class InventoryScreenMixin {
    @Inject(method = "extractRenderState", at = @At("TAIL"))
    private static void extractRenderStateExtra(LivingEntity livingEntity, CallbackInfoReturnable<EntityRenderState> cir) {
        final var renderState = cir.getReturnValue();
        if (renderState instanceof IHealthBarFeature healthBarFeature) {
            healthBarFeature.asteorBar$setInInventory(true);
        }
    }
}
