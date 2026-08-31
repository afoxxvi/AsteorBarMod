package com.afoxxvi.asteorbar.entity;

import com.afoxxvi.asteorbar.AsteorBar;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

public class AsteorBarRenderType {
    //If no texture, the bar is not rendered while using shader packs
    private static final Identifier LIGHTMAP_TEXTURE = Identifier.fromNamespaceAndPath(AsteorBar.MOD_ID, "textures/ui/lightmap.png");
    public static final RenderType RENDER_TYPE = RenderTypes.entityTranslucent(LIGHTMAP_TEXTURE);
}
