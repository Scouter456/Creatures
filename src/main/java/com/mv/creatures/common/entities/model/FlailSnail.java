package com.mv.creatures.common.entities.model;// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mv.creatures.common.entities.EntityMVFlailSnail;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class FlailSnail extends SegmentedModel<EntityMVFlailSnail> {
	private final ModelRenderer nindegy;
	private final ModelRenderer ShellLowerPivot;
	private final ModelRenderer ShellLowerPivotMid;
	private final ModelRenderer ShellLowerPivotUpper;
	private final ModelRenderer ShellMidPivot;
	private final ModelRenderer ShellMidPivotMid;
	private final ModelRenderer ShellMidPivotUpper;
	private final ModelRenderer ShellUpperPivotLower;
	private final ModelRenderer ShellUpperPivotMid;
	private final ModelRenderer ShellUpperPivotUpper;
	private final ModelRenderer MainBodyPivot;
	private final ModelRenderer MainBodyUpperPivot;
	private final ModelRenderer MainBodyUpperFrontPivot;
	private final ModelRenderer MainbodyUpperBackPivot;
	private final ModelRenderer TailPivot;
	private final ModelRenderer TailPivot2;
	private final ModelRenderer TailMusclePivot1;
	private final ModelRenderer TailMusclePivot2;
	private final ModelRenderer TailMusclePivot3;
	private final ModelRenderer MainBodyRightPivot;
	private final ModelRenderer MainBodyLeftPivot;
	private final ModelRenderer BodyToShellPivot;
	private final ModelRenderer BodyToShellPivotFront2;
	private final ModelRenderer BodyToShellPivotFront3;
	private final ModelRenderer MainNeckPivot;
	private final ModelRenderer NeckFrontMidPivot;
	private final ModelRenderer NeckFrontUpperPivot;
	private final ModelRenderer NeckBackUpperPivot;
	private final ModelRenderer NeckbackLowerPivot;
	private final ModelRenderer FlailStalkLeftPivot;
	private final ModelRenderer FlailLeftPivot;
	private final ModelRenderer FlailStalkRightPivot;
	private final ModelRenderer FlailRightPivot;

	public FlailSnail() {
		textureWidth = 128;
		textureHeight = 128;

		nindegy = new ModelRenderer(this);
		nindegy.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(nindegy, 0.0F, -1.5708F, 0.0F);
		

		ShellLowerPivot = new ModelRenderer(this);
		ShellLowerPivot.setRotationPoint(2.0F, -6.0F, 0.0F);
		nindegy.addChild(ShellLowerPivot);
		setRotationAngle(ShellLowerPivot, 0.0F, 0.0F, 0.0873F);
		ShellLowerPivot.setTextureOffset(46, 52).addBox(-7.0F, -1.0F, -5.0F, 14.0F, 1.0F, 10.0F, 0.0F, false);

		ShellLowerPivotMid = new ModelRenderer(this);
		ShellLowerPivotMid.setRotationPoint(1.0F, -1.5F, -0.5F);
		ShellLowerPivot.addChild(ShellLowerPivotMid);
		ShellLowerPivotMid.setTextureOffset(0, 28).addBox(-9.0F, -2.5F, -5.5F, 16.0F, 3.0F, 12.0F, 0.0F, false);

		ShellLowerPivotUpper = new ModelRenderer(this);
		ShellLowerPivotUpper.setRotationPoint(-0.1743F, -3.9924F, -0.5F);
		ShellLowerPivot.addChild(ShellLowerPivotUpper);
		ShellLowerPivotUpper.setTextureOffset(44, 28).addBox(-6.8257F, -2.0076F, -4.5F, 14.0F, 2.0F, 10.0F, 0.0F, false);

		ShellMidPivot = new ModelRenderer(this);
		ShellMidPivot.setRotationPoint(-0.1743F, -6.4924F, -0.5F);
		ShellLowerPivot.addChild(ShellMidPivot);
		setRotationAngle(ShellMidPivot, 0.0F, 0.0F, 0.0873F);
		ShellMidPivot.setTextureOffset(0, 43).addBox(-7.7823F, 0.4876F, -5.5F, 16.0F, 1.0F, 12.0F, 0.0F, false);

		ShellMidPivotMid = new ModelRenderer(this);
		ShellMidPivotMid.setRotationPoint(-0.1296F, -0.982F, 0.0F);
		ShellMidPivot.addChild(ShellMidPivotMid);
		ShellMidPivotMid.setTextureOffset(0, 11).addBox(-9.0F, -1.5F, -6.5F, 18.0F, 3.0F, 14.0F, 0.0F, false);

		ShellMidPivotUpper = new ModelRenderer(this);
		ShellMidPivotUpper.setRotationPoint(-0.6946F, -3.9392F, 0.0F);
		ShellMidPivotMid.addChild(ShellMidPivotUpper);
		setRotationAngle(ShellMidPivotUpper, 0.0F, 0.0F, 0.0873F);
		ShellMidPivotUpper.setTextureOffset(50, 11).addBox(-6.1318F, -0.576F, -4.5F, 14.0F, 4.0F, 10.0F, 0.0F, false);

		ShellUpperPivotLower = new ModelRenderer(this);
		ShellUpperPivotLower.setRotationPoint(0.7116F, -3.2654F, 0.0F);
		ShellMidPivotUpper.addChild(ShellUpperPivotLower);
		setRotationAngle(ShellUpperPivotLower, 0.0F, 0.0F, 0.0873F);
		ShellUpperPivotLower.setTextureOffset(32, 63).addBox(-4.0F, -3.5F, -2.5F, 9.0F, 7.0F, 6.0F, 0.0F, false);

		ShellUpperPivotMid = new ModelRenderer(this);
		ShellUpperPivotMid.setRotationPoint(0.6693F, -5.3825F, 0.0F);
		ShellUpperPivotLower.addChild(ShellUpperPivotMid);
		setRotationAngle(ShellUpperPivotMid, 0.0F, 0.0F, 0.1745F);
		ShellUpperPivotMid.setTextureOffset(24, 76).addBox(-2.5F, -3.5F, -1.5F, 5.0F, 7.0F, 4.0F, 0.0F, false);

		ShellUpperPivotUpper = new ModelRenderer(this);
		ShellUpperPivotUpper.setRotationPoint(1.0981F, -4.0981F, 0.0F);
		ShellUpperPivotMid.addChild(ShellUpperPivotUpper);
		setRotationAngle(ShellUpperPivotUpper, 0.0F, 0.0F, 0.1745F);
		ShellUpperPivotUpper.setTextureOffset(0, 28).addBox(-2.5F, -3.5F, -0.5F, 3.0F, 7.0F, 2.0F, 0.0F, false);

		MainBodyPivot = new ModelRenderer(this);
		MainBodyPivot.setRotationPoint(-0.5F, -0.5F, 0.5F);
		nindegy.addChild(MainBodyPivot);
		MainBodyPivot.setTextureOffset(0, 0).addBox(-16.5F, -2.5F, -4.5F, 33.0F, 3.0F, 8.0F, 0.0F, false);

		MainBodyUpperPivot = new ModelRenderer(this);
		MainBodyUpperPivot.setRotationPoint(0.75F, -3.5F, -0.5F);
		MainBodyPivot.addChild(MainBodyUpperPivot);
		MainBodyUpperPivot.setTextureOffset(44, 44).addBox(-11.25F, -1.0F, -3.0F, 23.0F, 2.0F, 6.0F, 0.0F, false);

		MainBodyUpperFrontPivot = new ModelRenderer(this);
		MainBodyUpperFrontPivot.setRotationPoint(-13.0F, -3.5F, -0.5F);
		MainBodyPivot.addChild(MainBodyUpperFrontPivot);
		MainBodyUpperFrontPivot.setTextureOffset(72, 74).addBox(-3.5F, -1.0F, -2.0F, 6.0F, 2.0F, 4.0F, 0.0F, false);

		MainbodyUpperBackPivot = new ModelRenderer(this);
		MainbodyUpperBackPivot.setRotationPoint(14.0F, -3.0F, -0.5F);
		MainBodyPivot.addChild(MainbodyUpperBackPivot);
		MainbodyUpperBackPivot.setTextureOffset(73, 45).addBox(-1.5F, -0.5F, -2.0F, 3.0F, 2.0F, 4.0F, 0.0F, false);

		TailPivot = new ModelRenderer(this);
		TailPivot.setRotationPoint(18.0F, -0.5F, -0.5F);
		MainBodyPivot.addChild(TailPivot);
		TailPivot.setTextureOffset(0, 78).addBox(-1.5F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		TailPivot2 = new ModelRenderer(this);
		TailPivot2.setRotationPoint(5.0F, 0.0F, 0.0F);
		TailPivot.addChild(TailPivot2);
		TailPivot2.setTextureOffset(83, 30).addBox(-2.5F, 0.0F, -1.5F, 4.0F, 1.0F, 3.0F, 0.0F, false);

		TailMusclePivot1 = new ModelRenderer(this);
		TailMusclePivot1.setRotationPoint(-1.5F, 0.5F, 0.0F);
		TailPivot2.addChild(TailMusclePivot1);
		setRotationAngle(TailMusclePivot1, 0.0F, 0.0F, 0.5672F);
		TailMusclePivot1.setTextureOffset(44, 31).addBox(-2.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		TailMusclePivot2 = new ModelRenderer(this);
		TailMusclePivot2.setRotationPoint(-4.9109F, 1.3058F, 0.0F);
		TailMusclePivot1.addChild(TailMusclePivot2);
		setRotationAngle(TailMusclePivot2, 0.0F, 0.0F, -0.3491F);
		TailMusclePivot2.setTextureOffset(0, 37).addBox(-1.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		TailMusclePivot3 = new ModelRenderer(this);
		TailMusclePivot3.setRotationPoint(-3.8144F, -0.8704F, 0.0F);
		TailMusclePivot2.addChild(TailMusclePivot3);
		setRotationAngle(TailMusclePivot3, 0.0F, 0.0F, -0.0436F);
		TailMusclePivot3.setTextureOffset(44, 28).addBox(-1.5F, -0.5F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		MainBodyRightPivot = new ModelRenderer(this);
		MainBodyRightPivot.setRotationPoint(1.5F, -0.5F, -5.5F);
		MainBodyPivot.addChild(MainBodyRightPivot);
		MainBodyRightPivot.setTextureOffset(56, 40).addBox(-11.0F, -1.0F, 0.0F, 23.0F, 2.0F, 1.0F, 0.0F, false);

		MainBodyLeftPivot = new ModelRenderer(this);
		MainBodyLeftPivot.setRotationPoint(2.0F, -0.5F, -5.5F);
		MainBodyPivot.addChild(MainBodyLeftPivot);
		MainBodyLeftPivot.setTextureOffset(0, 56).addBox(-11.5F, -1.0F, 9.0F, 23.0F, 2.0F, 1.0F, 0.0F, false);

		BodyToShellPivot = new ModelRenderer(this);
		BodyToShellPivot.setRotationPoint(0.0F, -4.0F, 0.0F);
		MainBodyPivot.addChild(BodyToShellPivot);
		BodyToShellPivot.setTextureOffset(0, 59).addBox(-4.0F, -3.0F, -3.0F, 14.0F, 4.0F, 5.0F, 0.0F, false);

		BodyToShellPivotFront2 = new ModelRenderer(this);
		BodyToShellPivotFront2.setRotationPoint(-4.5F, 0.0F, -0.5F);
		BodyToShellPivot.addChild(BodyToShellPivotFront2);
		setRotationAngle(BodyToShellPivotFront2, 0.0F, 0.0F, -0.6981F);
		BodyToShellPivotFront2.setTextureOffset(0, 43).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		BodyToShellPivotFront3 = new ModelRenderer(this);
		BodyToShellPivotFront3.setRotationPoint(11.4907F, 9.6418F, 0.0F);
		BodyToShellPivotFront2.addChild(BodyToShellPivotFront3);
		setRotationAngle(BodyToShellPivotFront3, 0.0F, 0.0F, 1.5708F);
		BodyToShellPivotFront3.setTextureOffset(0, 19).addBox(-2.5F, -1.0F, -1.5F, 4.0F, 2.0F, 3.0F, 0.0F, false);

		MainNeckPivot = new ModelRenderer(this);
		MainNeckPivot.setRotationPoint(-17.0F, -0.5F, 0.0F);
		nindegy.addChild(MainNeckPivot);
		setRotationAngle(MainNeckPivot, 0.0F, 0.0F, 0.5672F);
		MainNeckPivot.setTextureOffset(63, 64).addBox(-4.6464F, -2.6464F, -3.5F, 5.0F, 3.0F, 7.0F, 0.0F, false);

		NeckFrontMidPivot = new ModelRenderer(this);
		NeckFrontMidPivot.setRotationPoint(-4.7071F, -0.7071F, 0.0F);
		MainNeckPivot.addChild(NeckFrontMidPivot);
		setRotationAngle(NeckFrontMidPivot, 0.0F, 0.0F, 0.48F);
		NeckFrontMidPivot.setTextureOffset(56, 74).addBox(-4.4564F, -2.0872F, -3.0F, 5.0F, 3.0F, 6.0F, 0.0F, false);

		NeckFrontUpperPivot = new ModelRenderer(this);
		NeckFrontUpperPivot.setRotationPoint(-4.2608F, -0.0374F, 0.0F);
		NeckFrontMidPivot.addChild(NeckFrontUpperPivot);
		setRotationAngle(NeckFrontUpperPivot, 0.0F, 0.0F, 0.3054F);
		NeckFrontUpperPivot.setTextureOffset(74, 0).addBox(-4.9008F, -2.0349F, -2.0F, 5.0F, 3.0F, 4.0F, 0.0F, false);

		NeckBackUpperPivot = new ModelRenderer(this);
		NeckBackUpperPivot.setRotationPoint(0.8978F, -3.4691F, 0.0F);
		NeckFrontUpperPivot.addChild(NeckBackUpperPivot);
		setRotationAngle(NeckBackUpperPivot, 0.0F, 0.0F, -0.3927F);
		NeckBackUpperPivot.setTextureOffset(0, 74).addBox(-5.9061F, -0.894F, -1.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		NeckbackLowerPivot = new ModelRenderer(this);
		NeckbackLowerPivot.setRotationPoint(3.3305F, 0.2598F, 0.0F);
		NeckBackUpperPivot.addChild(NeckbackLowerPivot);
		setRotationAngle(NeckbackLowerPivot, 0.0F, 0.0F, -0.3927F);
		NeckbackLowerPivot.setTextureOffset(0, 68).addBox(-4.5F, -1.0F, -2.0F, 10.0F, 2.0F, 4.0F, 0.0F, false);

		FlailStalkLeftPivot = new ModelRenderer(this);
		FlailStalkLeftPivot.setRotationPoint(-4.8802F, -0.2177F, 1.8874F);
		NeckFrontUpperPivot.addChild(FlailStalkLeftPivot);
		setRotationAngle(FlailStalkLeftPivot, -0.0873F, 0.0F, -1.309F);
		FlailStalkLeftPivot.setTextureOffset(54, 11).addBox(-0.1488F, -6.7681F, -0.8667F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		FlailLeftPivot = new ModelRenderer(this);
		FlailLeftPivot.setRotationPoint(0.2194F, -6.0378F, -0.6317F);
		FlailStalkLeftPivot.addChild(FlailLeftPivot);
		setRotationAngle(FlailLeftPivot, 0.0436F, 0.0F, -0.0436F);
		FlailLeftPivot.setTextureOffset(0, 4).addBox(-0.8277F, -1.7123F, -0.6686F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		FlailStalkRightPivot = new ModelRenderer(this);
		FlailStalkRightPivot.setRotationPoint(-4.8939F, -0.0928F, -1.6959F);
		NeckFrontUpperPivot.addChild(FlailStalkRightPivot);
		setRotationAngle(FlailStalkRightPivot, 0.0873F, 0.0F, -1.309F);
		FlailStalkRightPivot.setTextureOffset(50, 11).addBox(-0.0246F, -6.8039F, -0.3224F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		FlailRightPivot = new ModelRenderer(this);
		FlailRightPivot.setRotationPoint(0.7457F, -5.7976F, 0.1051F);
		FlailStalkRightPivot.addChild(FlailRightPivot);
		setRotationAngle(FlailRightPivot, -0.0436F, 0.0F, 0.0F);
		FlailRightPivot.setTextureOffset(0, 0).addBox(-1.3403F, -1.999F, -1.0436F, 2.0F, 2.0F, 2.0F, 0.0F, false);
	}


	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(
				nindegy,
				MainBodyPivot,
				MainBodyUpperPivot,
				MainBodyUpperFrontPivot,
				MainbodyUpperBackPivot,
				TailPivot,
				TailPivot2,
				TailMusclePivot1,
				TailMusclePivot2,
				TailMusclePivot3,
				MainBodyRightPivot,
				MainBodyLeftPivot,
				BodyToShellPivot,
				BodyToShellPivotFront2,
				BodyToShellPivotFront3,
				MainNeckPivot,
				NeckFrontMidPivot,
				NeckFrontUpperPivot,
				NeckBackUpperPivot,
				NeckbackLowerPivot,
				FlailStalkLeftPivot,
				FlailLeftPivot,
				FlailStalkRightPivot,
				FlailRightPivot,
				ShellLowerPivot,
				ShellLowerPivotMid,
				ShellLowerPivotUpper,
				ShellMidPivot,
				ShellMidPivotMid,
				ShellMidPivotUpper,
				ShellUpperPivotLower,
				ShellUpperPivotMid,
				ShellUpperPivotUpper
		);
	}

	@Override
	public void setRotationAngles(EntityMVFlailSnail model, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		nindegy.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}