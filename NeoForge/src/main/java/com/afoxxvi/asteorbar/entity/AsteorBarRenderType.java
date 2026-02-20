package com.afoxxvi.asteorbar.entity;

import com.afoxxvi.asteorbar.AsteorBar;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.rendertype.RenderSetup;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.resources.Identifier;

public class AsteorBarRenderType {
    //If no texture, the bar is not rendered while using shader packs
    private static final Identifier LIGHTMAP_TEXTURE = Identifier.fromNamespaceAndPath(AsteorBar.MOD_ID, "textures/ui/lightmap.png");
    public static final RenderType RENDER_TYPE = RenderType.create(
            "asteorbar_health_bar",
            RenderSetup.builder(RenderPipelines.ENTITY_TRANSLUCENT)
                    .withTexture("Sampler0", LIGHTMAP_TEXTURE)
                    .useOverlay()
                    .useLightmap()
                    .affectsCrumbling()
                    .sortOnUpload()
                    .createRenderSetup()
    );
}
