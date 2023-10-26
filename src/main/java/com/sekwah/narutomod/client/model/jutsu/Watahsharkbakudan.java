package com.sekwah.narutomod.client.model.jutsu;// Made with Blockbench 4.1.1
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.sekwah.narutomod.NarutoMod;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class Watahsharkbakudan<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(NarutoMod.MOD_ID, "shark_bomb"), "main");
	private final ModelPart body;

	public Watahsharkbakudan(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(108, 0).addBox(-13.0F, -12.0F, -4.0F, 26.0F, 26.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -33.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(100, 191).addBox(-8.0F, -20.0F, -43.0F, 16.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(88, 54).addBox(-12.0F, -25.0F, -35.0F, 24.0F, 24.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 11.0F));

		PartDefinition topjaw = head.addOrReplaceChild("topjaw", CubeListBuilder.create().texOffs(0, 98).addBox(-10.0F, -9.0F, -24.0F, 20.0F, 9.0F, 25.0F, new CubeDeformation(0.0F))
		.texOffs(36, 271).addBox(1.0F, -0.5F, -23.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(32, 273).addBox(4.0F, -0.5F, -23.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(32, 271).addBox(7.0F, -0.5F, -23.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(28, 273).addBox(-3.0F, -0.5F, -23.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(28, 271).addBox(-6.0F, -0.5F, -23.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(40, 273).addBox(-9.0F, -0.5F, -23.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(34, 252).addBox(9.0F, -0.5F, -22.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(34, 256).addBox(9.0F, -0.5F, -19.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(20, 271).addBox(9.0F, -0.5F, -16.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 271).addBox(9.0F, -0.5F, -13.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 271).addBox(-9.0F, -0.5F, -13.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 244).addBox(-9.0F, -0.5F, -16.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(4, 271).addBox(-9.0F, -0.5F, -19.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 271).addBox(-9.0F, -0.5F, -22.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(58, 271).addBox(-8.0F, 0.0F, -22.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 273).addBox(-8.0F, 0.0F, -22.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(30, 248).addBox(-8.0F, 0.0F, -20.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(34, 244).addBox(-8.0F, 0.0F, -17.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(30, 264).addBox(-8.0F, 0.0F, -14.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(30, 260).addBox(-8.0F, 0.0F, -11.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 271).addBox(-6.0F, 0.0F, -22.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(44, 271).addBox(-3.0F, 0.0F, -22.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(44, 273).addBox(1.0F, 0.0F, -22.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 271).addBox(4.0F, 0.0F, -22.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(60, 271).addBox(7.0F, 0.0F, -22.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(52, 271).addBox(8.0F, 0.0F, -22.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 256).addBox(8.0F, 0.0F, -20.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 252).addBox(8.0F, 0.0F, -17.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 248).addBox(8.0F, 0.0F, -14.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(34, 248).addBox(8.0F, 0.0F, -11.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -35.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bottomjaw = head.addOrReplaceChild("bottomjaw", CubeListBuilder.create().texOffs(76, 168).addBox(-6.0F, -4.0F, -15.0F, 12.0F, 4.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(30, 256).addBox(5.0F, -5.5F, -10.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(30, 252).addBox(5.0F, -5.5F, -13.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 273).addBox(2.0F, -5.5F, -14.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(36, 273).addBox(-1.0F, -5.5F, -14.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(24, 273).addBox(-4.0F, -5.5F, -14.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(26, 260).addBox(-5.0F, -5.5F, -13.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 271).addBox(-5.0F, -5.5F, -10.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(62, 271).addBox(3.0F, -6.0F, -13.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(56, 271).addBox(4.0F, -6.0F, -13.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 271).addBox(-1.0F, -6.0F, -13.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(62, 273).addBox(-4.0F, -6.0F, -13.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(54, 271).addBox(-4.0F, -6.0F, -13.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 244).addBox(-4.0F, -6.0F, -11.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 264).addBox(4.0F, -6.0F, -11.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -35.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition fin3 = body.addOrReplaceChild("fin3", CubeListBuilder.create().texOffs(0, 168).addBox(0.0F, -1.0F, 0.0F, 22.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 7.0F, -1.0F, 0.0F, -0.3491F, 0.2618F));

		PartDefinition fin4 = body.addOrReplaceChild("fin4", CubeListBuilder.create().texOffs(64, 136).addBox(-22.0F, -1.0F, 0.0F, 22.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 7.0F, -1.0F, 0.0F, 0.3491F, -0.2618F));

		PartDefinition fin5 = body.addOrReplaceChild("fin5", CubeListBuilder.create().texOffs(176, 63).addBox(-1.0F, -23.0F, 0.0F, 2.0F, 26.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(200, 57).addBox(-1.0F, -28.0F, 10.0F, 2.0F, 34.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 6.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition body1 = body.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -13.0F, -4.0F, 28.0F, 28.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 22.0F));

		PartDefinition body2 = body1.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 54).addBox(-12.0F, -11.0F, -4.0F, 24.0F, 24.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 26.0F));

		PartDefinition body3 = body2.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(90, 98).addBox(-10.0F, -9.0F, -4.0F, 20.0F, 20.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 20.0F));

		PartDefinition body4 = body3.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(0, 136).addBox(-8.0F, -7.0F, -4.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 18.0F));

		PartDefinition body5 = body4.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(0, 191).addBox(-5.0F, -4.0F, -4.0F, 10.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 16.0F));

		PartDefinition tail = body5.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(52, 191).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 17.0F));

		PartDefinition fin1 = tail.addOrReplaceChild("fin1", CubeListBuilder.create().texOffs(0, 217).addBox(-1.0F, -10.0F, 0.0F, 2.0F, 10.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(76, 217).addBox(-1.0F, -26.0F, 6.0F, 2.0F, 16.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition fin2 = tail.addOrReplaceChild("fin2", CubeListBuilder.create().texOffs(38, 217).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(0, 244).addBox(-1.0F, 10.0F, 6.0F, 2.0F, 16.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 288, 288);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, buffer, packedLight, packedOverlay);
	}
}