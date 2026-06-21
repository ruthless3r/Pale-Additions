package net.ruthless3r.pale_additions.back_port;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import com.dannbrown.palegardenbackport.common.init.ModBlocks;
import com.dannbrown.palegardenbackport.common.init.ModItems;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class PaleGardenBP {
    public static final Block RESIN_CLUMP = Registries.BLOCK.get(new Identifier("palegardenbackport", "resin_clump"));
}
