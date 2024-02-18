package com.afoxxvi.asteorbar.config;

import com.afoxxvi.asteorbar.AsteorBar;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

public class FabricConfigAdapter implements ConfigAdapter {
    @Override
    public boolean enableOverlay() {
        return config.ENABLE_OVERLAY;
    }

    @Override
    public void enableOverlay(boolean enable) {
        config.ENABLE_OVERLAY = enable;
    }

    @Override
    public int overlayLayoutStyle() {
        return config.OVERLAY_LAYOUT_STYLE;
    }

    @Override
    public void overlayLayoutStyle(int style) {
        config.OVERLAY_LAYOUT_STYLE = style;
    }

    @Override
    public double overlayTextScale() {
        return config.OVERLAY_TEXT_SCALE;
    }

    @Override
    public int healthColorNormal() {
        return config.HEALTH_COLOR_NORMAL;
    }

    @Override
    public int healthColorPoison() {
        return config.HEALTH_COLOR_POISON;
    }

    @Override
    public int healthColorWither() {
        return config.HEALTH_COLOR_WITHER;
    }

    @Override
    public int healthColorFrozen() {
        return config.HEALTH_COLOR_FROZEN;
    }

    @Override
    public int healthBoundColor() {
        return config.HEALTH_BOUND_COLOR;
    }

    @Override
    public int healthBoundColorBlink() {
        return config.HEALTH_BOUND_COLOR_BLINK;
    }

    @Override
    public int healthBoundColorLow() {
        return config.HEALTH_BOUND_COLOR_LOW;
    }

    @Override
    public int healthEmptyColor() {
        return config.HEALTH_EMPTY_COLOR;
    }

    @Override
    public int absorptionColor() {
        return config.ABSORPTION_COLOR;
    }

    @Override
    public int absorptionBoundColor() {
        return config.ABSORPTION_BOUND_COLOR;
    }

    @Override
    public int foodColorNormal() {
        return config.FOOD_COLOR_NORMAL;
    }

    @Override
    public int foodColorHunger() {
        return config.FOOD_COLOR_HUNGER;
    }

    @Override
    public int foodBoundColor() {
        return config.FOOD_BOUND_COLOR;
    }

    @Override
    public int foodBoundColorBlink() {
        return config.FOOD_BOUND_COLOR_BLINK;
    }

    @Override
    public int foodEmptyColor() {
        return config.FOOD_EMPTY_COLOR;
    }

    @Override
    public int saturationColor() {
        return config.SATURATION_COLOR;
    }

    @Override
    public int experienceColor() {
        return config.EXPERIENCE_COLOR;
    }

    @Override
    public int experienceBoundColor() {
        return config.EXPERIENCE_BOUND_COLOR;
    }

    @Override
    public int experienceEmptyColor() {
        return config.EXPERIENCE_EMPTY_COLOR;
    }

    @Override
    public int airColor() {
        return config.AIR_COLOR;
    }

    @Override
    public int airBoundColor() {
        return config.AIR_BOUND_COLOR;
    }

    @Override
    public int mountHealthColor() {
        return config.MOUNT_HEALTH_COLOR;
    }

    @Override
    public int mountHealthColor2() {
        return config.MOUNT_HEALTH_COLOR_2;
    }

    @Override
    public int mountHealthBoundColor() {
        return config.MOUNT_HEALTH_BOUND_COLOR;
    }

    @Override
    public int mountHealthBoundColor2() {
        return config.MOUNT_HEALTH_BOUND_COLOR_2;
    }

    @Override
    public int mountHealthEmptyColor() {
        return config.MOUNT_HEALTH_EMPTY_COLOR;
    }

    @Override
    public int armorColor() {
        return config.ARMOR_COLOR;
    }

    @Override
    public int armorBoundColor() {
        return config.ARMOR_BOUND_COLOR;
    }

    @Override
    public int armorEmptyColor() {
        return config.ARMOR_EMPTY_COLOR;
    }

    @Override
    public int armorToughnessColor() {
        return config.ARMOR_TOUGHNESS_COLOR;
    }

    @Override
    public boolean enableHealthBlink() {
        return config.ENABLE_HEALTH_BLINK;
    }

    @Override
    public double lowHealthRate() {
        return config.LOW_HEALTH_RATE;
    }

    @Override
    public boolean overwriteVanillaArmorBar() {
        return config.OVERWRITE_VANILLA_ARMOR_BAR;
    }

    @Override
    public boolean overwriteVanillaExperienceBar() {
        return config.OVERWRITE_VANILLA_EXPERIENCE_BAR;
    }

