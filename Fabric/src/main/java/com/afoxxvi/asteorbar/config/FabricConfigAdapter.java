package com.afoxxvi.asteorbar.config;

import com.afoxxvi.asteorbar.AsteorBar;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

public class FabricConfigAdapter implements ConfigAdapter {
    @Override
    public boolean enableOverlay() {
        return config.overlay.enableOverlay;
    }

    @Override
    public void enableOverlay(boolean enable) {
        config.overlay.enableOverlay = enable;
        holder.save();
    }

    @Override
    public int overlayLayoutStyle() {
        return config.overlay.overlayLayoutStyle;
    }

    @Override
    public void overlayLayoutStyle(int style) {
        config.overlay.overlayLayoutStyle = style;
        holder.save();
    }

    @Override
    public double overlayTextScale() {
        return config.overlay.overlayTextScale;
    }

    @Override
    public int fullFoodLevelValue() {
        return config.overlay.fullFoodLevelValue;
    }

    @Override
    public double fullSaturationValue() {
        return config.overlay.fullSaturationValue;
    }

    @Override
    public double fullExhaustionValue() {
        return config.overlay.fullExhaustionValue;
    }

    @Override
    public int fullArmorValue() {
        return config.overlay.fullArmorValue;
    }

    @Override
    public int fullArmorToughnessValue() {
        return config.overlay.fullArmorToughnessValue;
    }

    @Override
    public int fullHealthValue() {
        return config.overlay.fullHealthValue;
    }

    @Override
    public boolean enableStackHealthBar() {
        return config.overlay.enableStackHealthBar;
    }

    @Override
    public String stackHealthBarColors() {
        return config.overlay.stackHealthBarColors;
    }

    @Override
    public int healthColorNormal() {
        return config.overlay.healthColorNormal;
    }

    @Override
    public int healthColorPoison() {
        return config.overlay.healthColorPoison;
    }

    @Override
    public int healthColorWither() {
        return config.overlay.healthColorWither;
    }

    @Override
    public int healthColorFrozen() {
        return config.overlay.healthColorFrozen;
    }

    @Override
    public int healthBoundColor() {
        return config.overlay.healthBoundColor;
    }

    @Override
    public int healthBoundColorBlink() {
        return config.overlay.healthBoundColorBlink;
    }

    @Override
    public int healthBoundColorLow() {
        return config.overlay.healthBoundColorLow;
    }

    @Override
    public int healthEmptyColor() {
        return config.overlay.healthEmptyColor;
    }

    @Override
    public int absorptionColor() {
        return config.overlay.absorptionColor;
    }

    @Override
    public int absorptionBoundColor() {
        return config.overlay.absorptionBoundColor;
    }

    @Override
    public int foodColorNormal() {
        return config.overlay.foodColorNormal;
    }

    @Override
    public int foodColorHunger() {
        return config.overlay.foodColorHunger;
    }

    @Override
    public int foodBoundColor() {
        return config.overlay.foodBoundColor;
    }

    @Override
    public int foodBoundColorBlink() {
        return config.overlay.foodBoundColorBlink;
    }

    @Override
    public int foodEmptyColor() {
        return config.overlay.foodEmptyColor;
    }

    @Override
    public int saturationColor() {
        return config.overlay.saturationColor;
    }

    @Override
    public int experienceColor() {
        return config.overlay.experienceColor;
    }

    @Override
    public int experienceBoundColor() {
        return config.overlay.experienceBoundColor;
    }

    @Override
    public int experienceEmptyColor() {
        return config.overlay.experienceEmptyColor;
    }

    @Override
    public int airColor() {
        return config.overlay.airColor;
    }

    @Override
    public int airBoundColor() {
        return config.overlay.airBoundColor;
    }

    @Override
    public int mountHealthColor() {
        return config.overlay.mountHealthColor;
    }

    @Override
    public int mountHealthColor2() {
        return config.overlay.mountHealthColor2;
    }

