package net.ruthless3r.pale_additions.itemlike;

import com.dannbrown.palegardenbackport.common.content.blocks.ResinClumpBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.util.Identifier;
import net.ruthless3r.pale_additions.PaleAdditions;
import net.ruthless3r.pale_additions.itemlike.custom.PaleAzaleaBlock;


public class ModBlocks {

    // Use our wrapper to ensure deterministic outline/collision shapes
    public static final Block GLOWING_RESIN_CLUMP = registerBlock("glowing_resin_clump", new ResinClumpBlock(FabricBlockSettings.copyOf(PaleBackPort.RESIN_CLUMP)
                    .luminance(10)
                    .nonOpaque()
    ));

    public static final Block GLOWING_RESIN_BLOCK = registerBlock("glowing_resin_block", new Block(FabricBlockSettings.copyOf(PaleBackPort.RESIN_BLOCK)
                    .luminance(10)
    ));

    public static final Block PALE_GRASS = registerBlock("pale_grass", new GrassBlock(FabricBlockSettings.copyOf(Blocks.GRASS)));

    public static final Block PALE_TALL_GRASS = registerBlock("pale_tall_grass", new TallPlantBlock(FabricBlockSettings.copyOf(Blocks.TALL_GRASS)));

    public static final Block PALE_BUSH = registerBlock("pale_bush", new GrassBlock(FabricBlockSettings.copyOf(Blocks.GRASS)));

    public static final Block PALE_AZALEA = registerBlock("pale_azalea", new PaleAzaleaBlock(FabricBlockSettings.copyOf(Blocks.AZALEA)));
    public static final Block POTTED_PALE_AZALEA = registerBlock("potted_pale_azalea", Blocks.createFlowerPotBlock(PALE_AZALEA, new FeatureFlag[0]));

    public static final Block PALE_AZALEA_LEAVES = registerBlock("pale_azalea_leaves", new LeavesBlock(FabricBlockSettings.copyOf(PaleBackPort.PALE_OAK_LEAVES)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(PaleAdditions.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(PaleAdditions.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        PaleAdditions.LOGGER.info("Registering ModBlocks for " + PaleAdditions.MOD_ID);
    }
}