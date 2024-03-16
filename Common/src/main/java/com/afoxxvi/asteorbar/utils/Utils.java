package com.afoxxvi.asteorbar.utils;

public class Utils {
    public static String formatNumber(double val) {
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
}
