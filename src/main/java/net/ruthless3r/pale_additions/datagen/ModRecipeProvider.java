package net.ruthless3r.pale_additions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.ruthless3r.pale_additions.back_port.PaleGardenBP;
import net.ruthless3r.pale_additions.block.ModBlocks;
import net.ruthless3r.pale_additions.item.ModItems;

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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, PaleGardenBP.RESIN_CLUMP)
                .input(ModItems.RESIN_NUGGET, 4)
                .criterion(hasItem(ModItems.RESIN_NUGGET), conditionsFromItem(ModItems.RESIN_NUGGET))
                .offerTo(exporter, new Identifier("pale_additions:resin_clump_from_resin_nuggets"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RESIN_NUGGET, 4)
                .input(PaleGardenBP.RESIN_CLUMP)
                .criterion(hasItem(PaleGardenBP.RESIN_CLUMP), conditionsFromItem(PaleGardenBP.RESIN_CLUMP))
                .offerTo(exporter, new Identifier("pale_additions:resin_nuggets_from_resin_clump"));
    }
}
