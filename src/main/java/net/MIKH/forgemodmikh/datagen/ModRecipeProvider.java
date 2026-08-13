package net.MIKH.forgemodmikh.datagen;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.block.ModBlock;
import net.MIKH.forgemodmikh.item.ModItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.IShapedRecipe;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        List<ItemLike> poopBlockSmeltingList = List.of(ModBlock.POOP_BLOCK.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.POOP_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A',ModItem.POOP.get())
                .unlockedBy(getHasName(ModItem.POOP.get()) , has(ModItem.POOP.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.BOOM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A',Items.TNT)
                .unlockedBy(getHasName(Items.TNT) , has(Items.TNT))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.CHISELER.get())
                .pattern("A")
                .pattern("B")
                .define('A', Items.IRON_INGOT)
                .define('B', Items.STICK)
                .unlockedBy(getHasName(Items.STICK) , has(Items.STICK))
                .unlockedBy(getHasName(Items.IRON_INGOT) , has(Items.IRON_INGOT))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItem.POOP.get(),9)
                .requires(ModBlock.POOP_BLOCK.get())
                .unlockedBy(getHasName(ModBlock.POOP_BLOCK.get()) , has(ModBlock.POOP_BLOCK.get()))
                .save(pRecipeOutput);

        oreSmelting(pRecipeOutput,poopBlockSmeltingList,RecipeCategory.MISC,ModBlock.DRIED_POOP_BLOCK.get(),0f,200,"poop");
        oreBlasting(pRecipeOutput,poopBlockSmeltingList,RecipeCategory.MISC,ModBlock.DRIED_POOP_BLOCK.get(),0f,200,"poop");



        slabBuilder(RecipeCategory.MISC,ModBlock.VOID_SLAB.get(),Ingredient.of(ModBlock.VOID_BLOCK.get())).group("void")
                .unlockedBy(getHasName(ModBlock.VOID_BLOCK.get()),has(ModBlock.VOID_BLOCK.get())).save(pRecipeOutput);
        stairBuilder(ModBlock.VOID_STAIR.get(),Ingredient.of(ModBlock.VOID_BLOCK.get())).group("void")
                .unlockedBy(getHasName(ModBlock.VOID_BLOCK.get()),has(ModBlock.VOID_BLOCK.get())).save(pRecipeOutput);
        wallBuilder(RecipeCategory.MISC,ModBlock.VOID_WALL.get(),Ingredient.of(ModBlock.VOID_BLOCK.get())).group("void")
                .unlockedBy(getHasName(ModBlock.VOID_BLOCK.get()),has(ModBlock.VOID_BLOCK.get())).save(pRecipeOutput);

        buttonBuilder(ModBlock.VOID_BUTTON.get(),Ingredient.of(ModBlock.VOID_BLOCK.get())).group("void")
                .unlockedBy(getHasName(ModBlock.VOID_BLOCK.get()),has(ModBlock.VOID_BLOCK.get())).save(pRecipeOutput);

        trapdoorBuilder(ModBlock.VOID_TRAPDOOR.get(),Ingredient.of(ModBlock.VOID_BLOCK.get())).group("void")
                .unlockedBy(getHasName(ModBlock.VOID_BLOCK.get()),has(ModBlock.VOID_BLOCK.get())).save(pRecipeOutput);
        doorBuilder(ModBlock.VOID_DOOR.get(),Ingredient.of(ModBlock.VOID_BLOCK.get())).group("void")
                .unlockedBy(getHasName(ModBlock.VOID_BLOCK.get()),has(ModBlock.VOID_BLOCK.get())).save(pRecipeOutput);
    }

//--------------------------------------------------------------------------------------------
    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {

        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult
                , pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {

        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult
                , pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(
            RecipeOutput pRecipeOutput,
            RecipeSerializer<T> pSerializer,
            AbstractCookingRecipe.Factory<T> pRecipeFactory,
            List<ItemLike> pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTime,
            String pGroup,
            String pSuffix
    ) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, ForgeModMIKH.MOD_ID + ":"  + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }
    }
}
