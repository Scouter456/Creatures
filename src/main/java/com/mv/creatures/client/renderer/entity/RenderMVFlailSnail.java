package com.mv.creatures.client.renderer.entity;

import com.mv.creatures.common.entities.EntityMVFlailSnail;
import com.mv.creatures.common.entities.EntityMVWorm;

import com.mv.creatures.common.entities.model.FlailSnail;
import com.mv.creatures.common.entities.model.ModelMVWorm;
import com.mv.creatures.core.MVCreatures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderMVFlailSnail extends MobRenderer<EntityMVFlailSnail, FlailSnail> {
    private static final ResourceLocation textureLoc = MVCreatures.getModelTexture("flailsnail.png");

    public RenderMVFlailSnail(EntityRendererManager manager, FlailSnail modelbase, float shadowSize){
        super(manager, modelbase, shadowSize);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityMVFlailSnail entity) {return textureLoc;}
}
