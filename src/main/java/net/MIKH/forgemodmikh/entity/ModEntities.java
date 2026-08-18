package net.MIKH.forgemodmikh.entity;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.entity.custom.CaciEntity;
import net.MIKH.forgemodmikh.entity.custom.JavelinProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,ForgeModMIKH.MOD_ID);

    public static final RegistryObject<EntityType<CaciEntity>> CACI = ENTITY_TYPES.register("caci",
            ()-> EntityType.Builder.of(CaciEntity::new, MobCategory.CREATURE)
                    .sized(.25f,.5f).build("caci"));

    public static final RegistryObject<EntityType<JavelinProjectileEntity>> JAVELIN =
            ENTITY_TYPES.register("javelin", () -> EntityType.Builder.<JavelinProjectileEntity>of(
                    JavelinProjectileEntity::new,MobCategory.MISC).sized(.25f,.25f).build("javelin"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
