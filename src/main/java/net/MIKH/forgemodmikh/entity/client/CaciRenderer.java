package net.MIKH.forgemodmikh.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.entity.custom.CaciEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CaciRenderer extends MobRenderer<CaciEntity,CaciModel<CaciEntity>> {
    public CaciRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CaciModel<>(pContext.bakeLayer(CaciModel.LAYER_LOCATION)), .05f);
    }

    @Override
    public ResourceLocation getTextureLocation(CaciEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(ForgeModMIKH.MOD_ID,"textures/entity/caci/cacitexture.png");
    }

    @Override
    public void render(CaciEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()){
            pPoseStack.scale(2f,2f,2f);
        }else {
            pPoseStack.scale(3.5f,3.5f,3.5f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
