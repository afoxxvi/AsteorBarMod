package com.afoxxvi.asteorbar.overlay;

public class NeoforgeGuiRegistry {
    private NeoforgeGuiRegistry() {
    }

    private static boolean initialized = false;

    public static void init() {
        if (initialized) return;
        initialized = true;
    }
}
