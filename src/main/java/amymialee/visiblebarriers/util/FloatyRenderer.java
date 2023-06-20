package amymialee.visiblebarriers.util;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;

import java.util.Random;

public class FloatyRenderer<T extends Entity> {
    private final Random random = new Random();
    public float uniqueOffset = this.random.nextFloat() * 3.1415927F * 2.0F;
    private final ItemRenderer renderer;
    private final ItemStack stack;

    public FloatyRenderer(ItemRenderer renderer, ItemStack stack) {
        this.renderer = renderer;
        this.stack = stack;
    }

    public void render(T entity, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        this.renderItem(stack, entity, g, matrixStack, vertexConsumerProvider, i);
    }

    public void renderItem(ItemStack stack, T entity, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        BakedModel bakedModel = this.renderer.getModel(stack, entity.getWorld(), null, entity.getId());
        matrixStack.translate(0.0D, entity.getHeight() / 2, 0.0D);
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotation(-((entity.age + g) * 8) / 20.0f));
        this.renderer.renderItem(stack, ModelTransformationMode.GROUND, false, matrixStack, vertexConsumerProvider, i, OverlayTexture.DEFAULT_UV, bakedModel);
        matrixStack.pop();
    }
}
