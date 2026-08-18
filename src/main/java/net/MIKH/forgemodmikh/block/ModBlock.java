package net.MIKH.forgemodmikh.block;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.block.custom.BoomBlock;
import net.MIKH.forgemodmikh.block.custom.CucumberCropBlock;
import net.MIKH.forgemodmikh.block.custom.ModFlammablePillarBlock;
import net.MIKH.forgemodmikh.block.custom.SkullLamp;
import net.MIKH.forgemodmikh.item.ModItem;
import net.MIKH.forgemodmikh.sound.ModSounds;
import net.MIKH.forgemodmikh.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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

    public static final RegistryObject<Block> MOON_ORE = registerBlock("moon_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE)
                    .strength(2f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> MOON_DEEPSLATE_ORE = registerBlock("moon_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of()
                    .sound(SoundType.DEEPSLATE)
                    .strength(3f)
                    .destroyTime(1f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> MOON_NETHER_ORE = registerBlock("moon_nether_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of()
                    .sound(SoundType.NETHERRACK)
                    .strength(1f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> MOON_END_ORE = registerBlock("moon_end_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE)
                    .strength(2f)
                    .requiresCorrectToolForDrops()
            ));



    public static final RegistryObject<Block> CUCUMBER_CROP = BLOCKS.register("cucumber_crop",
            ()-> new CucumberCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));



    public static final RegistryObject<RotatedPillarBlock> MAPLE_LOG = registerBlock("maple_log",
            ()-> new ModFlammablePillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> MAPLE_WOOD = registerBlock("maple_wood",
            ()-> new ModFlammablePillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            ()-> new ModFlammablePillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            ()-> new ModFlammablePillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> MAPLE_PLANKS = registerBlock("maple_planks",
            ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {return true;}
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {return 10;}
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {return 5;}
            });
    public static final RegistryObject<Block> MAPLE_LEAVES = registerBlock("maple_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {return true;}
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {return 30;}
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {return 20;}
            });

    public static final RegistryObject<Block> MAPLE_SAPLING = registerBlock("maple_sapling",
            ()-> new SaplingBlock(ModTreeGrowers.MAPLE,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));


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
