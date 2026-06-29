package net.ruthless3r.pale_additions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.ruthless3r.pale_additions.itemlike.ModBlocks;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.GLOWING_RESIN_BLOCK);
        grassDrops(ModBlocks.PALE_GRASS);
        grassDrops(ModBlocks.PALE_BUSH);
        tallGrassDrops(ModBlocks.PALE_TALL_GRASS, ModBlocks.PALE_GRASS);
        addDrop(ModBlocks.PALE_AZALEA);
        pottedPlantDrops(ModBlocks.POTTED_PALE_AZALEA);

        dropsWithShears(ModBlocks.PALE_AZALEA_LEAVES);
    }
}
