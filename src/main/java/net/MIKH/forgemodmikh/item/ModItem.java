package net.MIKH.forgemodmikh.item;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.item.custom.ChiselItem;
import net.MIKH.forgemodmikh.item.custom.HammerItem;
import net.MIKH.forgemodmikh.item.custom.ModArmorItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItem {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ForgeModMIKH.MOD_ID);

    public static final RegistryObject<Item> POOP = ITEMS.register("poop",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHISELER = ITEMS.register("chiseler",
            () -> new ChiselItem(new Item.Properties()
                    .durability(32)
            ));

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

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
