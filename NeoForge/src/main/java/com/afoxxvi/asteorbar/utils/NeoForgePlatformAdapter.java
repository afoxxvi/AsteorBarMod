package com.afoxxvi.asteorbar.utils;

import com.afoxxvi.asteorbar.entity.AsteorBarRenderType;
import com.afoxxvi.asteorbar.overlay.Overlays;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.Tags;

public class NeoForgePlatformAdapter implements PlatformAdapter {
    @Override
    public boolean isBoss(LivingEntity livingEntity) {
        return livingEntity.getType().is(Tags.EntityTypes.BOSSES);
    }

    @Override
    public boolean isEyeInFluid(Player player) {
        return player.isEyeInFluidType(NeoForgeMod.WATER_TYPE.value());
    }

    @Override
    public RenderType getRenderType() {
        return AsteorBarRenderType.RENDER_TYPE;
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public AppleSkinFoodValues getAppleSkinFoodValues(Player player) {
        if (!Overlays.appleskin) {
            return null;
        }
        // if not using third adapter, the game will crash if appleskin is not loaded
        return AppleSkinAdapter.getInstance().getAppleSkinFoodValues(player);
    }
}
