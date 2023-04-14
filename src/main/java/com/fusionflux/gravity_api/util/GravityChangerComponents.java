package com.fusionflux.gravity_api.util;

import com.fusionflux.gravity_api.GravityChangerMod;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import net.minecraft.entity.Entity;

public class GravityChangerComponents implements EntityComponentInitializer {

    public static final ComponentKey<GravityComponent> GRAVITY_MODIFIER =
            ComponentRegistry.getOrCreate(GravityChangerMod.id("gravity_direction"), GravityComponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerFor(Entity.class, GRAVITY_MODIFIER, GravityDirectionComponent::new);
    }
}
