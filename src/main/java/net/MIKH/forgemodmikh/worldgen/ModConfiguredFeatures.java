package net.MIKH.forgemodmikh.worldgen;

import net.MIKH.forgemodmikh.ForgeModMIKH;
import net.MIKH.forgemodmikh.block.ModBlock;
import net.MIKH.forgemodmikh.util.ModTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_MOON_ORE_KEY = registerKey("moon_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> NETHER_MOON_ORE_KEY = registerKey("nether_moon_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> END_MOON_ORE_KEY = registerKey("end_moon_ore");

    public static final ResourceKey<ConfiguredFeature<?,?>> MAPLE_KEY = registerKey("maple");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceable = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceable = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldMoonOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlock.MOON_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlock.MOON_DEEPSLATE_ORE.get().defaultBlockState())
        );

        register(context,OVERWORLD_MOON_ORE_KEY,Feature.ORE,new OreConfiguration(overworldMoonOres,9));

        register(context,NETHER_MOON_ORE_KEY,Feature.ORE,new OreConfiguration(
                netherrackReplaceable,ModBlock.MOON_NETHER_ORE.get().defaultBlockState(), 9));

        register(context,END_MOON_ORE_KEY,Feature.ORE,new OreConfiguration(
                endReplaceable,ModBlock.MOON_END_ORE.get().defaultBlockState(), 9));

        register(context,MAPLE_KEY,Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlock.MAPLE_LOG.get()),
                new ForkingTrunkPlacer(4,4,3),

                BlockStateProvider.simple(ModBlock.MAPLE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3),ConstantInt.of(3),3),

               new  TwoLayersFeatureSize(1,0,2)      ).build()
        );

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ForgeModMIKH.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