    @Override
    public boolean displayExperienceProgress() {
        return config.DISPLAY_EXPERIENCE_PROGRESS;
    }

    @Override
    public boolean displayExperienceLevel() {
        return config.DISPLAY_EXPERIENCE_LEVEL;
    }

    @Override
    public boolean displayHealthText() {
        return config.DISPLAY_HEALTH_TEXT;
    }

    @Override
    public int displayAbsorptionMethod() {
        return config.DISPLAY_ABSORPTION_METHOD;
    }

    @Override
    public boolean displayAbsorptionDivMaxHealth() {
        return config.DISPLAY_ABSORPTION_DIV_MAX_HEALTH;
    }

    @Override
    public int displayAbsorptionTextMethod() {
        return config.DISPLAY_ABSORPTION_TEXT_METHOD;
    }

    @Override
    public boolean enableFoodBlink() {
        return config.ENABLE_FOOD_BLINK;
    }

    @Override
    public boolean displaySaturation() {
        return config.DISPLAY_SATURATION;
    }

    @Override
    public boolean displayExhaustion() {
        return config.DISPLAY_EXHAUSTION;
    }

    @Override
    public boolean displayArmorToughness() {
        return config.DISPLAY_ARMOR_TOUGHNESS;
    }

    @Override
    public int cornerBarLength() {
        return config.CORNER_BAR_LENGTH;
    }

    @Override
    public int cornerHorizontalPadding() {
        return config.CORNER_HORIZONTAL_PADDING;
    }

    @Override
    public int cornerVerticalPadding() {
        return config.CORNER_VERTICAL_PADDING;
    }

    @Override
    public boolean enableHealthBar() {
        return config.ENABLE_HEALTH_BAR;
    }

    @Override
    public void enableHealthBar(boolean enable) {
        config.ENABLE_HEALTH_BAR = enable;
    }

    @Override
    public double maxDistance() {
        return config.MAX_DISTANCE;
    }

    @Override
    public boolean showOnPlayers() {
        return config.SHOW_ON_PLAYERS;
    }

    @Override
    public boolean showOnBosses() {
        return config.SHOW_ON_BOSSES;
    }

    @Override
    public boolean showOnFullHealthWithoutAbsorption() {
        return config.SHOW_ON_FULL_HEALTH_WITHOUT_ABSORPTION;
    }

    @Override
    public boolean showOnFullHealthWithAbsorption() {
        return config.SHOW_ON_FULL_HEALTH_WITH_ABSORPTION;
    }

    @Override
    public int healthBarHalfWidth() {
        return config.HEALTH_BAR_HALF_WIDTH;
    }

    @Override
    public int healthBarHalfHeight() {
        return config.HEALTH_BAR_HALF_HEIGHT;
    }

    @Override
    public double healthBarOffsetY() {
        return config.HEALTH_BAR_OFFSET_Y;
    }

    @Override
    public double healthBarScale() {
        return config.HEALTH_BAR_SCALE;
    }

    @Override
    public double healthBarTextScale() {
        return config.HEALTH_BAR_TEXT_SCALE;
    }

    @Override
    public double healthBarTextOffsetY() {
        return config.HEALTH_BAR_TEXT_OFFSET_Y;
    }

    @Override
    public int healthBarBoundWidth() {
        return config.HEALTH_BAR_BOUND_WIDTH;
    }

    @Override
    public boolean healthBarBoundVertex() {
        return config.HEALTH_BAR_BOUND_VERTEX;
    }

    @Override
    public int healthBarHealthColor() {
        return config.HEALTH_BAR_HEALTH_COLOR;
    }

    @Override
    public int healthBarAbsorptionColor() {
        return config.HEALTH_BAR_ABSORPTION_COLOR;
    }

    @Override
    public int healthBarBoundColor() {
        return config.HEALTH_BAR_BOUND_COLOR;
    }

    @Override
    public int healthBarEmptyColor() {
        return config.HEALTH_BAR_EMPTY_COLOR;
    }

    @Override
    public boolean healthBarHealthColorDynamic() {
        return config.HEALTH_BAR_HEALTH_COLOR_DYNAMIC;
    }

    @Override
    public int healthBarHealthColorFull() {
        return config.HEALTH_BAR_HEALTH_COLOR_FULL;
    }

    @Override
    public int healthBarHealthColorEmpty() {
        return config.HEALTH_BAR_HEALTH_COLOR_EMPTY;
    }

