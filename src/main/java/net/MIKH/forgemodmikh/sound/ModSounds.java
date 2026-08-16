package net.MIKH.forgemodmikh.sound;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(
            ForgeRegistries.SOUND_EVENTS, ForgeModMIKH.MOD_ID);

    public static final RegistryObject<SoundEvent> CHISEL_USE = registerSoundEvent("chisel_use");

    public static final RegistryObject<SoundEvent> VS_LORD_FROGG = registerSoundEvent("vs_lord_frogg");
    public static final ResourceKey<JukeboxSong> VS_LORD_FROGG_KEY = ResourceKey.create(Registries.JUKEBOX_SONG,
            ResourceLocation.fromNamespaceAndPath(ForgeModMIKH.MOD_ID,"vs_lord_frogg"));

    public static final RegistryObject<SoundEvent> VOID_BLOCK_BREAK = registerSoundEvent("void_block_break");
    public static final RegistryObject<SoundEvent> VOID_BLOCK_STEP = registerSoundEvent("void_block_step");
    public static final RegistryObject<SoundEvent> VOID_BLOCK_PLACE = registerSoundEvent("void_block_place");
    public static final RegistryObject<SoundEvent> VOID_BLOCK_HIT = registerSoundEvent("void_block_hit");
    public static final RegistryObject<SoundEvent> VOID_BLOCK_FALL = registerSoundEvent("void_block_fall");

    public static final ForgeSoundType VOID_BLOCK_SOUNDS = new ForgeSoundType(1f,1f,
            ModSounds.VOID_BLOCK_BREAK,ModSounds.VOID_BLOCK_STEP,ModSounds.VOID_BLOCK_PLACE,
            ModSounds.VOID_BLOCK_HIT,ModSounds.VOID_BLOCK_FALL);


    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name,() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(ForgeModMIKH.MOD_ID,name)));
    }
    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
