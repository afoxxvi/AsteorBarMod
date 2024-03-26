package com.afoxxvi.asteorbar.entity;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.mixin.RenderTypeMixin;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class AsteorBarRenderType extends RenderStateShard {
    //If no texture, the bar is not rendered while using shader packs
    private static final ResourceLocation LIGHTMAP_TEXTURE = new ResourceLocation(AsteorBar.MOD_ID, "textures/ui/lightmap.png");
    public static final RenderType RENDER_TYPE = RenderTypeMixin.create(
            "asteorbar_health_bar",
            DefaultVertexFormat.POSITION_COLOR_TEX,
            VertexFormat.Mode.QUADS,
            131072,
            false,
            false,
            RenderType.CompositeState.builder()
                    .setShaderState(RenderStateShard.POSITION_COLOR_TEX_SHADER)
                    .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                    .setTextureState(new TextureStateShard(LIGHTMAP_TEXTURE, false, false))
                    .createCompositeState(false));

    public AsteorBarRenderType(String p_110161_, Runnable p_110162_, Runnable p_110163_) {
        super(p_110161_, p_110162_, p_110163_);
    }
}
