// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.ruthless3r.pale_additions.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.ruthless3r.pale_additions.entity.custom.PaleCowEntity;

public class PaleCowModel<T extends PaleCowEntity> extends SinglePartEntityModel<T> {
    private final ModelPart paleCow;
	private final ModelPart head;
	private final ModelPart clump1;
	private final ModelPart body;
	private final ModelPart clumps;
	private final ModelPart clump2;
	private final ModelPart clump3;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	public PaleCowModel(ModelPart root) {
        this.paleCow = root;
		this.head = root.getChild("head");
		this.clump1 = head.getChild("clump1");
		this.body = root.getChild("body");
		this.clumps = body.getChild("clumps");
		this.clump2 = clumps.getChild("clump2");
		this.clump3 = clumps.getChild("clump3");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(22, 0).cuboid(-5.0F, -5.0F, -5.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, new Dilation(0.0F))
		.uv(22, 0).cuboid(4.0F, -5.0F, -5.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(1, 33).cuboid(-3.0F, 1.0F, -7.0F, 6.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.0F, -8.0F));

		ModelPartData clump1 = head.addChild("clump1", ModelPartBuilder.create().uv(0, 40).cuboid(-8.0F, -13.0F, 0.0F, 16.0F, 13.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 24).cuboid(0.0F, -13.0F, -8.0F, 0.0F, 13.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0F, -3.2F, 0.0F, -0.576F, 0.0F));

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(18, 4).cuboid(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, new Dilation(0.0F))
		.uv(52, 0).cuboid(-2.0F, 2.0F, -8.0F, 4.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

		ModelPartData clumps = body.addChild("clumps", ModelPartBuilder.create(), ModelTransform.of(0.0F, -5.0F, 3.0F, -1.5708F, 0.0F, 0.0F));

		ModelPartData clump2 = clumps.addChild("clump2", ModelPartBuilder.create().uv(0, 40).cuboid(-8.0F, -13.0F, 0.0F, 16.0F, 13.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 24).mirrored().cuboid(0.0F, -13.0F, -8.0F, 0.0F, 13.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.025F, 0.0F, 2.8F, 0.0F, 0.6807F, 0.0F));

		ModelPartData clump3 = clumps.addChild("clump3", ModelPartBuilder.create().uv(0, 40).cuboid(-8.0F, -13.0F, 0.0F, 16.0F, 13.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 24).cuboid(0.0F, -13.0F, -8.0F, 0.0F, 13.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(3.2F, 0.0F, 11.0F, 0.0F, -0.2269F, 0.0F));

		ModelPartData leg1 = modelPartData.addChild("leg1", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 12.0F, 7.0F));

		ModelPartData leg2 = modelPartData.addChild("leg2", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 12.0F, 7.0F));

		ModelPartData leg3 = modelPartData.addChild("leg3", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 12.0F, -6.0F));

		ModelPartData leg4 = modelPartData.addChild("leg4", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 12.0F, -6.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leg1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leg2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leg3.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leg4.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

    @Override
    public ModelPart getPart() {
        return paleCow;
    }

    // Took the lazy way out and copied the setAngle code from the quad thingy (If ever updated make sure to change this)
    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.head.pitch = headPitch * (float) (Math.PI / 180.0);
        this.head.yaw = headYaw * (float) (Math.PI / 180.0);
        this.leg1.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
        this.leg2.pitch = MathHelper.cos(limbAngle * 0.6662F + (float) Math.PI) * 1.4F * limbDistance;
        this.leg3.pitch = MathHelper.cos(limbAngle * 0.6662F + (float) Math.PI) * 1.4F * limbDistance;
        this.leg4.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
    }
}