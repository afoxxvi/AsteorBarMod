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
        return 1;
    }

    @Override
    public void overlayLayoutStyle(int style) {

    }

    @Override
    public double overlayTextScale() {
        return 1.0;
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
    public int healthColorNormal() {
        return 0xffff4545;
    }

    @Override
    public int healthColorPoison() {
        return 0xff9c8022;
    }

    @Override
    public int healthColorWither() {
        return 0xff4f2727;
    }

    @Override
    public int healthColorFrozen() {
        return 0xff3798f4;
    }

    @Override
    public int healthBoundColor() {
        return 0xff5d4848;
    }

    @Override
    public int healthBoundColorBlink() {
        return 0xffffffff;
    }

    @Override
    public int healthBoundColorLow() {
        return 0xffff0000;
    }

    @Override
    public int healthEmptyColor() {
        return 0xff464646;
    }

    @Override
    public int absorptionColor() {
        return 0xffe5d35c;
    }

    @Override
    public int absorptionBoundColor() {
        return 0xffe5d35c;
    }

    @Override
    public int foodColorNormal() {
        return 0xfff4f24c;
    }

    @Override
    public int foodColorHunger() {
        return 0xffb0be54;
    }

    @Override
    public int foodBoundColor() {
        return 0xff6a6142;
    }

    @Override
    public int foodBoundColorBlink() {
        return 0xff8e835d;
    }

    @Override
    public int foodEmptyColor() {
        return 0xff464646;
    }

    @Override
    public int saturationColor() {
        return 0xfffffe91;
    }

    @Override
    public int experienceColor() {
        return 0xff86c457;
    }

    @Override
    public int experienceBoundColor() {
        return 0xff09100c;
    }

    @Override
    public int experienceEmptyColor() {
        return 0xff29352f;
    }

    @Override
    public int airColor() {
        return 0xffd1ebff;
    }

    @Override
    public int airBoundColor() {
        return 0xff0094ff;
    }

    @Override
    public int mountHealthColor() {
        return 0xffda662c;
    }

    @Override
    public int mountHealthColor2() {
        return 0xffc1c1c1;
    }

    @Override
    public int mountHealthBoundColor() {
        return 0xff7f3919;
    }

    @Override
    public int mountHealthBoundColor2() {
        return 0xff797979;
    }

    @Override
    public int mountHealthEmptyColor() {
        return 0xff464646;
    }

    @Override
    public int armorColor() {
        return 0xffe6e7f2;
    }

    @Override
    public int armorBoundColor() {
        return 0xff323232;
    }

    @Override
    public int armorEmptyColor() {
        return 0xff464646;
    }

    @Override
    public int armorToughnessColor() {
        return 0xff75cdff;
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
    public boolean showOnFullHealthWithoutAbsorption() {
        return true;
    }

    @Override
    public boolean showOnFullHealthWithAbsorption() {
        return true;
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
    public int healthBarHealthColor() {
        return 0xAA008000;
    }

    @Override
    public int healthBarAbsorptionColor() {
        return 0xAAFFFF00;
    }

    @Override
    public int healthBarBoundColor() {
        return 0x55000000;
    }

    @Override
    public int healthBarEmptyColor() {
        return 0x33000000;
    }

    @Override
    public boolean healthBarHealthColorDynamic() {
        return true;
    }

    @Override
    public int healthBarHealthColorFull() {
        return 0xAA008000;
    }

    @Override
    public int healthBarHealthColorEmpty() {
        return 0xAA800000;
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
    public boolean hookVampirism() {
        return true;
    }
}
