package com.afoxxvi.asteorbar;

import com.afoxxvi.asteorbar.config.FabricConfigAdapter;
import com.afoxxvi.asteorbar.utils.FabricPlatformAdapter;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsteorBarFabric implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(AsteorBar.MOD_NAME);

    @Override
    public void onInitialize() {
        FabricConfigAdapter.init();
        AsteorBar.config = new FabricConfigAdapter();
        AsteorBar.platformAdapter = new FabricPlatformAdapter();
    }
}
