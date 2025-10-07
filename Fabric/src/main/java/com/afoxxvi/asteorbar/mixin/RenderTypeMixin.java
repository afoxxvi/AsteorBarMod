package com.afoxxvi.asteorbar.mixin;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import net.minecraft.client.renderer.RenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

//crash when declaring as an abstract class, don't know why
@Mixin(RenderType.class)
public interface RenderTypeMixin {
    @Invoker("create")
    static RenderType.CompositeRenderType create(String string, int i, boolean bl, boolean bl2, RenderPipeline renderPipeline, RenderType.CompositeState compositeState) {
        throw new IllegalStateException("");
    }
}
