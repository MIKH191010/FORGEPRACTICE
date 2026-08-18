package net.MIKH.forgemodmikh.datagen;

import net.MIKH.forgemodmikh.block.ModBlock;
import net.MIKH.forgemodmikh.block.custom.CucumberCropBlock;
import net.MIKH.forgemodmikh.item.ModItem;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
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

        dropSelf(ModBlock.MAPLE_LOG.get());
        dropSelf(ModBlock.STRIPPED_MAPLE_LOG.get());
        dropSelf(ModBlock.MAPLE_WOOD.get());
        dropSelf(ModBlock.STRIPPED_MAPLE_WOOD.get());
        dropSelf(ModBlock.MAPLE_PLANKS.get());
        dropSelf(ModBlock.MAPLE_SAPLING.get());

        add(ModBlock.MAPLE_LEAVES.get(),block ->
                createLeavesDrops(ModBlock.MAPLE_LEAVES.get(),ModBlock.MAPLE_SAPLING.get(),NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlock.VOID_SLAB.get(),
                block -> createSlabItemTable(ModBlock.VOID_SLAB.get()));
        this.add(ModBlock.VOID_DOOR.get(),
                block -> createDoorTable(ModBlock.VOID_DOOR.get()));
        dropSelf(ModBlock.VOID_BUTTON.get());


        this.add(ModBlock.MOON_ORE.get(),
               block -> createOreDrop(ModBlock.MOON_ORE.get(),ModItem.MOON_FRAGMENT.get()));
        this.add(ModBlock.MOON_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlock.MOON_ORE.get(),ModItem.MOON_FRAGMENT.get(),2,5));
        this.add(ModBlock.MOON_NETHER_ORE.get(),
                block -> createMultipleOreDrops(ModBlock.MOON_ORE.get(),ModItem.MOON_FRAGMENT.get(),2,5));
        this.add(ModBlock.MOON_END_ORE.get(),
                block -> createMultipleOreDrops(ModBlock.MOON_ORE.get(),ModItem.MOON_FRAGMENT.get(),3,8));


        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlock.CUCUMBER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CucumberCropBlock.AGE,CucumberCropBlock.MAX_AGE));

        this.add(ModBlock.CUCUMBER_CROP.get(),this.createCropDrops(ModBlock.CUCUMBER_CROP.get(),
                ModItem.CUCUMBER.get(),ModItem.CUCUMBER_SEEDS.get(),lootItemConditionBuilder));

//        this.add(ModBlock.ORE.get(), -----------------ORE DROP
//                block -> createOreDrop(ModBlock.ORE.get(),ModItem.ITEM.get()));
    }
    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlock.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
