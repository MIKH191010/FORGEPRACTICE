package net.MIKH.forgemodmikh.block;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.block.custom.BoomBlock;
import net.MIKH.forgemodmikh.block.custom.CucumberCropBlock;
import net.MIKH.forgemodmikh.block.custom.SkullLamp;
import net.MIKH.forgemodmikh.item.ModItem;
import net.MIKH.forgemodmikh.sound.ModSounds;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlock {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ForgeModMIKH.MOD_ID);

    public static final RegistryObject<Block> POOP_BLOCK = registerBlock("poop_block",
            () -> new Block (BlockBehaviour.Properties.of()
                    .destroyTime(0.5f)
                    .strength(0.5f)
                    .sound(SoundType.HONEY_BLOCK)));

    public static final RegistryObject<Block> DRIED_POOP_BLOCK = registerBlock("dried_poop_block",
            () -> new Block (BlockBehaviour.Properties.of()
                    .destroyTime(1f)
                    .strength(1f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GRAVEL)));

    public static final RegistryObject<Block> BOOM_BLOCK = registerBlock("boom_block",
            () -> new BoomBlock(BlockBehaviour.Properties.of()
                    .instabreak()
                    .sound(SoundType.METAL)));

    public static final RegistryObject<Block> SKULL_LAMP = registerBlock("skull_lamp",
            () -> new SkullLamp(BlockBehaviour.Properties.of()
                    .lightLevel(state -> state.getValue(SkullLamp.POWERED) ? 100 : 0)
                    .sound(SoundType.TRIAL_SPAWNER)
                    .strength(1f)
                    .requiresCorrectToolForDrops()
            ));



    public static final RegistryObject<Block> VOID_BLOCK = registerBlock("void_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f)
                    .requiresCorrectToolForDrops()
                    .sound(ModSounds.VOID_BLOCK_SOUNDS)));

    public static final RegistryObject<SlabBlock> VOID_SLAB = registerBlock("void_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<StairBlock> VOID_STAIR = registerBlock("void_stair",
            () -> new StairBlock(ModBlock.VOID_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<DoorBlock> VOID_DOOR = registerBlock("void_door",
            () -> new DoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<ButtonBlock> VOID_BUTTON = registerBlock("void_button",
            () -> new ButtonBlock(BlockSetType.OAK,5,
                    BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<WallBlock> VOID_WALL = registerBlock("void_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<TrapDoorBlock> VOID_TRAPDOOR = registerBlock("void_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops()));



    public static final RegistryObject<Block> CUCUMBER_CROP = BLOCKS.register("cucumber_crop",
            ()-> new CucumberCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));
    //-------------------------------------------------------------------
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name , RegistryObject<T> Block){
        ModItem.ITEMS.register(name,() -> new BlockItem(Block.get(),new Item.Properties()));
    }
    //-------------------------------------------------------------------

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
