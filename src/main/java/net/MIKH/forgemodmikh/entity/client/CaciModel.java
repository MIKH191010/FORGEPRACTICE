package net.MIKH.forgemodmikh.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.entity.custom.CaciEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class CaciModel<T extends CaciEntity> extends HierarchicalModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ForgeModMIKH.MOD_ID,"caci"), "main");
    private final ModelPart Character;
    private final ModelPart Body;
    private final ModelPart HeadDecor;
    private final ModelPart Face;
    private final ModelPart Limbs;
    private final ModelPart RA;
    private final ModelPart LA;
    private final ModelPart RL;
    private final ModelPart LL;

    public CaciModel(ModelPart root) {
        this.Character = root.getChild("Character");
        this.Body = this.Character.getChild("Body");
        this.HeadDecor = this.Body.getChild("HeadDecor");
        this.Face = this.Body.getChild("Face");
        this.Limbs = this.Character.getChild("Limbs");
        this.RA = this.Limbs.getChild("RA");
        this.LA = this.Limbs.getChild("LA");
        this.RL = this.Limbs.getChild("RL");
        this.LL = this.Limbs.getChild("LL");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Character = partdefinition.addOrReplaceChild("Character", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Body = Character.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-0.9F, -3.0F, -0.9F, 1.8F, 3.0F, 1.8F, new CubeDeformation(0.0F))
                .texOffs(0, 5).addBox(-0.7F, -2.8F, -1.0F, 1.4F, 2.6F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(6, 5).addBox(-1.0F, -2.8F, -0.7F, 2.0F, 2.6F, 1.4F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.1F, 0.0F));

        PartDefinition HeadDecor = Body.addOrReplaceChild("HeadDecor", CubeListBuilder.create().texOffs(9, 1).addBox(-0.5F, -4.6F, -0.6F, 0.6F, 0.6F, 0.6F, new CubeDeformation(0.0F))
                .texOffs(13, 4).addBox(-0.7F, -4.3F, -0.3F, 0.3F, 0.3F, 0.6F, new CubeDeformation(0.0F))
                .texOffs(13, 4).addBox(-0.75F, -4.4F, 0.0F, 0.15F, 0.4F, 0.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

        PartDefinition Face = Body.addOrReplaceChild("Face", CubeListBuilder.create().texOffs(7, 1).addBox(-0.6F, -2.3F, -1.1F, 0.2F, 0.2F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(7, 1).addBox(0.0F, -1.7F, -1.1F, 0.3F, 0.3F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(7, 1).addBox(0.4F, -2.3F, -1.1F, 0.2F, 0.2F, 0.1F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Limbs = Character.addOrReplaceChild("Limbs", CubeListBuilder.create(), PartPose.offset(0.0F, -1.1F, 0.0F));

        PartDefinition RA = Limbs.addOrReplaceChild("RA", CubeListBuilder.create().texOffs(13, 1).addBox(-0.7F, -0.3F, -0.3F, 0.7F, 0.6F, 0.6F, new CubeDeformation(0.0F))
                .texOffs(13, 1).addBox(-1.3F, -0.9F, -0.3F, 0.6F, 1.2F, 0.6F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.5F, 0.0F));

        PartDefinition LA = Limbs.addOrReplaceChild("LA", CubeListBuilder.create().texOffs(13, 1).addBox(-0.7F, -0.3F, -0.4F, 0.7F, 0.6F, 0.6F, new CubeDeformation(0.0F))
                .texOffs(13, 1).addBox(-1.3F, -0.3F, -0.4F, 0.6F, 1.2F, 0.6F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.5F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition RL = Limbs.addOrReplaceChild("RL", CubeListBuilder.create().texOffs(13, 1).addBox(-0.3F, -0.3F, -0.3F, 0.6F, 1.5F, 0.6F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -0.1F, 0.0F));

        PartDefinition LL = Limbs.addOrReplaceChild("LL", CubeListBuilder.create().texOffs(13, 1).addBox(-0.3F, -0.3F, -0.3F, 0.6F, 1.5F, 0.6F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -0.1F, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(CaciEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animateWalk(CaciAnimations.run,limbSwing,limbSwingAmount,2f,2.5f);
        this.animate(entity.idleAnimationState,CaciAnimations.idle,ageInTicks,.5f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,int color) {
        Character.render(poseStack, vertexConsumer, packedLight, packedOverlay,color);
    }

    @Override
    public ModelPart root() {
        return this.Character;
    }
}
