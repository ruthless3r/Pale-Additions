package net.ruthless3r.pale_additions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.ruthless3r.pale_additions.itemlike.PaleBackPort;
import net.ruthless3r.pale_additions.itemlike.ModBlocks;
import net.ruthless3r.pale_additions.itemlike.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLOWING_RESIN_CLUMP,
                RecipeCategory.DECORATIONS, ModBlocks.GLOWING_RESIN_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GLOWING_RESIN_CLUMP)
                .input(ModItems.RESIN_NUGGET, 3)
                .input(Items.GLOWSTONE_DUST)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(ModItems.RESIN_NUGGET), conditionsFromItem(ModItems.RESIN_NUGGET))
                .offerTo(exporter, new Identifier("pale_additions:glowing_resin_clump_from_resin_nuggets_and_glowstone_dust"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, PaleBackPort.RESIN_CLUMP)
                .input(ModItems.RESIN_NUGGET, 4)
                .criterion(hasItem(ModItems.RESIN_NUGGET), conditionsFromItem(ModItems.RESIN_NUGGET))
                .offerTo(exporter, new Identifier("pale_additions:resin_clump_from_resin_nuggets"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RESIN_NUGGET, 4)
                .input(PaleBackPort.RESIN_CLUMP)
                .criterion(hasItem(PaleBackPort.RESIN_CLUMP), conditionsFromItem(PaleBackPort.RESIN_CLUMP))
                .offerTo(exporter, new Identifier("pale_additions:resin_nuggets_from_resin_clump"));
    }
}
