package net.ruthless3r.pale_additions.block;

import com.dannbrown.palegardenbackport.common.content.blocks.ResinClumpBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;import net.minecraft.block.Block;
import net.minecraft.block.Blocks;import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.ruthless3r.pale_additions.PaleAdditions;
import net.ruthless3r.pale_additions.back_port.PaleGardenBP;


public class ModBlocks {

    // Use our wrapper to ensure deterministic outline/collision shapes
    public static final Block GLOWING_RESIN_CLUMP = registerBlock("glowing_resin_clump", new ResinClumpBlock(FabricBlockSettings.copyOf(PaleGardenBP.RESIN_CLUMP)
                    .luminance(10)
                    .nonOpaque()
                    .strength(0.5f)
    ));

    public static final Block GLOWING_RESIN_BLOCK = registerBlock("glowing_resin_block", new Block(FabricBlockSettings.copyOf(Blocks.GLOWSTONE)));

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