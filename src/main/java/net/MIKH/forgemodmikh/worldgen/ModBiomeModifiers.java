package net.MIKH.forgemodmikh.worldgen;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.entity.ModEntities;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_MOON_ORE = registerKey("add_moon_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_MOON_ORE = registerKey("add_nether_moon_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_MOON_ORE = registerKey("add_end_moon_ore");

    public static final ResourceKey<BiomeModifier> ADD_MAPLE_TREE = registerKey("add_maple_tree");

    public static final ResourceKey<BiomeModifier> SPAWN_CACI = registerKey("spawn_caci");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

//INDIVIDUAL BIOMES
//       context.register(ADD_MOON_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
//                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS),biomes.getOrThrow(Biomes.BAMBOO_JUNGLE),...),
//                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.MOON_ORE_PLACED_KEY)),
//                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_MOON_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.MOON_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_NETHER_MOON_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.NETHER_MOON_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_END_MOON_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.END_MOON_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));


        context.register(ADD_MAPLE_TREE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS),biomes.getOrThrow(Biomes.SAVANNA)),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.MAPLE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));


        context.register(SPAWN_CACI,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.DESERT),biomes.getOrThrow(Biomes.BADLANDS)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.CACI.get(),50,3,5))
        ));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(ForgeModMIKH.MOD_ID, name));
    }
}