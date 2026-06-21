package net.ruthless3r.pale_additions.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.ruthless3r.pale_additions.PaleAdditions;
import net.ruthless3r.pale_additions.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup PALE_ADDITIONS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PaleAdditions.MOD_ID,"pale_additions"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pale_additions"))
                    .icon(() -> new ItemStack(ModBlocks.GLOWING_RESIN_CLUMP)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.GLOWING_RESIN_CLUMP);
                        entries.add(ModBlocks.GLOWING_RESIN_BLOCK);
                        entries.add(ModItems.RESIN_NUGGET);
                    }).build());

    public static void registerItemGroups() {
        PaleAdditions.LOGGER.info("Registering ItemGroups for " + PaleAdditions.MOD_ID);
    }
}
