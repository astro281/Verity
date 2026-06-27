package com.veritymod;

import com.veritymod.entity.VerityEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.Commands;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.Mob;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerityMod implements ModInitializer {
	public static final String MOD_ID = "verity-mod";

	public static final EntityType<VerityEntity> VERITY = Registry.register(
			BuiltInRegistries.ENTITY_TYPE,
			ResourceLocation.fromNamespaceAndPath(MOD_ID, "verity"),
			FabricEntityTypeBuilder.create(MobCategory.CREATURE, VerityEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
	);

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(VERITY, Mob.createMobAttributes());

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(Commands.literal("verity")
					.executes(context -> {
						VerityEntity entity = VERITY.create(context.getSource().getLevel());
						if (entity != null) {
							entity.moveTo(context.getSource().getPosition().x, context.getSource().getPosition().y, context.getSource().getPosition().z, context.getSource().getRotation().y, 0);
							context.getSource().getLevel().addFreshEntity(entity);
							context.getSource().sendSuccess(() -> Component.literal("Verity spawned!"), false);
						}
						return 1;
					}));
		});

		LOGGER.info("Verity mod initialized!");
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}
