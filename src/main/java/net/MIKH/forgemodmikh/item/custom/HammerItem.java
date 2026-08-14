package net.MIKH.forgemodmikh.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends DiggerItem {
    public HammerItem(Tier pTier, Properties pProperties) {
        super(pTier, BlockTags.MINEABLE_WITH_PICKAXE, pProperties);
    }


    public static List<BlockPos> getBlocksToBeDestroyed(int range , BlockPos initialBlockPos , ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();
        //GET BLOCKS
        BlockHitResult traceResult = player.level().clip(new ClipContext(player.getEyePosition(1f),
                (player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f))),
                ClipContext.Block.COLLIDER,ClipContext.Fluid.NONE,player));
        if (traceResult.getType() == HitResult.Type.MISS){
            return positions;
        }
        //GET BLOCK IN A 3X3 WHEN PLAYER LOOKS UP OR DOWN
        if (traceResult.getDirection() == Direction.DOWN || traceResult.getDirection() == Direction.UP){
            for (int x = -range;x<=range;x++){
                for (int y = -range;y<=range;y++){
                    positions.add(new BlockPos(initialBlockPos.getX()+x, initialBlockPos.getY(), initialBlockPos.getZ()+y));
                }
            }
        }
        //GET BLOCK IN A 3X3 WHEN PLAYER LOOKS WEST OR EAST
        if (traceResult.getDirection() == Direction.WEST || traceResult.getDirection() == Direction.EAST){
            for (int x = -range;x<=range;x++){
                for (int y = -range;y<=range;y++){
                    positions.add(new BlockPos(initialBlockPos.getX(), initialBlockPos.getY()+y, initialBlockPos.getZ()+x));
                }
            }
        }
        //GET BLOCK IN A 3X3 WHEN PLAYER LOOKS NORTH OR SOUTH
        if (traceResult.getDirection() == Direction.NORTH || traceResult.getDirection() == Direction.SOUTH){
            for (int x = -range;x<=range;x++){
                for (int y = -range;y<=range;y++){
                    positions.add(new BlockPos(initialBlockPos.getX()+x, initialBlockPos.getY()+y, initialBlockPos.getZ()));
                }
            }
        }

        return positions;
    };
}
