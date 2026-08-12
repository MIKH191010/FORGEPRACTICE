package net.MIKH.forgemodmikh.block.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BoomBlock extends Block {
    public BoomBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void onProjectileHit(Level pLevel, BlockState pState, BlockHitResult pHit, Projectile pProjectile) {
        super.onProjectileHit(pLevel, pState, pHit, pProjectile);
        Level level = pLevel;
        if (!level.isClientSide() && pProjectile instanceof Arrow) {
            level.explode(pProjectile,
                    pHit.getBlockPos().getX(),
                    pHit.getBlockPos().getY()
                    ,pHit.getBlockPos().getZ(),
                    6f, Level.ExplosionInteraction.NONE);
            level.playSound(null,pHit.getBlockPos(), SoundEvents.BEACON_ACTIVATE, SoundSource.BLOCKS);
        }
    }
}
