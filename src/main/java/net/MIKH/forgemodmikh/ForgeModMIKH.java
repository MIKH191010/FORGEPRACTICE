package net.MIKH.forgemodmikh;

import com.mojang.logging.LogUtils;
import net.MIKH.forgemodmikh.block.ModBlock;
import net.MIKH.forgemodmikh.component.ModDataComponentTypes;
import net.MIKH.forgemodmikh.effect.ModEffects;
import net.MIKH.forgemodmikh.enchantment.ModEnchantmentEffects;
import net.MIKH.forgemodmikh.item.ModCreativeModeTab;
import net.MIKH.forgemodmikh.item.ModItem;
import net.MIKH.forgemodmikh.potion.ModPotions;
import net.MIKH.forgemodmikh.sound.ModSounds;
import net.MIKH.forgemodmikh.util.ModItemProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ForgeModMIKH.MOD_ID)
public class ForgeModMIKH
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "forgemodmikh";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public ForgeModMIKH(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);



//-----------------------------------------------------
        ModCreativeModeTab.register(modEventBus);

        ModItem.register(modEventBus);
        ModBlock.register(modEventBus);

        ModDataComponentTypes.register(modEventBus);

        ModSounds.register(modEventBus);

        ModEffects.register(modEventBus);

        ModPotions.register(modEventBus);

        ModEnchantmentEffects.register(modEventBus);
//-----------------------------------------------------


        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() ->{
            ComposterBlock.COMPOSTABLES.put(ModItem.CUCUMBER.get(),0.4f);
            ComposterBlock.COMPOSTABLES.put(ModItem.CUCUMBER_SEEDS.get(),0.2f);
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItem.POOP);
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItem.CHISELER);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlock.POOP_BLOCK);
            event.accept(ModBlock.DRIED_POOP_BLOCK);
            event.accept(ModBlock.VOID_BLOCK);
        }
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlock.BOOM_BLOCK);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ModItemProperties.addCustomItemProperties();
        }
    }
}
