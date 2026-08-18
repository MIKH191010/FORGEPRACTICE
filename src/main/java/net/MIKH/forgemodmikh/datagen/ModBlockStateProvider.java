package net.MIKH.forgemodmikh.datagen;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.block.ModBlock;
import net.MIKH.forgemodmikh.block.custom.CucumberCropBlock;
import net.MIKH.forgemodmikh.block.custom.SkullLamp;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ForgeModMIKH.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlock.BOOM_BLOCK);
        blockWithItem(ModBlock.POOP_BLOCK);
        blockWithItem(ModBlock.DRIED_POOP_BLOCK);

        blockWithItem(ModBlock.MOON_ORE);
        blockWithItem(ModBlock.MOON_DEEPSLATE_ORE);
        blockWithItem(ModBlock.MOON_NETHER_ORE);
        blockWithItem(ModBlock.MOON_END_ORE);

        customLamp();

        blockWithItem(ModBlock.VOID_BLOCK);

        slabBlock(ModBlock.VOID_SLAB.get(),blockTexture(ModBlock.VOID_BLOCK.get()),blockTexture(ModBlock.VOID_BLOCK.get()));
        stairsBlock(ModBlock.VOID_STAIR.get(),blockTexture(ModBlock.VOID_BLOCK.get()));
        wallBlock(ModBlock.VOID_WALL.get(),blockTexture(ModBlock.VOID_BLOCK.get()));
        buttonBlock(ModBlock.VOID_BUTTON.get(),blockTexture(ModBlock.VOID_BLOCK.get()));
        trapdoorBlockWithRenderType(ModBlock.VOID_TRAPDOOR.get(),modLoc("block/void_trapdoor"),true,"cutout");
        doorBlockWithRenderType(ModBlock.VOID_DOOR.get(),modLoc("block/void_door_bottom"),modLoc("block/void_door_top"),"cutout");

        blockItem(ModBlock.VOID_SLAB);
        blockItem(ModBlock.VOID_STAIR);
        blockItem(ModBlock.VOID_TRAPDOOR);

        makeCrop(((CropBlock) ModBlock.CUCUMBER_CROP.get()),"cucumber_crop_state","cucumber_crop_state");

        logBlock(ModBlock.MAPLE_LOG.get());
        logBlock(ModBlock.STRIPPED_MAPLE_LOG.get());
        axisBlock(ModBlock.MAPLE_WOOD.get(),blockTexture(ModBlock.MAPLE_LOG.get()),blockTexture(ModBlock.MAPLE_LOG.get()));
        axisBlock(ModBlock.STRIPPED_MAPLE_WOOD.get(),blockTexture(ModBlock.STRIPPED_MAPLE_LOG.get()),blockTexture(ModBlock.STRIPPED_MAPLE_LOG.get()));

        blockItem(ModBlock.MAPLE_LOG);
        blockItem(ModBlock.STRIPPED_MAPLE_LOG);
        blockItem(ModBlock.MAPLE_WOOD);
        blockItem(ModBlock.STRIPPED_MAPLE_WOOD);

        blockWithItem(ModBlock.MAPLE_PLANKS);

        saplingBlock(ModBlock.MAPLE_SAPLING);
        leavesBlock(ModBlock.MAPLE_LEAVES);
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject){
        simpleBlock(blockRegistryObject.get(),models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                ResourceLocation.parse("minecraft:block/leaves"),"all",blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CucumberCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(ForgeModMIKH.MOD_ID, "block/" + textureName + state.getValue(((CucumberCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void customLamp() {
        getVariantBuilder(ModBlock.SKULL_LAMP.get()).forAllStates(state -> {
            if(state.getValue(SkullLamp.POWERED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("skull_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(ForgeModMIKH.MOD_ID, "block/" + "skull_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("skull_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(ForgeModMIKH.MOD_ID, "block/" + "skull_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlock.SKULL_LAMP.get(), models().cubeAll("skull_lamp_on",
                ResourceLocation.fromNamespaceAndPath(ForgeModMIKH.MOD_ID, "block/" + "skull_lamp_on")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject){
        simpleBlockItem(blockRegistryObject.get(),new ModelFile.UncheckedModelFile(ForgeModMIKH.MOD_ID + ":block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath())
        );
    }
    private void blockItem(RegistryObject<? extends Block> blockRegistryObject,String appendix){
        simpleBlockItem(blockRegistryObject.get(),new ModelFile.UncheckedModelFile(ForgeModMIKH.MOD_ID + ":block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix)
        );
    }
}
