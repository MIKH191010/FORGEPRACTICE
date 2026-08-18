package net.MIKH.forgemodmikh.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.entity.custom.JavelinProjectileEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class JavelinProjectileModel extends EntityModel<JavelinProjectileEntity> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ForgeModMIKH.MOD_ID,"javelin"), "main");
    private final ModelPart javelin;

    public JavelinProjectileModel(ModelPart root) {
        this.javelin = root.getChild("Javelin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Javelin = partdefinition.addOrReplaceChild("Javelin", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -20.0F, 0.0F, 2.0F, 21.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 0).addBox(-1.5F, 1.0F, -0.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(8, 16).addBox(-0.5F, -20.0F, -1.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(8, 8).addBox(-0.5F, -23.0F, -1.5F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(20, 5).addBox(-1.0F, -23.0F, 0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 16).addBox(-0.5F, -25.0F, -1.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(20, 0).addBox(-0.5F, -27.0F, -0.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(20, 9).addBox(-0.5F, -29.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -1.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }


    @Override
    public void setupAnim(JavelinProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        javelin.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
