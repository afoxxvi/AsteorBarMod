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
            @Comment("Whether to enable the overlay. If disabled, all other overlay options will be ignored.")
            public boolean enableOverlay = DefaultConfigAdapter.I.enableOverlay();
            @Comment("The layout style of the overlay. 0: none, 1: above hot bar long, 2: above hot bar short, 3: top left, 4: top right, 5: bottom left, 6: bottom right")
            public int overlayLayoutStyle = DefaultConfigAdapter.I.overlayLayoutStyle();
            @Comment("The text scale of the overlay")
            public double overlayTextScale = DefaultConfigAdapter.I.overlayTextScale();
            @Comment("The color of the health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int healthColorNormal = DefaultConfigAdapter.I.healthColorNormal();
            @Comment("The color of the poison health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int healthColorPoison = DefaultConfigAdapter.I.healthColorPoison();
            @Comment("The color of the wither health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int healthColorWither = DefaultConfigAdapter.I.healthColorWither();
            @Comment("The color of the frozen health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int healthColorFrozen = DefaultConfigAdapter.I.healthColorFrozen();
            @Comment("The color of the health bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int healthBoundColor = DefaultConfigAdapter.I.healthBoundColor();
            @Comment("The color of the health bar bound when blinking. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int healthBoundColorBlink = DefaultConfigAdapter.I.healthBoundColorBlink();
            @Comment("The color of the low health bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int healthBoundColorLow = DefaultConfigAdapter.I.healthBoundColor();
            @Comment("The color of the empty part of the health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int healthEmptyColor = DefaultConfigAdapter.I.healthEmptyColor();
            @Comment("The color of the absorption bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int absorptionColor = DefaultConfigAdapter.I.absorptionColor();
            @Comment("The color of the absorption bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int absorptionBoundColor = DefaultConfigAdapter.I.absorptionBoundColor();
            @Comment("The color of the normal food level bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int foodColorNormal = DefaultConfigAdapter.I.foodColorNormal();
            @Comment("The color of the hunger food level bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int foodColorHunger = DefaultConfigAdapter.I.foodColorHunger();
            @Comment("The color of the food level bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int foodBoundColor = DefaultConfigAdapter.I.foodBoundColor();
            @Comment("The color of the food level bar bound when blinking. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int foodBoundColorBlink = DefaultConfigAdapter.I.foodBoundColorBlink();
            @Comment("The color of the empty part of the food level bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int foodEmptyColor = DefaultConfigAdapter.I.foodEmptyColor();
            @Comment("The color of the saturation bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int saturationColor = DefaultConfigAdapter.I.saturationColor();
            @Comment("The color of the experience bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int experienceColor = DefaultConfigAdapter.I.experienceColor();
            @Comment("The color of the experience bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int experienceBoundColor = DefaultConfigAdapter.I.experienceBoundColor();
            @Comment("The color of the empty part of the experience bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int experienceEmptyColor = DefaultConfigAdapter.I.experienceEmptyColor();
            @Comment("The color of the air bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int airColor = DefaultConfigAdapter.I.airColor();
            @Comment("The color of the air bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int airBoundColor = DefaultConfigAdapter.I.airBoundColor();
            @Comment("The color of the mount health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int mountHealthColor = DefaultConfigAdapter.I.mountHealthColor();
            @Comment("The color of the second mount health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int mountHealthColor2 = DefaultConfigAdapter.I.mountHealthColor2();
            @Comment("The color of the mount health bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int mountHealthBoundColor = DefaultConfigAdapter.I.mountHealthBoundColor();
            @Comment("The color of the second mount health bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int mountHealthBoundColor2 = DefaultConfigAdapter.I.mountHealthBoundColor2();
            @Comment("The color of the empty part of the mount health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int mountHealthEmptyColor = DefaultConfigAdapter.I.mountHealthEmptyColor();
            @Comment("The color of the armor bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int armorColor = DefaultConfigAdapter.I.armorColor();
            @Comment("The color of the armor bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int armorBoundColor = DefaultConfigAdapter.I.armorBoundColor();
            @Comment("The color of the empty part of the armor bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int armorEmptyColor = DefaultConfigAdapter.I.armorEmptyColor();
            @Comment("The color of the armor toughness bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int armorToughnessColor = DefaultConfigAdapter.I.armorToughnessColor();
            @Comment("Whether to enable health bar blink. This feature is designed to simulate the vanilla health icon blink.")
            public boolean enableHealthBlink = DefaultConfigAdapter.I.enableHealthBlink();
            @Comment("The health bar will start to flash when health rate is lower than this value. From 0.0-1.0. 0.0 means never flash.")
            public double lowHealthRate = DefaultConfigAdapter.I.lowHealthRate();
            @Comment("Whether to overwrite vanilla armor bar. If you don't like the mod's armor bar, you can disable this option.")
            public boolean overwriteVanillaArmorBar = DefaultConfigAdapter.I.overwriteVanillaArmorBar();
            @Comment("Whether to overwrite vanilla experience bar. If you don't like the mod's experience bar, you can disable this option, progress label won't be affected.")
            public boolean overwriteVanillaExperienceBar = DefaultConfigAdapter.I.overwriteVanillaExperienceBar();
            @Comment("Whether to display experience progress on the side of the experience bar.")
            public boolean displayExperienceProgress = DefaultConfigAdapter.I.displayExperienceProgress();
            @Comment("Whether to display experience level on the experience bar.")
            public boolean displayExperienceLevel = DefaultConfigAdapter.I.displayExperienceLevel();
            @Comment("Whether to display health text.")
            public boolean displayHealthText = DefaultConfigAdapter.I.displayHealthText();
            @Comment("0: Absorption will be displayed together with health bar. "
                    + "1: Absorption will be displayed half transparently on the health bar. "
                    + "2: Absorption will be displayed as bounds. "
                    + "Note: Since the absorption value can be higher than the max health, an extra number will be displayed to indicate value of absorption/max health, you can turn it off by editing 'displayAbsorptionDivMaxHealth'.")
            public int displayAbsorptionMethod = DefaultConfigAdapter.I.displayAbsorptionMethod();
            @Comment("Whether to display the value of (absorption / max health). To avoid ambiguity, turn it to true if you hide the health text and don't display absorption bar together with health bar, or you may not be able to get correct absorption value.")
            public boolean displayAbsorptionDivMaxHealth = DefaultConfigAdapter.I.displayAbsorptionDivMaxHealth();
            @Comment("0: Absorption text will be displayed together with health text. for example: 15(+10)/20. "
                    + "1: Absorption text will be displayed separately. for example: 10 15/20. "
                    + "Note: if 'displayHealthText' is false, absorption text will be disabled.")
            public int displayAbsorptionTextMethod = DefaultConfigAdapter.I.displayAbsorptionTextMethod();
            @Comment("Whether to enable food level bar blink. This feature is designed to simulate the vanilla food icon shake.")
            public boolean enableFoodBlink = DefaultConfigAdapter.I.enableFoodBlink();
            @Comment("Whether to display saturation bar.")
            public boolean displaySaturation = DefaultConfigAdapter.I.displaySaturation();
            @Comment("Whether to display exhaustion bar.")
            public boolean displayExhaustion = DefaultConfigAdapter.I.displayExhaustion();
            @Comment("Whether to display armor toughness bar.")
            public boolean displayArmorToughness = DefaultConfigAdapter.I.displayArmorToughness();
            @Comment("The length of the bars if using corner layout. Affected bars: health, food, experience.")
            public int cornerBarLength = DefaultConfigAdapter.I.cornerBarLength();
            @Comment("The horizontal padding of the bars if using corner layout.")
            public int cornerHorizontalPadding = DefaultConfigAdapter.I.cornerHorizontalPadding();
            @Comment("The vertical padding of the bars if using corner layout.")
            public int cornerVerticalPadding = DefaultConfigAdapter.I.cornerVerticalPadding();
        }
        //mob config
        static class EntityConfig {
            @Comment("Whether to enable health bar for entity. If disabled, all other health bar options will be ignored.")
            public boolean enableHealthBar = DefaultConfigAdapter.I.enableHealthBar();
            @Comment("The maximum distance to display mob health bar.")
            public double maxDistance = DefaultConfigAdapter.I.maxDistance();
            @Comment("Whether to display health bar on players.")
            public boolean showOnPlayers = DefaultConfigAdapter.I.showOnPlayers();
            @Comment("Whether to display health bar on bosses.")
            public boolean showOnBosses = DefaultConfigAdapter.I.showOnBosses();
            @Comment("Whether to display health bar on mobs with full health if the mob's absorption value is 0.")
            public boolean showOnFullHealthWithoutAbsorption = DefaultConfigAdapter.I.showOnFullHealthWithoutAbsorption();
            @Comment("Whether to display health bar on mobs with full health if the mob's absorption value is not 0.")
            public boolean showOnFullHealthWithAbsorption = DefaultConfigAdapter.I.showOnFullHealthWithAbsorption();
            @Comment("The half width of the health bar.")
            public int healthBarHalfWidth = DefaultConfigAdapter.I.healthBarHalfWidth();
            @Comment("The half height of the health bar.")
            public int healthBarHalfHeight = DefaultConfigAdapter.I.healthBarHalfHeight();
            @Comment("The offset of the health bar on the Y axis.")
            public double healthBarOffsetY = DefaultConfigAdapter.I.healthBarOffsetY();
            @Comment("The scale of the health bar.")
            public double healthBarScale = DefaultConfigAdapter.I.healthBarScale();
            @Comment("The scale of the health bar text.")
            public double healthBarTextScale = DefaultConfigAdapter.I.healthBarTextScale();
            @Comment("The offset of the health bar text on the Y axis.")
            public double healthBarTextOffsetY = DefaultConfigAdapter.I.healthBarTextOffsetY();
            @Comment("The width of the health bar bound. 0 to 10. Hint: This value is a little hard to adjust. If you want to make the bounds looks thinner, " +
                    "you can increase the health bar width&height and decrease the health bar scale. You may also need to change the text scale and offset. " +
                    "This can be complicated, I highly recommend you to use some in-game config mod like 'configured'.")
            public int healthBarBoundWidth = DefaultConfigAdapter.I.healthBarBoundWidth();
            @Comment("Whether to render the vertex of the health bar bound.")
            public boolean healthBarBoundVertex = DefaultConfigAdapter.I.healthBarBoundVertex();
            @Comment("The color of the health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int healthBarHealthColor = DefaultConfigAdapter.I.healthBarHealthColor();
            @Comment("The color of the absorption bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int healthBarAbsorptionColor = DefaultConfigAdapter.I.healthBarAbsorptionColor();
            @Comment("The color of the health bar bound. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int healthBarBoundColor = DefaultConfigAdapter.I.healthBarBoundColor();
            @Comment("The color of the empty part of the health bar. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int healthBarEmptyColor = DefaultConfigAdapter.I.healthBarEmptyColor();
            @Comment("Whether to use dynamic color for health bar. The color will be picked between healthBarHealthColorFull and healthBarHealthColorEmpty " +
                    "based on the health rate. If disabled, the health bar will always be healthBarHealthColor")
            public boolean healthBarHealthColorDynamic = DefaultConfigAdapter.I.healthBarHealthColorDynamic();
            @Comment("The color of the health bar when the mob is full health. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int healthBarHealthColorFull = DefaultConfigAdapter.I.healthBarHealthColorFull();
            @Comment("The color of the health bar when the mob is low health. 0x00000000 to 0xFFFFFFFF. ARGB format.")
            public int healthBarHealthColorEmpty = DefaultConfigAdapter.I.healthBarHealthColorEmpty();
        }
        static class HookConfig {
            @Comment("Whether to hook Tough As Nails. If enabled, the mod will display the thirst bar.")
            public boolean hookToughAsNails = DefaultConfigAdapter.I.hookToughAsNails();
            @Comment("Whether to hook Thirst Was Taken. If enabled, the mod will display the thirst bar.")
            public boolean hookThirstWasTaken = DefaultConfigAdapter.I.hookThirstWasTaken();
            @Comment("Whether to hook Mekanism. If enabled, the mod will display the energy bar.")
            public boolean hookMekanism = DefaultConfigAdapter.I.hookMekanism();
            @Comment("Whether to hook Dehydration. If enabled, the mod will display the thirst bar.")
            public boolean hookDehydration = DefaultConfigAdapter.I.hookDehydration();
        }
    }
}
