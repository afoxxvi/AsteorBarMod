package com.afoxxvi.asteorbar.key;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final KeyMapping.Category CATEGORY = KeyMapping.Category.register(Identifier.fromNamespaceAndPath(AsteorBar.MOD_ID, "key_bindings"));

    public static final KeyMapping TOGGLE_OVERLAY = new KeyMapping("asteorbar.key.toggle_overlay", GLFW.GLFW_KEY_F8, CATEGORY);
    public static final KeyMapping TOGGLE_MOB_BAR = new KeyMapping("asteorbar.key.toggle_mob_bar", GLFW.GLFW_KEY_F10, CATEGORY);

    public static void handleKeyInput() {
        while (KeyBinding.TOGGLE_OVERLAY.consumeClick()) {
            Overlays.style = (Overlays.style + 1) % Overlays.NUM_STYLES;
            AsteorBar.config.enableOverlay(Overlays.style != 0);
            AsteorBar.config.overlayLayoutStyle(Overlays.style);
        }
        while (KeyBinding.TOGGLE_MOB_BAR.consumeClick()) {
            AsteorBar.config.enableHealthBar(!AsteorBar.config.enableHealthBar());
        }
    }
}