    @Override
    public int mountHealthBoundColor() {
        return config.overlay.mountHealthBoundColor;
    }

    @Override
    public int mountHealthBoundColor2() {
        return config.overlay.mountHealthBoundColor2;
    }

    @Override
    public int mountHealthEmptyColor() {
        return config.overlay.mountHealthEmptyColor;
    }

    @Override
    public int armorColor() {
        return config.overlay.armorColor;
    }

    @Override
    public int armorBoundColor() {
        return config.overlay.armorBoundColor;
    }

    @Override
    public int armorEmptyColor() {
        return config.overlay.armorEmptyColor;
    }

    @Override
    public int armorToughnessColor() {
        return config.overlay.armorToughnessColor;
    }

    @Override
    public boolean enableHealthBlink() {
        return config.overlay.enableHealthBlink;
    }

    @Override
    public double lowHealthRate() {
        return config.overlay.lowHealthRate;
    }

    @Override
    public boolean overwriteVanillaArmorBar() {
        return config.overlay.overwriteVanillaArmorBar;
    }

    @Override
    public boolean overwriteVanillaExperienceBar() {
        return config.overlay.overwriteVanillaExperienceBar;
    }

    @Override
    public boolean displayExperienceProgress() {
        return config.overlay.displayExperienceProgress;
    }

    @Override
    public boolean displayExperienceLevel() {
        return config.overlay.displayExperienceLevel;
    }

    @Override
    public boolean displayHealthText() {
        return config.overlay.displayHealthText;
    }

    @Override
    public int displayAbsorptionMethod() {
        return config.overlay.displayAbsorptionMethod;
    }

    @Override
    public boolean displayAbsorptionDivMaxHealth() {
        return config.overlay.displayAbsorptionDivMaxHealth;
    }

    @Override
    public int displayAbsorptionTextMethod() {
        return config.overlay.displayAbsorptionTextMethod;
    }

    @Override
    public boolean enableFoodBlink() {
        return config.overlay.enableFoodBlink;
    }

    @Override
    public boolean displaySaturation() {
        return config.overlay.displaySaturation;
    }

    @Override
    public boolean displayExhaustion() {
        return config.overlay.displayExhaustion;
    }

    @Override
    public boolean displayArmorToughness() {
        return config.overlay.displayArmorToughness;
    }

    @Override
    public int cornerBarLength() {
        return config.overlay.cornerBarLength;
    }

    @Override
    public int cornerHorizontalPadding() {
        return config.overlay.cornerHorizontalPadding;
    }

    @Override
    public int cornerVerticalPadding() {
        return config.overlay.cornerVerticalPadding;
    }

    @Override
    public boolean enableHealthBar() {
        return config.entity.enableHealthBar;
    }

    @Override
    public void enableHealthBar(boolean enable) {
        config.entity.enableHealthBar = enable;
        holder.save();
    }

    @Override
    public double maxDistance() {
        return config.entity.maxDistance;
    }

    @Override
    public boolean showOnSelf() {
        return config.entity.showOnSelf;
    }

    @Override
    public boolean showOnPlayers() {
        return config.entity.showOnPlayers;
    }

    @Override
    public boolean showOnBosses() {
        return config.entity.showOnBosses;
    }

    @Override
    public boolean showOnFullHealthWithoutAbsorption() {
        return config.entity.showOnFullHealthWithoutAbsorption;
    }

    @Override
    public boolean showOnFullHealthWithAbsorption() {
        return config.entity.showOnFullHealthWithAbsorption;
    }

    @Override
    public int healthBarHalfWidth() {
        return config.entity.healthBarHalfWidth;
    }

    @Override
    public int healthBarHalfHeight() {
        return config.entity.healthBarHalfHeight;
    }

    @Override
    public double healthBarOffsetY() {
        return config.entity.healthBarOffsetY;
    }

    @Override
    public double healthBarScale() {
        return config.entity.healthBarScale;
    }

