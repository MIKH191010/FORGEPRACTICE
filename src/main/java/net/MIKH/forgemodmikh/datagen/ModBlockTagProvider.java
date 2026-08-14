package net.MIKH.forgemodmikh.datagen;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.block.ModBlock;
import net.MIKH.forgemodmikh.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ForgeModMIKH.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlock.DRIED_POOP_BLOCK.get())

                .add(ModBlock.VOID_BLOCK.get())
                .add(ModBlock.VOID_SLAB.get())
                .add(ModBlock.VOID_STAIR.get())
                .add(ModBlock.VOID_BUTTON.get())
                .add(ModBlock.VOID_DOOR.get())
                .add(ModBlock.VOID_TRAPDOOR.get())
                .add(ModBlock.VOID_WALL.get())

                .add(ModBlock.SKULL_LAMP.get()
                );
        tag(ModTags.Blocks.NEEDS_KNIGHT_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlock.SKULL_LAMP.get());
        tag(ModTags.Blocks.INCORRECT_FOR_KNIGHT_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_KNIGHT_TOOL);



        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlock.POOP_BLOCK.get()
                );
        tag(BlockTags.WALLS).add(ModBlock.VOID_WALL.get());
    }
}