    public static void init() {
        AutoConfig.register(FabricConfigAdapter.AsteorBarConfig.class, Toml4jConfigSerializer::new);
        config = AutoConfig.getConfigHolder(FabricConfigAdapter.AsteorBarConfig.class).getConfig();
    }

    private static FabricConfigAdapter.AsteorBarConfig config;

    @Config(name = AsteorBar.MOD_ID)
    public static class AsteorBarConfig implements ConfigData {
        //overlay config
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to enable the overlay. If disabled, all other overlay options will be ignored.")
        public boolean ENABLE_OVERLAY = DefaultConfigAdapter.I.enableOverlay();
        @ConfigEntry.Gui.Tooltip
        @Comment("The layout style of the overlay. 0: none, 1: above hot bar long, 2: above hot bar short, 3: top left, 4: top right, 5: bottom left, 6: bottom right")
        public int OVERLAY_LAYOUT_STYLE = DefaultConfigAdapter.I.overlayLayoutStyle();

        @ConfigEntry.Gui.Tooltip
        @Comment("The text scale of the overlay")
        public double OVERLAY_TEXT_SCALE = DefaultConfigAdapter.I.overlayTextScale();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int HEALTH_COLOR_NORMAL = DefaultConfigAdapter.I.healthColorNormal();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the poison health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int HEALTH_COLOR_POISON = DefaultConfigAdapter.I.healthColorPoison();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the wither health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int HEALTH_COLOR_WITHER = DefaultConfigAdapter.I.healthColorWither();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the frozen health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int HEALTH_COLOR_FROZEN = DefaultConfigAdapter.I.healthColorFrozen();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the health bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int HEALTH_BOUND_COLOR = DefaultConfigAdapter.I.healthBoundColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the health bar bound when blinking. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int HEALTH_BOUND_COLOR_BLINK = DefaultConfigAdapter.I.healthBoundColorBlink();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the low health bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int HEALTH_BOUND_COLOR_LOW = DefaultConfigAdapter.I.healthBoundColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the empty part of the health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int HEALTH_EMPTY_COLOR = DefaultConfigAdapter.I.healthEmptyColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the absorption bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int ABSORPTION_COLOR = DefaultConfigAdapter.I.absorptionColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the absorption bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int ABSORPTION_BOUND_COLOR = DefaultConfigAdapter.I.absorptionBoundColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the normal food level bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int FOOD_COLOR_NORMAL = DefaultConfigAdapter.I.foodColorNormal();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the hunger food level bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int FOOD_COLOR_HUNGER = DefaultConfigAdapter.I.foodColorHunger();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the food level bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int FOOD_BOUND_COLOR = DefaultConfigAdapter.I.foodBoundColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the food level bar bound when blinking. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int FOOD_BOUND_COLOR_BLINK = DefaultConfigAdapter.I.foodBoundColorBlink();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the empty part of the food level bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int FOOD_EMPTY_COLOR = DefaultConfigAdapter.I.foodEmptyColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the saturation bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int SATURATION_COLOR = DefaultConfigAdapter.I.saturationColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the experience bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int EXPERIENCE_COLOR = DefaultConfigAdapter.I.experienceColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the experience bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int EXPERIENCE_BOUND_COLOR = DefaultConfigAdapter.I.experienceBoundColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the empty part of the experience bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int EXPERIENCE_EMPTY_COLOR = DefaultConfigAdapter.I.experienceEmptyColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the air bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int AIR_COLOR = DefaultConfigAdapter.I.airColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the air bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int AIR_BOUND_COLOR = DefaultConfigAdapter.I.airBoundColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the mount health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int MOUNT_HEALTH_COLOR = DefaultConfigAdapter.I.mountHealthColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the second mount health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int MOUNT_HEALTH_COLOR_2 = DefaultConfigAdapter.I.mountHealthColor2();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the mount health bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int MOUNT_HEALTH_BOUND_COLOR = DefaultConfigAdapter.I.mountHealthBoundColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the second mount health bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int MOUNT_HEALTH_BOUND_COLOR_2 = DefaultConfigAdapter.I.mountHealthBoundColor2();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the empty part of the mount health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int MOUNT_HEALTH_EMPTY_COLOR = DefaultConfigAdapter.I.mountHealthEmptyColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the armor bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int ARMOR_COLOR = DefaultConfigAdapter.I.armorColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the armor bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int ARMOR_BOUND_COLOR = DefaultConfigAdapter.I.armorBoundColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the empty part of the armor bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int ARMOR_EMPTY_COLOR = DefaultConfigAdapter.I.armorEmptyColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the armor toughness bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int ARMOR_TOUGHNESS_COLOR = DefaultConfigAdapter.I.armorToughnessColor();

        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to enable health bar blink. This feature is designed to simulate the vanilla health icon blink.")
        public boolean ENABLE_HEALTH_BLINK = DefaultConfigAdapter.I.enableHealthBlink();
        @ConfigEntry.Gui.Tooltip
        @Comment("The health bar will start to flash when health rate is lower than this value. From 0.0-1.0. 0.0 means never flash.")
        public double LOW_HEALTH_RATE = DefaultConfigAdapter.I.lowHealthRate();
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to overwrite vanilla armor bar. If you don't like the mod's armor bar, you can disable this option.")
        public boolean OVERWRITE_VANILLA_ARMOR_BAR = DefaultConfigAdapter.I.overwriteVanillaArmorBar();
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to overwrite vanilla experience bar. If you don't like the mod's experience bar, you can disable this option, progress label won't be affected.")
        public boolean OVERWRITE_VANILLA_EXPERIENCE_BAR = DefaultConfigAdapter.I.overwriteVanillaExperienceBar();
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to display experience progress on the side of the experience bar.")
        public boolean DISPLAY_EXPERIENCE_PROGRESS = DefaultConfigAdapter.I.displayExperienceProgress();
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to display experience level on the experience bar.")
        public boolean DISPLAY_EXPERIENCE_LEVEL = DefaultConfigAdapter.I.displayExperienceLevel();
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to display health text.")
        public boolean DISPLAY_HEALTH_TEXT = DefaultConfigAdapter.I.displayHealthText();
        @ConfigEntry.Gui.Tooltip
        @Comment("0: Absorption will be displayed together with health bar. "
                + "1: Absorption will be displayed half transparently on the health bar. "
                + "2: Absorption will be displayed as bounds. "
                + "Note: Since the absorption value can be higher than the max health, an extra number will be displayed to indicate value of absorption/max health, you can turn it off by editing 'displayAbsorptionDivMaxHealth'.")
        public int DISPLAY_ABSORPTION_METHOD = DefaultConfigAdapter.I.displayAbsorptionMethod();
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to display the value of (absorption / max health). To avoid ambiguity, turn it to true if you hide the health text and don't display absorption bar together with health bar, or you may not be able to get correct absorption value.")
        public boolean DISPLAY_ABSORPTION_DIV_MAX_HEALTH = DefaultConfigAdapter.I.displayAbsorptionDivMaxHealth();
        @ConfigEntry.Gui.Tooltip
        @Comment("0: Absorption text will be displayed together with health text. for example: 15(+10)/20. "
                + "1: Absorption text will be displayed separately. for example: 10 15/20. "
                + "Note: if 'displayHealthText' is false, absorption text will be disabled.")
        public int DISPLAY_ABSORPTION_TEXT_METHOD = DefaultConfigAdapter.I.displayAbsorptionTextMethod();
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to enable food level bar blink. This feature is designed to simulate the vanilla food icon shake.")
        public boolean ENABLE_FOOD_BLINK = DefaultConfigAdapter.I.enableFoodBlink();
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to display saturation bar.")
        public boolean DISPLAY_SATURATION = DefaultConfigAdapter.I.displaySaturation();
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to display exhaustion bar.")
        public boolean DISPLAY_EXHAUSTION = DefaultConfigAdapter.I.displayExhaustion();
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to display armor toughness bar.")
        public boolean DISPLAY_ARMOR_TOUGHNESS = DefaultConfigAdapter.I.displayArmorToughness();
        @ConfigEntry.Gui.Tooltip
        @Comment("The length of the bars if using corner layout. Affected bars: health, food, experience.")
        public int CORNER_BAR_LENGTH = DefaultConfigAdapter.I.cornerBarLength();
        @ConfigEntry.Gui.Tooltip
        @Comment("The horizontal padding of the bars if using corner layout.")
        public int CORNER_HORIZONTAL_PADDING = DefaultConfigAdapter.I.cornerHorizontalPadding();
        @ConfigEntry.Gui.Tooltip
        @Comment("The vertical padding of the bars if using corner layout.")
        public int CORNER_VERTICAL_PADDING = DefaultConfigAdapter.I.cornerVerticalPadding();
        //mob config
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to enable health bar for entity. If disabled, all other health bar options will be ignored.")
        public boolean ENABLE_HEALTH_BAR = DefaultConfigAdapter.I.enableHealthBar();
        @ConfigEntry.Gui.Tooltip
        @Comment("The maximum distance to display mob health bar.")
        public double MAX_DISTANCE = DefaultConfigAdapter.I.maxDistance();
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to display health bar on players.")
        public boolean SHOW_ON_PLAYERS = DefaultConfigAdapter.I.showOnPlayers();
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to display health bar on bosses.")
        public boolean SHOW_ON_BOSSES = DefaultConfigAdapter.I.showOnBosses();
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to display health bar on mobs with full health if the mob's absorption value is 0.")
        public boolean SHOW_ON_FULL_HEALTH_WITHOUT_ABSORPTION = DefaultConfigAdapter.I.showOnFullHealthWithoutAbsorption();
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to display health bar on mobs with full health if the mob's absorption value is not 0.")
        public boolean SHOW_ON_FULL_HEALTH_WITH_ABSORPTION = DefaultConfigAdapter.I.showOnFullHealthWithAbsorption();
        @ConfigEntry.Gui.Tooltip
        @Comment("The half width of the health bar.")
        public int HEALTH_BAR_HALF_WIDTH = DefaultConfigAdapter.I.healthBarHalfWidth();
        @ConfigEntry.Gui.Tooltip
        @Comment("The half height of the health bar.")
        public int HEALTH_BAR_HALF_HEIGHT = DefaultConfigAdapter.I.healthBarHalfHeight();
        @ConfigEntry.Gui.Tooltip
        @Comment("The offset of the health bar on the Y axis.")
        public double HEALTH_BAR_OFFSET_Y = DefaultConfigAdapter.I.healthBarOffsetY();
        @ConfigEntry.Gui.Tooltip
        @Comment("The scale of the health bar.")
        public double HEALTH_BAR_SCALE = DefaultConfigAdapter.I.healthBarScale();
        @ConfigEntry.Gui.Tooltip
        @Comment("The scale of the health bar text.")
        public double HEALTH_BAR_TEXT_SCALE = DefaultConfigAdapter.I.healthBarTextScale();
        @ConfigEntry.Gui.Tooltip
        @Comment("The offset of the health bar text on the Y axis.")
        public double HEALTH_BAR_TEXT_OFFSET_Y = DefaultConfigAdapter.I.healthBarTextOffsetY();
        @ConfigEntry.Gui.Tooltip
        @Comment("The width of the health bar bound. 0 to 10. Hint: This value is a little hard to adjust. If you want to make the bounds looks thinner, " +
                "you can increase the health bar width&height and decrease the health bar scale. You may also need to change the text scale and offset. " +
                "This can be complicated, I highly recommend you to use some in-game config mod like 'configured'.")
        public int HEALTH_BAR_BOUND_WIDTH = DefaultConfigAdapter.I.healthBarBoundWidth();
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to render the vertex of the health bar bound.")
        public boolean HEALTH_BAR_BOUND_VERTEX = DefaultConfigAdapter.I.healthBarBoundVertex();
        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int HEALTH_BAR_HEALTH_COLOR = DefaultConfigAdapter.I.healthBarHealthColor();
        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the absorption bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int HEALTH_BAR_ABSORPTION_COLOR = DefaultConfigAdapter.I.healthBarAbsorptionColor();
        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the health bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int HEALTH_BAR_BOUND_COLOR = DefaultConfigAdapter.I.healthBarBoundColor();
        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the empty part of the health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int HEALTH_BAR_EMPTY_COLOR = DefaultConfigAdapter.I.healthBarEmptyColor();
        @ConfigEntry.Gui.Tooltip
        @Comment("Whether to use dynamic color for health bar. The color will be picked between healthBarHealthColorFull and healthBarHealthColorEmpty " +
                "based on the health rate. If disabled, the health bar will always be healthBarHealthColor")
        public boolean HEALTH_BAR_HEALTH_COLOR_DYNAMIC = DefaultConfigAdapter.I.healthBarHealthColorDynamic();
        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the health bar when the mob is full health. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int HEALTH_BAR_HEALTH_COLOR_FULL = DefaultConfigAdapter.I.healthBarHealthColorFull();
        @ConfigEntry.Gui.Tooltip
        @Comment("The color of the health bar when the mob is low health. 0x00000000 to 0xFFFFFFFF. ARGB format.")
        public int HEALTH_BAR_HEALTH_COLOR_EMPTY = DefaultConfigAdapter.I.healthBarHealthColorEmpty();
    }
}
