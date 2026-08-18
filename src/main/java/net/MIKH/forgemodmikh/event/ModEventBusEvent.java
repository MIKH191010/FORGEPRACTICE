package net.MIKH.forgemodmikh.event;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.entity.ModEntities;
import net.MIKH.forgemodmikh.entity.client.CaciModel;
import net.MIKH.forgemodmikh.entity.custom.CaciEntity;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ForgeModMIKH.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvent {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(CaciModel.LAYER_LOCATION,CaciModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void registerAttribute(EntityAttributeCreationEvent event){
        event.put(ModEntities.CACI.get(), CaciEntity.createAttributes().build());
    }

    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event){
        event.register(ModEntities.CACI.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
