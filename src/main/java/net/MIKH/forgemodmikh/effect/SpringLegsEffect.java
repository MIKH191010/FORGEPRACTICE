package net.MIKH.forgemodmikh.effect;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class SpringLegsEffect extends MobEffect {
    protected SpringLegsEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity.verticalCollision){
            if (pLivingEntity.onGround() && pLivingEntity.getDeltaMovement().y < 0) {
                pLivingEntity.setDeltaMovement(pLivingEntity.getDeltaMovement().x,-pLivingEntity.getDeltaMovement().y*10,pLivingEntity.getDeltaMovement().z);
                pLivingEntity.hasImpulse = true;
            }
        }
        return super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }
}
