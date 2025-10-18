package com.afoxxvi.asteorbar.config;

public class DefaultConfigAdapter implements ConfigAdapter {
    public static final DefaultConfigAdapter I = new DefaultConfigAdapter();

    @Override
    public boolean enableOverlay() {
        return true;
    }

    @Override
    public void enableOverlay(boolean enable) {

    }

    @Override
    public int overlayLayoutStyle() {
        return 2;
    }

    @Override
    public void overlayLayoutStyle(int style) {

    }

    @Override
    public double overlayTextScale() {
        return 1.0;
    }

    @Override
    public int overlayBarInnerHeight() {
        return 3;
    }

    @Override
    public int overlayBarVerticalMargin() {
        return 1;
    }

    @Override
    public int overlayBarTextOffsetY() {
        return -2;
    }

    @Override
    public double hideDecimalWhenEqualOrMoreThan() {
        return 100.0;
    }

    @Override
    public int fullFoodLevelValue() {
        return 20;
    }

    @Override
    public double fullSaturationValue() {
        return 20;
    }

    @Override
    public double fullExhaustionValue() {
        return 4;
    }

    @Override
    public int fullArmorValue() {
        return 20;
    }

    @Override
    public int fullArmorToughnessValue() {
        return 12;
    }

    @Override
    public int fullHealthValue() {
        return 20;
    }

    @Override
    public boolean enableStackHealthBar() {
        return false;
    }

    @Override
    public String stackHealthBarColors() {
        return "#ffff4545,#ffefa360,#ff966acc,#ffcc64a8,#ff1dc29b,#ff9acc64";
    }

    @Override
    public double healthRegenerationOpacity() {
        return 1.0;
    }

    @Override
    public double healthRegenerationOpacityOnFull() {
        return 0.33;
    }

    @Override
    public int hideUnchangingBarAfterSeconds() {
        return 0;
    }

    @Override
    public String healthColorNormalARGB() {
        return "#ffff4545";
    }

    @Override
    public String healthColorPoisonARGB() {
        return "#ff9c8022";
    }

    @Override
    public String healthColorWitherARGB() {
        return "#ff4f2727";
    }

    @Override
    public String healthColorFrozenARGB() {
        return "#ff3798f4";
    }

    @Override
    public String healthBoundColorARGB() {
        return "#ff5d4848";
    }

    @Override
    public String healthBoundColorBlinkARGB() {
        return "#ffffffff";
    }

    @Override
    public String healthBoundColorLowARGB() {
        return "#ffff0000";
    }

    @Override
    public String healthEmptyColorARGB() {
        return "#ff464646";
    }

    @Override
    public String absorptionColorARGB() {
        return "#ffe5d35c";
    }

    @Override
    public String absorptionBoundColorARGB() {
        return "#ffe5d35c";
    }

    @Override
    public String foodColorNormalARGB() {
        return "#fff4f24c";
    }

    @Override
    public String foodColorHungerARGB() {
        return "#ffb0be54";
    }

    @Override
    public String foodBoundColorARGB() {
        return "#ff6a6142";
    }

    @Override
    public String foodBoundColorBlinkARGB() {
        return "#ff8e835d";
    }

    @Override
    public String foodEmptyColorARGB() {
        return "#ff464646";
    }

    @Override
    public String saturationColorARGB() {
        return "#fffffe91";
    }

    @Override
    public String experienceColorARGB() {
        return "#ff86c457";
    }

    @Override
    public String experienceBoundColorARGB() {
        return "#ff09100c";
    }

    @Override
    public String experienceEmptyColorARGB() {
        return "#ff29352f";
    }

    @Override
    public String airColorARGB() {
        return "#ffd1ebff";
    }

    @Override
    public String airBoundColorARGB() {
        return "#ff0094ff";
    }

    @Override
    public String mountHealthColorARGB() {
        return "#ffda662c";
    }

    @Override
    public String mountHealthColor2ARGB() {
        return "#ffc1c1c1";
    }

    @Override
    public String mountHealthBoundColorARGB() {
        return "#ff7f3919";
    }

    @Override
    public String mountHealthBoundColor2ARGB() {
        return "#ff797979";
    }

    @Override
    public String mountHealthEmptyColorARGB() {
        return "#ff464646";
    }

    @Override
    public boolean mountHealthOnLeftSide() {
        return false;
    }

    @Override
    public String armorColorARGB() {
        return "#ffe6e7f2";
    }

    @Override
    public String armorBoundColorARGB() {
        return "#ff323232";
    }

    @Override
    public String armorEmptyColorARGB() {
        return "#ff464646";
    }

    @Override
    public String armorToughnessColorARGB() {
        return "#ff75cdff";
    }

    @Override
    public boolean enableHealthBlink() {
        return true;
    }

    @Override
    public double lowHealthRate() {
        return 0.2;
    }

