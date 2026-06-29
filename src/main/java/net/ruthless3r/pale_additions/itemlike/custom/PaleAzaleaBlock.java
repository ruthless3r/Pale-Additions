package net.ruthless3r.pale_additions.itemlike.custom;

import net.minecraft.block.AzaleaBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.sapling.AzaleaSaplingGenerator;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.ruthless3r.pale_additions.world.tree.PaleAzaleaSaplingGenerator;

public class PaleAzaleaBlock extends AzaleaBlock implements Fertilizable {
    private static final PaleAzaleaSaplingGenerator GENERATOR = new PaleAzaleaSaplingGenerator();

    public PaleAzaleaBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        GENERATOR.generate(world, world.getChunkManager().getChunkGenerator(), pos, state, random);
    }
}
