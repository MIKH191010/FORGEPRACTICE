package net.MIKH.forgemodmikh.util;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        //public static final TagKey<TagKey> EXAMPLE = createTag("example");
        public static final TagKey<Block> NEEDS_KNIGHT_TOOL = createTag("needs_knight_tool");
        public static final TagKey<Block> INCORRECT_FOR_KNIGHT_TOOL = createTag("incorrect_for_knight_tool");

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ForgeModMIKH.MOD_ID,name));
        }
    }

    public static class Items{
       // public static final TagKey<TagKey> EXAMPLE = createTag("example");

        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ForgeModMIKH.MOD_ID,name));
        }
    }
}