    @Override
    public boolean shakeHealthAndFoodWhileLow() {
        return true;
    }

    @Override
    public boolean overwriteVanillaArmorBar() {
        return true;
    }

    @Override
    public boolean overwriteVanillaExperienceBar() {
        return true;
    }

    @Override
    public boolean displayExperienceProgress() {
        return true;
    }

    @Override
    public boolean displayExperienceLevel() {
        return true;
    }

    @Override
    public boolean displayHealthText() {
        return true;
    }

    @Override
    public int displayAbsorptionMethod() {
        return 2;
    }

    @Override
    public boolean displayAbsorptionDivMaxHealth() {
        return false;
    }

    @Override
    public int displayAbsorptionTextMethod() {
        return 1;
    }

    @Override
    public boolean enableFoodBlink() {
        return true;
    }

    @Override
    public boolean displaySaturation() {
        return true;
    }

    @Override
    public boolean displayExhaustion() {
        return true;
    }

    @Override
    public boolean displayFoodText() {
        return false;
    }

    @Override
    public boolean displayArmorToughness() {
        return true;
    }

    @Override
    public int cornerBarLength() {
        return 120;
    }

    @Override
    public int cornerHorizontalPadding() {
        return 16;
    }

    @Override
    public int cornerVerticalPadding() {
        return 16;
    }

    @Override
    public boolean forceRenderAtCorner() {
        return false;
    }

    @Override
    public boolean enableHealthBar() {
        return true;
    }

    @Override
    public void enableHealthBar(boolean enable) {

    }

    @Override
    public double maxDistance() {
        return 32;
    }

    @Override
    public boolean showOnSelf() {
        return true;
    }

    @Override
    public boolean showOnPlayers() {
        return true;
    }

    @Override
    public boolean showOnBosses() {
        return true;
    }

    @Override
    public boolean showOnArmorStands() {
        return false;
    }

    @Override
    public boolean showOnFullHealthWithoutAbsorption() {
        return true;
    }

    @Override
    public boolean showOnFullHealthWithAbsorption() {
        return true;
    }

    @Override
    public int healthBarAlpha() {
        return 180;
    }

    @Override
    public int healthBarHalfWidth() {
        return 50;
    }

    @Override
    public int healthBarHalfHeight() {
        return 3;
    }

    @Override
    public double healthBarOffsetY() {
        return 0.2;
    }

    @Override
    public double healthBarScale() {
        return 0.015;
    }

    @Override
    public double healthBarTextScale() {
        return 0.8;
    }

    @Override
    public double healthBarTextOffsetY() {
        return -2.75;
    }

    @Override
    public int healthBarBoundWidth() {
        return 2;
    }

    @Override
    public boolean healthBarBoundVertex() {
        return false;
    }

    @Override
    public String healthBarHealthColorARGB() {
        return "#AA008000";
    }

    @Override
    public String healthBarAbsorptionColorARGB() {
        return "#AAFFFF00";
    }

    @Override
    public String healthBarBoundColorARGB() {
        return "#55606060";
    }

    @Override
    public String healthBarEmptyColorARGB() {
        return "#33404040";
    }

    @Override
    public boolean healthBarHealthColorDynamic() {
        return true;
    }

    @Override
    public String healthBarHealthColorFullARGB() {
        return "#AA008000";
    }

    @Override
    public String healthBarHealthColorEmptyARGB() {
        return "#AA800000";
    }

    @Override
    public boolean hookToughAsNails() {
        return true;
    }

    @Override
    public boolean hookThirstWasTaken() {
        return true;
    }

    @Override
    public boolean hookMekanism() {
        return true;
    }

    @Override
    public boolean hookDehydration() {
        return true;
    }

    @Override
    public boolean hookParcool() {
        return true;
    }

    @Override
    public boolean hookIronsSpellbooks() {
        return true;
    }

    @Override
    public boolean hookFeathers() {
        return true;
    }

    @Override
    public boolean hookAppleSkin() {
        return true;
    }

    @Override
    public boolean hookSuperiorShields() {
        return true;
    }

    @Override
    public boolean hookLightShield() {
        return true;
    }

    @Override
    public boolean hookVampirism() {
        return true;
    }

    @Override
    public boolean hookHomeostatic() {
        return true;
    }

    @Override
    public boolean hookBotania() {
        return true;
    }

    @Override
    public boolean hookOrigins() {
        return true;
    }

    @Override
    public boolean hookTFC() {
        return true;
    }

    @Override
    public boolean hookArsNouveau() {
        return true;
    }

    @Override
    public boolean hookApoli() {
        return true;
    }

    @Override
    public boolean hookThermoo() {
        return true;
    }

    @Override
    public boolean hookMealApi() {
        return true;
    }

    @Override
    public boolean hookLegendarySurvivalOverhaul() {
        return true;
    }
}
