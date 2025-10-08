package com.afoxxvi.asteorbar;

import com.afoxxvi.asteorbar.config.ForgeConfigAdapter;
import com.afoxxvi.asteorbar.network.NetworkHandler;
import com.afoxxvi.asteorbar.utils.ForgePlatformAdapter;
import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(AsteorBar.MOD_ID)
public class AsteorBarForge {
    public static final Logger LOGGER = LogUtils.getLogger();

    public AsteorBarForge(FMLJavaModLoadingContext context) {
        var modBusGroup = context.getModBusGroup();
        FMLCommonSetupEvent.getBus(modBusGroup).addListener(this::commonSetup);
        NetworkHandler.init();
        context.registerConfig(ModConfig.Type.CLIENT, ForgeConfigAdapter.Config.CONFIG);
        AsteorBar.platformAdapter = new ForgePlatformAdapter();
        AsteorBar.config = new ForgeConfigAdapter();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Enabling AsteorBar");
    }
}
