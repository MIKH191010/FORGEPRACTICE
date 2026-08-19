package net.MIKH.forgemodmikh.particle;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticle {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES,
            ForgeModMIKH.MOD_ID);

    public static final RegistryObject<SimpleParticleType> POOP_PARTICLES = PARTICLE_TYPES.register("poop_particles",
            () -> new SimpleParticleType(true));


    public static void register(IEventBus eventBus){
        PARTICLE_TYPES.register(eventBus);
    }
}