    @Override
    public double healthBarTextScale() {
        return config.entity.healthBarTextScale;
    }

    @Override
    public double healthBarTextOffsetY() {
        return config.entity.healthBarTextOffsetY;
    }

    @Override
    public int healthBarBoundWidth() {
        return config.entity.healthBarBoundWidth;
    }

    @Override
    public boolean healthBarBoundVertex() {
        return config.entity.healthBarBoundVertex;
    }

    @Override
    public int healthBarHealthColor() {
        return config.entity.healthBarHealthColor;
    }

    @Override
    public int healthBarAbsorptionColor() {
        return config.entity.healthBarAbsorptionColor;
    }

    @Override
    public int healthBarBoundColor() {
        return config.entity.healthBarBoundColor;
    }

    @Override
    public int healthBarEmptyColor() {
        return config.entity.healthBarEmptyColor;
    }

    @Override
    public boolean healthBarHealthColorDynamic() {
        return config.entity.healthBarHealthColorDynamic;
    }

    @Override
    public int healthBarHealthColorFull() {
        return config.entity.healthBarHealthColorFull;
    }

    @Override
    public int healthBarHealthColorEmpty() {
        return config.entity.healthBarHealthColorEmpty;
    }

    @Override
    public boolean hookToughAsNails() {
        return config.hook.hookToughAsNails;
    }

    @Override
    public boolean hookThirstWasTaken() {
        return config.hook.hookThirstWasTaken;
    }

    @Override
    public boolean hookMekanism() {
        return config.hook.hookMekanism;
    }

    @Override
    public boolean hookDehydration() {
        return config.hook.hookDehydration;
    }

    public static void init() {
        AutoConfig.register(FabricConfigAdapter.AsteorBarConfig.class, JanksonConfigSerializer::new);
        holder = AutoConfig.getConfigHolder(FabricConfigAdapter.AsteorBarConfig.class);
        holder.load();
        config = holder.getConfig();
    }

    public static ConfigHolder<AsteorBarConfig> holder;
    public static FabricConfigAdapter.AsteorBarConfig config;

    @Config(name = AsteorBar.MOD_ID)
    public static class AsteorBarConfig implements ConfigData {
        @ConfigEntry.Gui.CollapsibleObject
        OverlayConfig overlay = new OverlayConfig();
        @ConfigEntry.Gui.CollapsibleObject
        EntityConfig entity = new EntityConfig();
        @ConfigEntry.Gui.CollapsibleObject
        HookConfig hook = new HookConfig();

