package net.MIKH.forgemodmikh.effect;

import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BleedingEffect extends MobEffect {
    protected BleedingEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity.getHealth() > 1f){
            pLivingEntity.hurt(pLivingEntity.damageSources().genericKill(),1f);
        }
        return super.applyEffectTick(pLivingEntity, pAmplifier);

    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        int i = 10 >> pAmplifier;
        return i > 0 ? pDuration % i == 0 : true;
    };
}
