package net.ruthless3r.pale_additions.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.ruthless3r.pale_additions.PaleAdditions;

public class ModModelLayers {
    public static final EntityModelLayer PALE_COW =
            new EntityModelLayer(new Identifier(PaleAdditions.MOD_ID, "pale_cow"), "main");
}
