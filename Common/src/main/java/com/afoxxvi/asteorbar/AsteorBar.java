package com.afoxxvi.asteorbar;


import com.afoxxvi.asteorbar.config.ConfigAdapter;
import com.afoxxvi.asteorbar.config.DefaultConfigAdapter;
import com.afoxxvi.asteorbar.utils.PlatformAdapter;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.slf4j.Logger;

public class AsteorBar {
    public static final String MOD_ID = "asteorbar";
    public static final String MOD_NAME = "AsteorBar";
    public static ConfigAdapter config = new DefaultConfigAdapter();
    public static Compatibility compatibility = new Compatibility();

    public static PlatformAdapter platformAdapter = new PlatformAdapter() {
        @Override
        public Logger getLogger() {
            return null;
        }

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

        @Override
        public AppleSkinFoodValues getAppleSkinFoodValues(Player player) {
            return new AppleSkinFoodValues(0, 0, 0);
        }
    };

    public static class Compatibility {
        public boolean toughAsNails = false;
        public boolean thirst = false;
        public boolean mekanism = false;
        public boolean dehydration = false;
        public boolean parcool = false;
        public boolean ironsSpellbooks = false;
        public boolean feathers = false;
        public boolean appleskin = false;
        public boolean superiorshields = false;
        public boolean vampirism = false;
        public boolean lightshield = false;
        public boolean homeostatic = false;
        public boolean botania = false;
        public boolean origins = false;
        public boolean tfc = false;
        public boolean arsNouveau = false;
        public boolean apoli = false;


        public void init() {
            toughAsNails = platformAdapter.isModLoaded("toughasnails");
            thirst = platformAdapter.isModLoaded("thirst");
            mekanism = platformAdapter.isModLoaded("mekanism");
            dehydration = platformAdapter.isModLoaded("dehydration");
            parcool = platformAdapter.isModLoaded("parcool");
            ironsSpellbooks = platformAdapter.isModLoaded("irons_spellbooks");
            feathers = platformAdapter.isModLoaded("feathers");
            appleskin = platformAdapter.isModLoaded("appleskin");
            superiorshields = platformAdapter.isModLoaded("superiorshields");
            vampirism = platformAdapter.isModLoaded("vampirism");
            lightshield = platformAdapter.isModLoaded("lightshield");
            homeostatic = platformAdapter.isModLoaded("homeostatic");
            botania = platformAdapter.isModLoaded("botania");
            origins = platformAdapter.isModLoaded("origins");
            tfc = platformAdapter.isModLoaded("tfc");
            arsNouveau = platformAdapter.isModLoaded("ars_nouveau");
            apoli = platformAdapter.isModLoaded("apoli");
        }
    }
}
