package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.parts.*;
import com.afoxxvi.asteorbar.utils.GuiHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;

import java.util.ArrayList;
import java.util.List;

public class Overlays {
    public static final int STYLE_NONE = 0;
    public static final int STYLE_ABOVE_HOT_BAR_LONG = 1;
    public static final int STYLE_ABOVE_HOT_BAR_SHORT = 2;
    public static final int STYLE_TOP_LEFT = 3;
    public static final int STYLE_TOP_RIGHT = 4;
    public static final int STYLE_BOTTOM_LEFT = 5;
    public static final int STYLE_BOTTOM_RIGHT = 6;
    public static final int NUM_STYLES = 7;
    public static final PlayerHealthOverlay PLAYER_HEALTH = new PlayerHealthOverlay();
    public static final FoodLevelOverlay FOOD_LEVEL = new FoodLevelOverlay();
    public static final AirLevelOverlay AIR_LEVEL = new AirLevelOverlay();
    public static final ExperienceBarOverlay EXPERIENCE_BAR = new ExperienceBarOverlay();
    public static final MountHealthOverlay MOUNT_HEALTH = new MountHealthOverlay();
    public static final ArmorLevelOverlay ARMOR_LEVEL = new ArmorLevelOverlay();
    public static final StringOverlay STRING = new StringOverlay();
    public static int style = 0;
    public static int vertical = 0;
    public static int horizontal = 0;
    public static int length = 10;
    public static int leftHeight = 39;
    public static int rightHeight = 39;
    public static final int ALIGN_LEFT = 0;
    public static final int ALIGN_CENTER = 1;
    public static final int ALIGN_RIGHT = 2;
    private static List<Render> stringRenders = new ArrayList<>();
    private static boolean initialized = false;
    public static boolean toughAsNails = false;

    public static void init() {
        initialized = true;
        toughAsNails = AsteorBar.platformAdapter.isModLoaded("toughasnails");
    }

    public static void reset() {
        if (!initialized) {
            init();
        }
        vertical = AsteorBar.config.cornerVerticalPadding();
        horizontal = AsteorBar.config.cornerHorizontalPadding();
        length = AsteorBar.config.cornerBarLength();
        style = AsteorBar.config.overlayLayoutStyle();
        stringRenders.clear();
        leftHeight = 39;
        rightHeight = 39;
    }

    public static void renderString(GuiGraphics guiGraphics) {
        if (stringRenders == null) return;
        guiGraphics.pose().pushPose();
        float scale = (float) AsteorBar.config.overlayTextScale();
        guiGraphics.pose().scale(scale, scale, 1);
        var font = Minecraft.getInstance().font;
        for (var render : stringRenders) {
            var width = font.width(render.text);
            var x = render.x / scale + width / 2f * (1 / scale - 1);
            var y = render.y / scale + font.lineHeight / 2f * (1 / scale - 1);
            if (render.bound) {
                GuiHelper.drawString(guiGraphics, render.text, (int) x + 1, (int) y, render.boundColor, render.shadow);
                GuiHelper.drawString(guiGraphics, render.text, (int) x - 1, (int) y, render.boundColor, render.shadow);
                GuiHelper.drawString(guiGraphics, render.text, (int) x, (int) y + 1, render.boundColor, render.shadow);
                GuiHelper.drawString(guiGraphics, render.text, (int) x, (int) y - 1, render.boundColor, render.shadow);
            }
            GuiHelper.drawString(guiGraphics, render.text, (int) x, (int) y, render.color, render.shadow);
        }
        guiGraphics.pose().popPose();
        stringRenders.clear();
    }

    public static void addStringRender(int x, int y, int color, String text, int align, boolean shadow) {
        addStringRender(x, y, color, text, align, shadow, false, 0);
    }

    public static void addStringRender(int x, int y, int color, String text, int align, boolean shadow, boolean bound, int boundColor) {
        if (stringRenders == null) {
            stringRenders = new ArrayList<>();
        }
        var render = new Render();
        render.x = x;
        render.y = y;
        render.color = color;
        render.text = text;
        render.align = align;
        render.shadow = shadow;
        switch (render.align) {
            case ALIGN_CENTER -> render.x -= Minecraft.getInstance().font.width(text) / 2;
            case ALIGN_RIGHT -> render.x -= Minecraft.getInstance().font.width(text);
        }
        render.bound = bound;
        render.boundColor = boundColor;
        stringRenders.add(render);
    }

    private static class Render {
        int x;
        int y;
        int color;
        String text;
        int align;
        boolean shadow;
        boolean bound;
        int boundColor;
    }
}
