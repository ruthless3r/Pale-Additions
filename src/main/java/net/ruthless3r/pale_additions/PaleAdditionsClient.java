package net.ruthless3r.pale_additions;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.ruthless3r.pale_additions.init.ModBlocks;

public class PaleAdditionsClient  implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        //I'm not sure how to properly make the cutouts work when datagening ._.

        //Also, for some reason "minecraft:block/resin_clump" has a translucent render type that doesn't seem to work,
        //so I'm brute forcing the render type to cutout for Glowing Resin Clump
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.GLOWING_RESIN_BLOCK,
                ModBlocks.PALE_BUSH,
                ModBlocks.PALE_GRASS,
                ModBlocks.PALE_TALL_GRASS,
                ModBlocks.PALE_AZALEA,
                ModBlocks.POTTED_PALE_AZALEA);
    }
}
