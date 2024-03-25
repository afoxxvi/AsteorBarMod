package com.afoxxvi.asteorbar.config;

import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.parts.PlayerHealthOverlay;
import net.neoforged.neoforge.common.ModConfigSpec;

public class NeoForgeConfigAdapter implements ConfigAdapter {
    public static class Config {
        public static ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
        //overlay config
        public static final ModConfigSpec.BooleanValue ENABLE_OVERLAY;
        public static final ModConfigSpec.IntValue OVERLAY_LAYOUT_STYLE;
        public static final ModConfigSpec.DoubleValue OVERLAY_TEXT_SCALE;
        public static final ModConfigSpec.IntValue FULL_FOOD_LEVEL_VALUE;
        public static final ModConfigSpec.DoubleValue FULL_SATURATION_VALUE;
        public static final ModConfigSpec.DoubleValue FULL_EXHAUSTION_VALUE;
        public static final ModConfigSpec.IntValue FULL_ARMOR_VALUE;
        public static final ModConfigSpec.IntValue FULL_ARMOR_TOUGHNESS_VALUE;
        public static final ModConfigSpec.IntValue FULL_HEALTH_VALUE;
        public static final ModConfigSpec.BooleanValue ENABLE_STACK_HEALTH_BAR;
        public static final ModConfigSpec.ConfigValue<String> STACK_HEALTH_BAR_COLORS;
        public static final ModConfigSpec.IntValue HEALTH_COLOR_NORMAL;
        public static final ModConfigSpec.IntValue HEALTH_COLOR_POISON;
        public static final ModConfigSpec.IntValue HEALTH_COLOR_WITHER;
        public static final ModConfigSpec.IntValue HEALTH_COLOR_FROZEN;
        public static final ModConfigSpec.IntValue HEALTH_BOUND_COLOR;
        public static final ModConfigSpec.IntValue HEALTH_BOUND_COLOR_BLINK;
        public static final ModConfigSpec.IntValue HEALTH_BOUND_COLOR_LOW;
        public static final ModConfigSpec.IntValue HEALTH_EMPTY_COLOR;
        public static final ModConfigSpec.IntValue ABSORPTION_COLOR;
        public static final ModConfigSpec.IntValue ABSORPTION_BOUND_COLOR;
        public static final ModConfigSpec.IntValue FOOD_COLOR_NORMAL;
        public static final ModConfigSpec.IntValue FOOD_COLOR_HUNGER;
        public static final ModConfigSpec.IntValue FOOD_BOUND_COLOR;
        public static final ModConfigSpec.IntValue FOOD_BOUND_COLOR_BLINK;
        public static final ModConfigSpec.IntValue FOOD_EMPTY_COLOR;
        public static final ModConfigSpec.IntValue SATURATION_COLOR;
        public static final ModConfigSpec.IntValue EXPERIENCE_COLOR;
        public static final ModConfigSpec.IntValue EXPERIENCE_BOUND_COLOR;
        public static final ModConfigSpec.IntValue EXPERIENCE_EMPTY_COLOR;
        public static final ModConfigSpec.IntValue AIR_COLOR;
        public static final ModConfigSpec.IntValue AIR_BOUND_COLOR;
        public static final ModConfigSpec.IntValue MOUNT_HEALTH_COLOR;
        public static final ModConfigSpec.IntValue MOUNT_HEALTH_COLOR_2;
        public static final ModConfigSpec.IntValue MOUNT_HEALTH_BOUND_COLOR;
        public static final ModConfigSpec.IntValue MOUNT_HEALTH_BOUND_COLOR_2;
        public static final ModConfigSpec.IntValue MOUNT_HEALTH_EMPTY_COLOR;
        public static final ModConfigSpec.BooleanValue MOUNT_HEALTH_ON_LEFT_SIDE;
        public static final ModConfigSpec.IntValue ARMOR_COLOR;
        public static final ModConfigSpec.IntValue ARMOR_BOUND_COLOR;
        public static final ModConfigSpec.IntValue ARMOR_EMPTY_COLOR;
        public static final ModConfigSpec.IntValue ARMOR_TOUGHNESS_COLOR;
        public static final ModConfigSpec.BooleanValue ENABLE_HEALTH_BLINK;
        public static final ModConfigSpec.DoubleValue LOW_HEALTH_RATE;
        public static final ModConfigSpec.BooleanValue OVERWRITE_VANILLA_ARMOR_BAR;
        public static final ModConfigSpec.BooleanValue OVERWRITE_VANILLA_EXPERIENCE_BAR;
        public static final ModConfigSpec.BooleanValue DISPLAY_EXPERIENCE_PROGRESS;
        public static final ModConfigSpec.BooleanValue DISPLAY_EXPERIENCE_LEVEL;
        public static final ModConfigSpec.BooleanValue DISPLAY_HEALTH_TEXT;
        public static final ModConfigSpec.IntValue DISPLAY_ABSORPTION_METHOD;
        public static final ModConfigSpec.BooleanValue DISPLAY_ABSORPTION_DIV_MAX_HEALTH;
        public static final ModConfigSpec.IntValue DISPLAY_ABSORPTION_TEXT_METHOD;
        public static final ModConfigSpec.BooleanValue ENABLE_FOOD_BLINK;
        public static final ModConfigSpec.BooleanValue DISPLAY_SATURATION;
        public static final ModConfigSpec.BooleanValue DISPLAY_EXHAUSTION;
        public static final ModConfigSpec.BooleanValue DISPLAY_ARMOR_TOUGHNESS;
        public static final ModConfigSpec.IntValue CORNER_BAR_LENGTH;
        public static final ModConfigSpec.IntValue CORNER_HORIZONTAL_PADDING;
        public static final ModConfigSpec.IntValue CORNER_VERTICAL_PADDING;
        //mob config
        public static final ModConfigSpec.BooleanValue ENABLE_HEALTH_BAR;
        public static final ModConfigSpec.DoubleValue MAX_DISTANCE;
        public static final ModConfigSpec.BooleanValue SHOW_ON_SELF;
        public static final ModConfigSpec.BooleanValue SHOW_ON_PLAYERS;
        public static final ModConfigSpec.BooleanValue SHOW_ON_BOSSES;
        public static final ModConfigSpec.BooleanValue SHOW_ON_FULL_HEALTH_WITHOUT_ABSORPTION;
        public static final ModConfigSpec.BooleanValue SHOW_ON_FULL_HEALTH_WITH_ABSORPTION;
        public static final ModConfigSpec.IntValue HEALTH_BAR_ALPHA;
        public static final ModConfigSpec.IntValue HEALTH_BAR_HALF_WIDTH;
        public static final ModConfigSpec.IntValue HEALTH_BAR_HALF_HEIGHT;
        public static final ModConfigSpec.DoubleValue HEALTH_BAR_OFFSET_Y;
        public static final ModConfigSpec.DoubleValue HEALTH_BAR_SCALE;
        public static final ModConfigSpec.DoubleValue HEALTH_BAR_TEXT_SCALE;
        public static final ModConfigSpec.DoubleValue HEALTH_BAR_TEXT_OFFSET_Y;
        public static final ModConfigSpec.IntValue HEALTH_BAR_BOUND_WIDTH;
        public static final ModConfigSpec.BooleanValue HEALTH_BAR_BOUND_VERTEX;
        public static final ModConfigSpec.IntValue HEALTH_BAR_HEALTH_COLOR;
        public static final ModConfigSpec.IntValue HEALTH_BAR_ABSORPTION_COLOR;
        public static final ModConfigSpec.IntValue HEALTH_BAR_BOUND_COLOR;
        public static final ModConfigSpec.IntValue HEALTH_BAR_EMPTY_COLOR;
        public static final ModConfigSpec.BooleanValue HEALTH_BAR_HEALTH_COLOR_DYNAMIC;
        public static final ModConfigSpec.IntValue HEALTH_BAR_HEALTH_COLOR_FULL;
        public static final ModConfigSpec.IntValue HEALTH_BAR_HEALTH_COLOR_EMPTY;
        public static final ModConfigSpec.BooleanValue HOOK_TOUGH_AS_NAILS;
        public static final ModConfigSpec.BooleanValue HOOK_THIRST_WAS_TAKEN;
        public static final ModConfigSpec.BooleanValue HOOK_MEKANISM;
        public static final ModConfigSpec.BooleanValue HOOK_DEHYDRATION;
        public static final ModConfigSpec.BooleanValue HOOK_PARCOOL;
        public static final ModConfigSpec.BooleanValue HOOK_IRONS_SPELLBOOKS;
        public static final ModConfigSpec.BooleanValue HOOK_FEATHERS;
        public static final ModConfigSpec.BooleanValue HOOK_APPLE_SKIN;
        public static final ModConfigSpec.BooleanValue HOOK_SUPERIOR_SHIELDS;
        public static final ModConfigSpec.BooleanValue HOOK_VAMPIRISM;

