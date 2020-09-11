package com.mv.creatures.client.renderer.entity;

import com.mv.creatures.common.entities.EntityMVWorm;
import com.mv.creatures.common.entities.model.ModelMVWorm;
import com.mv.creatures.core.MVCreatures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderMVWorm extends MobRenderer<EntityMVWorm, ModelMVWorm> {
    private static final ResourceLocation textureLoc = MVCreatures.getModelTexture("mvworm.png");

    public RenderMVWorm(EntityRendererManager manager, ModelMVWorm modelbase, float shadowSize){
        super(manager, modelbase, shadowSize);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityMVWorm entity) {return textureLoc;}
}
