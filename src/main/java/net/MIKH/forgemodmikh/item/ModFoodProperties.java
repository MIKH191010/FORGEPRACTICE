package net.MIKH.forgemodmikh.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties CUCUMBER =
            new FoodProperties.Builder().nutrition(2).saturationModifier(3).effect(new MobEffectInstance(MobEffects.LUCK,400),0.5f).fast().build();
}
