package com.afoxxvi.asteorbar.listener;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.entity.LightShieldRenderer;
import com.afoxxvi.asteorbar.key.KeyBinding;
import com.afoxxvi.asteorbar.overlay.ForgeGuiRegistry;
import com.afoxxvi.asteorbar.overlay.Overlays;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.NamedGuiOverlay;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AsteorBar.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeEventListener {
    public static long tickCount = 0L;
    public static final ResourceLocation TOUGH_AS_NAILS_THIRST_LEVEL = new ResourceLocation("toughasnails", "thirst_level");
    public static final ResourceLocation THIRST_THIRST_LEVEL = new ResourceLocation("thirst", "thirst_level");
    public static final ResourceLocation MEKANISM_ENERGY_LEVEL = new ResourceLocation("mekanism", "energy_level");
    public static final ResourceLocation PARCOOL_STAMINA = new ResourceLocation("parcool", "hud.stamina.host");
    public static final ResourceLocation IRONS_SPELLBOOKS_MANA = new ResourceLocation("irons_spellbooks", "mana_overlay");
    public static final ResourceLocation FEATHERS_FEATHERS = new ResourceLocation("feathers", "feathers");
    public static final ResourceLocation VAMPIRISM_BLOOD = new ResourceLocation("vampirism", "blood_bar");
    public static final ResourceLocation SUPERIOR_SHIELDS_SHIELD = new ResourceLocation("superiorshields", "superior_shield_overlay");
    public static final ResourceLocation HOMEOSTATIC_WATER = new ResourceLocation("homeostatic", "water_level");
    public static final ResourceLocation HOMEOSTATIC_HYDRATION = new ResourceLocation("homeostatic", "hydration");
    public static final ResourceLocation ARS_NOUVEAU_MANA = new ResourceLocation("ars_nouveau", "mana_hud");
    public static final ResourceLocation TFC_HEALTH = new ResourceLocation("tfc", "health");
    public static final ResourceLocation TFC_MOUNT_HEALTH = new ResourceLocation("tfc", "mount_health");
    public static final ResourceLocation TFC_FOOD = new ResourceLocation("tfc", "food");
    public static final ResourceLocation TFC_THIRST = new ResourceLocation("tfc", "thirst");
    public static final ResourceLocation TFC_EXPERIENCE = new ResourceLocation("tfc", "experience");


    @SubscribeEvent
    public static void disableVanillaOverlays(RenderGuiOverlayEvent.Pre event) {
        if (!AsteorBar.config.enableOverlay()) return;
        NamedGuiOverlay overlay = event.getOverlay();
        if (overlay == VanillaGuiOverlay.VIGNETTE.type()) {
            Overlays.reset();
            LightShieldRenderer.init();
            ForgeGuiRegistry.init();
        }
        if (overlay == VanillaGuiOverlay.PLAYER_HEALTH.type()) {
            event.setCanceled(true);
            return;
        }
        if (overlay == VanillaGuiOverlay.FOOD_LEVEL.type()) {
            event.setCanceled(true);
            return;
        }
        if (overlay == VanillaGuiOverlay.AIR_LEVEL.type()) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.config.overwriteVanillaExperienceBar() && overlay == VanillaGuiOverlay.EXPERIENCE_BAR.type()) {
            event.setCanceled(true);
            return;
        }
        if (overlay == VanillaGuiOverlay.MOUNT_HEALTH.type()) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.config.overwriteVanillaArmorBar() && overlay == VanillaGuiOverlay.ARMOR_LEVEL.type()) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.compatibility.toughAsNails && AsteorBar.config.hookToughAsNails() && overlay.id()
                .equals(TOUGH_AS_NAILS_THIRST_LEVEL)) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.compatibility.thirst && AsteorBar.config.hookThirstWasTaken() && overlay.id().equals(THIRST_THIRST_LEVEL)) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.compatibility.mekanism && AsteorBar.config.hookMekanism() && overlay.id().equals(MEKANISM_ENERGY_LEVEL)) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.compatibility.parcool && AsteorBar.config.hookParcool() && overlay.id().equals(PARCOOL_STAMINA)) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.compatibility.ironsSpellbooks && AsteorBar.config.hookIronsSpellbooks() && overlay.id().equals(IRONS_SPELLBOOKS_MANA)) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.compatibility.feathers && AsteorBar.config.hookFeathers() && overlay.id().equals(FEATHERS_FEATHERS)) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.compatibility.vampirism && AsteorBar.config.hookVampirism() && overlay.id().equals(VAMPIRISM_BLOOD)) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.compatibility.superiorshields && AsteorBar.config.hookSuperiorShields() && overlay.id().equals(SUPERIOR_SHIELDS_SHIELD)) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.compatibility.lightshield && AsteorBar.config.hookLightShield() && overlay.id().getNamespace().equals("lightshield")) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.compatibility.homeostatic && AsteorBar.config.hookHomeostatic() && (overlay.id().equals(HOMEOSTATIC_WATER) || overlay.id().equals(HOMEOSTATIC_HYDRATION))) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.compatibility.arsNouveau && AsteorBar.config.hookArsNouveau() && overlay.id().equals(ARS_NOUVEAU_MANA)) {
            event.setCanceled(true);
            return;
        }
        if (AsteorBar.compatibility.tfc && AsteorBar.config.hookTFC() && (overlay.id().equals(TFC_HEALTH) || overlay.id().equals(TFC_MOUNT_HEALTH) || overlay.id().equals(TFC_FOOD) || overlay.id().equals(TFC_THIRST) || overlay.id().equals(TFC_EXPERIENCE))) {
            event.setCanceled(true);
            return;
        }
    }

    @SubscribeEvent
    public static void handleKeyInput(InputEvent.Key event) {
        KeyBinding.handleKeyInput();
    }
}
