package com.afoxxvi.asteorbar.listener;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.key.KeyBinding;
import com.afoxxvi.asteorbar.overlay.Overlays;
import dev.ghen.thirst.foundation.gui.ThirstBarRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import toughasnails.thirst.ThirstOverlayHandler;

@Mod.EventBusSubscriber(modid = AsteorBar.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeEventListener {
    public static long tickCount = 0L;
    private static Object mekasuitEnergyLevel;
    public static final ResourceLocation TOUGH_AS_NAILS_THIRST_LEVEL = new ResourceLocation("toughasnails", "thirst_level");
    public static final ResourceLocation THIRST_THIRST_LEVEL = new ResourceLocation("thirst", "thirst_level");
    public static final ResourceLocation MEKANISM_ENERGY_LEVEL = new ResourceLocation("mekanism", "mekasuit_energy_level");
    public static final ResourceLocation PARCOOL_STAMINA = new ResourceLocation("parcool", "hud.stamina.host");
    public static final ResourceLocation IRONS_SPELLBOOKS_MANA = new ResourceLocation("irons_spellbooks", "mana_overlay");
    public static final ResourceLocation FEATHERS_FEATHERS = new ResourceLocation("feathers", "feathers");
    public static final ResourceLocation VAMPIRISM_BLOOD = new ResourceLocation("vampirism", "blood_bar");
    public static final ResourceLocation SUPERIOR_SHIELDS_SHIELD = new ResourceLocation("superiorshields", "superior_shield_overlay");

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (!Minecraft.getInstance().isPaused()) {
            tickCount++;
        }
    }

    @SubscribeEvent
    public static void onRenderPre(RenderGameOverlayEvent.Pre event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            if (!ModEventListener.registerOverlay) ModEventListener.registerOverlays();
        }
    }

    @SubscribeEvent
    public static void disableVanillaOverlays(RenderGameOverlayEvent.PreLayer event) {
        if (!AsteorBar.config.enableOverlay()) return;
        var overlay = event.getOverlay();
        if (overlay == ForgeIngameGui.VIGNETTE_ELEMENT) {
            Overlays.reset();
        }
        if (mekasuitEnergyLevel == null && Overlays.mekanism && overlay.getClass().getSimpleName().equals("MekaSuitEnergyLevel")) {
            mekasuitEnergyLevel = overlay;
        }
        if (overlay == ForgeIngameGui.PLAYER_HEALTH_ELEMENT
                || overlay == ForgeIngameGui.FOOD_LEVEL_ELEMENT
                || overlay == ForgeIngameGui.AIR_LEVEL_ELEMENT
                || (AsteorBar.config.overwriteVanillaExperienceBar() && overlay == ForgeIngameGui.EXPERIENCE_BAR_ELEMENT)
                || overlay == ForgeIngameGui.MOUNT_HEALTH_ELEMENT
                || (AsteorBar.config.overwriteVanillaArmorBar() && overlay == ForgeIngameGui.ARMOR_LEVEL_ELEMENT)
                || Overlays.toughAsNails && AsteorBar.config.hookToughAsNails() && overlay == ThirstOverlayHandler.THIRST_LEVEL_ELEMENT
                || Overlays.thirst && AsteorBar.config.hookThirstWasTaken() && overlay == ThirstBarRenderer.THIRST_OVERLAY
                || Overlays.mekanism && AsteorBar.config.hookMekanism() && overlay == mekasuitEnergyLevel
                || Overlays.parcool && AsteorBar.config.hookParcool() && overlay.id().equals(PARCOOL_STAMINA)
                || Overlays.ironsSpellbooks && AsteorBar.config.hookIronsSpellbooks() && overlay.id().equals(IRONS_SPELLBOOKS_MANA)
                || Overlays.feathers && AsteorBar.config.hookFeathers() && overlay.id().equals(FEATHERS_FEATHERS)
                || Overlays.vampirism && AsteorBar.config.hookVampirism() && overlay.id().equals(VAMPIRISM_BLOOD)
                || Overlays.superiorshields && AsteorBar.config.hookSuperiorShields() && overlay.id().equals(SUPERIOR_SHIELDS_SHIELD)
        ) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void handleKeyInput(InputEvent.KeyInputEvent event) {
        KeyBinding.handleKeyInput();
    }
}
