package net.MIKH.forgemodmikh.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.MIKH.forgemodmikh.effect.ModEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record JaggedBladeEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<JaggedBladeEnchantmentEffect> CODEC = MapCodec.unit(JaggedBladeEnchantmentEffect::new);

    @Override
    public void apply(ServerLevel pLevel, int pEnchantmentLevel, EnchantedItemInUse pItem, Entity pEntity, Vec3 pOrigin) {
        if (pEntity instanceof LivingEntity livingEntity){

            livingEntity.addEffect(new MobEffectInstance(ModEffects.BLEEDING_EFFECT.getHolder().get(),20*5));
            boolean hasEffect = livingEntity.hasEffect(ModEffects.BLEEDING_EFFECT.getHolder().get());
            if(hasEffect){
                livingEntity.hurt(livingEntity.damageSources().genericKill(),
                        3 * (livingEntity.getMaxHealth()/60) * (pEnchantmentLevel/3) );// deals more damage based on max healthex:warden att 500 maxhealth and level 3 deals 75 per  hit or 25 at level 1
            }

        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
