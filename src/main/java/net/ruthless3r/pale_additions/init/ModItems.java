package net.ruthless3r.pale_additions.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.ruthless3r.pale_additions.PaleAdditions;

public class ModItems {

    public static final Item RESIN_NUGGET = registerItem("resin_nugget", new Item(new FabricItemSettings()));

    public static final Item PALE_APPLE = registerItem("pale_apple", new Item(new FabricItemSettings().food(
            new FoodComponent.Builder().hunger(5).saturationModifier(0.7f).build()
    )));

    public static final Item RESIN_GLAZED_PALE_APPLE = registerItem("resin_glazed_pale_apple", new Item(new FabricItemSettings().food(
            new FoodComponent.Builder().hunger(7).saturationModifier(3.0f).alwaysEdible().build()
    )));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PaleAdditions.MOD_ID, name), item);
    }

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(RESIN_NUGGET);
    }


    public static void registerModItems() {
        PaleAdditions.LOGGER.info("Registering ModItems for " + PaleAdditions.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
