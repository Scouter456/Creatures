package com.mv.creatures.client;

import com.mv.creatures.common.blocks.MVBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class RenderLayerRegistration {
    public static void init(){
        RenderType cutoutMipped = RenderType.getCutoutMipped();
        RenderType cutout = RenderType.getCutout();
        RenderType translucent = RenderType.getTranslucent();
        RenderType translucentnocrumb = RenderType.getTranslucentNoCrumbling();
        RenderType solid = RenderType.getSolid();
        RenderTypeLookup.setRenderLayer(MVBlocks.mucus.get(), translucent);
        RenderTypeLookup.setRenderLayer(MVBlocks.mucus_layers.get(), translucent);
        RenderTypeLookup.setRenderLayer(MVBlocks.dried_mucus.get(), solid);
        RenderTypeLookup.setRenderLayer(MVBlocks.dried_mucus_layers.get(), solid);
    }
}
