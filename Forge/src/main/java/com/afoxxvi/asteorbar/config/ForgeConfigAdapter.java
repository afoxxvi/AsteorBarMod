package com.afoxxvi.asteorbar.config;

import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.parts.PlayerHealthOverlay;
import net.minecraftforge.common.ForgeConfigSpec;

public class ForgeConfigAdapter implements ConfigAdapter {
    public static class Config {
        public static ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
        //overlay config
        public static final ForgeConfigSpec.BooleanValue ENABLE_OVERLAY;
        public static final ForgeConfigSpec.IntValue OVERLAY_LAYOUT_STYLE;
        public static final ForgeConfigSpec.DoubleValue OVERLAY_TEXT_SCALE;
        public static final ForgeConfigSpec.IntValue HEALTH_COLOR_NORMAL;
        public static final ForgeConfigSpec.IntValue HEALTH_COLOR_POISON;
        public static final ForgeConfigSpec.IntValue HEALTH_COLOR_WITHER;
        public static final ForgeConfigSpec.IntValue HEALTH_COLOR_FROZEN;
        public static final ForgeConfigSpec.IntValue HEALTH_BOUND_COLOR;
        public static final ForgeConfigSpec.IntValue HEALTH_BOUND_COLOR_BLINK;
        public static final ForgeConfigSpec.IntValue HEALTH_BOUND_COLOR_LOW;
        public static final ForgeConfigSpec.IntValue HEALTH_EMPTY_COLOR;
        public static final ForgeConfigSpec.IntValue ABSORPTION_COLOR;
        public static final ForgeConfigSpec.IntValue ABSORPTION_BOUND_COLOR;
        public static final ForgeConfigSpec.IntValue FOOD_COLOR_NORMAL;
        public static final ForgeConfigSpec.IntValue FOOD_COLOR_HUNGER;
        public static final ForgeConfigSpec.IntValue FOOD_BOUND_COLOR;
        public static final ForgeConfigSpec.IntValue FOOD_BOUND_COLOR_BLINK;
        public static final ForgeConfigSpec.IntValue FOOD_EMPTY_COLOR;
        public static final ForgeConfigSpec.IntValue SATURATION_COLOR;
        public static final ForgeConfigSpec.IntValue EXPERIENCE_COLOR;
        public static final ForgeConfigSpec.IntValue EXPERIENCE_BOUND_COLOR;
        public static final ForgeConfigSpec.IntValue EXPERIENCE_EMPTY_COLOR;
        public static final ForgeConfigSpec.IntValue AIR_COLOR;
        public static final ForgeConfigSpec.IntValue AIR_BOUND_COLOR;
        public static final ForgeConfigSpec.IntValue MOUNT_HEALTH_COLOR;
        public static final ForgeConfigSpec.IntValue MOUNT_HEALTH_COLOR_2;
        public static final ForgeConfigSpec.IntValue MOUNT_HEALTH_BOUND_COLOR;
        public static final ForgeConfigSpec.IntValue MOUNT_HEALTH_BOUND_COLOR_2;
        public static final ForgeConfigSpec.IntValue MOUNT_HEALTH_EMPTY_COLOR;
        public static final ForgeConfigSpec.IntValue ARMOR_COLOR;
        public static final ForgeConfigSpec.IntValue ARMOR_BOUND_COLOR;
        public static final ForgeConfigSpec.IntValue ARMOR_EMPTY_COLOR;
        public static final ForgeConfigSpec.IntValue ARMOR_TOUGHNESS_COLOR;
        public static final ForgeConfigSpec.BooleanValue ENABLE_HEALTH_BLINK;
        public static final ForgeConfigSpec.DoubleValue LOW_HEALTH_RATE;
        public static final ForgeConfigSpec.BooleanValue OVERWRITE_VANILLA_ARMOR_BAR;
        public static final ForgeConfigSpec.BooleanValue OVERWRITE_VANILLA_EXPERIENCE_BAR;
        public static final ForgeConfigSpec.BooleanValue DISPLAY_EXPERIENCE_PROGRESS;
        public static final ForgeConfigSpec.BooleanValue DISPLAY_EXPERIENCE_LEVEL;
        public static final ForgeConfigSpec.BooleanValue DISPLAY_HEALTH_TEXT;
        public static final ForgeConfigSpec.IntValue DISPLAY_ABSORPTION_METHOD;
        public static final ForgeConfigSpec.BooleanValue DISPLAY_ABSORPTION_DIV_MAX_HEALTH;
        public static final ForgeConfigSpec.IntValue DISPLAY_ABSORPTION_TEXT_METHOD;
        public static final ForgeConfigSpec.BooleanValue ENABLE_FOOD_BLINK;
        public static final ForgeConfigSpec.BooleanValue DISPLAY_SATURATION;
        public static final ForgeConfigSpec.BooleanValue DISPLAY_EXHAUSTION;
        public static final ForgeConfigSpec.BooleanValue DISPLAY_ARMOR_TOUGHNESS;
        public static final ForgeConfigSpec.IntValue CORNER_BAR_LENGTH;
        public static final ForgeConfigSpec.IntValue CORNER_HORIZONTAL_PADDING;
        public static final ForgeConfigSpec.IntValue CORNER_VERTICAL_PADDING;
        //mob config
        public static final ForgeConfigSpec.BooleanValue ENABLE_HEALTH_BAR;
        public static final ForgeConfigSpec.DoubleValue MAX_DISTANCE;
        public static final ForgeConfigSpec.BooleanValue SHOW_ON_PLAYERS;
        public static final ForgeConfigSpec.BooleanValue SHOW_ON_BOSSES;
        public static final ForgeConfigSpec.BooleanValue SHOW_ON_FULL_HEALTH_WITHOUT_ABSORPTION;
        public static final ForgeConfigSpec.BooleanValue SHOW_ON_FULL_HEALTH_WITH_ABSORPTION;
        public static final ForgeConfigSpec.IntValue HEALTH_BAR_HALF_WIDTH;
        public static final ForgeConfigSpec.IntValue HEALTH_BAR_HALF_HEIGHT;
        public static final ForgeConfigSpec.DoubleValue HEALTH_BAR_OFFSET_Y;
        public static final ForgeConfigSpec.DoubleValue HEALTH_BAR_SCALE;
        public static final ForgeConfigSpec.DoubleValue HEALTH_BAR_TEXT_SCALE;
        public static final ForgeConfigSpec.DoubleValue HEALTH_BAR_TEXT_OFFSET_Y;
        public static final ForgeConfigSpec.IntValue HEALTH_BAR_BOUND_WIDTH;
        public static final ForgeConfigSpec.BooleanValue HEALTH_BAR_BOUND_VERTEX;
        public static final ForgeConfigSpec.IntValue HEALTH_BAR_HEALTH_COLOR;
        public static final ForgeConfigSpec.IntValue HEALTH_BAR_ABSORPTION_COLOR;
        public static final ForgeConfigSpec.IntValue HEALTH_BAR_BOUND_COLOR;
        public static final ForgeConfigSpec.IntValue HEALTH_BAR_EMPTY_COLOR;
        public static final ForgeConfigSpec.BooleanValue HEALTH_BAR_HEALTH_COLOR_DYNAMIC;
        public static final ForgeConfigSpec.IntValue HEALTH_BAR_HEALTH_COLOR_FULL;
        public static final ForgeConfigSpec.IntValue HEALTH_BAR_HEALTH_COLOR_EMPTY;
        public static final ForgeConfigSpec.BooleanValue HOOK_TOUGH_AS_NAILS;
        public static final ForgeConfigSpec.BooleanValue HOOK_THIRST_WAS_TAKEN;
        public static final ForgeConfigSpec.BooleanValue HOOK_MEKANISM;
        public static final ForgeConfigSpec.BooleanValue HOOK_DEHYDRATION;

