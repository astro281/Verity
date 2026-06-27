package com.veritymod.client.renderer;

import com.veritymod.VerityMod;
import com.veritymod.entity.VerityEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class VerityEntityRenderer extends EntityRenderer<VerityEntity> {
    public VerityEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(VerityEntity entity) {
        return VerityMod.id("textures/entity/verity.png");
    }
}
