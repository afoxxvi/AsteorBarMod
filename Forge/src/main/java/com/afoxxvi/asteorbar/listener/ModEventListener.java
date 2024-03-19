package com.afoxxvi.asteorbar.listener;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.AsteorBarForge;
import com.afoxxvi.asteorbar.key.KeyBinding;
import com.afoxxvi.asteorbar.overlay.ForgeRenderGui;
import com.afoxxvi.asteorbar.overlay.parts.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.afoxxvi.asteorbar.overlay.Overlays.*;

@Mod.EventBusSubscriber(modid = AsteorBar.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventListener {
    @SubscribeEvent
    public static void registerOverlay(RegisterGuiOverlaysEvent event) {
        AsteorBarForge.LOGGER.info("Registering Overlays");
        event.registerBelow(VanillaGuiOverlay.PLAYER_HEALTH.id(), "player_health", new ForgeRenderGui(PLAYER_HEALTH));
        event.registerBelow(VanillaGuiOverlay.PLAYER_HEALTH.id(), "food_level", new ForgeRenderGui(FOOD_LEVEL));
        event.registerBelow(VanillaGuiOverlay.PLAYER_HEALTH.id(), "mount_health", new ForgeRenderGui(MOUNT_HEALTH));
        event.registerBelow(VanillaGuiOverlay.PLAYER_HEALTH.id(), "tough_as_nails", new ForgeRenderGui(new ToughAsNailsOverlay()));
        event.registerBelow(VanillaGuiOverlay.PLAYER_HEALTH.id(), "thirst", new ForgeRenderGui(new ThirstOverlay()));
        event.registerBelow(VanillaGuiOverlay.PLAYER_HEALTH.id(), "feathers", new ForgeRenderGui(new FeathersOverlay()));
        event.registerBelow(VanillaGuiOverlay.PLAYER_HEALTH.id(), "irons_spellbooks_mana", new ForgeRenderGui(new IronsSpellbooksOverlay()));
        event.registerBelow(VanillaGuiOverlay.PLAYER_HEALTH.id(), "parcool_stamina", new ForgeRenderGui(new ParcoolOverlay()));
        event.registerBelow(VanillaGuiOverlay.PLAYER_HEALTH.id(), "experience_bar", new ForgeRenderGui(EXPERIENCE_BAR));
        event.registerBelow(VanillaGuiOverlay.PLAYER_HEALTH.id(), "armor_level", new ForgeRenderGui(ARMOR_LEVEL));
        event.registerBelow(VanillaGuiOverlay.PLAYER_HEALTH.id(), "mekanism", new ForgeRenderGui(new MekanismOverlay()));
        event.registerBelow(VanillaGuiOverlay.AIR_LEVEL.id(), "air_level", new ForgeRenderGui(AIR_LEVEL));
        event.registerAbove(VanillaGuiOverlay.EXPERIENCE_BAR.id(), "string", new ForgeRenderGui(STRING));
    }

    @SubscribeEvent
    public static void registerKeyMapping(RegisterKeyMappingsEvent event) {
        event.register(KeyBinding.TOGGLE_OVERLAY);
        event.register(KeyBinding.TOGGLE_MOB_BAR);
    }
}
