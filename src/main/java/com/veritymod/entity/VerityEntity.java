package com.veritymod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathAwareEntity;
import net.minecraft.world.level.World;

public class VerityEntity extends PathAwareEntity {
    public VerityEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
}
