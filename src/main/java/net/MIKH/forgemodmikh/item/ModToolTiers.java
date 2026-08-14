package net.MIKH.forgemodmikh.item;

import net.MIKH.forgemodmikh.datagen.ModBlockTagProvider;
import net.MIKH.forgemodmikh.util.ModTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier KNIGHT = new ForgeTier(1500,4,3,20,
            ModTags.Blocks.NEEDS_KNIGHT_TOOL,
            () -> Ingredient.of(Items.IRON_INGOT),
            ModTags.Blocks.INCORRECT_FOR_KNIGHT_TOOL);

}
