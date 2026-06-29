package net.ruthless3r.pale_additions.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.ruthless3r.pale_additions.entity.custom.PaleCowEntity;
import net.ruthless3r.pale_additions.PaleAdditions;

public class ModEntities {
    public static final EntityType<PaleCowEntity> PALE_COW = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(PaleAdditions.MOD_ID, "pale_cow"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PaleCowEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());
}
