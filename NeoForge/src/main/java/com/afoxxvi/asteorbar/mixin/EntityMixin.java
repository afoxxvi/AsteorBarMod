package com.afoxxvi.asteorbar.mixin;

import com.afoxxvi.asteorbar.render.IHealthBarFeature;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.state.CameraRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public abstract class EntityMixin {
    @Shadow
    public abstract <S extends EntityRenderState> EntityRenderer<?, ? super S> getRenderer(S entityRenderState);

    @Inject(method = "submit(Lnet/minecraft/client/renderer/entity/state/EntityRenderState;Lnet/minecraft/client/renderer/state/CameraRenderState;DDDLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;)V",
            at = @At("TAIL"))
    private <S extends EntityRenderState> void submit(S entityRenderState, CameraRenderState cameraRenderState, double x, double y, double z, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CallbackInfo ci) {
        if (!(entityRenderState instanceof IHealthBarFeature feat) || feat.asteorBar$getMaxHealth() <= 0 || !(entityRenderState instanceof LivingEntityRenderState)) {
            return;
        }
        var entityRenderer = getRenderer(entityRenderState);
        var vec3 = entityRenderer.getRenderOffset(entityRenderState);
        poseStack.pushPose();
        poseStack.translate(x + vec3.x(), y + vec3.y(), z + vec3.z());
        com.afoxxvi.asteorbar.entity.EntityRenderer.submit(feat, (LivingEntityRenderState) entityRenderState, poseStack, submitNodeCollector);
        poseStack.popPose();
    }
}
