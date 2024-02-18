package com.afoxxvi.asteorbar;

import com.afoxxvi.asteorbar.config.NeoForgeConfigAdapter;
import com.afoxxvi.asteorbar.network.NetworkHandler;
import com.afoxxvi.asteorbar.utils.NeoForgePlatformAdapter;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(AsteorBar.MOD_ID)
public class AsteorBarNeoForge {
    public static final Logger LOGGER = LogUtils.getLogger();

    public AsteorBarNeoForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        NeoForge.EVENT_BUS.register(NetworkHandler.class);
        NetworkHandler.init();
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, NeoForgeConfigAdapter.Config.CONFIG);
        AsteorBar.platformAdapter = new NeoForgePlatformAdapter();
        AsteorBar.config = new NeoForgeConfigAdapter();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Enabling AsteorBar");
    }
}
