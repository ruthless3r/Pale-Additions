package net.ruthless3r.pale_additions.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.ruthless3r.pale_additions.PaleAdditions;
import net.ruthless3r.pale_additions.itemlike.ModBlocks;
import net.ruthless3r.pale_additions.itemlike.PaleBackPort;

public class ModWorldConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> PALE_AZALEA_KEY = registryKey("pale_azalea");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, PALE_AZALEA_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(PaleBackPort.PALE_OAK_LOG),
                new BendingTrunkPlacer(4, 2, 0, 3, UniformIntProvider.create(1, 2)),
                BlockStateProvider.of(ModBlocks.PALE_AZALEA_LEAVES),
                new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(2), 50),
                new TwoLayersFeatureSize(1, 0, 1)
        ).dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).forceDirt().build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(PaleAdditions.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {


        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
