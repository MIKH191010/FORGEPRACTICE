package net.MIKH.forgemodmikh.event;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.item.ModItem;
import net.MIKH.forgemodmikh.item.custom.HammerItem;
import net.MIKH.forgemodmikh.potion.ModPotions;
import net.MIKH.forgemodmikh.villager.ModVillagers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.brewing.BrewingRecipeRegisterEvent;
import net.minecraftforge.event.brewing.PotionBrewEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = ForgeModMIKH.MOD_ID,bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCK = new HashSet<>();
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();
        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer){
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCK.contains(initialBlockPos)){
                return;
            }

            for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(1,initialBlockPos,serverPlayer)){
                if(pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem,event.getLevel().getBlockState(pos))){
                    continue;
                }
                HARVESTED_BLOCK.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCK.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(BrewingRecipeRegisterEvent event){
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, Items.PISTON, ModPotions.SPRING_LEGS_POTION.getHolder().get());
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){

        if (event.getType() == ModVillagers.DISCORDMOD.get()){
            var trades = event.getTrades();
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD,5),
                    new ItemStack(ModItem.POOP.get(),10),6,4,0.05f));
        }

    }

//    @SubscribeEvent
//    public static void addWanderingTrades(WandererTradesEvent event) {
//        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
//        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();
//
//        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
//                new ItemCost(Items.EMERALD, 12),
//                new ItemStack(ModItem.STICK_DANCE.get(), 1), 1, 10, 0.2f
//        ));
//
//        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
//                new ItemCost(Items.NETHERITE_INGOT, 8),
//                new ItemStack(ModItem.VS_LORD_FROGG_MUSIC_DISC.get(), 1), 1, 10, 0.2f
//        ));
//    }

}
