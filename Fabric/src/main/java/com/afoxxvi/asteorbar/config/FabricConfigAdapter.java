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
    public int overlayBarInnerHeight() {
        return config.overlay.overlayBarInnerHeight;
    }

    @Override
    public int overlayBarVerticalMargin() {
        return config.overlay.overlayBarVerticalMargin;
    }

    @Override
    public int overlayBarTextOffsetY() {
        return config.overlay.overlayBarTextOffsetY;
    }

    @Override
    public double hideDecimalWhenEqualOrMoreThan() {
        return config.overlay.hideDecimalWhenEqualOrMoreThan;
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
    public double healthRegenerationOpacity() {
        return config.overlay.healthRegenerationOpacity;
    }

    @Override
    public double healthRegenerationOpacityOnFull() {
        return config.overlay.healthRegenerationOpacityOnFull;
    }

    @Override
    public int hideUnchangingBarAfterSeconds() {
        return config.overlay.hideUnchangingBarAfterSeconds;
    }

    @Override
    public String healthColorNormalARGB() {
        return config.overlay.healthColorNormalARGB;
    }

    @Override
    public String healthColorPoisonARGB() {
        return config.overlay.healthColorPoisonARGB;
    }

    @Override
    public String healthColorWitherARGB() {
        return config.overlay.healthColorWitherARGB;
    }

    @Override
    public String healthColorFrozenARGB() {
        return config.overlay.healthColorFrozenARGB;
    }

    @Override
    public String healthBoundColorARGB() {
        return config.overlay.healthBoundColorARGB;
    }

    @Override
    public String healthBoundColorBlinkARGB() {
        return config.overlay.healthBoundColorBlinkARGB;
    }

    @Override
    public String healthBoundColorLowARGB() {
        return config.overlay.healthBoundColorLowARGB;
    }

    @Override
    public String healthEmptyColorARGB() {
        return config.overlay.healthEmptyColorARGB;
    }

    @Override
    public String absorptionColorARGB() {
        return config.overlay.absorptionColorARGB;
    }

    @Override
    public String absorptionBoundColorARGB() {
        return config.overlay.absorptionBoundColorARGB;
    }

    @Override
    public String foodColorNormalARGB() {
        return config.overlay.foodColorNormalARGB;
    }

    @Override
    public String foodColorHungerARGB() {
        return config.overlay.foodColorHungerARGB;
    }

    @Override
    public String foodBoundColorARGB() {
        return config.overlay.foodBoundColorARGB;
    }

    @Override
    public String foodBoundColorBlinkARGB() {
        return config.overlay.foodBoundColorBlinkARGB;
    }

    @Override
    public String foodEmptyColorARGB() {
        return config.overlay.foodEmptyColorARGB;
    }

    @Override
    public String saturationColorARGB() {
        return config.overlay.saturationColorARGB;
    }

    @Override
    public String experienceColorARGB() {
        return config.overlay.experienceColorARGB;
    }

    @Override
    public String experienceBoundColorARGB() {
        return config.overlay.experienceBoundColorARGB;
    }

    @Override
    public String experienceEmptyColorARGB() {
        return config.overlay.experienceEmptyColorARGB;
    }

    @Override
    public String airColorARGB() {
        return config.overlay.airColorARGB;
    }

    @Override
    public String airBoundColorARGB() {
        return config.overlay.airBoundColorARGB;
    }

    @Override
    public String mountHealthColorARGB() {
        return config.overlay.mountHealthColorARGB;
    }

    @Override
    public String mountHealthColor2ARGB() {
        return config.overlay.mountHealthColor2ARGB;
    }

    @Override
    public String mountHealthBoundColorARGB() {
        return config.overlay.mountHealthBoundColorARGB;
    }

    @Override
    public String mountHealthBoundColor2ARGB() {
        return config.overlay.mountHealthBoundColor2ARGB;
    }

    @Override
    public String mountHealthEmptyColorARGB() {
        return config.overlay.mountHealthEmptyColorARGB;
    }

    @Override
    public boolean mountHealthOnLeftSide() {
        return config.overlay.mountHealthOnLeftSide;
    }

    @Override
    public String armorColorARGB() {
        return config.overlay.armorColorARGB;
    }

    @Override
    public String armorBoundColorARGB() {
        return config.overlay.armorBoundColorARGB;
    }

    @Override
    public String armorEmptyColorARGB() {
        return config.overlay.armorEmptyColorARGB;
    }

    @Override
    public String armorToughnessColorARGB() {
        return config.overlay.armorToughnessColorARGB;
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
    public boolean shakeHealthAndFoodWhileLow() {
        return config.overlay.shakeHealthAndFoodWhileLow;
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
    public boolean displayFoodText() {
        return config.overlay.displayFoodText;
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
    public boolean forceRenderAtCorner() {
        return config.overlay.forceRenderAtCorner;
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
    public boolean showOnArmorStands() {
        return config.entity.showOnArmorStands;
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
    public int healthBarAlpha() {
        return config.entity.healthBarAlpha;
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
    public String healthBarHealthColorARGB() {
        return config.entity.healthBarHealthColorARGB;
    }

    @Override
    public String healthBarAbsorptionColorARGB() {
        return config.entity.healthBarAbsorptionColorARGB;
    }

    @Override
    public String healthBarBoundColorARGB() {
        return config.entity.healthBarBoundColorARGB;
    }

    @Override
    public String healthBarEmptyColorARGB() {
        return config.entity.healthBarEmptyColorARGB;
    }

    @Override
    public boolean healthBarHealthColorDynamic() {
        return config.entity.healthBarHealthColorDynamic;
    }

    @Override
    public String healthBarHealthColorFullARGB() {
        return config.entity.healthBarHealthColorFullARGB;
    }

    @Override
    public String healthBarHealthColorEmptyARGB() {
        return config.entity.healthBarHealthColorEmptyARGB;
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

    @Override
    public boolean hookParcool() {
        return config.hook.hookParcool;
    }

    @Override
    public boolean hookIronsSpellbooks() {
        return config.hook.hookIronsSpellbooks;
    }

    @Override
    public boolean hookFeathers() {
        return config.hook.hookFeathers;
    }

    @Override
    public boolean hookAppleSkin() {
        return config.hook.hookAppleSkin;
    }

    @Override
    public boolean hookSuperiorShields() {
        return config.hook.hookSuperiorShields;
    }

    @Override
    public boolean hookLightShield() {
        return config.hook.hookLightShield;
    }

    @Override
    public boolean hookVampirism() {
        return config.hook.hookVampirism;
    }

    @Override
    public boolean hookHomeostatic() {
        return config.hook.hookHomeostatic;
    }

    @Override
    public boolean hookBotania() {
        return config.hook.hookBotania;
    }

    @Override
    public boolean hookOrigins() {
        return config.hook.hookOrigins;
    }

    @Override
    public boolean hookTFC() {
        return config.hook.hookTFC;
    }

    @Override
    public boolean hookArsNouveau() {
        return config.hook.hookArsNouveau;
    }

    @Override
    public boolean hookApoli() {
        return config.hook.hookApoli;
    }

    @Override
    public boolean hookThermoo() {
        return config.hook.hookThermoo;
    }

    @Override
    public boolean hookMealApi() {
        return config.hook.hookMealApi;
    }

    @Override
    public boolean hookLegendarySurvivalOverhaul() {
        return config.hook.hookLegendarySurvivalOverhaul;
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
            @Comment(ConfigComment.overlayBarInnerHeight)
            public int overlayBarInnerHeight = DefaultConfigAdapter.I.overlayBarInnerHeight();
            @Comment(ConfigComment.overlayBarVerticalMargin)
            public int overlayBarVerticalMargin = DefaultConfigAdapter.I.overlayBarVerticalMargin();
            @Comment(ConfigComment.overlayBarTextOffsetY)
            public int overlayBarTextOffsetY = DefaultConfigAdapter.I.overlayBarTextOffsetY();
            @Comment(ConfigComment.hideDecimalWhenEqualOrMoreThan)
            public double hideDecimalWhenEqualOrMoreThan = DefaultConfigAdapter.I.hideDecimalWhenEqualOrMoreThan();
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
            @Comment(ConfigComment.healthRegenerationOpacity)
            public double healthRegenerationOpacity = DefaultConfigAdapter.I.healthRegenerationOpacity();
            @Comment(ConfigComment.healthRegenerationOpacityOnFull)
            public double healthRegenerationOpacityOnFull = DefaultConfigAdapter.I.healthRegenerationOpacityOnFull();
            @Comment(ConfigComment.hideUnchangingBarAfterSeconds)
            public int hideUnchangingBarAfterSeconds = DefaultConfigAdapter.I.hideUnchangingBarAfterSeconds();
            @Comment(ConfigComment.healthColorNormal)
            public String healthColorNormalARGB = DefaultConfigAdapter.I.healthColorNormalARGB();
            @Comment(ConfigComment.healthColorPoison)
            public String healthColorPoisonARGB = DefaultConfigAdapter.I.healthColorPoisonARGB();
            @Comment(ConfigComment.healthColorWither)
            public String healthColorWitherARGB = DefaultConfigAdapter.I.healthColorWitherARGB();
            @Comment(ConfigComment.healthColorFrozen)
            public String healthColorFrozenARGB = DefaultConfigAdapter.I.healthColorFrozenARGB();
            @Comment(ConfigComment.healthBoundColor)
            public String healthBoundColorARGB = DefaultConfigAdapter.I.healthBoundColorARGB();
            @Comment(ConfigComment.healthBoundColorBlink)
            public String healthBoundColorBlinkARGB = DefaultConfigAdapter.I.healthBoundColorBlinkARGB();
            @Comment(ConfigComment.healthBoundColorLow)
            public String healthBoundColorLowARGB = DefaultConfigAdapter.I.healthBoundColorLowARGB();
            @Comment(ConfigComment.healthEmptyColor)
            public String healthEmptyColorARGB = DefaultConfigAdapter.I.healthEmptyColorARGB();
            @Comment(ConfigComment.absorptionColor)
            public String absorptionColorARGB = DefaultConfigAdapter.I.absorptionColorARGB();
            @Comment(ConfigComment.absorptionBoundColor)
            public String absorptionBoundColorARGB = DefaultConfigAdapter.I.absorptionBoundColorARGB();
            @Comment(ConfigComment.foodColorNormal)
            public String foodColorNormalARGB = DefaultConfigAdapter.I.foodColorNormalARGB();
            @Comment(ConfigComment.foodColorHunger)
            public String foodColorHungerARGB = DefaultConfigAdapter.I.foodColorHungerARGB();
            @Comment(ConfigComment.foodBoundColor)
            public String foodBoundColorARGB = DefaultConfigAdapter.I.foodBoundColorARGB();
            @Comment(ConfigComment.foodBoundColorBlink)
            public String foodBoundColorBlinkARGB = DefaultConfigAdapter.I.foodBoundColorBlinkARGB();
            @Comment(ConfigComment.foodEmptyColor)
            public String foodEmptyColorARGB = DefaultConfigAdapter.I.foodEmptyColorARGB();
            @Comment(ConfigComment.saturationColor)
            public String saturationColorARGB = DefaultConfigAdapter.I.saturationColorARGB();
            @Comment(ConfigComment.experienceColor)
            public String experienceColorARGB = DefaultConfigAdapter.I.experienceColorARGB();
            @Comment(ConfigComment.experienceBoundColor)
            public String experienceBoundColorARGB = DefaultConfigAdapter.I.experienceBoundColorARGB();
            @Comment(ConfigComment.experienceEmptyColor)
            public String experienceEmptyColorARGB = DefaultConfigAdapter.I.experienceEmptyColorARGB();
            @Comment(ConfigComment.airColor)
            public String airColorARGB = DefaultConfigAdapter.I.airColorARGB();
            @Comment(ConfigComment.airBoundColor)
            public String airBoundColorARGB = DefaultConfigAdapter.I.airBoundColorARGB();
            @Comment(ConfigComment.mountHealthColor)
            public String mountHealthColorARGB = DefaultConfigAdapter.I.mountHealthColorARGB();
            @Comment(ConfigComment.mountHealthColor2)
            public String mountHealthColor2ARGB = DefaultConfigAdapter.I.mountHealthColor2ARGB();
            @Comment(ConfigComment.mountHealthBoundColor)
            public String mountHealthBoundColorARGB = DefaultConfigAdapter.I.mountHealthBoundColorARGB();
            @Comment(ConfigComment.mountHealthBoundColor2)
            public String mountHealthBoundColor2ARGB = DefaultConfigAdapter.I.mountHealthBoundColor2ARGB();
            @Comment(ConfigComment.mountHealthEmptyColor)
            public String mountHealthEmptyColorARGB = DefaultConfigAdapter.I.mountHealthEmptyColorARGB();
            @Comment(ConfigComment.mountHealthOnLeftSide)
            public boolean mountHealthOnLeftSide = DefaultConfigAdapter.I.mountHealthOnLeftSide();
            @Comment(ConfigComment.armorColor)
            public String armorColorARGB = DefaultConfigAdapter.I.armorColorARGB();
            @Comment(ConfigComment.armorBoundColor)
            public String armorBoundColorARGB = DefaultConfigAdapter.I.armorBoundColorARGB();
            @Comment(ConfigComment.armorEmptyColor)
            public String armorEmptyColorARGB = DefaultConfigAdapter.I.armorEmptyColorARGB();
            @Comment(ConfigComment.armorToughnessColor)
            public String armorToughnessColorARGB = DefaultConfigAdapter.I.armorToughnessColorARGB();
            @Comment(ConfigComment.enableHealthBlink)
            public boolean enableHealthBlink = DefaultConfigAdapter.I.enableHealthBlink();
            @Comment(ConfigComment.lowHealthRate)
            public double lowHealthRate = DefaultConfigAdapter.I.lowHealthRate();
            @Comment(ConfigComment.shakeHealthAndFoodWhileLow)
            public boolean shakeHealthAndFoodWhileLow = DefaultConfigAdapter.I.shakeHealthAndFoodWhileLow();
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
            @Comment(ConfigComment.displayFoodText)
            public boolean displayFoodText = DefaultConfigAdapter.I.displayFoodText();
            @Comment(ConfigComment.displayArmorToughness)
            public boolean displayArmorToughness = DefaultConfigAdapter.I.displayArmorToughness();
            @Comment(ConfigComment.cornerBarLength)
            public int cornerBarLength = DefaultConfigAdapter.I.cornerBarLength();
            @Comment(ConfigComment.cornerHorizontalPadding)
            public int cornerHorizontalPadding = DefaultConfigAdapter.I.cornerHorizontalPadding();
            @Comment(ConfigComment.cornerVerticalPadding)
            public int cornerVerticalPadding = DefaultConfigAdapter.I.cornerVerticalPadding();
            @Comment(ConfigComment.forceRenderAtCorner)
            public boolean forceRenderAtCorner = DefaultConfigAdapter.I.forceRenderAtCorner();
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
            @Comment(ConfigComment.showOnArmorStands)
            public boolean showOnArmorStands = DefaultConfigAdapter.I.showOnArmorStands();
            @Comment(ConfigComment.showOnFullHealthWithoutAbsorption)
            public boolean showOnFullHealthWithoutAbsorption = DefaultConfigAdapter.I.showOnFullHealthWithoutAbsorption();
            @Comment(ConfigComment.showOnFullHealthWithAbsorption)
            public boolean showOnFullHealthWithAbsorption = DefaultConfigAdapter.I.showOnFullHealthWithAbsorption();
            @Comment(ConfigComment.healthBarAlpha)
            public int healthBarAlpha = DefaultConfigAdapter.I.healthBarAlpha();
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
            public String healthBarHealthColorARGB = DefaultConfigAdapter.I.healthBarHealthColorARGB();
            @Comment(ConfigComment.healthBarAbsorptionColor)
            public String healthBarAbsorptionColorARGB = DefaultConfigAdapter.I.healthBarAbsorptionColorARGB();
            @Comment(ConfigComment.healthBarBoundColor)
            public String healthBarBoundColorARGB = DefaultConfigAdapter.I.healthBarBoundColorARGB();
            @Comment(ConfigComment.healthBarEmptyColor)
            public String healthBarEmptyColorARGB = DefaultConfigAdapter.I.healthBarEmptyColorARGB();
            @Comment(ConfigComment.healthBarHealthColorDynamic)
            public boolean healthBarHealthColorDynamic = DefaultConfigAdapter.I.healthBarHealthColorDynamic();
            @Comment(ConfigComment.healthBarHealthColorFull)
            public String healthBarHealthColorFullARGB = DefaultConfigAdapter.I.healthBarHealthColorFullARGB();
            @Comment(ConfigComment.healthBarHealthColorEmpty)
            public String healthBarHealthColorEmptyARGB = DefaultConfigAdapter.I.healthBarHealthColorEmptyARGB();
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
            @Comment(ConfigComment.hookParcool)
            public boolean hookParcool = DefaultConfigAdapter.I.hookParcool();
            @Comment(ConfigComment.hookIronsSpellbooks)
            public boolean hookIronsSpellbooks = DefaultConfigAdapter.I.hookIronsSpellbooks();
            @Comment(ConfigComment.hookFeathers)
            public boolean hookFeathers = DefaultConfigAdapter.I.hookFeathers();
            @Comment(ConfigComment.hookAppleSkin)
            public boolean hookAppleSkin = DefaultConfigAdapter.I.hookAppleSkin();
            @Comment(ConfigComment.hookSuperiorShields)
            public boolean hookSuperiorShields = DefaultConfigAdapter.I.hookSuperiorShields();
            @Comment(ConfigComment.hookLightShield)
            public boolean hookLightShield = DefaultConfigAdapter.I.hookLightShield();
            @Comment(ConfigComment.hookVampirism)
            public boolean hookVampirism = DefaultConfigAdapter.I.hookVampirism();
            @Comment(ConfigComment.hookHomeostatic)
            public boolean hookHomeostatic = DefaultConfigAdapter.I.hookHomeostatic();
            @Comment(ConfigComment.hookBotania)
            public boolean hookBotania = DefaultConfigAdapter.I.hookBotania();
            @Comment(ConfigComment.hookOrigins)
            public boolean hookOrigins = DefaultConfigAdapter.I.hookOrigins();
            @Comment(ConfigComment.hookTFC)
            public boolean hookTFC = DefaultConfigAdapter.I.hookTFC();
            @Comment(ConfigComment.hookArsNouveau)
            public boolean hookArsNouveau = DefaultConfigAdapter.I.hookArsNouveau();
            @Comment(ConfigComment.hookApoli)
            public boolean hookApoli = DefaultConfigAdapter.I.hookApoli();
            @Comment(ConfigComment.hookThermoo)
            public boolean hookThermoo = DefaultConfigAdapter.I.hookThermoo();
            @Comment(ConfigComment.hookMealAPI)
            public boolean hookMealApi = DefaultConfigAdapter.I.hookMealApi();
            @Comment(ConfigComment.hookLegendarySurvivalOverhaul)
            public boolean hookLegendarySurvivalOverhaul = DefaultConfigAdapter.I.hookLegendarySurvivalOverhaul();
        }
    }
}