        //overlay config
        static class OverlayConfig {
            @Comment(ConfigComment.enableOverlay)
            public boolean enableOverlay = DefaultConfigAdapter.I.enableOverlay();
            @Comment(ConfigComment.overlayLayoutStyle)
            public int overlayLayoutStyle = DefaultConfigAdapter.I.overlayLayoutStyle();
            @Comment(ConfigComment.overlayTextScale)
            public double overlayTextScale = DefaultConfigAdapter.I.overlayTextScale();
            @Comment(ConfigComment.fullFoodLevelValue)
            public int fullFoodLevelValue = DefaultConfigAdapter.I.fullFoodLevelValue();
            @Comment(ConfigComment.fullSaturationValue)
            public double fullSaturationValue = DefaultConfigAdapter.I.fullSaturationValue();
            @Comment(ConfigComment.fullExhaustionValue)
            public double fullExhaustionValue = DefaultConfigAdapter.I.fullExhaustionValue();
            @Comment(ConfigComment.fullArmorValue)
            public int fullArmorValue = DefaultConfigAdapter.I.fullArmorValue();
            @Comment(ConfigComment.fullArmorToughnessValue)
            public int fullArmorToughnessValue = DefaultConfigAdapter.I.fullArmorToughnessValue();
            @Comment(ConfigComment.fullHealthValue)
            public int fullHealthValue = DefaultConfigAdapter.I.fullHealthValue();
            @Comment(ConfigComment.enableStackHealthBar)
            public boolean enableStackHealthBar = DefaultConfigAdapter.I.enableStackHealthBar();
            @Comment(ConfigComment.stackHealthBarColors)
            public String stackHealthBarColors = DefaultConfigAdapter.I.stackHealthBarColors();
            @Comment(ConfigComment.healthColorNormal)
            public int healthColorNormal = DefaultConfigAdapter.I.healthColorNormal();
            @Comment(ConfigComment.healthColorPoison)
            public int healthColorPoison = DefaultConfigAdapter.I.healthColorPoison();
            @Comment(ConfigComment.healthColorWither)
            public int healthColorWither = DefaultConfigAdapter.I.healthColorWither();
            @Comment(ConfigComment.healthColorFrozen)
            public int healthColorFrozen = DefaultConfigAdapter.I.healthColorFrozen();
            @Comment(ConfigComment.healthBoundColor)
            public int healthBoundColor = DefaultConfigAdapter.I.healthBoundColor();
            @Comment(ConfigComment.healthBoundColorBlink)
            public int healthBoundColorBlink = DefaultConfigAdapter.I.healthBoundColorBlink();
            @Comment(ConfigComment.healthBoundColorLow)
            public int healthBoundColorLow = DefaultConfigAdapter.I.healthBoundColor();
            @Comment(ConfigComment.healthEmptyColor)
            public int healthEmptyColor = DefaultConfigAdapter.I.healthEmptyColor();
            @Comment(ConfigComment.absorptionColor)
            public int absorptionColor = DefaultConfigAdapter.I.absorptionColor();
            @Comment(ConfigComment.absorptionBoundColor)
            public int absorptionBoundColor = DefaultConfigAdapter.I.absorptionBoundColor();
            @Comment(ConfigComment.foodColorNormal)
            public int foodColorNormal = DefaultConfigAdapter.I.foodColorNormal();
            @Comment(ConfigComment.foodColorHunger)
            public int foodColorHunger = DefaultConfigAdapter.I.foodColorHunger();
            @Comment(ConfigComment.foodBoundColor)
            public int foodBoundColor = DefaultConfigAdapter.I.foodBoundColor();
            @Comment(ConfigComment.foodBoundColorBlink)
            public int foodBoundColorBlink = DefaultConfigAdapter.I.foodBoundColorBlink();
            @Comment(ConfigComment.foodEmptyColor)
            public int foodEmptyColor = DefaultConfigAdapter.I.foodEmptyColor();
            @Comment(ConfigComment.saturationColor)
            public int saturationColor = DefaultConfigAdapter.I.saturationColor();
            @Comment(ConfigComment.experienceColor)
            public int experienceColor = DefaultConfigAdapter.I.experienceColor();
            @Comment(ConfigComment.experienceBoundColor)
            public int experienceBoundColor = DefaultConfigAdapter.I.experienceBoundColor();
            @Comment(ConfigComment.experienceEmptyColor)
            public int experienceEmptyColor = DefaultConfigAdapter.I.experienceEmptyColor();
            @Comment(ConfigComment.airColor)
            public int airColor = DefaultConfigAdapter.I.airColor();
            @Comment(ConfigComment.airBoundColor)
            public int airBoundColor = DefaultConfigAdapter.I.airBoundColor();
            @Comment(ConfigComment.mountHealthColor)
            public int mountHealthColor = DefaultConfigAdapter.I.mountHealthColor();
            @Comment(ConfigComment.mountHealthColor2)
            public int mountHealthColor2 = DefaultConfigAdapter.I.mountHealthColor2();
            @Comment(ConfigComment.mountHealthBoundColor)
            public int mountHealthBoundColor = DefaultConfigAdapter.I.mountHealthBoundColor();
            @Comment(ConfigComment.mountHealthBoundColor2)
            public int mountHealthBoundColor2 = DefaultConfigAdapter.I.mountHealthBoundColor2();
            @Comment(ConfigComment.mountHealthEmptyColor)
            public int mountHealthEmptyColor = DefaultConfigAdapter.I.mountHealthEmptyColor();
            @Comment(ConfigComment.armorColor)
            public int armorColor = DefaultConfigAdapter.I.armorColor();
            @Comment(ConfigComment.armorBoundColor)
            public int armorBoundColor = DefaultConfigAdapter.I.armorBoundColor();
            @Comment(ConfigComment.armorEmptyColor)
            public int armorEmptyColor = DefaultConfigAdapter.I.armorEmptyColor();
            @Comment(ConfigComment.armorToughnessColor)
            public int armorToughnessColor = DefaultConfigAdapter.I.armorToughnessColor();
            @Comment(ConfigComment.enableHealthBlink)
            public boolean enableHealthBlink = DefaultConfigAdapter.I.enableHealthBlink();
            @Comment(ConfigComment.lowHealthRate)
            public double lowHealthRate = DefaultConfigAdapter.I.lowHealthRate();
            @Comment(ConfigComment.overwriteVanillaArmorBar)
            public boolean overwriteVanillaArmorBar = DefaultConfigAdapter.I.overwriteVanillaArmorBar();
            @Comment(ConfigComment.overwriteVanillaExperienceBar)
            public boolean overwriteVanillaExperienceBar = DefaultConfigAdapter.I.overwriteVanillaExperienceBar();
            @Comment(ConfigComment.displayExperienceProgress)
            public boolean displayExperienceProgress = DefaultConfigAdapter.I.displayExperienceProgress();
            @Comment(ConfigComment.displayExperienceLevel)
            public boolean displayExperienceLevel = DefaultConfigAdapter.I.displayExperienceLevel();
            @Comment(ConfigComment.displayHealthText)
            public boolean displayHealthText = DefaultConfigAdapter.I.displayHealthText();
            @Comment(ConfigComment.displayAbsorptionMethod)
            public int displayAbsorptionMethod = DefaultConfigAdapter.I.displayAbsorptionMethod();
            @Comment(ConfigComment.displayAbsorptionDivMaxHealth)
            public boolean displayAbsorptionDivMaxHealth = DefaultConfigAdapter.I.displayAbsorptionDivMaxHealth();
            @Comment(ConfigComment.displayAbsorptionTextMethod)
            public int displayAbsorptionTextMethod = DefaultConfigAdapter.I.displayAbsorptionTextMethod();
            @Comment(ConfigComment.enableFoodBlink)
            public boolean enableFoodBlink = DefaultConfigAdapter.I.enableFoodBlink();
            @Comment(ConfigComment.displaySaturation)
            public boolean displaySaturation = DefaultConfigAdapter.I.displaySaturation();
            @Comment(ConfigComment.displayExhaustion)
            public boolean displayExhaustion = DefaultConfigAdapter.I.displayExhaustion();
            @Comment(ConfigComment.displayArmorToughness)
            public boolean displayArmorToughness = DefaultConfigAdapter.I.displayArmorToughness();
            @Comment(ConfigComment.cornerBarLength)
            public int cornerBarLength = DefaultConfigAdapter.I.cornerBarLength();
            @Comment(ConfigComment.cornerHorizontalPadding)
            public int cornerHorizontalPadding = DefaultConfigAdapter.I.cornerHorizontalPadding();
            @Comment(ConfigComment.cornerVerticalPadding)
            public int cornerVerticalPadding = DefaultConfigAdapter.I.cornerVerticalPadding();
        }

