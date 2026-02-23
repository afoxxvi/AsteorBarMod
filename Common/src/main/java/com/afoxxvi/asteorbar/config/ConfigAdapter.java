package com.afoxxvi.asteorbar.config;

import com.afoxxvi.asteorbar.utils.Utils;

public interface ConfigAdapter {
    boolean enableOverlay();

    void enableOverlay(boolean enable);

    int overlayLayoutStyle();

    void overlayLayoutStyle(int style);

    double overlayTextScale();

    int overlayBarInnerHeight();

    int overlayBarVerticalMargin();

    int overlayBarTextOffsetY();

    double hideDecimalWhenEqualOrMoreThan();

    int fullFoodLevelValue();

    double fullSaturationValue();

    double fullExhaustionValue();

    int fullArmorValue();

    int fullArmorToughnessValue();

    int fullHealthValue();

    boolean enableStackHealthBar();

    String stackHealthBarColors();

    double healthRegenerationOpacity();

    double healthRegenerationOpacityOnFull();

    int hideUnchangingBarAfterSeconds();

    default int healthColorNormal() {
        return Utils.parseColor(healthColorNormalARGB());
    }

    String healthColorNormalARGB();

    default int healthColorPoison() {
        return Utils.parseColor(healthColorPoisonARGB());
    }

    String healthColorPoisonARGB();

    default int healthColorWither() {
        return Utils.parseColor(healthColorWitherARGB());
    }

    String healthColorWitherARGB();

    default int healthColorFrozen() {
        return Utils.parseColor(healthColorFrozenARGB());
    }

    String healthColorFrozenARGB();

    default int healthBoundColor() {
        return Utils.parseColor(healthBoundColorARGB());
    }

    String healthBoundColorARGB();

    default int healthBoundColorBlink() {
        return Utils.parseColor(healthBoundColorBlinkARGB());
    }

    String healthBoundColorBlinkARGB();

    default int healthBoundColorLow() {
        return Utils.parseColor(healthBoundColorLowARGB());
    }

    String healthBoundColorLowARGB();

    default int healthEmptyColor() {
        return Utils.parseColor(healthEmptyColorARGB());
    }

    String healthEmptyColorARGB();

    default int absorptionColor() {
        return Utils.parseColor(absorptionColorARGB());
    }

    String absorptionColorARGB();

    default int absorptionBoundColor() {
        return Utils.parseColor(absorptionBoundColorARGB());
    }

    String absorptionBoundColorARGB();

    default int foodColorNormal() {
        return Utils.parseColor(foodColorNormalARGB());
    }

    String foodColorNormalARGB();

    default int foodColorHunger() {
        return Utils.parseColor(foodColorHungerARGB());
    }

    String foodColorHungerARGB();

    default int foodBoundColor() {
        return Utils.parseColor(foodBoundColorARGB());
    }

    String foodBoundColorARGB();

    default int foodBoundColorBlink() {
        return Utils.parseColor(foodBoundColorBlinkARGB());
    }

    String foodBoundColorBlinkARGB();

    default int foodEmptyColor() {
        return Utils.parseColor(foodEmptyColorARGB());
    }

    String foodEmptyColorARGB();

    default int saturationColor() {
        return Utils.parseColor(saturationColorARGB());
    }

    String saturationColorARGB();

    default int experienceColor() {
        return Utils.parseColor(experienceColorARGB());
    }

    String experienceColorARGB();

    default int experienceBoundColor() {
        return Utils.parseColor(experienceBoundColorARGB());
    }

    String experienceBoundColorARGB();

    default int experienceEmptyColor() {
        return Utils.parseColor(experienceEmptyColorARGB());
    }

    String experienceEmptyColorARGB();

    default int airColor() {
        return Utils.parseColor(airColorARGB());
    }

    String airColorARGB();

    default int airBoundColor() {
        return Utils.parseColor(airBoundColorARGB());
    }

    String airBoundColorARGB();

    default int mountHealthColor() {
        return Utils.parseColor(mountHealthColorARGB());
    }

    String mountHealthColorARGB();

    default int mountHealthColor2() {
        return Utils.parseColor(mountHealthColor2ARGB());
    }

