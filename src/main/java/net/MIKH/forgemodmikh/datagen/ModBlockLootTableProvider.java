package net.MIKH.forgemodmikh.datagen;

import net.MIKH.forgemodmikh.block.ModBlock;
import net.MIKH.forgemodmikh.block.custom.CucumberCropBlock;
import net.MIKH.forgemodmikh.item.ModItem;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider( HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlock.POOP_BLOCK.get());
        dropSelf(ModBlock.DRIED_POOP_BLOCK.get());
        dropSelf(ModBlock.BOOM_BLOCK.get());
        dropSelf(ModBlock.SKULL_LAMP.get());

        dropSelf(ModBlock.VOID_BLOCK.get());
        dropSelf(ModBlock.VOID_WALL.get());
        dropSelf(ModBlock.VOID_STAIR.get());
        dropSelf(ModBlock.VOID_TRAPDOOR.get());
        this.add(ModBlock.VOID_SLAB.get(),
                block -> createSlabItemTable(ModBlock.VOID_SLAB.get()));
        this.add(ModBlock.VOID_DOOR.get(),
                block -> createDoorTable(ModBlock.VOID_DOOR.get()));
        dropSelf(ModBlock.VOID_BUTTON.get());


        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlock.CUCUMBER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CucumberCropBlock.AGE,CucumberCropBlock.MAX_AGE));

        this.add(ModBlock.CUCUMBER_CROP.get(),this.createCropDrops(ModBlock.CUCUMBER_CROP.get(),
                ModItem.CUCUMBER.get(),ModItem.CUCUMBER_SEEDS.get(),lootItemConditionBuilder));

//        this.add(ModBlock.ORE.get(), -----------------ORE DROP
//                block -> createOreDrop(ModBlock.ORE.get(),ModItem.ITEM.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlock.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
