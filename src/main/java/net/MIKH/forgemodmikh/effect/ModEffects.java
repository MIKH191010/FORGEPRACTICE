package net.MIKH.forgemodmikh.effect;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.enchantment.custom.JaggedBladeEnchantmentEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ForgeModMIKH.MOD_ID);

    public static final RegistryObject<MobEffect> SPRING_LEGS_EFFECT = MOB_EFFECTS.register("spring_legs",
            ()-> new SpringLegsEffect(MobEffectCategory.NEUTRAL, 0xffff)
                    .addAttributeModifier(Attributes.JUMP_STRENGTH , ResourceLocation.fromNamespaceAndPath(ForgeModMIKH.MOD_ID,"spring_legs"),
                            0.25f,AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));


    public static final RegistryObject<MobEffect> BLEEDING_EFFECT = MOB_EFFECTS.register("bleeding",
            ()-> new BleedingEffect(MobEffectCategory.HARMFUL, 13458603)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED , ResourceLocation.fromNamespaceAndPath(ForgeModMIKH.MOD_ID,"bleeding"),
                            -0.25f,AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
