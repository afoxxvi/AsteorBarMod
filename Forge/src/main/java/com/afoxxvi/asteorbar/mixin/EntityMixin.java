package com.afoxxvi.asteorbar.mixin;

import com.afoxxvi.asteorbar.AsteorBar;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value = EntityRenderDispatcher.class, remap = false)
public abstract class EntityMixin {
    @Shadow
    public abstract <T extends Entity> EntityRenderer<? super T, ?> getRenderer(T entity);

    @Inject(method = "render(Lnet/minecraft/world/entity/Entity;DDDFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V",
            at = @At("TAIL"))
    private <E extends Entity> void render(E entity, double x, double y, double z, float p, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, CallbackInfo ci) {
        if (entity instanceof LivingEntity && AsteorBar.config.enableHealthBar()) {
            EntityRenderer<? super E, ?> renderer = getRenderer(entity);
            second(entity, x, y, z, p, poseStack, multiBufferSource, renderer);
        }
    }

    @Unique
    private <E extends Entity, S extends EntityRenderState> void second(E entity, double x, double y, double z, float p, PoseStack poseStack, MultiBufferSource multiBufferSource, EntityRenderer<? super E, S> renderer) {
        var state = renderer.createRenderState(entity, p);
        var vec3 = renderer.getRenderOffset(state);
        poseStack.pushPose();
        poseStack.translate(x + vec3.x(), y + vec3.y(), z + vec3.z());
        if (entity instanceof LivingEntity livingEntity) {
            com.afoxxvi.asteorbar.entity.EntityRenderer.render(livingEntity, poseStack, multiBufferSource);
        }
        poseStack.popPose();
    }
}
