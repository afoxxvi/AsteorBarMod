package com.afoxxvi.asteorbar.mixin;

import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

//crash when declaring as an abstract class, don't know why
@Mixin(RenderType.class)
public interface RenderTypeMixin {
    @Invoker("create")
    static RenderType.CompositeRenderType create(String name, VertexFormat format, VertexFormat.Mode mode, int bufSize, boolean affectsCrumbling, boolean sortOnUpload, RenderType.CompositeState glState) {
        throw new IllegalStateException("");
    }
}
