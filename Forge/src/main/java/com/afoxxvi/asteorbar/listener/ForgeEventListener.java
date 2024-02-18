package com.afoxxvi.asteorbar.listener;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.key.KeyBinding;
import com.afoxxvi.asteorbar.overlay.Overlays;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.NamedGuiOverlay;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AsteorBar.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeEventListener {
    public static long tickCount = 0L;
    public static final ResourceLocation TOUGH_AS_NAILS_THIRST_LEVEL = new ResourceLocation("toughasnails", "thirst_level");

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (!Minecraft.getInstance().isPaused()) {
            tickCount++;
        }
    }

    @SubscribeEvent
    public static void disableVanillaOverlays(RenderGuiOverlayEvent.Pre event) {
        if (!AsteorBar.config.enableOverlay()) return;
        NamedGuiOverlay overlay = event.getOverlay();
        if (overlay == VanillaGuiOverlay.VIGNETTE.type()) {
            Overlays.reset();
        }
        if (overlay == VanillaGuiOverlay.PLAYER_HEALTH.type()
                || overlay == VanillaGuiOverlay.FOOD_LEVEL.type()
                || overlay == VanillaGuiOverlay.AIR_LEVEL.type()
                || (AsteorBar.config.overwriteVanillaExperienceBar() && overlay == VanillaGuiOverlay.EXPERIENCE_BAR.type())
                || overlay == VanillaGuiOverlay.MOUNT_HEALTH.type()
                || (AsteorBar.config.overwriteVanillaArmorBar() && overlay == VanillaGuiOverlay.ARMOR_LEVEL.type())
                || Overlays.toughAsNails && overlay.id().equals(TOUGH_AS_NAILS_THIRST_LEVEL)
        ) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void handleKeyInput(InputEvent.Key event) {
        KeyBinding.handleKeyInput();
    }
}
