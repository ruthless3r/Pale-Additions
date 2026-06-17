package net.ruthless3r.pale_additions;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.ruthless3r.pale_additions.datagen.ModBlockTagProvider;
import net.ruthless3r.pale_additions.datagen.ModItemTagProvider;
import net.ruthless3r.pale_additions.datagen.ModLootTableProvider;
import net.ruthless3r.pale_additions.datagen.ModModelProvider;
import net.ruthless3r.pale_additions.datagen.ModRecipeProvider;

public class PaleAdditionsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
