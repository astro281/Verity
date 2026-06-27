package com.veritymod.client;

import com.veritymod.VerityMod;
import com.veritymod.client.renderer.VerityEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class VerityModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(VerityMod.VERITY, VerityEntityRenderer::new);
	}
}
