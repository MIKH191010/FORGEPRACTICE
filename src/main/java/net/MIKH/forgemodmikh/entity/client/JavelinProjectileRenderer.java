package net.MIKH.forgemodmikh.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.entity.custom.JavelinProjectileEntity;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.particles.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class JavelinProjectileRenderer extends EntityRenderer<JavelinProjectileEntity> {
    private JavelinProjectileModel model;
    public JavelinProjectileRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new JavelinProjectileModel(pContext.bakeLayer(JavelinProjectileModel.LAYER_LOCATION));
    }
    @Override
    public void render(JavelinProjectileEntity pEntity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        if(!pEntity.isGrounded()) {

            Level level = pEntity.level();
            if(level.isClientSide()){
                    float spreadX = level.getRandom().nextFloat()/5;
                    float spreadY = level.getRandom().nextFloat()/5;
                    float spreadZ = level.getRandom().nextFloat()/5;

                    level.addParticle(ParticleTypes.END_ROD,
                            pEntity.getX(),pEntity.getY(),pEntity.getZ(),
                            spreadX,spreadY,spreadZ);
            }
//            else{
//                ((ServerLevel) level).sendParticles(ParticleTypes.CLOUD,
//                        pEntity.getX(),pEntity.getY(),pEntity.getZ(),5,
//                        0,0,0,
//                        1);
//            }

            poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, pEntity.yRotO, pEntity.getYRot()) +180));
            poseStack.mulPose(Axis.XP.rotationDegrees(Mth.lerp(partialTicks, pEntity.xRotO, pEntity.getXRot()) +90f));
            poseStack.mulPose(Axis.YP.rotationDegrees(pEntity.getRenderingRotation() * 15f));
            poseStack.translate(0, -1.0f, 0);
        } else {
            poseStack.mulPose(Axis.YP.rotationDegrees(pEntity.getYRot() + 180));
            poseStack.mulPose(Axis.XP.rotationDegrees(pEntity.getXRot() + 90f));
            poseStack.translate(0, -.15f, 0);
        }

        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(
                buffer, this.model.renderType(this.getTextureLocation(pEntity)),false, false);
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(pEntity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
    @Override
    public ResourceLocation getTextureLocation(JavelinProjectileEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(ForgeModMIKH.MOD_ID,"textures/entity/javelin/javelin.png");
    }
}
