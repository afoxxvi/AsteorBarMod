package com.afoxxvi.asteorbar;


import com.afoxxvi.asteorbar.config.ConfigAdapter;
import com.afoxxvi.asteorbar.config.DefaultConfigAdapter;
import com.afoxxvi.asteorbar.utils.PlatformAdapter;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class AsteorBar {
    public static final String MOD_ID = "asteorbar";
    public static final String MOD_NAME = "AsteorBar";
    public static ConfigAdapter config = new DefaultConfigAdapter();
    public static PlatformAdapter platformAdapter = new PlatformAdapter() {
        @Override
        public boolean isBoss(LivingEntity livingEntity) {
            return false;
        }

        @Override
        public boolean isEyeInFluid(Player player) {
            return false;
        }

        @Override
        public RenderType getRenderType() {
            return RenderType.translucent();
        }

        @Override
        public boolean isModLoaded(String modId) {
            return false;
        }
    };
}
