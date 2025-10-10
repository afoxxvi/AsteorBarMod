package com.afoxxvi.asteorbar.mixin;

import com.afoxxvi.asteorbar.entity.EntityRenderer;
import com.afoxxvi.asteorbar.render.IHealthBarFeature;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin<T extends LivingEntity, S extends LivingEntityRenderState, M extends EntityModel<? super S>> {
    @Inject(
            method = "extractRenderState(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;F)V",
            at = @At("TAIL")
    )
    public void extract(T livingEntity, S livingEntityRenderState, float f, CallbackInfo ci) {
        if (!EntityRenderer.shouldRender(livingEntity, Minecraft.getInstance().player)) {
            return;
        }
        if (livingEntityRenderState instanceof IHealthBarFeature healthBarFeature) {
            healthBarFeature.asteorBar$setHealth(livingEntity.getHealth());
            healthBarFeature.asteorBar$setMaxHealth(livingEntity.getMaxHealth());
            healthBarFeature.asteorBar$setAbsorptionAmount(livingEntity.getAbsorptionAmount());
        }
    }
}