        static {
            BUILDER.push("overlay");
            ENABLE_OVERLAY = BUILDER
                    .comment("Whether to enable the overlay. If disabled, all other overlay options will be ignored.")
                    .translation("text.autoconfig.asteorbar.option.overlay.enableOverlay")
                    .define("enableOverlay", DefaultConfigAdapter.I.enableOverlay());
            OVERLAY_LAYOUT_STYLE = BUILDER
                    .comment("The layout style of the overlay. 0: none, 1: above hot bar long, 2: above hot bar short, 3: top left, 4: top right, 5: bottom left, 6: bottom right")
                    .translation("text.autoconfig.asteorbar.option.overlay.overlayLayoutStyle")
                    .defineInRange("overlayLayoutStyle", DefaultConfigAdapter.I.overlayLayoutStyle(), 0, Overlays.NUM_STYLES - 1);
            OVERLAY_TEXT_SCALE = BUILDER
                    .comment("The scale of the overlay text.")
                    .translation("text.autoconfig.asteorbar.option.overlay.overlayTextScale")
                    .defineInRange("overlayTextScale", DefaultConfigAdapter.I.overlayTextScale(), 0.1, 10.0);
            HEALTH_COLOR_NORMAL = BUILDER
                    .comment("The color of the health bar when the player is not affected by any status effect. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.healthColorNormal")
                    .defineInRange("healthColorNormal", DefaultConfigAdapter.I.healthColorNormal(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_COLOR_POISON = BUILDER
                    .comment("The color of the health bar when the player is poisoned. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.healthColorPoison")
                    .defineInRange("healthColorPoison", DefaultConfigAdapter.I.healthColorPoison(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_COLOR_WITHER = BUILDER
                    .comment("The color of the health bar when the player is withered. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.healthColorWither")
                    .defineInRange("healthColorWither", DefaultConfigAdapter.I.healthColorWither(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_COLOR_FROZEN = BUILDER
                    .comment("The color of the health bar when the player is frozen. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.healthColorFrozen")
                    .defineInRange("healthColorFrozen", DefaultConfigAdapter.I.healthColorFrozen(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_BOUND_COLOR = BUILDER
                    .comment("The color of the health bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.healthBoundColor")
                    .defineInRange("healthBoundColor", DefaultConfigAdapter.I.healthBoundColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_BOUND_COLOR_BLINK = BUILDER
                    .comment("The color of the health bar bound when the health rate is lower than the low health rate. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.healthBoundColorBlink")
                    .defineInRange("healthBoundColorBlink", DefaultConfigAdapter.I.healthBoundColorBlink(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_BOUND_COLOR_LOW = BUILDER
                    .comment("The color of the health bar bound when the health rate is lower than the low health rate. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.healthBoundColorLow")
                    .defineInRange("healthBoundColorLow", DefaultConfigAdapter.I.healthBoundColorLow(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_EMPTY_COLOR = BUILDER
                    .comment("The color of the empty part of the health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.healthEmptyColor")
                    .defineInRange("healthEmptyColor", DefaultConfigAdapter.I.healthEmptyColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            ABSORPTION_COLOR = BUILDER
                    .comment("The color of the absorption bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.absorptionColor")
                    .defineInRange("absorptionColor", DefaultConfigAdapter.I.absorptionColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            ABSORPTION_BOUND_COLOR = BUILDER
                    .comment("The color of the absorption bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.absorptionBoundColor")
                    .defineInRange("absorptionBoundColor", DefaultConfigAdapter.I.absorptionBoundColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            FOOD_COLOR_NORMAL = BUILDER
                    .comment("The color of the food level bar when the player is not affected by any status effect. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.foodColorNormal")
                    .defineInRange("foodColorNormal", DefaultConfigAdapter.I.foodColorNormal(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            FOOD_COLOR_HUNGER = BUILDER
                    .comment("The color of the food level bar when the player is hungry. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.foodColorHunger")
                    .defineInRange("foodColorHunger", DefaultConfigAdapter.I.foodColorHunger(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            FOOD_BOUND_COLOR = BUILDER
                    .comment("The color of the food level bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.foodBoundColor")
                    .defineInRange("foodBoundColor", DefaultConfigAdapter.I.foodBoundColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            FOOD_BOUND_COLOR_BLINK = BUILDER
                    .comment("The color of the food level bar bound when the food level is lower than the low food level. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.foodBoundColorBlink")
                    .defineInRange("foodBoundColorBlink", DefaultConfigAdapter.I.foodBoundColorBlink(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            FOOD_EMPTY_COLOR = BUILDER
                    .comment("The color of the empty part of the food level bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.foodEmptyColor")
                    .defineInRange("foodEmptyColor", DefaultConfigAdapter.I.foodEmptyColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            SATURATION_COLOR = BUILDER
                    .comment("The color of the saturation bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.saturationColor")
                    .defineInRange("saturationColor", DefaultConfigAdapter.I.saturationColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            EXPERIENCE_COLOR = BUILDER
                    .comment("The color of the experience bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.experienceColor")
                    .defineInRange("experienceColor", DefaultConfigAdapter.I.experienceColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            EXPERIENCE_BOUND_COLOR = BUILDER
                    .comment("The color of the experience bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.experienceBoundColor")
                    .defineInRange("experienceBoundColor", DefaultConfigAdapter.I.experienceBoundColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            EXPERIENCE_EMPTY_COLOR = BUILDER
                    .comment("The color of the empty part of the experience bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.experienceEmptyColor")
                    .defineInRange("experienceEmptyColor", DefaultConfigAdapter.I.experienceEmptyColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            AIR_COLOR = BUILDER
                    .comment("The color of the air bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.airColor")
                    .defineInRange("airColor", DefaultConfigAdapter.I.airColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            AIR_BOUND_COLOR = BUILDER
                    .comment("The color of the air bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.airBoundColor")
                    .defineInRange("airBoundColor", DefaultConfigAdapter.I.airBoundColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            MOUNT_HEALTH_COLOR = BUILDER
                    .comment("The color of the mount health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.mountHealthColor")
                    .defineInRange("mountHealthColor", DefaultConfigAdapter.I.mountHealthColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            MOUNT_HEALTH_COLOR_2 = BUILDER
                    .comment("The color of the mount health bar when the mount is not tamed. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.mountHealthColor2")
                    .defineInRange("mountHealthColor2", DefaultConfigAdapter.I.mountHealthColor2(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            MOUNT_HEALTH_BOUND_COLOR = BUILDER
                    .comment("The color of the mount health bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.mountHealthBoundColor")
                    .defineInRange("mountHealthBoundColor", DefaultConfigAdapter.I.mountHealthBoundColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            MOUNT_HEALTH_BOUND_COLOR_2 = BUILDER
                    .comment("The color of the mount health bar bound when the mount is not tamed. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.mountHealthBoundColor2")
                    .defineInRange("mountHealthBoundColor2", DefaultConfigAdapter.I.mountHealthBoundColor2(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            MOUNT_HEALTH_EMPTY_COLOR = BUILDER
                    .comment("The color of the empty part of the mount health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.mountHealthEmptyColor")
                    .defineInRange("mountHealthEmptyColor", DefaultConfigAdapter.I.mountHealthEmptyColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            ARMOR_COLOR = BUILDER
                    .comment("The color of the armor bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.armorColor")
                    .defineInRange("armorColor", DefaultConfigAdapter.I.armorColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            ARMOR_BOUND_COLOR = BUILDER
                    .comment("The color of the armor bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.armorBoundColor")
                    .defineInRange("armorBoundColor", DefaultConfigAdapter.I.armorBoundColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            ARMOR_EMPTY_COLOR = BUILDER
                    .comment("The color of the empty part of the armor bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.armorEmptyColor")
                    .defineInRange("armorEmptyColor", DefaultConfigAdapter.I.armorEmptyColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            ARMOR_TOUGHNESS_COLOR = BUILDER
                    .comment("The color of the armor toughness bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.overlay.armorToughnessColor")
                    .defineInRange("armorToughnessColor", DefaultConfigAdapter.I.armorToughnessColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            ENABLE_HEALTH_BLINK = BUILDER
                    .comment("Whether to enable health bar blink. This feature is designed to simulate the vanilla health icon blink.")
                    .translation("text.autoconfig.asteorbar.option.overlay.enableHealthBlink")
                    .define("enableHealthBlink", DefaultConfigAdapter.I.enableHealthBlink());
            LOW_HEALTH_RATE = BUILDER
                    .comment("The health bar will start to flash when health rate is lower than this value. From 0.0-1.0. 0.0 means never flash.")
                    .translation("text.autoconfig.asteorbar.option.overlay.lowHealthRate")
                    .defineInRange("lowHealthRate", DefaultConfigAdapter.I.lowHealthRate(), 0.0, 1.0);
            OVERWRITE_VANILLA_ARMOR_BAR = BUILDER
                    .comment("Whether to overwrite vanilla armor bar. If you don't like the mod's armor bar, you can disable this option.")
                    .translation("text.autoconfig.asteorbar.option.overlay.overwriteVanillaArmorBar")
                    .define("overwriteVanillaArmorBar", DefaultConfigAdapter.I.overwriteVanillaArmorBar());
            OVERWRITE_VANILLA_EXPERIENCE_BAR = BUILDER
                    .comment("Whether to overwrite vanilla experience bar. If you don't like the mod's experience bar, you can disable this option, progress label won't be affected.")
                    .translation("text.autoconfig.asteorbar.option.overlay.overwriteVanillaExperienceBar")
                    .define("overwriteVanillaExperienceBar", DefaultConfigAdapter.I.overwriteVanillaExperienceBar());
            DISPLAY_EXPERIENCE_PROGRESS = BUILDER
                    .comment("Whether to display experience progress on the side of the experience bar.")
                    .translation("text.autoconfig.asteorbar.option.overlay.displayExperienceProgress")
                    .define("displayExperienceProgress", DefaultConfigAdapter.I.displayExperienceProgress());
            DISPLAY_EXPERIENCE_LEVEL = BUILDER
                    .comment("Whether to display experience level on the experience bar.")
                    .translation("text.autoconfig.asteorbar.option.overlay.displayExperienceLevel")
                    .define("displayExperienceLevel", DefaultConfigAdapter.I.displayExperienceLevel());
            DISPLAY_HEALTH_TEXT = BUILDER
                    .comment("Whether to display health text.")
                    .translation("text.autoconfig.asteorbar.option.overlay.displayHealthText")
                    .define("displayHealthText", DefaultConfigAdapter.I.displayHealthText());
            DISPLAY_ABSORPTION_METHOD = BUILDER
                    .comment("0: Absorption will be displayed together with health bar. "
                            + "1: Absorption will be displayed half transparently on the health bar. "
                            + "2: Absorption will be displayed as bounds. "
                            + "Note: Since the absorption value can be higher than the max health, an extra number will be displayed to indicate value of absorption/max health, you can turn it off by editing 'displayAbsorptionDivMaxHealth'.")
                    .translation("text.autoconfig.asteorbar.option.overlay.displayAbsorptionAsBounds")
                    .defineInRange("displayAbsorptionMethod", DefaultConfigAdapter.I.displayAbsorptionMethod(), 0, PlayerHealthOverlay.ABSORPTION_MODES - 1);
            DISPLAY_ABSORPTION_DIV_MAX_HEALTH = BUILDER
                    .comment("Whether to display the value of (absorption / max health). To avoid ambiguity, turn it to true if you hide the health text and don't display absorption bar together with health bar, or you may not be able to get correct absorption value.")
                    .translation("text.autoconfig.asteorbar.option.overlay.displayAbsorptionDivMaxHealth")
                    .define("displayAbsorptionDivMaxHealth", DefaultConfigAdapter.I.displayAbsorptionDivMaxHealth());
            DISPLAY_ABSORPTION_TEXT_METHOD = BUILDER
                    .comment("0: Absorption text will be displayed together with health text. for example: 15(+10)/20. "
                            + "1: Absorption text will be displayed separately. for example: 10 15/20. "
                            + "Note: if 'displayHealthText' is false, absorption text will be disabled.")
                    .translation("text.autoconfig.asteorbar.option.overlay.displayAbsorptionText")
                    .defineInRange("displayAbsorptionTextMethod", DefaultConfigAdapter.I.displayAbsorptionTextMethod(), 0, PlayerHealthOverlay.ABSORPTION_TEXT_MODES - 1);
            ENABLE_FOOD_BLINK = BUILDER
                    .comment("Whether to enable food level bar blink. This feature is designed to simulate the vanilla food icon shake.")
                    .translation("text.autoconfig.asteorbar.option.overlay.enableFoodBlink")
                    .define("enableFoodBlink", DefaultConfigAdapter.I.enableFoodBlink());
            DISPLAY_SATURATION = BUILDER
                    .comment("Whether to display saturation bar.")
                    .translation("text.autoconfig.asteorbar.option.overlay.displaySaturation")
                    .define("displaySaturation", DefaultConfigAdapter.I.displaySaturation());
            DISPLAY_EXHAUSTION = BUILDER
                    .comment("Whether to display exhaustion bar.")
                    .translation("text.autoconfig.asteorbar.option.overlay.displayExhaustion")
                    .define("displayExhaustion", DefaultConfigAdapter.I.displayExhaustion());
            DISPLAY_ARMOR_TOUGHNESS = BUILDER
                    .comment("Whether to display armor toughness bar.")
                    .translation("text.autoconfig.asteorbar.option.overlay.displayArmorToughness")
                    .define("displayArmorToughness", DefaultConfigAdapter.I.displayArmorToughness());
            CORNER_BAR_LENGTH = BUILDER
                    .comment("The length of the bars if using corner layout. Affected bars: health, food, experience.")
                    .translation("text.autoconfig.asteorbar.option.overlay.cornerBarLength")
                    .defineInRange("cornerBarLength", DefaultConfigAdapter.I.cornerBarLength(), 40, 182);
            CORNER_HORIZONTAL_PADDING = BUILDER
                    .comment("The horizontal padding of the bars if using corner layout.")
                    .translation("text.autoconfig.asteorbar.option.overlay.cornerHorizontalPadding")
                    .defineInRange("cornerHorizontalPadding", DefaultConfigAdapter.I.cornerHorizontalPadding(), 0, 100);
            CORNER_VERTICAL_PADDING = BUILDER
                    .comment("The vertical padding of the bars if using corner layout.")
                    .translation("text.autoconfig.asteorbar.option.overlay.cornerVerticalPadding")
                    .defineInRange("cornerVerticalPadding", DefaultConfigAdapter.I.cornerVerticalPadding(), 0, 100);
            BUILDER.pop();
            BUILDER.push("entity");
            ENABLE_HEALTH_BAR = BUILDER
                    .comment("Whether to enable health bar for entity. If disabled, all other health bar options will be ignored.")
                    .translation("text.autoconfig.asteorbar.option.entity.enableHealthBar")
                    .define("enableHealthBar", DefaultConfigAdapter.I.enableHealthBar());
            MAX_DISTANCE = BUILDER
                    .comment("The maximum distance to display mob health bar.")
                    .translation("text.autoconfig.asteorbar.option.entity.maxDistance")
                    .defineInRange("maxDistance", DefaultConfigAdapter.I.maxDistance(), 0.0, 100.0);
            SHOW_ON_PLAYERS = BUILDER
                    .comment("Whether to display health bar on players.")
                    .translation("text.autoconfig.asteorbar.option.entity.showOnPlayers")
                    .define("showOnPlayers", DefaultConfigAdapter.I.showOnPlayers());
            SHOW_ON_BOSSES = BUILDER
                    .comment("Whether to display health bar on bosses.")
                    .translation("text.autoconfig.asteorbar.option.entity.showOnBosses")
                    .define("showOnBosses", DefaultConfigAdapter.I.showOnBosses());
            SHOW_ON_FULL_HEALTH_WITHOUT_ABSORPTION = BUILDER
                    .comment("Whether to display health bar on mobs with full health if the mob's absorption value is 0.")
                    .translation("text.autoconfig.asteorbar.option.entity.showOnFullHealthWithoutAbsorption")
                    .define("showOnFullHealthWithoutAbsorption", DefaultConfigAdapter.I.showOnFullHealthWithoutAbsorption());
            SHOW_ON_FULL_HEALTH_WITH_ABSORPTION = BUILDER
                    .comment("Whether to display health bar on mobs with full health if the mob's absorption value is not 0.")
                    .translation("text.autoconfig.asteorbar.option.entity.showOnFullHealthWithAbsorption")
                    .define("showOnFullHealthWithAbsorption", DefaultConfigAdapter.I.showOnFullHealthWithAbsorption());
            HEALTH_BAR_HALF_WIDTH = BUILDER
                    .comment("The half width of the health bar.")
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarHalfWidth")
                    .defineInRange("healthBarHalfWidth", DefaultConfigAdapter.I.healthBarHalfWidth(), 1, 1000);
            HEALTH_BAR_HALF_HEIGHT = BUILDER
                    .comment("The half height of the health bar.")
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarHalfHeight")
                    .defineInRange("healthBarHalfHeight", DefaultConfigAdapter.I.healthBarHalfHeight(), 1, 200);
            HEALTH_BAR_OFFSET_Y = BUILDER
                    .comment("The offset of the health bar on the Y axis.")
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarOffsetY")
                    .defineInRange("healthBarOffsetY", DefaultConfigAdapter.I.healthBarOffsetY(), -10, 10);
            HEALTH_BAR_SCALE = BUILDER
                    .comment("The scale of the health bar.")
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarScale")
                    .defineInRange("healthBarScale", DefaultConfigAdapter.I.healthBarScale(), 0.001, 0.1);
            HEALTH_BAR_TEXT_SCALE = BUILDER
                    .comment("The scale of the health bar text.")
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarTextScale")
                    .defineInRange("healthBarTextScale", DefaultConfigAdapter.I.healthBarTextScale(), 0.1, 1.0);
            HEALTH_BAR_TEXT_OFFSET_Y = BUILDER
                    .comment("The offset of the health bar text on the Y axis.")
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarTextOffsetY")
                    .defineInRange("healthBarTextOffsetY", DefaultConfigAdapter.I.healthBarTextOffsetY(), -10, 10);
            HEALTH_BAR_BOUND_WIDTH = BUILDER
                    .comment("The width of the health bar bound. 0 to 10. Hint: This value is a little hard to adjust. If you want to make the bounds looks thinner, " +
                            "you can increase the health bar width&height and decrease the health bar scale. You may also need to change the text scale and offset. " +
                            "This can be complicated, I highly recommend you to use some in-game config mod like 'configured'.")
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarBoundWidth")
                    .defineInRange("healthBarBoundWidth", DefaultConfigAdapter.I.healthBarBoundWidth(), 0, 10);
            HEALTH_BAR_BOUND_VERTEX = BUILDER
                    .comment("Whether to render the vertex of the health bar bound.")
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarBoundVertex")
                    .define("healthBarBoundVertex", DefaultConfigAdapter.I.healthBarBoundVertex());
            HEALTH_BAR_HEALTH_COLOR = BUILDER
                    .comment("The color of the health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarHealthColor")
                    .defineInRange("healthBarHealthColor", DefaultConfigAdapter.I.healthBarHealthColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_BAR_ABSORPTION_COLOR = BUILDER
                    .comment("The color of the absorption bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarAbsorptionColor")
                    .defineInRange("healthBarAbsorptionColor", DefaultConfigAdapter.I.healthBarAbsorptionColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_BAR_BOUND_COLOR = BUILDER
                    .comment("The color of the health bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarBoundColor")
                    .defineInRange("healthBarBoundColor", DefaultConfigAdapter.I.healthBarBoundColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_BAR_EMPTY_COLOR = BUILDER
                    .comment("The color of the empty part of the health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarEmptyColor")
                    .defineInRange("healthBarEmptyColor", DefaultConfigAdapter.I.healthBarEmptyColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_BAR_HEALTH_COLOR_DYNAMIC = BUILDER
                    .comment("Whether to use dynamic color for health bar. The color will be picked between healthBarHealthColorFull and healthBarHealthColorEmpty " +
                            "based on the health rate. If disabled, the health bar will always be healthBarHealthColor")
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarHealthColorDynamic")
                    .define("healthBarHealthColorDynamic", DefaultConfigAdapter.I.healthBarHealthColorDynamic());
            HEALTH_BAR_HEALTH_COLOR_FULL = BUILDER
                    .comment("The color of the health bar when the mob is full health. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarHealthColorFull")
                    .defineInRange("healthBarHealthColorFull", DefaultConfigAdapter.I.healthBarHealthColorFull(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_BAR_HEALTH_COLOR_EMPTY = BUILDER
                    .comment("The color of the health bar when the mob is low health. 0x00000000 to 0xFFFFFFFF. ARGB format.")
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarHealthColorEmpty")
                    .defineInRange("healthBarHealthColorEmpty", DefaultConfigAdapter.I.healthBarHealthColorEmpty(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            BUILDER.pop();
            BUILDER.push("hook");
            HOOK_TOUGH_AS_NAILS = BUILDER
                    .comment("Whether to hook Tough As Nails mod.")
                    .translation("text.autoconfig.asteorbar.option.hook.hookToughAsNails")
                    .define("toughAsNails", DefaultConfigAdapter.I.hookToughAsNails());
            HOOK_THIRST_WAS_TAKEN = BUILDER
                    .comment("Whether to hook Thirst mod.")
                    .translation("text.autoconfig.asteorbar.option.hook.hookThirstWasTaken")
                    .define("thirstWasTaken", DefaultConfigAdapter.I.hookThirstWasTaken());
            HOOK_MEKANISM = BUILDER
                    .comment("Whether to hook Mekanism mod.")
                    .translation("text.autoconfig.asteorbar.option.hook.hookMekanism")
                    .define("mekanism", DefaultConfigAdapter.I.hookMekanism());
            HOOK_DEHYDRATION = BUILDER
                    .comment("Whether to hook Dehydration mod.")
                    .translation("text.autoconfig.asteorbar.option.hook.hookDehydration")
                    .define("dehydration", DefaultConfigAdapter.I.hookDehydration());
            BUILDER.pop();
        }

        public static ForgeConfigSpec CONFIG = BUILDER.build();
    }

    @Override
    public boolean enableOverlay() {
        return Config.ENABLE_OVERLAY.get();
    }

    @Override
    public void enableOverlay(boolean enable) {
        Config.ENABLE_OVERLAY.set(enable);
        Config.ENABLE_OVERLAY.save();
    }

    @Override
    public int overlayLayoutStyle() {
        return Config.OVERLAY_LAYOUT_STYLE.get();
    }

    @Override
    public void overlayLayoutStyle(int style) {
        Config.OVERLAY_LAYOUT_STYLE.set(style);
        Config.OVERLAY_LAYOUT_STYLE.save();
    }

    @Override
    public double overlayTextScale() {
        return Config.OVERLAY_TEXT_SCALE.get();
    }

    @Override
    public int healthColorNormal() {
        return Config.HEALTH_COLOR_NORMAL.get();
    }

    @Override
    public int healthColorPoison() {
        return Config.HEALTH_COLOR_POISON.get();
    }

    @Override
    public int healthColorWither() {
        return Config.HEALTH_COLOR_WITHER.get();
    }

    @Override
    public int healthColorFrozen() {
        return Config.HEALTH_COLOR_FROZEN.get();
    }

    @Override
    public int healthBoundColor() {
        return Config.HEALTH_BOUND_COLOR.get();
    }

    @Override
    public int healthBoundColorBlink() {
        return Config.HEALTH_BOUND_COLOR_BLINK.get();
    }

    @Override
    public int healthBoundColorLow() {
        return Config.HEALTH_BOUND_COLOR_LOW.get();
    }

    @Override
    public int healthEmptyColor() {
        return Config.HEALTH_EMPTY_COLOR.get();
    }

    @Override
    public int absorptionColor() {
        return Config.ABSORPTION_COLOR.get();
    }

    @Override
    public int absorptionBoundColor() {
        return Config.ABSORPTION_BOUND_COLOR.get();
    }

    @Override
    public int foodColorNormal() {
        return Config.FOOD_COLOR_NORMAL.get();
    }

    @Override
    public int foodColorHunger() {
        return Config.FOOD_COLOR_HUNGER.get();
    }

    @Override
    public int foodBoundColor() {
        return Config.FOOD_BOUND_COLOR.get();
    }

    @Override
    public int foodBoundColorBlink() {
        return Config.FOOD_BOUND_COLOR_BLINK.get();
    }

    @Override
    public int foodEmptyColor() {
        return Config.FOOD_EMPTY_COLOR.get();
    }

    @Override
    public int saturationColor() {
        return Config.SATURATION_COLOR.get();
    }

    @Override
    public int experienceColor() {
        return Config.EXPERIENCE_COLOR.get();
    }

    @Override
    public int experienceBoundColor() {
        return Config.EXPERIENCE_BOUND_COLOR.get();
    }

    @Override
    public int experienceEmptyColor() {
        return Config.EXPERIENCE_EMPTY_COLOR.get();
    }

    @Override
    public int airColor() {
        return Config.AIR_COLOR.get();
    }

    @Override
    public int airBoundColor() {
        return Config.AIR_BOUND_COLOR.get();
    }

    @Override
    public int mountHealthColor() {
        return Config.MOUNT_HEALTH_COLOR.get();
    }

    @Override
    public int mountHealthColor2() {
        return Config.MOUNT_HEALTH_COLOR_2.get();
    }

    @Override
    public int mountHealthBoundColor() {
        return Config.MOUNT_HEALTH_BOUND_COLOR.get();
    }

    @Override
    public int mountHealthBoundColor2() {
        return Config.MOUNT_HEALTH_BOUND_COLOR_2.get();
    }

    @Override
    public int mountHealthEmptyColor() {
        return Config.MOUNT_HEALTH_EMPTY_COLOR.get();
    }

    @Override
    public int armorColor() {
        return Config.ARMOR_COLOR.get();
    }

    @Override
    public int armorBoundColor() {
        return Config.ARMOR_BOUND_COLOR.get();
    }

    @Override
    public int armorEmptyColor() {
        return Config.ARMOR_EMPTY_COLOR.get();
    }

    @Override
    public int armorToughnessColor() {
        return Config.ARMOR_TOUGHNESS_COLOR.get();
    }

    @Override
    public boolean enableHealthBlink() {
        return Config.ENABLE_HEALTH_BLINK.get();
    }

    @Override
    public double lowHealthRate() {
        return Config.LOW_HEALTH_RATE.get();
    }

    @Override
    public boolean overwriteVanillaArmorBar() {
        return Config.OVERWRITE_VANILLA_ARMOR_BAR.get();
    }

    @Override
    public boolean overwriteVanillaExperienceBar() {
        return Config.OVERWRITE_VANILLA_EXPERIENCE_BAR.get();
    }

    @Override
    public boolean displayExperienceProgress() {
        return Config.DISPLAY_EXPERIENCE_PROGRESS.get();
    }

    @Override
    public boolean displayExperienceLevel() {
        return Config.DISPLAY_EXPERIENCE_LEVEL.get();
    }

    @Override
    public boolean displayHealthText() {
        return Config.DISPLAY_HEALTH_TEXT.get();
    }

    @Override
    public int displayAbsorptionMethod() {
        return Config.DISPLAY_ABSORPTION_METHOD.get();
    }

    @Override
    public boolean displayAbsorptionDivMaxHealth() {
        return Config.DISPLAY_ABSORPTION_DIV_MAX_HEALTH.get();
    }

    @Override
    public int displayAbsorptionTextMethod() {
        return Config.DISPLAY_ABSORPTION_TEXT_METHOD.get();
    }

    @Override
    public boolean enableFoodBlink() {
        return Config.ENABLE_FOOD_BLINK.get();
    }

    @Override
    public boolean displaySaturation() {
        return Config.DISPLAY_SATURATION.get();
    }

    @Override
    public boolean displayExhaustion() {
        return Config.DISPLAY_EXHAUSTION.get();
    }

    @Override
    public boolean displayArmorToughness() {
        return Config.DISPLAY_ARMOR_TOUGHNESS.get();
    }

    @Override
    public int cornerBarLength() {
        return Config.CORNER_BAR_LENGTH.get();
    }

    @Override
    public int cornerHorizontalPadding() {
        return Config.CORNER_HORIZONTAL_PADDING.get();
    }

    @Override
    public int cornerVerticalPadding() {
        return Config.CORNER_VERTICAL_PADDING.get();
    }

    @Override
    public boolean enableHealthBar() {
        return Config.ENABLE_HEALTH_BAR.get();
    }

    @Override
    public void enableHealthBar(boolean enable) {
        Config.ENABLE_HEALTH_BAR.set(enable);
        Config.ENABLE_HEALTH_BAR.save();
    }

    @Override
    public double maxDistance() {
        return Config.MAX_DISTANCE.get();
    }

    @Override
    public boolean showOnPlayers() {
        return Config.SHOW_ON_PLAYERS.get();
    }

    @Override
    public boolean showOnBosses() {
        return Config.SHOW_ON_BOSSES.get();
    }

    @Override
    public boolean showOnFullHealthWithoutAbsorption() {
        return Config.SHOW_ON_FULL_HEALTH_WITHOUT_ABSORPTION.get();
    }

    @Override
    public boolean showOnFullHealthWithAbsorption() {
        return Config.SHOW_ON_FULL_HEALTH_WITH_ABSORPTION.get();
    }

    @Override
    public int healthBarHalfWidth() {
        return Config.HEALTH_BAR_HALF_WIDTH.get();
    }

    @Override
    public int healthBarHalfHeight() {
        return Config.HEALTH_BAR_HALF_HEIGHT.get();
    }

    @Override
    public double healthBarOffsetY() {
        return Config.HEALTH_BAR_OFFSET_Y.get();
    }

    @Override
    public double healthBarScale() {
        return Config.HEALTH_BAR_SCALE.get();
    }

    @Override
    public double healthBarTextScale() {
        return Config.HEALTH_BAR_TEXT_SCALE.get();
    }

    @Override
    public double healthBarTextOffsetY() {
        return Config.HEALTH_BAR_TEXT_OFFSET_Y.get();
    }

    @Override
    public int healthBarBoundWidth() {
        return Config.HEALTH_BAR_BOUND_WIDTH.get();
    }

    @Override
    public boolean healthBarBoundVertex() {
        return Config.HEALTH_BAR_BOUND_VERTEX.get();
    }

    @Override
    public int healthBarHealthColor() {
        return Config.HEALTH_BAR_HEALTH_COLOR.get();
    }

    @Override
    public int healthBarAbsorptionColor() {
        return Config.HEALTH_BAR_ABSORPTION_COLOR.get();
    }

    @Override
    public int healthBarBoundColor() {
        return Config.HEALTH_BAR_BOUND_COLOR.get();
    }

    @Override
    public int healthBarEmptyColor() {
        return Config.HEALTH_BAR_EMPTY_COLOR.get();
    }

    @Override
    public boolean healthBarHealthColorDynamic() {
        return Config.HEALTH_BAR_HEALTH_COLOR_DYNAMIC.get();
    }

    @Override
    public int healthBarHealthColorFull() {
        return Config.HEALTH_BAR_HEALTH_COLOR_FULL.get();
    }

    @Override
    public int healthBarHealthColorEmpty() {
        return Config.HEALTH_BAR_HEALTH_COLOR_EMPTY.get();
    }

    @Override
    public boolean hookToughAsNails() {
        return Config.HOOK_TOUGH_AS_NAILS.get();
    }

    @Override
    public boolean hookThirstWasTaken() {
        return Config.HOOK_THIRST_WAS_TAKEN.get();
    }

    @Override
    public boolean hookMekanism() {
        return Config.HOOK_MEKANISM.get();
    }

    @Override
    public boolean hookDehydration() {
        return Config.HOOK_DEHYDRATION.get();
    }
}
