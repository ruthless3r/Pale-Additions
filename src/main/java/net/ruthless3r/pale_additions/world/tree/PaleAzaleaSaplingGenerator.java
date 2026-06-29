package net.ruthless3r.pale_additions.world.tree;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.ruthless3r.pale_additions.world.ModWorldConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class PaleAzaleaSaplingGenerator extends SaplingGenerator {
    @Override
    protected @Nullable RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ModWorldConfiguredFeatures.PALE_AZALEA_KEY;
    }
}
