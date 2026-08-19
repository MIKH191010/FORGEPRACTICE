package net.MIKH.forgemodmikh.item;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.block.ModBlock;
import net.MIKH.forgemodmikh.entity.ModEntities;
import net.MIKH.forgemodmikh.item.custom.ChiselItem;
import net.MIKH.forgemodmikh.item.custom.HammerItem;
import net.MIKH.forgemodmikh.item.custom.JavelinItem;
import net.MIKH.forgemodmikh.item.custom.ModArmorItem;
import net.MIKH.forgemodmikh.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItem {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ForgeModMIKH.MOD_ID);

    public static final RegistryObject<Item> POOP = ITEMS.register("poop",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MOON_FRAGMENT = ITEMS.register("moon_fragment",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MOON_COMPOUND = ITEMS.register("moon_compound",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CUCUMBER)));

    public static final RegistryObject<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds",
            () -> new ItemNameBlockItem(ModBlock.CUCUMBER_CROP.get(),new Item.Properties()));

    public static final RegistryObject<Item> CHISELER = ITEMS.register("chiseler",
            () -> new ChiselItem(new Item.Properties()
                    .durability(32)
            ));
    public static  final RegistryObject<Item> VS_LORD_FROGG_MUSIC_DISC = ITEMS.register("vs_lord_frogg_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.VS_LORD_FROGG_KEY).stacksTo(1)));

    public static final RegistryObject<Item> KNIGHT_SWORD = ITEMS.register("knight_sword",
            () -> new SwordItem(ModToolTiers.KNIGHT,new Item.Properties()
                                .attributes(SwordItem.createAttributes(ModToolTiers.KNIGHT,3,-2f))
                                ));
    public static final RegistryObject<Item> KNIGHT_PICKAXE = ITEMS.register("knight_pickaxe",
            () -> new PickaxeItem(ModToolTiers.KNIGHT,new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.KNIGHT,2,-2.5f))
            ));
    public static final RegistryObject<Item> KNIGHT_AXE = ITEMS.register("knight_axe",
            () -> new AxeItem(ModToolTiers.KNIGHT,new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.KNIGHT,6,-3f))
            ));
    public static final RegistryObject<Item> KNIGHT_SHOVEL = ITEMS.register("knight_shovel",
            () -> new ShovelItem(ModToolTiers.KNIGHT,new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.KNIGHT,1,-2.5f))
            ));
    public static final RegistryObject<Item> KNIGHT_HOE = ITEMS.register("knight_hoe",
            () -> new HoeItem(ModToolTiers.KNIGHT,new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.KNIGHT,0,-2.5f))
            ));
    public static final RegistryObject<Item> KNIGHT_HAMMER = ITEMS.register("knight_hammer",
            () -> new HammerItem(ModToolTiers.KNIGHT,new Item.Properties()
                    .attributes(HammerItem.createAttributes(ModToolTiers.KNIGHT,8,-3.5f))
            ));

    public static final RegistryObject<Item> KNIGHT_HELMET = ITEMS.register("knight_helmet",
            () -> new ModArmorItem(ModArmorMaterials.KNIGHT_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(20))));

    public static final RegistryObject<Item> KNIGHT_CHESTPLATE = ITEMS.register("knight_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.KNIGHT_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(20))));

    public static final RegistryObject<Item> KNIGHT_LEGGINGS = ITEMS.register("knight_leggings",
            () -> new ModArmorItem(ModArmorMaterials.KNIGHT_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(20))));

    public static final RegistryObject<Item> KNIGHT_BOOTS = ITEMS.register("knight_boots",
            () -> new ModArmorItem(ModArmorMaterials.KNIGHT_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(20))));

    public static final RegistryObject<Item> PHOENIX_BOW = ITEMS.register("phoenix_bow",
            () -> new BowItem(new Item.Properties().durability(500)));

    public static final RegistryObject<Item> CACI_SPAWN_EGG = ITEMS.register("caci_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CACI,0x46612c,0x222034,new Item.Properties()));

    public static final RegistryObject<Item> JAVELIN = ITEMS.register("javelin",
            ()-> new JavelinItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> STICK_DANCE = ITEMS.register("stick_dance",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
