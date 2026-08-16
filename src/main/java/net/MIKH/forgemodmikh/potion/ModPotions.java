package net.MIKH.forgemodmikh.potion;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, ForgeModMIKH.MOD_ID);

    public static final RegistryObject<Potion> SPRING_LEGS_POTION = POTIONS.register("spring_legs_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SPRING_LEGS_EFFECT.getHolder().get(),200,0)));

    public static final void register(IEventBus eventBus){
        POTIONS.register(eventBus);
    }
}
