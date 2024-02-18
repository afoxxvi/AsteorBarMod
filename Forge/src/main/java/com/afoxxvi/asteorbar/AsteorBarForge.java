package com.afoxxvi.asteorbar;

import com.afoxxvi.asteorbar.config.ForgeConfigAdapter;
import com.afoxxvi.asteorbar.network.NetworkHandler;
import com.afoxxvi.asteorbar.utils.ForgePlatformAdapter;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(AsteorBar.MOD_ID)
public class AsteorBarForge {
    public static final Logger LOGGER = LogUtils.getLogger();

    public AsteorBarForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(NetworkHandler.class);
        NetworkHandler.init();
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ForgeConfigAdapter.Config.CONFIG);
        AsteorBar.platformAdapter = new ForgePlatformAdapter();
        AsteorBar.config = new ForgeConfigAdapter();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Enabling AsteorBar");
    }
}
