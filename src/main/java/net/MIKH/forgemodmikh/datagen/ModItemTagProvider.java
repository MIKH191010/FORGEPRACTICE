package net.MIKH.forgemodmikh.datagen;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.block.ModBlock;
import net.MIKH.forgemodmikh.item.ModItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                              CompletableFuture<TagLookup<Block>> pBlockTags,
                              @Nullable ExistingFileHelper existingFileHelper) {

        super(pOutput, pLookupProvider, pBlockTags, ForgeModMIKH.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItem.KNIGHT_HELMET.get())
                .add(ModItem.KNIGHT_CHESTPLATE.get())
                .add(ModItem.KNIGHT_LEGGINGS.get())
                .add(ModItem.KNIGHT_BOOTS.get());
        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlock.MAPLE_LOG.get().asItem())
                .add(ModBlock.STRIPPED_MAPLE_LOG.get().asItem())
                .add(ModBlock.MAPLE_WOOD.get().asItem())
                .add(ModBlock.STRIPPED_MAPLE_WOOD.get().asItem()
                );
        tag(ItemTags.PLANKS)
                .add(ModBlock.MAPLE_PLANKS.get().asItem()
                );
    }
}
