package net.MIKH.forgemodmikh.item.custom;

import net.MIKH.forgemodmikh.component.ModDataComponentTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.MIKH.forgemodmikh.block.ModBlock;

import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block,Block> chiselMap =
            Map.of(
                    ModBlock.DRIED_POOP_BLOCK.get(), ModBlock.POOP_BLOCK.get()
            );


    public ChiselItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();
        if (chiselMap.containsKey(clickedBlock)){
            if (!level.isClientSide()){
                
                level.setBlockAndUpdate(pContext.getClickedPos(),chiselMap.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1,
                        ((ServerLevel) level),
                        ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
                level.playSound(null,pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);

                pContext.getItemInHand().set(ModDataComponentTypes.COORDINATES.get(),pContext.getClickedPos());
            }
        }
        return InteractionResult.SUCCESS;
    }
    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        pTooltipComponents.add(Component.translatable("tooltip.forgemikh.chiseler"));
        if (pStack.get(ModDataComponentTypes.COORDINATES.get()) != null){
            pTooltipComponents.add(
                                    Component.literal("Last block of shit scraped at: " +
                                    pStack.get(ModDataComponentTypes.COORDINATES.get()))
                                    );
        }
    }
}
