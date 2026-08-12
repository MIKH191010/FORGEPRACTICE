package net.MIKH.forgemodmikh.item;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.block.ModBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ForgeModMIKH.MOD_ID);
    //----------------------------------------ITEMS
    public static final RegistryObject<CreativeModeTab> TABITEM = CREATIVE_MODE_TABS.register("forgemodmikh_items",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItem.POOP.get()))
                    .title(Component.translatable("creativetab.forgemodmikh.ItemTab"))
                    .displayItems((itemDisplayParameters,output)->{
                        output.accept(ModItem.POOP.get());
                        output.accept(ModItem.CHISELER.get());
                    })
                    .build()
    );//----------------------------------------BLOCKS
    public static final RegistryObject<CreativeModeTab> TABBLOCK = CREATIVE_MODE_TABS.register("forgemodmikh_blocks",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlock.POOP_BLOCK.get()))
                    .withTabsBefore(TABITEM.getId())
                    .title(Component.translatable("creativetab.forgemodmikh.BlockTab"))
                    .displayItems((itemDisplayParameters,output)->{
                        output.accept(ModBlock.POOP_BLOCK.get());
                        output.accept(ModBlock.DRIED_POOP_BLOCK.get());
                        output.accept(ModBlock.BOOM_BLOCK.get());
                    })
                    .build()
    );//----------------------------------------TOOLS
    public static final RegistryObject<CreativeModeTab> TABTOOLS = CREATIVE_MODE_TABS.register("forgemodmikh_tools",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItem.CHISELER.get()))
                    .withTabsBefore(TABBLOCK.getId())
                    .title(Component.translatable("creativetab.forgemodmikh.ItemTab"))
                    .displayItems((itemDisplayParameters,output)->{
                        output.accept(ModItem.CHISELER.get());
                    })
                    .build()
    );//----------------------------------------


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
