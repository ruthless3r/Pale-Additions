package net.ruthless3r.pale_additions;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.ruthless3r.pale_additions.block.ModBlocks;

public class PaleAdditionsClient  implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLOWING_RESIN_CLUMP, RenderLayer.getCutout());
    }
}
