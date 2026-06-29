package net.ruthless3r.pale_additions.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.ruthless3r.pale_additions.entity.custom.PaleCowEntity;

public class PaleCowEntityRenderer extends MobEntityRenderer<PaleCowEntity, PaleCowModel<PaleCowEntity>> {
    private static final Identifier[] TEXTURES = {
            new Identifier("pale_additions", "textures/entity/pale_cow/pale_cow_stage_0.png"),
            new Identifier("pale_additions", "textures/entity/pale_cow/pale_cow_stage_1.png"),
            new Identifier("pale_additions", "textures/entity/pale_cow/pale_cow_stage_2.png"),
            new Identifier("pale_additions", "textures/entity/pale_cow/pale_cow_stage_3.png")
    };

    public PaleCowEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new PaleCowModel<>(context.getPart(ModModelLayers.PALE_COW)), 0.7f);
    }

    @Override
    public Identifier getTexture(PaleCowEntity entity) {
        return TEXTURES[entity.getClumpStage()];
    }

    @Override
    public void render(PaleCowEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