    String mountHealthColor2ARGB();

    default int mountHealthBoundColor() {
        return Utils.parseColor(mountHealthBoundColorARGB());
    }

    String mountHealthBoundColorARGB();

    default int mountHealthBoundColor2() {
        return Utils.parseColor(mountHealthBoundColor2ARGB());
    }

    String mountHealthBoundColor2ARGB();

    default int mountHealthEmptyColor() {
        return Utils.parseColor(mountHealthEmptyColorARGB());
    }

    String mountHealthEmptyColorARGB();

    boolean mountHealthOnLeftSide();

    default int armorColor() {
        return Utils.parseColor(armorColorARGB());
    }

    String armorColorARGB();

    default int armorBoundColor() {
        return Utils.parseColor(armorBoundColorARGB());
    }

    String armorBoundColorARGB();

    default int armorEmptyColor() {
        return Utils.parseColor(armorEmptyColorARGB());
    }

    String armorEmptyColorARGB();

    default int armorToughnessColor() {
        return Utils.parseColor(armorToughnessColorARGB());
    }

    String armorToughnessColorARGB();

    boolean enableHealthBlink();

    double lowHealthRate();

    boolean shakeHealthAndFoodWhileLow();

    boolean overwriteVanillaArmorBar();

    boolean overwriteVanillaExperienceBar();

    boolean displayExperienceProgress();

    boolean displayExperienceLevel();

    boolean displayHealthText();

    int displayAbsorptionMethod();

    boolean displayAbsorptionDivMaxHealth();

    int displayAbsorptionTextMethod();

    boolean enableFoodBlink();

    boolean displaySaturation();

    boolean displayExhaustion();

    boolean displayFoodText();

    boolean displayArmorToughness();

    int cornerBarLength();

    int cornerHorizontalPadding();

    int cornerVerticalPadding();

    boolean forceRenderAtCorner();

    //mob config
    boolean enableHealthBar();

    void enableHealthBar(boolean enable);

    double maxDistance();

    boolean showOnSelf();

    boolean showOnPlayers();

    boolean showOnBosses();

    boolean showOnArmorStands();

    boolean showOnFullHealthWithoutAbsorption();

    boolean showOnFullHealthWithAbsorption();

    int healthBarAlpha();

    int healthBarHalfWidth();

    int healthBarHalfHeight();

    double healthBarOffsetY();

    double healthBarScale();

    double healthBarTextScale();

    double healthBarTextOffsetY();

    int healthBarBoundWidth();

    boolean healthBarBoundVertex();

    default int healthBarHealthColor() {
        return Utils.parseColor(healthBarHealthColorARGB());
    }

    String healthBarHealthColorARGB();

    default int healthBarAbsorptionColor() {
        return Utils.parseColor(healthBarAbsorptionColorARGB());
    }

    String healthBarAbsorptionColorARGB();

    default int healthBarBoundColor() {
        return Utils.parseColor(healthBarBoundColorARGB());
    }

    String healthBarBoundColorARGB();

    default int healthBarEmptyColor() {
        return Utils.parseColor(healthBarEmptyColorARGB());
    }

    String healthBarEmptyColorARGB();

    boolean healthBarHealthColorDynamic();

    default int healthBarHealthColorFull() {
        return Utils.parseColor(healthBarHealthColorFullARGB());
    }

    String healthBarHealthColorFullARGB();

    default int healthBarHealthColorEmpty() {
        return Utils.parseColor(healthBarHealthColorEmptyARGB());
    }

    String healthBarHealthColorEmptyARGB();

    boolean hookToughAsNails();

    boolean hookThirstWasTaken();

    boolean hookMekanism();

    boolean hookDehydration();

    boolean hookParcool();

    boolean hookIronsSpellbooks();

    boolean hookFeathers();

    boolean hookAppleSkin();

    boolean hookSuperiorShields();

    boolean hookVampirism();

    boolean hookBotania();

    boolean hookOrigins();

    boolean hookTFC();

    boolean hookArsNouveau();

    boolean hookApoli();

    boolean hookThermoo();

    boolean hookMealApi();

    boolean hookLegendarySurvivalOverhaul();
}
