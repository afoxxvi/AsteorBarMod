package com.afoxxvi.asteorbar.overlay;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.parts.*;
import com.afoxxvi.asteorbar.utils.GuiHelper;
import com.afoxxvi.asteorbar.utils.Pair;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
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
    public static final MainOverlay MAIN = new MainOverlay();
    public static final PlayerHealthOverlay PLAYER_HEALTH = new PlayerHealthOverlay();
    public static final FoodLevelOverlay FOOD_LEVEL = new FoodLevelOverlay();
    public static final AirLevelOverlay AIR_LEVEL = new AirLevelOverlay();
    public static final ExperienceBarOverlay EXPERIENCE_BAR = new ExperienceBarOverlay();
    public static final MountHealthOverlay MOUNT_HEALTH = new MountHealthOverlay();
    public static final ArmorLevelOverlay ARMOR_LEVEL = new ArmorLevelOverlay();
    public static final StringOverlay STRING = new StringOverlay();
    public static int style = 0;
    public static int verticalLeft = 0;
    public static int verticalRight = 0;
    public static int horizontal = 0;
    public static int length = 10;
    public static int leftHeight = 39;
    public static int rightHeight = 39;
    public static final int ALIGN_LEFT = 0;
    public static final int ALIGN_CENTER = 1;
    public static final int ALIGN_RIGHT = 2;
    private static List<Render> stringRenders = new ArrayList<>();
    private static boolean initialized = false;
    private static final List<Pair<BaseOverlay, Position>> NONE = List.of();
    private static final List<Pair<BaseOverlay, Position>> ORDER_ABOVE_HOT_BAR_LONG = Arrays.asList(
            new Pair<>(EXPERIENCE_BAR, Position.FULL_BOTTOM),
            new Pair<>(FOOD_LEVEL, Position.FULL_BOTTOM),
            new Pair<>(PLAYER_HEALTH, Position.FULL_BOTTOM),
            new Pair<>(MOUNT_HEALTH, Position.HALF_BOTTOM_RIGHT),
            new Pair<>(ARMOR_LEVEL, Position.HALF_BOTTOM_LEFT),
            new Pair<>(AIR_LEVEL, Position.HALF_BOTTOM_RIGHT)
    );

    private static final List<Pair<BaseOverlay, Position>> ORDER_ABOVE_HOT_BAR_SHORT = Arrays.asList(
            new Pair<>(EXPERIENCE_BAR, Position.FULL_BOTTOM),
            new Pair<>(PLAYER_HEALTH, Position.HALF_BOTTOM_LEFT),
            new Pair<>(FOOD_LEVEL, Position.HALF_BOTTOM_RIGHT),
            new Pair<>(MOUNT_HEALTH, Position.HALF_BOTTOM_RIGHT),
            new Pair<>(ARMOR_LEVEL, Position.HALF_BOTTOM_LEFT),
            new Pair<>(AIR_LEVEL, Position.HALF_BOTTOM_RIGHT)
    );

    private static final List<Pair<BaseOverlay, Position>> ORDER_TOP_LEFT = Arrays.asList(
            new Pair<>(PLAYER_HEALTH, Position.TOP_LEFT),
            new Pair<>(MOUNT_HEALTH, Position.TOP_LEFT),
            new Pair<>(FOOD_LEVEL, Position.TOP_LEFT),
            new Pair<>(EXPERIENCE_BAR, Position.TOP_LEFT),
            new Pair<>(ARMOR_LEVEL, Position.TOP_LEFT),
            new Pair<>(AIR_LEVEL, Position.TOP_LEFT)
    );

    private static final List<Pair<BaseOverlay, Position>> ORDER_TOP_RIGHT = Arrays.asList(
            new Pair<>(PLAYER_HEALTH, Position.TOP_RIGHT),
            new Pair<>(MOUNT_HEALTH, Position.TOP_RIGHT),
            new Pair<>(FOOD_LEVEL, Position.TOP_RIGHT),
            new Pair<>(EXPERIENCE_BAR, Position.TOP_RIGHT),
            new Pair<>(ARMOR_LEVEL, Position.TOP_RIGHT),
            new Pair<>(AIR_LEVEL, Position.TOP_RIGHT)
    );

    private static final List<Pair<BaseOverlay, Position>> ORDER_BOTTOM_LEFT = Arrays.asList(
            new Pair<>(PLAYER_HEALTH, Position.BOTTOM_LEFT),
            new Pair<>(MOUNT_HEALTH, Position.BOTTOM_LEFT),
            new Pair<>(FOOD_LEVEL, Position.BOTTOM_LEFT),
            new Pair<>(EXPERIENCE_BAR, Position.BOTTOM_LEFT),
            new Pair<>(ARMOR_LEVEL, Position.BOTTOM_LEFT),
            new Pair<>(AIR_LEVEL, Position.BOTTOM_LEFT)
    );

    private static final List<Pair<BaseOverlay, Position>> ORDER_BOTTOM_RIGHT = Arrays.asList(
            new Pair<>(PLAYER_HEALTH, Position.BOTTOM_RIGHT),
            new Pair<>(MOUNT_HEALTH, Position.BOTTOM_RIGHT),
            new Pair<>(FOOD_LEVEL, Position.BOTTOM_RIGHT),
            new Pair<>(EXPERIENCE_BAR, Position.BOTTOM_RIGHT),
            new Pair<>(ARMOR_LEVEL, Position.BOTTOM_RIGHT),
            new Pair<>(AIR_LEVEL, Position.BOTTOM_RIGHT)
    );

    private static final List<List<Pair<BaseOverlay, Position>>> ORDER = Arrays.asList(
            NONE,
            ORDER_ABOVE_HOT_BAR_LONG,
            ORDER_ABOVE_HOT_BAR_SHORT,
            ORDER_TOP_LEFT,
            ORDER_TOP_RIGHT,
            ORDER_BOTTOM_LEFT,
            ORDER_BOTTOM_RIGHT
    );

    public enum Position {
        TOP_LEFT(false),
        TOP_RIGHT(true),
        BOTTOM_LEFT(false),
        BOTTOM_RIGHT(true),
        FULL_BOTTOM(false),
        HALF_BOTTOM_LEFT(false),
        HALF_BOTTOM_RIGHT(true),
        /**
         * Will be dynamically adjusted according to the style.
         * {@link SimpleBarOverlay#isLeftSide}
         */
        UNSPECIFIED(false),
        ;

        public final boolean flip;

        Position(boolean flip) {
            this.flip = flip;
        }
    }

    public static void init() {
        initialized = true;
        AsteorBar.compatibility.init();
    }

    public static List<Pair<BaseOverlay, Position>> getCurrentOrder() {
        return ORDER.get(style);
    }

    public static void registerOverlayAtFirst(@NotNull BaseOverlay baseOverlay, @Nullable Position position) {
        registerOverlay(baseOverlay, null, position, 0);
    }

    public static void registerOverlayAtLast(@NotNull BaseOverlay baseOverlay, @Nullable Position position) {
        registerOverlay(baseOverlay, null, position, 1);
    }

    public static void registerOverlayAtRecommended(@NotNull BaseOverlay baseOverlay, @Nullable Position position) {
        registerOverlay(baseOverlay, ARMOR_LEVEL, position, 0);
    }

    public static void registerOverlayBefore(@NotNull BaseOverlay baseOverlay, @NotNull BaseOverlay target, @Nullable Position position) {
        registerOverlay(baseOverlay, target, position, 0);
    }

    public static void registerOverlayAfter(@NotNull BaseOverlay baseOverlay, @NotNull BaseOverlay target, @Nullable Position position) {
        registerOverlay(baseOverlay, target, position, 1);
    }

    private static void registerOverlay(@NotNull BaseOverlay baseOverlay, @Nullable BaseOverlay target, @Nullable Position position, int shift) {
        if (position == null) {
            position = Position.UNSPECIFIED;
        }
        for (int i = 1; i < ORDER.size(); i++) {
            final var list = ORDER.get(i);
            list.removeIf(pair -> pair.getA().getClass().equals(baseOverlay.getClass()));
            if (target == null) {
                list.add(shift * list.size(), new Pair<>(baseOverlay, position));
                continue;
            }
            for (int j = 0; j < ORDER.size(); j++) {
                if (list.get(j).getA().getClass().equals(target.getClass())) {
                    list.add(j + shift, new Pair<>(baseOverlay, position));
                    break;
                }
            }
        }
    }

    public static void reset() {
        if (!initialized) {
            init();
        }
        verticalLeft = AsteorBar.config.cornerVerticalPadding();
        verticalRight = AsteorBar.config.cornerVerticalPadding();
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
