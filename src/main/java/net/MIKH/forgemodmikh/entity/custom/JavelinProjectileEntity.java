package net.MIKH.forgemodmikh.entity.custom;

import net.MIKH.forgemodmikh.entity.ModEntities;
import net.MIKH.forgemodmikh.item.ModItem;
import net.MIKH.forgemodmikh.particle.ModParticle;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec2;

public class JavelinProjectileEntity extends AbstractArrow {
    private float rotation;
    public Vec2 groundedOffset;

    public JavelinProjectileEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public JavelinProjectileEntity(LivingEntity shooter,Level level){
        super(ModEntities.JAVELIN.get(),shooter,level,new ItemStack(ModItem.JAVELIN.get()),null);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItem.JAVELIN.get());
    }

    public float getRenderingRotation() {
        rotation += 0.5f;
        if(rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    public boolean isGrounded() {
        return inGround;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 7.5f);

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        Level level = this.level();
        if(level.isClientSide()){
            for(int i=1;i<=5;i++){
                float spreadX = ((float) level.getRandom().nextInt(-10, 10) /10) /2;
                float spreadY = ((float) level.getRandom().nextInt(-10, 10) /10) /2;
                float spreadZ = ((float) level.getRandom().nextInt(-10, 10) /10) /2;
                level.addParticle(ParticleTypes.CLOUD,
                        result.getBlockPos().getX(),result.getBlockPos().getY(),result.getBlockPos().getZ(),
                        spreadX,spreadY,spreadZ);
            }
            for(int i=1;i<=20;i++){
                float spreadX = ((float) level.getRandom().nextInt(-10, 10) /10);
                float spreadY = ((float) level.getRandom().nextInt(-10, 10) /10);
                float spreadZ = ((float) level.getRandom().nextInt(-10, 10) /10);
                level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK,level().getBlockState(result.getBlockPos())),
                        this.getX(),this.getY(),this.getZ(),
                        spreadX,spreadY,spreadZ);
            }
        }
//        else{
//            ((ServerLevel) level).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK,level().getBlockState(result.getBlockPos())),
//                    this.getX(),this.getY(),this.getZ(),10,
//                    0,0,0,
//                    1);
//            ((ServerLevel) level).sendParticles(ParticleTypes.CLOUD,
//                    this.getX(),this.getY(),this.getZ(),5,
//                    0,0,0,
//                    1);
//        }
    }
}
