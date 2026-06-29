package net.ruthless3r.pale_additions;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.ruthless3r.pale_additions.entity.ModEntities;
import net.ruthless3r.pale_additions.entity.custom.PaleCowEntity;
import net.ruthless3r.pale_additions.itemlike.ModBlocks;
import net.ruthless3r.pale_additions.itemlike.ModItemGroups;
import net.ruthless3r.pale_additions.itemlike.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaleAdditions implements ModInitializer {
	public static final String MOD_ID = "pale_additions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();

		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		FabricDefaultAttributeRegistry.register(ModEntities.PALE_COW, PaleCowEntity.createPaleCowAttributes());
	}
}