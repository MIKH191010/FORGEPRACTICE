package net.MIKH.forgemodmikh.villager;

import com.google.common.collect.ImmutableSet;
import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.block.ModBlock;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.MarshalledObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, ForgeModMIKH.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS,ForgeModMIKH.MOD_ID);

    public static final RegistryObject<PoiType> MIKH_POI = POI_TYPES.register("mikh_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlock.CHAIR.get().getStateDefinition().getPossibleStates()),1,1));

    public static final RegistryObject<VillagerProfession> DISCORDMOD = VILLAGER_PROFESSION.register("discordmod",
            ()->new VillagerProfession("discordmod",holder -> holder.value() == MIKH_POI.get(),
                    holder -> holder.value() == MIKH_POI.get(),ImmutableSet.of(),ImmutableSet.of(),
                    SoundEvents.ZOMBIE_AMBIENT));

    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSION.register(eventBus);
    }
}
