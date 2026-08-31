package com.afoxxvi.asteorbar;

import com.afoxxvi.asteorbar.key.KeyBinding;
import com.afoxxvi.asteorbar.network.NetworkHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;

public class AsteorBarFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        NetworkHandler.initClient();
        KeyMappingHelper.registerKeyMapping(KeyBinding.TOGGLE_OVERLAY);
        KeyMappingHelper.registerKeyMapping(KeyBinding.TOGGLE_MOB_BAR);
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            KeyBinding.handleKeyInput();
        });
    }
}
