package com.fusionflux.gravity_api;

import com.fusionflux.gravity_api.command.GravityCommand;
import com.fusionflux.gravity_api.config.GravityChangerConfig;
import com.fusionflux.gravity_api.config.MidnightConfig;
import com.fusionflux.gravity_api.item.ModItems;
import com.fusionflux.gravity_api.util.GravityChannel;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.command.api.CommandRegistrationCallback;

import java.util.Map;

public class GravityChangerMod implements ModInitializer {
    public static final String MOD_ID = "gravity_api";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final ItemGroup GravityChangerGroup = FabricItemGroup.builder(id("general")).icon(() -> new ItemStack(ModItems.GRAVITY_CHANGER_UP)).entries((displayParameters, itemStackCollector) -> {
        Registries.ITEM.getEntries().stream().filter(entry -> entry.getKey().getValue().getNamespace().equals(MOD_ID)).map(Map.Entry::getValue).forEach(itemStackCollector::addItem);
    }).build();

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize(ModContainer mod) {
        MidnightConfig.init(GravityChangerMod.MOD_ID, GravityChangerConfig.class);
        ModItems.init();
        GravityChannel.initServer();
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> GravityCommand.register(dispatcher));

    }
}
