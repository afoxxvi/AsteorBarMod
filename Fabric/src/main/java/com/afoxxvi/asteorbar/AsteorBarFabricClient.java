package com.afoxxvi.asteorbar;

import com.afoxxvi.asteorbar.key.KeyBinding;
import com.afoxxvi.asteorbar.network.NetworkHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

public class AsteorBarFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        NetworkHandler.init();
        KeyBindingHelper.registerKeyBinding(KeyBinding.TOGGLE_OVERLAY);
        KeyBindingHelper.registerKeyBinding(KeyBinding.TOGGLE_MOB_BAR);
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            KeyBinding.handleKeyInput();
        });
    }
}
