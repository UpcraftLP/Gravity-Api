package com.fusionflux.gravity_api;

import com.fusionflux.gravity_api.util.GravityChannel;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class ClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient(ModContainer mod) {
        GravityChannel.initClient();
    }
}
