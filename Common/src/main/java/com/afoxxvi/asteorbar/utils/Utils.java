package com.afoxxvi.asteorbar.utils;

public class Utils {
    public static int getTotalExperience(int level) {
        if (level < 0) {
            return 0;
        } else if (level < 17) {
            return level * level + 6 * level;
        } else {
            return level < 32 ? (int) (2.5D * (double) level * (double) level - 40.5D * (double) level + 360.0D + 0.5D) : (int) (4.5D * (double) level * (double) level - 162.5D * (double) level + 2220.0D + 0.5D);
        }
    }

    public static String formatNumber(double val) {
        String str = String.format("%.1f", val);
        if (str.endsWith(".0")) {
            str = str.substring(0, str.length() - 2);
        }
        return str;
    }

    public static int mixColor(int color1, int color2, double ratio) {
        short r = (short) ((color1 >> 16 & 0xFF) * ratio + (color2 >> 16 & 0xFF) * (1 - ratio));
        short g = (short) ((color1 >> 8 & 0xFF) * ratio + (color2 >> 8 & 0xFF) * (1 - ratio));
        short b = (short) ((color1 & 0xFF) * ratio + (color2 & 0xFF) * (1 - ratio));
        short a = (short) ((color1 >> 24 & 0xFF) * ratio + (color2 >> 24 & 0xFF) * (1 - ratio));
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    public static int modifyColor(int color, int multi) {
        short r = (short) ((color >> 16 & 0xFF) * multi / 255);
        short g = (short) ((color >> 8 & 0xFF) * multi / 255);
        short b = (short) ((color & 0xFF) * multi / 255);
        short a = (short) ((color >> 24 & 0xFF));
        return (a << 24) | (r << 16) | (g << 8) | b;
    }
}
