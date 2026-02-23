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
        public static final ModConfigSpec.IntValue OVERLAY_BAR_INNER_HEIGHT;
        public static final ModConfigSpec.IntValue OVERLAY_BAR_VERTICAL_MARGIN;
        public static final ModConfigSpec.IntValue OVERLAY_BAR_TEXT_OFFSET_Y;
        public static final ModConfigSpec.DoubleValue HIDE_DECIMAL_WHEN_EQUAL_OR_MORE_THAN;
        public static final ModConfigSpec.IntValue FULL_FOOD_LEVEL_VALUE;
        public static final ModConfigSpec.DoubleValue FULL_SATURATION_VALUE;
        public static final ModConfigSpec.DoubleValue FULL_EXHAUSTION_VALUE;
        public static final ModConfigSpec.IntValue FULL_ARMOR_VALUE;
        public static final ModConfigSpec.IntValue FULL_ARMOR_TOUGHNESS_VALUE;
        public static final ModConfigSpec.IntValue FULL_HEALTH_VALUE;
        public static final ModConfigSpec.BooleanValue ENABLE_STACK_HEALTH_BAR;
        public static final ModConfigSpec.ConfigValue<String> STACK_HEALTH_BAR_COLORS;
        public static final ModConfigSpec.DoubleValue HEALTH_REGENERATION_OPACITY;
        public static final ModConfigSpec.DoubleValue HEALTH_REGENERATION_OPACITY_ON_FULL;
        public static final ModConfigSpec.IntValue HIDE_UNCHANGING_BAR_AFTER_SECONDS;
        public static final ModConfigSpec.ConfigValue<String> HEALTH_COLOR_NORMAL_ARGB;
        public static final ModConfigSpec.ConfigValue<String> HEALTH_COLOR_POISON_ARGB;
        public static final ModConfigSpec.ConfigValue<String> HEALTH_COLOR_WITHER_ARGB;
        public static final ModConfigSpec.ConfigValue<String> HEALTH_COLOR_FROZEN_ARGB;
        public static final ModConfigSpec.ConfigValue<String> HEALTH_BOUND_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> HEALTH_BOUND_COLOR_BLINK_ARGB;
        public static final ModConfigSpec.ConfigValue<String> HEALTH_BOUND_COLOR_LOW_ARGB;
        public static final ModConfigSpec.ConfigValue<String> HEALTH_EMPTY_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> ABSORPTION_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> ABSORPTION_BOUND_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> FOOD_COLOR_NORMAL_ARGB;
        public static final ModConfigSpec.ConfigValue<String> FOOD_COLOR_HUNGER_ARGB;
        public static final ModConfigSpec.ConfigValue<String> FOOD_BOUND_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> FOOD_BOUND_COLOR_BLINK_ARGB;
        public static final ModConfigSpec.ConfigValue<String> FOOD_EMPTY_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> SATURATION_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> EXPERIENCE_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> EXPERIENCE_BOUND_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> EXPERIENCE_EMPTY_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> AIR_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> AIR_BOUND_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> MOUNT_HEALTH_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> MOUNT_HEALTH_COLOR_2_ARGB;
        public static final ModConfigSpec.ConfigValue<String> MOUNT_HEALTH_BOUND_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> MOUNT_HEALTH_BOUND_COLOR_2_ARGB;
        public static final ModConfigSpec.ConfigValue<String> MOUNT_HEALTH_EMPTY_COLOR_ARGB;
        public static final ModConfigSpec.BooleanValue MOUNT_HEALTH_ON_LEFT_SIDE;
        public static final ModConfigSpec.ConfigValue<String> ARMOR_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> ARMOR_BOUND_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> ARMOR_EMPTY_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> ARMOR_TOUGHNESS_COLOR_ARGB;
        public static final ModConfigSpec.BooleanValue ENABLE_HEALTH_BLINK;
        public static final ModConfigSpec.DoubleValue LOW_HEALTH_RATE;
        public static final ModConfigSpec.BooleanValue SHAKE_HEALTH_AND_FOOD_WHILE_LOW;
        public static final ModConfigSpec.BooleanValue OVERWRITE_VANILLA_HEALTH_BAR;
        public static final ModConfigSpec.BooleanValue OVERWRITE_VANILLA_FOOD_BAR;
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
        public static final ModConfigSpec.BooleanValue DISPLAY_FOOD_TEXT;
        public static final ModConfigSpec.BooleanValue DISPLAY_ARMOR_TOUGHNESS;
        public static final ModConfigSpec.IntValue CORNER_BAR_LENGTH;
        public static final ModConfigSpec.IntValue CORNER_HORIZONTAL_PADDING;
        public static final ModConfigSpec.IntValue CORNER_VERTICAL_PADDING;
        public static final ModConfigSpec.BooleanValue FORCE_RENDER_AT_CORNER;
        //mob config
        public static final ModConfigSpec.BooleanValue ENABLE_HEALTH_BAR;
        public static final ModConfigSpec.DoubleValue MAX_DISTANCE;
        public static final ModConfigSpec.BooleanValue SHOW_ON_SELF;
        public static final ModConfigSpec.BooleanValue SHOW_ON_PLAYERS;
        public static final ModConfigSpec.BooleanValue SHOW_ON_BOSSES;
        public static final ModConfigSpec.BooleanValue SHOW_ON_ARMOR_STANDS;
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
        public static final ModConfigSpec.ConfigValue<String> HEALTH_BAR_HEALTH_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> HEALTH_BAR_ABSORPTION_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> HEALTH_BAR_BOUND_COLOR_ARGB;
        public static final ModConfigSpec.ConfigValue<String> HEALTH_BAR_EMPTY_COLOR_ARGB;
        public static final ModConfigSpec.BooleanValue HEALTH_BAR_HEALTH_COLOR_DYNAMIC;
        public static final ModConfigSpec.ConfigValue<String> HEALTH_BAR_HEALTH_COLOR_FULL_ARGB;
        public static final ModConfigSpec.ConfigValue<String> HEALTH_BAR_HEALTH_COLOR_EMPTY_ARGB;
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
        public static final ModConfigSpec.BooleanValue HOOK_BOTANIA;
        public static final ModConfigSpec.BooleanValue HOOK_ORIGINS;
        public static final ModConfigSpec.BooleanValue HOOK_TFC;
        public static final ModConfigSpec.BooleanValue HOOK_ARS_NOUVEAU;
        public static final ModConfigSpec.BooleanValue HOOK_APOLI;
        public static final ModConfigSpec.BooleanValue HOOK_THERMOO;
        public static final ModConfigSpec.BooleanValue HOOK_MEAL_API;
        public static final ModConfigSpec.BooleanValue HOOK_LEGENDARY_SURVIVAL_OVERHAUL;

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
            OVERLAY_BAR_INNER_HEIGHT = BUILDER
                    .comment(ConfigComment.overlayBarInnerHeight)
                    .translation("text.autoconfig.asteorbar.option.overlay.overlayBarInnerHeight")
                    .defineInRange("overlayBarInnerHeight", DefaultConfigAdapter.I.overlayBarInnerHeight(), 1, Integer.MAX_VALUE);
            OVERLAY_BAR_VERTICAL_MARGIN = BUILDER
                    .comment(ConfigComment.overlayBarVerticalMargin)
                    .translation("text.autoconfig.asteorbar.option.overlay.overlayBarVerticalMargin")
                    .defineInRange("overlayBarVerticalMargin", DefaultConfigAdapter.I.overlayBarVerticalMargin(), 0, Integer.MAX_VALUE);
            OVERLAY_BAR_TEXT_OFFSET_Y = BUILDER
                    .comment(ConfigComment.overlayBarTextOffsetY)
                    .translation("text.autoconfig.asteorbar.option.overlay.overlayBarTextOffsetY")
                    .defineInRange("overlayBarTextOffsetY", DefaultConfigAdapter.I.overlayBarTextOffsetY(), Integer.MIN_VALUE, Integer.MAX_VALUE);
            HIDE_DECIMAL_WHEN_EQUAL_OR_MORE_THAN = BUILDER
                    .comment(ConfigComment.hideDecimalWhenEqualOrMoreThan)
                    .translation("text.autoconfig.asteorbar.option.overlay.hideDecimalWhenEqualOrMoreThan")
                    .defineInRange("hideDecimalWhenEqualOrMoreThan", DefaultConfigAdapter.I.hideDecimalWhenEqualOrMoreThan(), 0.0, Double.MAX_VALUE);
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
            HEALTH_REGENERATION_OPACITY = BUILDER
                    .comment(ConfigComment.healthRegenerationOpacity)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthRegenerationOpacity")
                    .defineInRange("healthRegenerationOpacity", DefaultConfigAdapter.I.healthRegenerationOpacity(), 0.0, 1.0);
            HEALTH_REGENERATION_OPACITY_ON_FULL = BUILDER
                    .comment(ConfigComment.healthRegenerationOpacityOnFull)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthRegenerationOpacityOnFull")
                    .defineInRange("healthRegenerationOpacityOnFull", DefaultConfigAdapter.I.healthRegenerationOpacityOnFull(), 0.0, 1.0);
            HIDE_UNCHANGING_BAR_AFTER_SECONDS = BUILDER
                    .comment(ConfigComment.hideUnchangingBarAfterSeconds)
                    .translation("text.autoconfig.asteorbar.option.overlay.hideUnchangingBarAfterSeconds")
                    .defineInRange("hideUnchangingBarAfterSeconds", DefaultConfigAdapter.I.hideUnchangingBarAfterSeconds(), 0, Integer.MAX_VALUE);
            HEALTH_COLOR_NORMAL_ARGB = BUILDER
                    .comment(ConfigComment.healthColorNormal)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthColorNormalARGB")
                    .define("healthColorNormalARGB", DefaultConfigAdapter.I.healthColorNormalARGB());
            HEALTH_COLOR_POISON_ARGB = BUILDER
                    .comment(ConfigComment.healthColorPoison)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthColorPoisonARGB")
                    .define("healthColorPoisonARGB", DefaultConfigAdapter.I.healthColorPoisonARGB());
            HEALTH_COLOR_WITHER_ARGB = BUILDER
                    .comment(ConfigComment.healthColorWither)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthColorWitherARGB")
                    .define("healthColorWitherARGB", DefaultConfigAdapter.I.healthColorWitherARGB());
            HEALTH_COLOR_FROZEN_ARGB = BUILDER
                    .comment(ConfigComment.healthColorFrozen)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthColorFrozenARGB")
                    .define("healthColorFrozenARGB", DefaultConfigAdapter.I.healthColorFrozenARGB());
            HEALTH_BOUND_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.healthBoundColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthBoundColorARGB")
                    .define("healthBoundColorARGB", DefaultConfigAdapter.I.healthBoundColorARGB());
            HEALTH_BOUND_COLOR_BLINK_ARGB = BUILDER
                    .comment(ConfigComment.healthBoundColorBlink)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthBoundColorBlinkARGB")
                    .define("healthBoundColorBlinkARGB", DefaultConfigAdapter.I.healthBoundColorBlinkARGB());
            HEALTH_BOUND_COLOR_LOW_ARGB = BUILDER
                    .comment(ConfigComment.healthBoundColorLow)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthBoundColorLowARGB")
                    .define("healthBoundColorLowARGB", DefaultConfigAdapter.I.healthBoundColorLowARGB());
            HEALTH_EMPTY_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.healthEmptyColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.healthEmptyColorARGB")
                    .define("healthEmptyColorARGB", DefaultConfigAdapter.I.healthEmptyColorARGB());
            ABSORPTION_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.absorptionColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.absorptionColorARGB")
                    .define("absorptionColorARGB", DefaultConfigAdapter.I.absorptionColorARGB());
            ABSORPTION_BOUND_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.absorptionBoundColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.absorptionBoundColorARGB")
                    .define("absorptionBoundColorARGB", DefaultConfigAdapter.I.absorptionBoundColorARGB());
            FOOD_COLOR_NORMAL_ARGB = BUILDER
                    .comment(ConfigComment.foodColorNormal)
                    .translation("text.autoconfig.asteorbar.option.overlay.foodColorNormalARGB")
                    .define("foodColorNormalARGB", DefaultConfigAdapter.I.foodColorNormalARGB());
            FOOD_COLOR_HUNGER_ARGB = BUILDER
                    .comment(ConfigComment.foodColorHunger)
                    .translation("text.autoconfig.asteorbar.option.overlay.foodColorHungerARGB")
                    .define("foodColorHungerARGB", DefaultConfigAdapter.I.foodColorHungerARGB());
            FOOD_BOUND_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.foodBoundColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.foodBoundColorARGB")
                    .define("foodBoundColorARGB", DefaultConfigAdapter.I.foodBoundColorARGB());
            FOOD_BOUND_COLOR_BLINK_ARGB = BUILDER
                    .comment(ConfigComment.foodBoundColorBlink)
                    .translation("text.autoconfig.asteorbar.option.overlay.foodBoundColorBlinkARGB")
                    .define("foodBoundColorBlinkARGB", DefaultConfigAdapter.I.foodBoundColorBlinkARGB());
            FOOD_EMPTY_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.foodEmptyColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.foodEmptyColorARGB")
                    .define("foodEmptyColorARGB", DefaultConfigAdapter.I.foodEmptyColorARGB());
            SATURATION_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.saturationColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.saturationColorARGB")
                    .define("saturationColorARGB", DefaultConfigAdapter.I.saturationColorARGB());
            EXPERIENCE_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.experienceColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.experienceColorARGB")
                    .define("experienceColorARGB", DefaultConfigAdapter.I.experienceColorARGB());
            EXPERIENCE_BOUND_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.experienceBoundColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.experienceBoundColorARGB")
                    .define("experienceBoundColorARGB", DefaultConfigAdapter.I.experienceBoundColorARGB());
            EXPERIENCE_EMPTY_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.experienceEmptyColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.experienceEmptyColorARGB")
                    .define("experienceEmptyColorARGB", DefaultConfigAdapter.I.experienceEmptyColorARGB());
            AIR_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.airColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.airColorARGB")
                    .define("airColorARGB", DefaultConfigAdapter.I.airColorARGB());
            AIR_BOUND_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.airBoundColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.airBoundColorARGB")
                    .define("airBoundColorARGB", DefaultConfigAdapter.I.airBoundColorARGB());
            MOUNT_HEALTH_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.mountHealthColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.mountHealthColorARGB")
                    .define("mountHealthColorARGB", DefaultConfigAdapter.I.mountHealthColorARGB());
            MOUNT_HEALTH_COLOR_2_ARGB = BUILDER
                    .comment(ConfigComment.mountHealthColor2)
                    .translation("text.autoconfig.asteorbar.option.overlay.mountHealthColor2ARGB")
                    .define("mountHealthColor2ARGB", DefaultConfigAdapter.I.mountHealthColor2ARGB());
            MOUNT_HEALTH_BOUND_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.mountHealthBoundColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.mountHealthBoundColorARGB")
                    .define("mountHealthBoundColorARGB", DefaultConfigAdapter.I.mountHealthBoundColorARGB());
            MOUNT_HEALTH_BOUND_COLOR_2_ARGB = BUILDER
                    .comment(ConfigComment.mountHealthBoundColor2)
                    .translation("text.autoconfig.asteorbar.option.overlay.mountHealthBoundColor2ARGB")
                    .define("mountHealthBoundColor2ARGB", DefaultConfigAdapter.I.mountHealthBoundColor2ARGB());
            MOUNT_HEALTH_EMPTY_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.mountHealthEmptyColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.mountHealthEmptyColorARGB")
                    .define("mountHealthEmptyColorARGB", DefaultConfigAdapter.I.mountHealthEmptyColorARGB());
            MOUNT_HEALTH_ON_LEFT_SIDE = BUILDER
                    .comment(ConfigComment.mountHealthOnLeftSide)
                    .translation("text.autoconfig.asteorbar.option.overlay.mountHealthOnLeftSide")
                    .define("mountHealthOnLeftSide", DefaultConfigAdapter.I.mountHealthOnLeftSide());
            ARMOR_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.armorColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.armorColorARGB")
                    .define("armorColorARGB", DefaultConfigAdapter.I.armorColorARGB());
            ARMOR_BOUND_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.armorBoundColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.armorBoundColorARGB")
                    .define("armorBoundColorARGB", DefaultConfigAdapter.I.armorBoundColorARGB());
            ARMOR_EMPTY_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.armorEmptyColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.armorEmptyColorARGB")
                    .define("armorEmptyColorARGB", DefaultConfigAdapter.I.armorEmptyColorARGB());
            ARMOR_TOUGHNESS_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.armorToughnessColor)
                    .translation("text.autoconfig.asteorbar.option.overlay.armorToughnessColorARGB")
                    .define("armorToughnessColorARGB", DefaultConfigAdapter.I.armorToughnessColorARGB());
            ENABLE_HEALTH_BLINK = BUILDER
                    .comment(ConfigComment.enableHealthBlink)
                    .translation("text.autoconfig.asteorbar.option.overlay.enableHealthBlink")
                    .define("enableHealthBlink", DefaultConfigAdapter.I.enableHealthBlink());
            LOW_HEALTH_RATE = BUILDER
                    .comment(ConfigComment.lowHealthRate)
                    .translation("text.autoconfig.asteorbar.option.overlay.lowHealthRate")
                    .defineInRange("lowHealthRate", DefaultConfigAdapter.I.lowHealthRate(), 0.0, 1.0);
            SHAKE_HEALTH_AND_FOOD_WHILE_LOW = BUILDER
                    .comment(ConfigComment.shakeHealthAndFoodWhileLow)
                    .translation("text.autoconfig.asteorbar.option.overlay.shakeHealthAndFoodWhileLow")
                    .define("shakeHealthAndFoodWhileLow", DefaultConfigAdapter.I.shakeHealthAndFoodWhileLow());
            OVERWRITE_VANILLA_HEALTH_BAR = BUILDER
                    .comment(ConfigComment.overwriteVanillaHealthBar)
                    .translation("text.autoconfig.asteorbar.option.overlay.overwriteVanillaHealthBar")
                    .define("overwriteVanillaHealthBar", DefaultConfigAdapter.I.overwriteVanillaHealthBar());
            OVERWRITE_VANILLA_FOOD_BAR = BUILDER
                    .comment(ConfigComment.overwriteVanillaFoodBar)
                    .translation("text.autoconfig.asteorbar.option.overlay.overwriteVanillaFoodBar")
                    .define("overwriteVanillaFoodBar", DefaultConfigAdapter.I.overwriteVanillaFoodBar());
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
            DISPLAY_FOOD_TEXT = BUILDER
                    .comment(ConfigComment.displayFoodText)
                    .translation("text.autoconfig.asteorbar.option.overlay.displayFoodText")
                    .define("displayFoodText", DefaultConfigAdapter.I.displayFoodText());
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
            FORCE_RENDER_AT_CORNER = BUILDER
                    .comment(ConfigComment.forceRenderAtCorner)
                    .translation("text.autoconfig.asteorbar.option.overlay.forceRenderAtCorner")
                    .define("forceRenderAtCorner", DefaultConfigAdapter.I.forceRenderAtCorner());
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
            SHOW_ON_ARMOR_STANDS = BUILDER
                    .comment(ConfigComment.showOnArmorStands)
                    .translation("text.autoconfig.asteorbar.option.entity.showOnArmorStands")
                    .define("showOnArmorStands", DefaultConfigAdapter.I.showOnArmorStands());
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
            HEALTH_BAR_HEALTH_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.healthBarHealthColor)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarHealthColorARGB")
                    .define("healthBarHealthColorARGB", DefaultConfigAdapter.I.healthBarHealthColorARGB());
            HEALTH_BAR_ABSORPTION_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.healthBarAbsorptionColor)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarAbsorptionColorARGB")
                    .define("healthBarAbsorptionColorARGB", DefaultConfigAdapter.I.healthBarAbsorptionColorARGB());
            HEALTH_BAR_BOUND_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.healthBarBoundColor)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarBoundColorARGB")
                    .define("healthBarBoundColorARGB", DefaultConfigAdapter.I.healthBarBoundColorARGB());
            HEALTH_BAR_EMPTY_COLOR_ARGB = BUILDER
                    .comment(ConfigComment.healthBarEmptyColor)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarEmptyColorARGB")
                    .define("healthBarEmptyColorARGB", DefaultConfigAdapter.I.healthBarEmptyColorARGB());
            HEALTH_BAR_HEALTH_COLOR_DYNAMIC = BUILDER
                    .comment(ConfigComment.healthBarHealthColorDynamic)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarHealthColorDynamic")
                    .define("healthBarHealthColorDynamic", DefaultConfigAdapter.I.healthBarHealthColorDynamic());
            HEALTH_BAR_HEALTH_COLOR_FULL_ARGB = BUILDER
                    .comment(ConfigComment.healthBarHealthColorFull)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarHealthColorFullARGB")
                    .define("healthBarHealthColorFullARGB", DefaultConfigAdapter.I.healthBarHealthColorFullARGB());
            HEALTH_BAR_HEALTH_COLOR_EMPTY_ARGB = BUILDER
                    .comment(ConfigComment.healthBarHealthColorEmpty)
                    .translation("text.autoconfig.asteorbar.option.entity.healthBarHealthColorEmptyARGB")
                    .define("healthBarHealthColorEmptyARGB", DefaultConfigAdapter.I.healthBarHealthColorEmptyARGB());
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
            HOOK_BOTANIA = BUILDER
                    .comment(ConfigComment.hookBotania)
                    .translation("text.autoconfig.asteorbar.option.hook.hookBotania")
                    .define("botania", DefaultConfigAdapter.I.hookBotania());
            HOOK_ORIGINS = BUILDER
                    .comment(ConfigComment.hookOrigins)
                    .translation("text.autoconfig.asteorbar.option.hook.hookOrigins")
                    .define("origins", DefaultConfigAdapter.I.hookOrigins());
            HOOK_TFC = BUILDER
                    .comment(ConfigComment.hookTFC)
                    .translation("text.autoconfig.asteorbar.option.hook.hookTFC")
                    .define("tfc", DefaultConfigAdapter.I.hookTFC());
            HOOK_ARS_NOUVEAU = BUILDER
                    .comment(ConfigComment.hookArsNouveau)
                    .translation("text.autoconfig.asteorbar.option.hook.hookArsNouveau")
                    .define("arsNouveau", DefaultConfigAdapter.I.hookArsNouveau());
            HOOK_APOLI = BUILDER
                    .comment(ConfigComment.hookApoli)
                    .translation("text.autoconfig.asteorbar.option.hook.hookApoli")
                    .define("apoli", DefaultConfigAdapter.I.hookApoli());
            HOOK_THERMOO = BUILDER
                    .comment(ConfigComment.hookThermoo)
                    .translation("text.autoconfig.asteorbar.option.hook.hookThermoo")
                    .define("thermoo", DefaultConfigAdapter.I.hookThermoo());
            HOOK_MEAL_API = BUILDER
                    .comment(ConfigComment.hookMealAPI)
                    .translation("text.autoconfig.asteorbar.option.hook.hookMealApi")
                    .define("mealAPI", DefaultConfigAdapter.I.hookMealApi());
            HOOK_LEGENDARY_SURVIVAL_OVERHAUL = BUILDER
                    .comment(ConfigComment.hookLegendarySurvivalOverhaul)
                    .translation("text.autoconfig.asteorbar.option.hook.hookLegendarySurvivalOverhaul")
                    .define("legendarySurvivalOverhaul", DefaultConfigAdapter.I.hookLegendarySurvivalOverhaul());
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
    public int overlayBarInnerHeight() {
        return Config.OVERLAY_BAR_INNER_HEIGHT.get();
    }

    @Override
    public int overlayBarVerticalMargin() {
        return Config.OVERLAY_BAR_VERTICAL_MARGIN.get();
    }

    @Override
    public int overlayBarTextOffsetY() {
        return Config.OVERLAY_BAR_TEXT_OFFSET_Y.get();
    }

    @Override
    public double hideDecimalWhenEqualOrMoreThan() {
        return Config.HIDE_DECIMAL_WHEN_EQUAL_OR_MORE_THAN.get();
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
    public double healthRegenerationOpacity() {
        return Config.HEALTH_REGENERATION_OPACITY.get();
    }

    @Override
    public double healthRegenerationOpacityOnFull() {
        return Config.HEALTH_REGENERATION_OPACITY_ON_FULL.get();
    }

    @Override
    public int hideUnchangingBarAfterSeconds() {
        return Config.HIDE_UNCHANGING_BAR_AFTER_SECONDS.get();
    }

    @Override
    public String healthColorNormalARGB() {
        return Config.HEALTH_COLOR_NORMAL_ARGB.get();
    }

    @Override
    public String healthColorPoisonARGB() {
        return Config.HEALTH_COLOR_POISON_ARGB.get();
    }

    @Override
    public String healthColorWitherARGB() {
        return Config.HEALTH_COLOR_WITHER_ARGB.get();
    }

    @Override
    public String healthColorFrozenARGB() {
        return Config.HEALTH_COLOR_FROZEN_ARGB.get();
    }

    @Override
    public String healthBoundColorARGB() {
        return Config.HEALTH_BOUND_COLOR_ARGB.get();
    }

    @Override
    public String healthBoundColorBlinkARGB() {
        return Config.HEALTH_BOUND_COLOR_BLINK_ARGB.get();
    }

    @Override
    public String healthBoundColorLowARGB() {
        return Config.HEALTH_BOUND_COLOR_LOW_ARGB.get();
    }

    @Override
    public String healthEmptyColorARGB() {
        return Config.HEALTH_EMPTY_COLOR_ARGB.get();
    }

    @Override
    public String absorptionColorARGB() {
        return Config.ABSORPTION_COLOR_ARGB.get();
    }

    @Override
    public String absorptionBoundColorARGB() {
        return Config.ABSORPTION_BOUND_COLOR_ARGB.get();
    }

    @Override
    public String foodColorNormalARGB() {
        return Config.FOOD_COLOR_NORMAL_ARGB.get();
    }

    @Override
    public String foodColorHungerARGB() {
        return Config.FOOD_COLOR_HUNGER_ARGB.get();
    }

    @Override
    public String foodBoundColorARGB() {
        return Config.FOOD_BOUND_COLOR_ARGB.get();
    }

    @Override
    public String foodBoundColorBlinkARGB() {
        return Config.FOOD_BOUND_COLOR_BLINK_ARGB.get();
    }

    @Override
    public String foodEmptyColorARGB() {
        return Config.FOOD_EMPTY_COLOR_ARGB.get();
    }

    @Override
    public String saturationColorARGB() {
        return Config.SATURATION_COLOR_ARGB.get();
    }

    @Override
    public String experienceColorARGB() {
        return Config.EXPERIENCE_COLOR_ARGB.get();
    }

    @Override
    public String experienceBoundColorARGB() {
        return Config.EXPERIENCE_BOUND_COLOR_ARGB.get();
    }

    @Override
    public String experienceEmptyColorARGB() {
        return Config.EXPERIENCE_EMPTY_COLOR_ARGB.get();
    }

    @Override
    public String airColorARGB() {
        return Config.AIR_COLOR_ARGB.get();
    }

    @Override
    public String airBoundColorARGB() {
        return Config.AIR_BOUND_COLOR_ARGB.get();
    }

    @Override
    public String mountHealthColorARGB() {
        return Config.MOUNT_HEALTH_COLOR_ARGB.get();
    }

    @Override
    public String mountHealthColor2ARGB() {
        return Config.MOUNT_HEALTH_COLOR_2_ARGB.get();
    }

    @Override
    public String mountHealthBoundColorARGB() {
        return Config.MOUNT_HEALTH_BOUND_COLOR_ARGB.get();
    }

    @Override
    public String mountHealthBoundColor2ARGB() {
        return Config.MOUNT_HEALTH_BOUND_COLOR_2_ARGB.get();
    }

    @Override
    public String mountHealthEmptyColorARGB() {
        return Config.MOUNT_HEALTH_EMPTY_COLOR_ARGB.get();
    }

    @Override
    public boolean mountHealthOnLeftSide() {
        return Config.MOUNT_HEALTH_ON_LEFT_SIDE.get();
    }

    @Override
    public String armorColorARGB() {
        return Config.ARMOR_COLOR_ARGB.get();
    }

    @Override
    public String armorBoundColorARGB() {
        return Config.ARMOR_BOUND_COLOR_ARGB.get();
    }

    @Override
    public String armorEmptyColorARGB() {
        return Config.ARMOR_EMPTY_COLOR_ARGB.get();
    }

    @Override
    public String armorToughnessColorARGB() {
        return Config.ARMOR_TOUGHNESS_COLOR_ARGB.get();
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
    public boolean shakeHealthAndFoodWhileLow() {
        return Config.SHAKE_HEALTH_AND_FOOD_WHILE_LOW.get();
    }

    @Override
    public boolean overwriteVanillaHealthBar() {
        return Config.OVERWRITE_VANILLA_HEALTH_BAR.get();
    }

    @Override
    public boolean overwriteVanillaFoodBar() {
        return Config.OVERWRITE_VANILLA_FOOD_BAR.get();
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
    public boolean displayFoodText() {
        return Config.DISPLAY_FOOD_TEXT.get();
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
    public boolean forceRenderAtCorner() {
        return Config.FORCE_RENDER_AT_CORNER.get();
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
    public boolean showOnArmorStands() {
        return Config.SHOW_ON_ARMOR_STANDS.get();
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
    public String healthBarHealthColorARGB() {
        return Config.HEALTH_BAR_HEALTH_COLOR_ARGB.get();
    }

    @Override
    public String healthBarAbsorptionColorARGB() {
        return Config.HEALTH_BAR_ABSORPTION_COLOR_ARGB.get();
    }

    @Override
    public String healthBarBoundColorARGB() {
        return Config.HEALTH_BAR_BOUND_COLOR_ARGB.get();
    }

    @Override
    public String healthBarEmptyColorARGB() {
        return Config.HEALTH_BAR_EMPTY_COLOR_ARGB.get();
    }

    @Override
    public boolean healthBarHealthColorDynamic() {
        return Config.HEALTH_BAR_HEALTH_COLOR_DYNAMIC.get();
    }

    @Override
    public String healthBarHealthColorFullARGB() {
        return Config.HEALTH_BAR_HEALTH_COLOR_FULL_ARGB.get();
    }

    @Override
    public String healthBarHealthColorEmptyARGB() {
        return Config.HEALTH_BAR_HEALTH_COLOR_EMPTY_ARGB.get();
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

    @Override
    public boolean hookBotania() {
        return Config.HOOK_BOTANIA.get();
    }

    @Override
    public boolean hookOrigins() {
        return Config.HOOK_ORIGINS.get();
    }

    @Override
    public boolean hookTFC() {
        return Config.HOOK_TFC.get();
    }

    @Override
    public boolean hookArsNouveau() {
        return Config.HOOK_ARS_NOUVEAU.get();
    }

    @Override
    public boolean hookApoli() {
        return Config.HOOK_APOLI.get();
    }

    @Override
    public boolean hookThermoo() {
        return Config.HOOK_THERMOO.get();
    }

    @Override
    public boolean hookMealApi() {
        return Config.HOOK_MEAL_API.get();
    }

    @Override
    public boolean hookLegendarySurvivalOverhaul() {
        return Config.HOOK_LEGENDARY_SURVIVAL_OVERHAUL.get();
    }

}
