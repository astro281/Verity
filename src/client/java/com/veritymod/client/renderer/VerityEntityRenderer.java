package com.veritymod.client.renderer;

import com.veritymod.VerityMod;
import com.veritymod.entity.VerityEntity;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class VerityEntityRenderer extends EntityRenderer<VerityEntity> {
    public VerityEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(VerityEntity entity) {
        return VerityMod.id("textures/entity/verity.png");
    }
}
