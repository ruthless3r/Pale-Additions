package net.ruthless3r.pale_additions.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.ruthless3r.pale_additions.PaleAdditions;

public class ModItemGroups {

    public static final ItemGroup PALE_ADDITIONS = Registry.register(Registries.ITEM_GROUP,

            new Identifier(PaleAdditions.MOD_ID,"pale_additions"),

            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pale_additions"))

                    .icon(() -> new ItemStack(ModBlocks.GLOWING_RESIN_CLUMP)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.GLOWING_RESIN_CLUMP);
                        entries.add(ModBlocks.GLOWING_RESIN_BLOCK);
                        entries.add(ModBlocks.PALE_BUSH);
                        entries.add(ModBlocks.PALE_GRASS);
                        entries.add(ModBlocks.PALE_TALL_GRASS);
                        entries.add(ModBlocks.PALE_AZALEA);
                        entries.add(ModItems.RESIN_NUGGET);
                        entries.add(ModItems.PALE_APPLE);
                        entries.add(ModItems.RESIN_GLAZED_PALE_APPLE);

                    }).build());

    public static void registerItemGroups() {
        PaleAdditions.LOGGER.info("Registering ItemGroups for " + PaleAdditions.MOD_ID);
    }
}
