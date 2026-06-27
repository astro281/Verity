package com.veritymod;

import com.veritymod.entity.VerityEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerityMod implements ModInitializer {
	public static final String MOD_ID = "verity-mod";

	public static final EntityType<VerityEntity> VERITY = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(MOD_ID, "verity"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, VerityEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
	);

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(VERITY, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0));

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(CommandManager.literal("verity")
					.executes(context -> {
						VerityEntity entity = VERITY.create(context.getSource().getWorld());
						if (entity != null) {
							entity.refreshPositionAndAngles(context.getSource().getPosition().x, context.getSource().getPosition().y, context.getSource().getPosition().z, context.getSource().getRotation().y, 0);
							context.getSource().getWorld().spawnEntity(entity);
							context.getSource().sendFeedback(() -> Text.literal("Verity spawned!"), false);
						}
						return 1;
					}));
		});

		LOGGER.info("Verity mod initialized!");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
