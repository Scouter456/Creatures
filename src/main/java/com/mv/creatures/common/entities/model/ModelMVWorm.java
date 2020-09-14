package com.mv.creatures.common.entities.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mv.creatures.common.entities.EntityMVWorm;
import jdk.nashorn.internal.ir.annotations.Immutable;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelMVWorm extends SegmentedModel<EntityMVWorm> {
    ModelRenderer block;

    public ModelMVWorm(){
        super(RenderType::getEntityCutoutNoCull);
        textureWidth = 32;
        textureHeight = 32;

        block = new ModelRenderer(this, 0,4);
        block.addBox(-10F,-10F,-10F,10F,10F,10F);
        block.setRotationPoint(-0.5F,-0.5F,-0.5F);

    }



    @Override
    public Iterable<ModelRenderer> getParts(){
        return ImmutableList.of(
                block
                );
    }

    private void setRotation(ModelRenderer model, float x, float y, float z){
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    @Override
    public void setRotationAngles(EntityMVWorm model, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }
    @Override
    public void render(MatrixStack ms, IVertexBuilder buffer, int light, int overlay, float r, float g, float b, float a){
        block.render(ms, buffer, light, overlay, r, g, b,a);
    }
}
