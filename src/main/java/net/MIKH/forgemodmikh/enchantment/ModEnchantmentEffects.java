package net.MIKH.forgemodmikh.enchantment;

import com.mojang.serialization.MapCodec;
import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.enchantment.custom.JaggedBladeEnchantmentEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModEnchantmentEffects {
    public static final  DeferredRegister<MapCodec<? extends  EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECT =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, ForgeModMIKH.MOD_ID);

    public static RegistryObject<MapCodec<? extends  EnchantmentEntityEffect>> JAGGED_BLADE =
            ENTITY_ENCHANTMENT_EFFECT.register("jagged_blade",() -> JaggedBladeEnchantmentEffect.CODEC);

    public static void register(IEventBus eventBus){
        ENTITY_ENCHANTMENT_EFFECT.register(eventBus);
    }
}