        static {
            BUILDER.push("overlay");
            ENABLE_OVERLAY = BUILDER
                    .comment(ConfigComment.enableOverlay)
                    .translation("text.autoconfig.asteorbar.option.overlay.enableOverlay")
                    .define("enableOverlay", DefaultConfigAdapter.I.enableOverlay());
            OVERLAY_LAYOUT_STYLE = BUILDER
                    .comment(ConfigComment.overlayLayoutStyle)
                    .translation("text.autoconfig.asteorbar.option.overlay.overlayLayoutStyle")
                    .defineInRange("overlayLayoutStyle", DefaultConfigAdapter.I.overlayLayoutStyle(), 0, Overlays.NUM_STYLES - 1);
            OVERLAY_TEXT_SCALE = BUILDER
                    .comment(ConfigComment.overlayTextScale)
                    .translation("text.autoconfig.asteorbar.option.overlay.overlayTextScale")
                    .defineInRange("overlayTextScale", DefaultConfigAdapter.I.overlayTextScale(), 0.1, 10.0);
            FULL_FOOD_LEVEL_VALUE = BUILDER
                    .comment(ConfigComment.fullFoodLevelValue)
                    .translation("text.autoconfig.asteorbar.option.overlay.fullFoodLevelValue")
                    .defineInRange("fullFoodLevelValue", DefaultConfigAdapter.I.fullFoodLevelValue(), 1, Integer.MAX_VALUE);
            FULL_SATURATION_VALUE = BUILDER
                    .comment(ConfigComment.fullSaturationValue)
                    .translation("text.autoconfig.asteorbar.option.overlay.fullSaturationValue")
                    .defineInRange("fullSaturationValue", DefaultConfigAdapter.I.fullSaturationValue(), 1, Double.MAX_VALUE);
            FULL_EXHAUSTION_VALUE = BUILDER
                    .comment(ConfigComment.fullExhaustionValue)
                    .translation("text.autoconfig.asteorbar.option.overlay.fullExhaustionValue")
                    .defineInRange("fullExhaustionValue", DefaultConfigAdapter.I.fullExhaustionValue(), 1, Double.MAX_VALUE);
            FULL_ARMOR_VALUE = BUILDER
                    .comment(ConfigComment.fullArmorValue)
                    .translation("text.autoconfig.asteorbar.option.overlay.fullArmorValue")
                    .defineInRange("fullArmorValue", DefaultConfigAdapter.I.fullArmorValue(), 1, Integer.MAX_VALUE);
            FULL_ARMOR_TOUGHNESS_VALUE = BUILDER
                    .comment(ConfigComment.fullArmorToughnessValue)
                    .translation("text.autoconfig.asteorbar.option.overlay.fullArmorToughnessValue")
                    .defineInRange("fullArmorToughnessValue", DefaultConfigAdapter.I.fullArmorToughnessValue(), 1, Integer.MAX_VALUE);
            FULL_HEALTH_VALUE = BUILDER
                    .comment(ConfigComment.fullHealthValue)
                    .translation("text.autoconfig.asteorbar.option.overlay.fullHealthValue")
                    .defineInRange("fullHealthValue", DefaultConfigAdapter.I.fullHealthValue(), 1, Integer.MAX_VALUE);
            ENABLE_STACK_HEALTH_BAR = BUILDER
                    .comment(ConfigComment.enableStackHealthBar)
                    .translation("text.autoconfig.asteorbar.option.overlay.enableStackHealthBar")
                    .define("enableStackHealthBar", DefaultConfigAdapter.I.enableStackHealthBar());
            STACK_HEALTH_BAR_COLORS = BUILDER
                    .comment(ConfigComment.stackHealthBarColors)
                    .translation("text.autoconfig.asteorbar.option.overlay.stackHealthBarColors")
                    .define("stackHealthBarColors", DefaultConfigAdapter.I.stackHealthBarColors());
            HEALTH_COLOR_NORMAL = BUILDER
                    .comment(ConfigComment.healthColorNormal)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthColorNormal")
                    .defineInRange("healthColorNormal", DefaultConfigAdapter.I.healthColorNormal(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_COLOR_POISON = BUILDER
                    .comment(ConfigComment.healthColorPoison)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthColorPoison")
                    .defineInRange("healthColorPoison", DefaultConfigAdapter.I.healthColorPoison(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_COLOR_WITHER = BUILDER
                    .comment(ConfigComment.healthColorWither)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthColorWither")
                    .defineInRange("healthColorWither", DefaultConfigAdapter.I.healthColorWither(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_COLOR_FROZEN = BUILDER
                    .comment(ConfigComment.healthColorFrozen)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthColorFrozen")
                    .defineInRange("healthColorFrozen", DefaultConfigAdapter.I.healthColorFrozen(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_BOUND_COLOR = BUILDER
                    .comment(ConfigComment.healthBoundColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthBoundColor")
                    .defineInRange("healthBoundColor", DefaultConfigAdapter.I.healthBoundColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_BOUND_COLOR_BLINK = BUILDER
                    .comment(ConfigComment.healthBoundColorBlink)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthBoundColorBlink")
                    .defineInRange("healthBoundColorBlink", DefaultConfigAdapter.I.healthBoundColorBlink(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_BOUND_COLOR_LOW = BUILDER
                    .comment(ConfigComment.healthBoundColorLow)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthBoundColorLow")
                    .defineInRange("healthBoundColorLow", DefaultConfigAdapter.I.healthBoundColorLow(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_EMPTY_COLOR = BUILDER
                    .comment(ConfigComment.healthEmptyColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthEmptyColor")
                    .defineInRange("healthEmptyColor", DefaultConfigAdapter.I.healthEmptyColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            ABSORPTION_COLOR = BUILDER
                    .comment(ConfigComment.absorptionColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.absorptionColor")
                    .defineInRange("absorptionColor", DefaultConfigAdapter.I.absorptionColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            ABSORPTION_BOUND_COLOR = BUILDER
                    .comment(ConfigComment.absorptionBoundColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.absorptionBoundColor")
                    .defineInRange("absorptionBoundColor", DefaultConfigAdapter.I.absorptionBoundColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            FOOD_COLOR_NORMAL = BUILDER
                    .comment(ConfigComment.foodColorNormal)
                    .translation("text.autoconfig.asteorbar.option.overlay.foodColorNormal")
                    .defineInRange("foodColorNormal", DefaultConfigAdapter.I.foodColorNormal(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            FOOD_COLOR_HUNGER = BUILDER
                    .comment(ConfigComment.foodColorHunger)
                    .translation("text.autoconfig.asteorbar.option.overlay.foodColorHunger")
                    .defineInRange("foodColorHunger", DefaultConfigAdapter.I.foodColorHunger(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            FOOD_BOUND_COLOR = BUILDER
                    .comment(ConfigComment.foodBoundColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.foodBoundColor")
                    .defineInRange("foodBoundColor", DefaultConfigAdapter.I.foodBoundColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            FOOD_BOUND_COLOR_BLINK = BUILDER
                    .comment(ConfigComment.foodBoundColorBlink)
                    .translation("text.autoconfig.asteorbar.option.overlay.foodBoundColorBlink")
                    .defineInRange("foodBoundColorBlink", DefaultConfigAdapter.I.foodBoundColorBlink(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            FOOD_EMPTY_COLOR = BUILDER
                    .comment(ConfigComment.foodEmptyColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.foodEmptyColor")
                    .defineInRange("foodEmptyColor", DefaultConfigAdapter.I.foodEmptyColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            SATURATION_COLOR = BUILDER
                    .comment(ConfigComment.saturationColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.saturationColor")
                    .defineInRange("saturationColor", DefaultConfigAdapter.I.saturationColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            EXPERIENCE_COLOR = BUILDER
                    .comment(ConfigComment.experienceColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.experienceColor")
                    .defineInRange("experienceColor", DefaultConfigAdapter.I.experienceColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            EXPERIENCE_BOUND_COLOR = BUILDER
                    .comment(ConfigComment.experienceBoundColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.experienceBoundColor")
                    .defineInRange("experienceBoundColor", DefaultConfigAdapter.I.experienceBoundColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            EXPERIENCE_EMPTY_COLOR = BUILDER
                    .comment(ConfigComment.experienceEmptyColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.experienceEmptyColor")
                    .defineInRange("experienceEmptyColor", DefaultConfigAdapter.I.experienceEmptyColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            AIR_COLOR = BUILDER
                    .comment(ConfigComment.airColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.airColor")
                    .defineInRange("airColor", DefaultConfigAdapter.I.airColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            AIR_BOUND_COLOR = BUILDER
                    .comment(ConfigComment.airBoundColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.airBoundColor")
                    .defineInRange("airBoundColor", DefaultConfigAdapter.I.airBoundColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            MOUNT_HEALTH_COLOR = BUILDER
                    .comment(ConfigComment.mountHealthColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.mountHealthColor")
                    .defineInRange("mountHealthColor", DefaultConfigAdapter.I.mountHealthColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            MOUNT_HEALTH_COLOR_2 = BUILDER
                    .comment(ConfigComment.mountHealthColor2)
                    .translation("text.autoconfig.asteorbar.option.overlay.mountHealthColor2")
                    .defineInRange("mountHealthColor2", DefaultConfigAdapter.I.mountHealthColor2(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            MOUNT_HEALTH_BOUND_COLOR = BUILDER
                    .comment(ConfigComment.mountHealthBoundColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.mountHealthBoundColor")
                    .defineInRange("mountHealthBoundColor", DefaultConfigAdapter.I.mountHealthBoundColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            MOUNT_HEALTH_BOUND_COLOR_2 = BUILDER
                    .comment(ConfigComment.mountHealthBoundColor2)
                    .translation("text.autoconfig.asteorbar.option.overlay.mountHealthBoundColor2")
                    .defineInRange("mountHealthBoundColor2", DefaultConfigAdapter.I.mountHealthBoundColor2(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            MOUNT_HEALTH_EMPTY_COLOR = BUILDER
                    .comment(ConfigComment.mountHealthEmptyColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.mountHealthEmptyColor")
                    .defineInRange("mountHealthEmptyColor", DefaultConfigAdapter.I.mountHealthEmptyColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            MOUNT_HEALTH_ON_LEFT_SIDE = BUILDER
                    .comment(ConfigComment.mountHealthOnLeftSide)
                    .translation("text.autoconfig.asteorbar.option.overlay.mountHealthOnLeftSide")
                    .define("mountHealthOnLeftSide", DefaultConfigAdapter.I.mountHealthOnLeftSide());
            ARMOR_COLOR = BUILDER
                    .comment(ConfigComment.armorColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.armorColor")
                    .defineInRange("armorColor", DefaultConfigAdapter.I.armorColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            ARMOR_BOUND_COLOR = BUILDER
                    .comment(ConfigComment.armorBoundColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.armorBoundColor")
                    .defineInRange("armorBoundColor", DefaultConfigAdapter.I.armorBoundColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            ARMOR_EMPTY_COLOR = BUILDER
                    .comment(ConfigComment.armorEmptyColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.armorEmptyColor")
                    .defineInRange("armorEmptyColor", DefaultConfigAdapter.I.armorEmptyColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            ARMOR_TOUGHNESS_COLOR = BUILDER
                    .comment(ConfigComment.armorToughnessColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.armorToughnessColor")
                    .defineInRange("armorToughnessColor", DefaultConfigAdapter.I.armorToughnessColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            ENABLE_HEALTH_BLINK = BUILDER
                    .comment(ConfigComment.enableHealthBlink)
                    .translation("text.autoconfig.asteorbar.option.overlay.enableHealthBlink")
                    .define("enableHealthBlink", DefaultConfigAdapter.I.enableHealthBlink());
            LOW_HEALTH_RATE = BUILDER
                    .comment(ConfigComment.lowHealthRate)
                    .translation("text.autoconfig.asteorbar.option.overlay.lowHealthRate")
                    .defineInRange("lowHealthRate", DefaultConfigAdapter.I.lowHealthRate(), 0.0, 1.0);
            OVERWRITE_VANILLA_ARMOR_BAR = BUILDER
                    .comment(ConfigComment.overwriteVanillaArmorBar)
                    .translation("text.autoconfig.asteorbar.option.overlay.overwriteVanillaArmorBar")
                    .define("overwriteVanillaArmorBar", DefaultConfigAdapter.I.overwriteVanillaArmorBar());
            OVERWRITE_VANILLA_EXPERIENCE_BAR = BUILDER
                    .comment(ConfigComment.overwriteVanillaExperienceBar)
                    .translation("text.autoconfig.asteorbar.option.overlay.overwriteVanillaExperienceBar")
                    .define("overwriteVanillaExperienceBar", DefaultConfigAdapter.I.overwriteVanillaExperienceBar());
            DISPLAY_EXPERIENCE_PROGRESS = BUILDER
                    .comment(ConfigComment.displayExperienceProgress)
                    .translation("text.autoconfig.asteorbar.option.overlay.displayExperienceProgress")
                    .define("displayExperienceProgress", DefaultConfigAdapter.I.displayExperienceProgress());
            DISPLAY_EXPERIENCE_LEVEL = BUILDER
                    .comment(ConfigComment.displayExperienceLevel)
                    .translation("text.autoconfig.asteorbar.option.overlay.displayExperienceLevel")
                    .define("displayExperienceLevel", DefaultConfigAdapter.I.displayExperienceLevel());
            DISPLAY_HEALTH_TEXT = BUILDER
                    .comment(ConfigComment.displayHealthText)
                    .translation("text.autoconfig.asteorbar.option.overlay.displayHealthText")
                    .define("displayHealthText", DefaultConfigAdapter.I.displayHealthText());
            DISPLAY_ABSORPTION_METHOD = BUILDER
                    .comment(ConfigComment.displayAbsorptionMethod)
                    .translation("text.autoconfig.asteorbar.option.overlay.displayAbsorptionMethod")
                    .defineInRange("displayAbsorptionMethod", DefaultConfigAdapter.I.displayAbsorptionMethod(), 0, PlayerHealthOverlay.ABSORPTION_MODES - 1);
            DISPLAY_ABSORPTION_DIV_MAX_HEALTH = BUILDER
                    .comment(ConfigComment.displayAbsorptionDivMaxHealth)
                    .translation("text.autoconfig.asteorbar.option.overlay.displayAbsorptionDivMaxHealth")
                    .define("displayAbsorptionDivMaxHealth", DefaultConfigAdapter.I.displayAbsorptionDivMaxHealth());
            DISPLAY_ABSORPTION_TEXT_METHOD = BUILDER
                    .comment(ConfigComment.displayAbsorptionTextMethod)
                    .translation("text.autoconfig.asteorbar.option.overlay.displayAbsorptionTextMethod")
                    .defineInRange("displayAbsorptionTextMethod", DefaultConfigAdapter.I.displayAbsorptionTextMethod(), 0, PlayerHealthOverlay.ABSORPTION_TEXT_MODES - 1);
            ENABLE_FOOD_BLINK = BUILDER
                    .comment(ConfigComment.enableFoodBlink)
                    .translation("text.autoconfig.asteorbar.option.overlay.enableFoodBlink")
                    .define("enableFoodBlink", DefaultConfigAdapter.I.enableFoodBlink());
            DISPLAY_SATURATION = BUILDER
                    .comment(ConfigComment.displaySaturation)
                    .translation("text.autoconfig.asteorbar.option.overlay.displaySaturation")
                    .define("displaySaturation", DefaultConfigAdapter.I.displaySaturation());
            DISPLAY_EXHAUSTION = BUILDER
                    .comment(ConfigComment.displayExhaustion)
                    .translation("text.autoconfig.asteorbar.option.overlay.displayExhaustion")
                    .define("displayExhaustion", DefaultConfigAdapter.I.displayExhaustion());
            DISPLAY_ARMOR_TOUGHNESS = BUILDER
                    .comment(ConfigComment.displayArmorToughness)
                    .translation("text.autoconfig.asteorbar.option.overlay.displayArmorToughness")
                    .define("displayArmorToughness", DefaultConfigAdapter.I.displayArmorToughness());
            CORNER_BAR_LENGTH = BUILDER
                    .comment(ConfigComment.cornerBarLength)
                    .translation("text.autoconfig.asteorbar.option.overlay.cornerBarLength")
                    .defineInRange("cornerBarLength", DefaultConfigAdapter.I.cornerBarLength(), 40, 182);
            CORNER_HORIZONTAL_PADDING = BUILDER
                    .comment(ConfigComment.cornerHorizontalPadding)
                    .translation("text.autoconfig.asteorbar.option.overlay.cornerHorizontalPadding")
                    .defineInRange("cornerHorizontalPadding", DefaultConfigAdapter.I.cornerHorizontalPadding(), 0, 100);
            CORNER_VERTICAL_PADDING = BUILDER
                    .comment(ConfigComment.cornerVerticalPadding)
                    .translation("text.autoconfig.asteorbar.option.overlay.cornerVerticalPadding")
                    .defineInRange("cornerVerticalPadding", DefaultConfigAdapter.I.cornerVerticalPadding(), 0, 100);
            BUILDER.pop();
            BUILDER.push("entity");
            ENABLE_HEALTH_BAR = BUILDER
                    .comment(ConfigComment.enableHealthBar)
                    .translation("text.autoconfig.asteorbar.option.entity.enableHealthBar")
                    .define("enableHealthBar", DefaultConfigAdapter.I.enableHealthBar());
            MAX_DISTANCE = BUILDER
                    .comment(ConfigComment.maxDistance)
                    .translation("text.autoconfig.asteorbar.option.entity.maxDistance")
                    .defineInRange("maxDistance", DefaultConfigAdapter.I.maxDistance(), 0.0, 100.0);
            SHOW_ON_SELF = BUILDER
                    .comment(ConfigComment.showOnSelf)
                    .translation("text.autoconfig.asteorbar.option.entity.showOnSelf")
                    .define("showOnSelf", DefaultConfigAdapter.I.showOnSelf());
            SHOW_ON_PLAYERS = BUILDER
                    .comment(ConfigComment.showOnPlayers)
                    .translation("text.autoconfig.asteorbar.option.entity.showOnPlayers")
                    .define("showOnPlayers", DefaultConfigAdapter.I.showOnPlayers());
            SHOW_ON_BOSSES = BUILDER
                    .comment(ConfigComment.showOnBosses)
                    .translation("text.autoconfig.asteorbar.option.entity.showOnBosses")
                    .define("showOnBosses", DefaultConfigAdapter.I.showOnBosses());
            SHOW_ON_FULL_HEALTH_WITHOUT_ABSORPTION = BUILDER
                    .comment(ConfigComment.showOnFullHealthWithoutAbsorption)
                    .translation("text.autoconfig.asteorbar.option.entity.showOnFullHealthWithoutAbsorption")
                    .define("showOnFullHealthWithoutAbsorption", DefaultConfigAdapter.I.showOnFullHealthWithoutAbsorption());
            SHOW_ON_FULL_HEALTH_WITH_ABSORPTION = BUILDER
                    .comment(ConfigComment.showOnFullHealthWithAbsorption)
                    .translation("text.autoconfig.asteorbar.option.entity.showOnFullHealthWithAbsorption")
                    .define("showOnFullHealthWithAbsorption", DefaultConfigAdapter.I.showOnFullHealthWithAbsorption());
            HEALTH_BAR_ALPHA = BUILDER
                    .comment(ConfigComment.healthBarAlpha)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarAlpha")
                    .defineInRange("healthBarAlpha", DefaultConfigAdapter.I.healthBarAlpha(), 0, 255);
            HEALTH_BAR_HALF_WIDTH = BUILDER
                    .comment(ConfigComment.healthBarHalfWidth)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarHalfWidth")
                    .defineInRange("healthBarHalfWidth", DefaultConfigAdapter.I.healthBarHalfWidth(), 1, 1000);
            HEALTH_BAR_HALF_HEIGHT = BUILDER
                    .comment(ConfigComment.healthBarHalfHeight)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarHalfHeight")
                    .defineInRange("healthBarHalfHeight", DefaultConfigAdapter.I.healthBarHalfHeight(), 1, 200);
            HEALTH_BAR_OFFSET_Y = BUILDER
                    .comment(ConfigComment.healthBarOffsetY)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarOffsetY")
                    .defineInRange("healthBarOffsetY", DefaultConfigAdapter.I.healthBarOffsetY(), -10, 10);
            HEALTH_BAR_SCALE = BUILDER
                    .comment(ConfigComment.healthBarScale)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarScale")
                    .defineInRange("healthBarScale", DefaultConfigAdapter.I.healthBarScale(), 0.001, 0.1);
            HEALTH_BAR_TEXT_SCALE = BUILDER
                    .comment(ConfigComment.healthBarTextScale)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarTextScale")
                    .defineInRange("healthBarTextScale", DefaultConfigAdapter.I.healthBarTextScale(), 0.1, 1.0);
            HEALTH_BAR_TEXT_OFFSET_Y = BUILDER
                    .comment(ConfigComment.healthBarTextOffsetY)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarTextOffsetY")
                    .defineInRange("healthBarTextOffsetY", DefaultConfigAdapter.I.healthBarTextOffsetY(), -10, 10);
            HEALTH_BAR_BOUND_WIDTH = BUILDER
                    .comment(ConfigComment.healthBarBoundWidth)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarBoundWidth")
                    .defineInRange("healthBarBoundWidth", DefaultConfigAdapter.I.healthBarBoundWidth(), 0, 10);
            HEALTH_BAR_BOUND_VERTEX = BUILDER
                    .comment(ConfigComment.healthBarBoundVertex)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarBoundVertex")
                    .define("healthBarBoundVertex", DefaultConfigAdapter.I.healthBarBoundVertex());
            HEALTH_BAR_HEALTH_COLOR = BUILDER
                    .comment(ConfigComment.healthBarHealthColor)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarHealthColor")
                    .defineInRange("healthBarHealthColor", DefaultConfigAdapter.I.healthBarHealthColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_BAR_ABSORPTION_COLOR = BUILDER
                    .comment(ConfigComment.healthBarAbsorptionColor)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarAbsorptionColor")
                    .defineInRange("healthBarAbsorptionColor", DefaultConfigAdapter.I.healthBarAbsorptionColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_BAR_BOUND_COLOR = BUILDER
                    .comment(ConfigComment.healthBarBoundColor)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarBoundColor")
                    .defineInRange("healthBarBoundColor", DefaultConfigAdapter.I.healthBarBoundColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_BAR_EMPTY_COLOR = BUILDER
                    .comment(ConfigComment.healthBarEmptyColor)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarEmptyColor")
                    .defineInRange("healthBarEmptyColor", DefaultConfigAdapter.I.healthBarEmptyColor(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_BAR_HEALTH_COLOR_DYNAMIC = BUILDER
                    .comment(ConfigComment.healthBarHealthColorDynamic)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarHealthColorDynamic")
                    .define("healthBarHealthColorDynamic", DefaultConfigAdapter.I.healthBarHealthColorDynamic());
            HEALTH_BAR_HEALTH_COLOR_FULL = BUILDER
                    .comment(ConfigComment.healthBarHealthColorFull)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarHealthColorFull")
                    .defineInRange("healthBarHealthColorFull", DefaultConfigAdapter.I.healthBarHealthColorFull(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HEALTH_BAR_HEALTH_COLOR_EMPTY = BUILDER
                    .comment(ConfigComment.healthBarHealthColorEmpty)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarHealthColorEmpty")
                    .defineInRange("healthBarHealthColorEmpty", DefaultConfigAdapter.I.healthBarHealthColorEmpty(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            BUILDER.pop();
            BUILDER.push("hook");
            HOOK_TOUGH_AS_NAILS = BUILDER
                    .comment(ConfigComment.hookToughAsNails)
                    .translation("text.autoconfig.asteorbar.option.hook.hookToughAsNails")
                    .define("toughAsNails", DefaultConfigAdapter.I.hookToughAsNails());
            HOOK_THIRST_WAS_TAKEN = BUILDER
                    .comment(ConfigComment.hookThirstWasTaken)
                    .translation("text.autoconfig.asteorbar.option.hook.hookThirstWasTaken")
                    .define("thirstWasTaken", DefaultConfigAdapter.I.hookThirstWasTaken());
            HOOK_MEKANISM = BUILDER
                    .comment(ConfigComment.hookMekanism)
                    .translation("text.autoconfig.asteorbar.option.hook.hookMekanism")
                    .define("mekanism", DefaultConfigAdapter.I.hookMekanism());
            HOOK_DEHYDRATION = BUILDER
                    .comment(ConfigComment.hookDehydration)
                    .translation("text.autoconfig.asteorbar.option.hook.hookDehydration")
                    .define("dehydration", DefaultConfigAdapter.I.hookDehydration());
            HOOK_PARCOOL = BUILDER
                    .comment(ConfigComment.hookParcool)
                    .translation("text.autoconfig.asteorbar.option.hook.hookParcool")
                    .define("parcool", DefaultConfigAdapter.I.hookParcool());
            HOOK_IRONS_SPELLBOOKS = BUILDER
                    .comment(ConfigComment.hookIronsSpellbooks)
                    .translation("text.autoconfig.asteorbar.option.hook.hookIronsSpellbooks")
                    .define("ironsSpellbooks", DefaultConfigAdapter.I.hookIronsSpellbooks());
            HOOK_FEATHERS = BUILDER
                    .comment(ConfigComment.hookFeathers)
                    .translation("text.autoconfig.asteorbar.option.hook.hookFeathers")
                    .define("feathers", DefaultConfigAdapter.I.hookFeathers());
            HOOK_APPLE_SKIN = BUILDER
                    .comment(ConfigComment.hookAppleSkin)
                    .translation("text.autoconfig.asteorbar.option.hook.hookAppleSkin")
                    .define("appleSkin", DefaultConfigAdapter.I.hookAppleSkin());
            HOOK_SUPERIOR_SHIELDS = BUILDER
                    .comment(ConfigComment.hookSuperiorShields)
                    .translation("text.autoconfig.asteorbar.option.hook.hookSuperiorShields")
                    .define("superiorShields", DefaultConfigAdapter.I.hookSuperiorShields());
            HOOK_VAMPIRISM = BUILDER
                    .comment(ConfigComment.hookVampirism)
                    .translation("text.autoconfig.asteorbar.option.hook.hookVampirism")
                    .define("vampirism", DefaultConfigAdapter.I.hookVampirism());
            BUILDER.pop();
        }

        public static ModConfigSpec CONFIG = BUILDER.build();
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
    public int fullFoodLevelValue() {
        return Config.FULL_FOOD_LEVEL_VALUE.get();
    }

    @Override
    public double fullSaturationValue() {
        return Config.FULL_SATURATION_VALUE.get();
    }

    @Override
    public double fullExhaustionValue() {
        return Config.FULL_EXHAUSTION_VALUE.get();
    }

    @Override
    public int fullArmorValue() {
        return Config.FULL_ARMOR_VALUE.get();
    }

    @Override
    public int fullArmorToughnessValue() {
        return Config.FULL_ARMOR_TOUGHNESS_VALUE.get();
    }

    @Override
    public int fullHealthValue() {
        return Config.FULL_HEALTH_VALUE.get();
    }

    @Override
    public boolean enableStackHealthBar() {
        return Config.ENABLE_STACK_HEALTH_BAR.get();
    }

    @Override
    public String stackHealthBarColors() {
        return Config.STACK_HEALTH_BAR_COLORS.get();
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
    public boolean mountHealthOnLeftSide() {
        return Config.MOUNT_HEALTH_ON_LEFT_SIDE.get();
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
    public boolean showOnSelf() {
        return Config.SHOW_ON_SELF.get();
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
    public int healthBarAlpha() {
        return Config.HEALTH_BAR_ALPHA.get();
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

    @Override
    public boolean hookParcool() {
        return Config.HOOK_PARCOOL.get();
    }

    @Override
    public boolean hookIronsSpellbooks() {
        return Config.HOOK_IRONS_SPELLBOOKS.get();
    }

    @Override
    public boolean hookFeathers() {
        return Config.HOOK_FEATHERS.get();
    }

    @Override
    public boolean hookAppleSkin() {
        return Config.HOOK_APPLE_SKIN.get();
    }

    @Override
    public boolean hookSuperiorShields() {
        return Config.HOOK_SUPERIOR_SHIELDS.get();
    }

    @Override
    public boolean hookVampirism() {
        return Config.HOOK_VAMPIRISM.get();
    }

}
