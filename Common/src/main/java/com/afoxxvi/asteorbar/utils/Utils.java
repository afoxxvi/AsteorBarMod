package com.afoxxvi.asteorbar.utils;

import com.afoxxvi.asteorbar.AsteorBar;

public class Utils {
    public static String formatNumber(double val) {
        if (val >= AsteorBar.config.hideDecimalWhenEqualOrMoreThan()) {
            return String.valueOf((int) val);
        }
        String str = String.format("%.1f", val);
        if (str.endsWith(".0")) {
            str = str.substring(0, str.length() - 2);
        }
        return str;
    }

    public static int parseHexColor(String color) {
        int value = 0;
        for (int i = 0; i < color.length(); i++) {
            if (i == 0 && color.charAt(i) == '#') continue;
            value <<= 4;
            char c = color.charAt(i);
            if (c >= '0' && c <= '9') {
                value += c - '0';
            } else if (c >= 'A' && c <= 'F') {
                value += c - 'A' + 10;
            } else if (c >= 'a' && c <= 'f') {
                value += c - 'a' + 10;
            }
        }
        return value;
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

    /**
     * Parse color from string.
     * Decimal format: "16711680"
     * Hex format: "#FF0000" or "0xFF0000"
     */
    public static int parseColor(String color) {
        try {
            if (color.startsWith("#") || color.startsWith("0x") || color.startsWith("0X")) {
                return parseHexColor(color);
            } else {
                return Integer.parseInt(color);
            }
        } catch (NumberFormatException e) {
            return 0xFFFFFFFF;
        }
    }

    public static int modifyAlpha(int color, float alpha) {
        if (alpha == 0) return color;
        int alphaInt = (int) (alpha * 255);
        return (color & 0x00ffffff) | (alphaInt << 24);
    }

    public static int getWhiteAlpha(float alpha) {
        int alphaInt = (int) (alpha * 255);
        return (alphaInt << 24) | 0x00ffffff;
    }
}