        //mob config
        static class EntityConfig {
            @Comment(ConfigComment.enableHealthBar)
            public boolean enableHealthBar = DefaultConfigAdapter.I.enableHealthBar();
            @Comment(ConfigComment.maxDistance)
            public double maxDistance = DefaultConfigAdapter.I.maxDistance();
            @Comment(ConfigComment.showOnSelf)
            public boolean showOnSelf = DefaultConfigAdapter.I.showOnSelf();
            @Comment(ConfigComment.showOnPlayers)
            public boolean showOnPlayers = DefaultConfigAdapter.I.showOnPlayers();
            @Comment(ConfigComment.showOnBosses)
            public boolean showOnBosses = DefaultConfigAdapter.I.showOnBosses();
            @Comment(ConfigComment.showOnFullHealthWithoutAbsorption)
            public boolean showOnFullHealthWithoutAbsorption = DefaultConfigAdapter.I.showOnFullHealthWithoutAbsorption();
            @Comment(ConfigComment.showOnFullHealthWithAbsorption)
            public boolean showOnFullHealthWithAbsorption = DefaultConfigAdapter.I.showOnFullHealthWithAbsorption();
            @Comment(ConfigComment.healthBarHalfWidth)
            public int healthBarHalfWidth = DefaultConfigAdapter.I.healthBarHalfWidth();
            @Comment(ConfigComment.healthBarHalfHeight)
            public int healthBarHalfHeight = DefaultConfigAdapter.I.healthBarHalfHeight();
            @Comment(ConfigComment.healthBarOffsetY)
            public double healthBarOffsetY = DefaultConfigAdapter.I.healthBarOffsetY();
            @Comment(ConfigComment.healthBarScale)
            public double healthBarScale = DefaultConfigAdapter.I.healthBarScale();
            @Comment(ConfigComment.healthBarTextScale)
            public double healthBarTextScale = DefaultConfigAdapter.I.healthBarTextScale();
            @Comment(ConfigComment.healthBarTextOffsetY)
            public double healthBarTextOffsetY = DefaultConfigAdapter.I.healthBarTextOffsetY();
            @Comment(ConfigComment.healthBarBoundWidth)
            public int healthBarBoundWidth = DefaultConfigAdapter.I.healthBarBoundWidth();
            @Comment(ConfigComment.healthBarBoundVertex)
            public boolean healthBarBoundVertex = DefaultConfigAdapter.I.healthBarBoundVertex();
            @Comment(ConfigComment.healthBarHealthColor)
            public int healthBarHealthColor = DefaultConfigAdapter.I.healthBarHealthColor();
            @Comment(ConfigComment.healthBarAbsorptionColor)
            public int healthBarAbsorptionColor = DefaultConfigAdapter.I.healthBarAbsorptionColor();
            @Comment(ConfigComment.healthBarBoundColor)
            public int healthBarBoundColor = DefaultConfigAdapter.I.healthBarBoundColor();
            @Comment(ConfigComment.healthBarEmptyColor)
            public int healthBarEmptyColor = DefaultConfigAdapter.I.healthBarEmptyColor();
            @Comment(ConfigComment.healthBarHealthColorDynamic)
            public boolean healthBarHealthColorDynamic = DefaultConfigAdapter.I.healthBarHealthColorDynamic();
            @Comment(ConfigComment.healthBarHealthColorFull)
            public int healthBarHealthColorFull = DefaultConfigAdapter.I.healthBarHealthColorFull();
            @Comment(ConfigComment.healthBarHealthColorEmpty)
            public int healthBarHealthColorEmpty = DefaultConfigAdapter.I.healthBarHealthColorEmpty();
        }

        static class HookConfig {
            @Comment(ConfigComment.hookToughAsNails)
            public boolean hookToughAsNails = DefaultConfigAdapter.I.hookToughAsNails();
            @Comment(ConfigComment.hookThirstWasTaken)
            public boolean hookThirstWasTaken = DefaultConfigAdapter.I.hookThirstWasTaken();
            @Comment(ConfigComment.hookMekanism)
            public boolean hookMekanism = DefaultConfigAdapter.I.hookMekanism();
            @Comment(ConfigComment.hookDehydration)
            public boolean hookDehydration = DefaultConfigAdapter.I.hookDehydration();
        }
    }
}
