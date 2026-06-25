package net.ruthless3r.pale_additions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import net.ruthless3r.pale_additions.PaleAdditions;
import net.ruthless3r.pale_additions.init.ModBlocks;
import net.ruthless3r.pale_additions.init.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GLOWING_RESIN_BLOCK);
        blockStateModelGenerator.registerTintableCross(ModBlocks.PALE_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.PALE_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.PALE_TALL_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
//        blockStateModelGenerator.registerAzalea(ModBlocks.PALE_AZALEA);
        registerAzaleaPlant(blockStateModelGenerator, ModBlocks.PALE_AZALEA);
        blockStateModelGenerator.registerPottedAzaleaBush(ModBlocks.POTTED_PALE_AZALEA);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RESIN_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RESIN_GLAZED_PALE_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PALE_APPLE, Models.GENERATED);
    }

    //The register for azalea didn't include the plant and particle part so that's what makes this different from blockStatModelGenerator.registerAzalea()
    public final void registerAzaleaPlant(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        Model model = new Model(Optional.of(new Identifier("minecraft", "block/azalea")), Optional.empty(), TextureKey.TOP, TextureKey.SIDE, TextureKey.PLANT, TextureKey.PARTICLE);
        Identifier identifier = model.upload(block, TextureMap.sideAndTop(block).put(TextureKey.PLANT, TextureMap.getSubId(block, "_plant")).put(TextureKey.PARTICLE, TextureMap.getSubId(block, "_plant")), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, identifier));
    }

    //TODO: Make a custom datagen for potted azalea
    // I'm not sure of this, but I think the template from registerPottedAzaleaBush also suffers from the same issue as the other.
}
