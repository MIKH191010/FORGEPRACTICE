package net.MIKH.forgemodmikh.block;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.item.ModItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerBlock;

public class ModBlock {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ForgeModMIKH.MOD_ID);

    public static final RegistryObject<Block> POOP_BLOCK = registerBlock("poop_block",
            () -> new Block (BlockBehaviour.Properties.of()
                    .destroyTime(0.5f)
                    .strength(0.5f)
                    .sound(SoundType.HONEY_BLOCK)
            ));
    public static final RegistryObject<Block> DRIED_POOP_BLOCK = registerBlock("dried_poop_block",
            () -> new Block (BlockBehaviour.Properties.of()
                    .destroyTime(1f)
                    .strength(1f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GRAVEL)
            ));
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
