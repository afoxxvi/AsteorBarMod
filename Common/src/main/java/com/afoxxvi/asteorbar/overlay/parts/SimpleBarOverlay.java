package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.afoxxvi.asteorbar.overlay.RenderGui;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

public abstract class SimpleBarOverlay extends BaseOverlay {
    protected long lastChangeMillis = 0;
    private Parameters lastParameters = new Parameters();
    private Overlays.Position definedPosition = Overlays.Position.UNSPECIFIED;
    private final Map<String, BiConsumer<Player, Parameters>> postProcessors = new LinkedHashMap<>();
    private final Map<String, Layer> layers = new LinkedHashMap<>();

    public static class Parameters {
        public int fillColor = 0;
        public int fillColor2 = 0;
        public int secondFillColor = 0;
        public float secondFillAlpha = 1.0F;
        public int boundColor = 0;
        public float boundAlpha = 1.0F;
        public int boundColor2 = 0;
        public int emptyColor = 0;
        public double value = 0;
        public double valueIncrement = 0;
        public double secondValueOffset = 0;
        public double secondValue = 0;
        public double secondValueIncrement = 0;
        public double capacity = 1;
        public int boundFillColor = 0;
        public double boundValue = 0;
        public double boundValueIncrement = 0;
        public double boundCapacity = 1;
        public String centerText = null;
        public String leftText = null;
        public String rightText = null;
        public String leftOuterText = null;
        public String rightOuterText = null;
        public int centerColor = 0;
        public int leftColor = 0;
        public int rightColor = 0;
        public int leftOuterColor = 0;
        public int rightOuterColor = 0;
        public int verticalShift = 0;

        public Parameters() {
        }

        public boolean valueEquals(Parameters other) {
            return value == other.value && capacity == other.capacity && boundValue == other.boundValue && boundCapacity == other.boundCapacity && Objects.equals(centerText, other.centerText) && Objects.equals(leftText, other.leftText) && Objects.equals(rightText, other.rightText);
        }
    }

    public interface Layer {
        void drawLayer(Player player, GuiGraphics guiGraphics, int left, int top, int right, int bottom, Parameters parameters, boolean flip);
    }

    protected void drawDecorations(GuiGraphics guiGraphics, int left, int top, int right, int bottom, Parameters parameters, boolean flip) {
    }

    public void draw(GuiGraphics guiGraphics, int left, int top, int right, int bottom, Parameters parameters, boolean flip) {
        if (parameters == null) return;
        RenderSystem.setShaderTexture(0, LIGHTMAP_TEXTURE);
        guiGraphics.flush();
        top += parameters.verticalShift;
        bottom += parameters.verticalShift;
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, parameters.boundAlpha);
        if (parameters.boundColor2 == 0) {
            drawBound(guiGraphics, left, top, right, bottom, parameters.boundColor);
        } else {
            drawBound(guiGraphics, left, top, right, bottom, parameters.boundColor, parameters.boundColor2);
        }
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        drawEmptyFill(guiGraphics, left + 1, top + 1, right - 1, bottom - 1, parameters.emptyColor);
        final int innerWidth = right - left - 2;
        final int fillWidth = (int) (innerWidth * parameters.value / parameters.capacity);
        final float alpha = (float) Math.cos(tick / 40.0);
        if (parameters.fillColor2 != 0) {
            drawFillFlip(guiGraphics, left + 1, top + 1, right - 1, bottom - 1, fillWidth, parameters.fillColor, parameters.fillColor2, flip);
        } else {
            drawFillFlip(guiGraphics, left + 1, top + 1, right - 1, bottom - 1, fillWidth, parameters.fillColor, flip);
        }
        final int secondFillWidth = (int) (innerWidth * parameters.secondValue / parameters.capacity);
        final int secondFillOffset = (int) (innerWidth * parameters.secondValueOffset);
        if (parameters.secondFillColor != 0) {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, parameters.secondFillAlpha);
            drawFillFlip(guiGraphics, left + 1 + secondFillOffset, top + 1, right - 1, bottom - 1, secondFillWidth, parameters.secondFillColor, flip);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        }
        final int boundFillWidth = (int) ((right - left) * parameters.boundValue / parameters.boundCapacity);
        if (parameters.boundFillColor != 0) {
            drawBoundFlip(guiGraphics, left, top, right, bottom, boundFillWidth, parameters.boundFillColor, flip);
        }
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, alpha);
        if (parameters.valueIncrement > 0) {
            final int incrementWidth = (int) (innerWidth * parameters.valueIncrement);
            drawFillFlipConcat(guiGraphics, left + 1, top + 1, right - 1, bottom - 1, fillWidth, incrementWidth, parameters.fillColor, flip);
        }
        if (parameters.secondValueIncrement > 0) {
            final int incrementWidth = (int) (innerWidth * parameters.secondValueIncrement);
            drawFillFlipConcat(guiGraphics, left + 1 + secondFillOffset, top + 1, right - 1, bottom - 1, secondFillWidth, incrementWidth, parameters.secondFillColor, flip);
        }
        if (parameters.boundValueIncrement > 0) {
            final int incrementWidth = (int) ((right - left) * parameters.boundValueIncrement);
            drawBoundFlipConcat(guiGraphics, left, top, right, bottom, boundFillWidth, incrementWidth, parameters.boundFillColor, flip);
        }
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        if (parameters.centerText != null) {
            Overlays.addStringRender((left + right) / 2, top - 2, parameters.centerColor, parameters.centerText, Overlays.ALIGN_CENTER, true);
        }
        if (parameters.leftText != null) {
            if (flip) {
                Overlays.addStringRender(right - 2, top - 2, parameters.leftColor, parameters.leftText, Overlays.ALIGN_RIGHT, true);
            } else {
                Overlays.addStringRender(left + 2, top - 2, parameters.leftColor, parameters.leftText, Overlays.ALIGN_LEFT, true);
            }
        }
        if (parameters.rightText != null) {
            if (flip) {
                Overlays.addStringRender(left + 2, top - 2, parameters.rightColor, parameters.rightText, Overlays.ALIGN_LEFT, true);
            } else {
                Overlays.addStringRender(right - 2, top - 2, parameters.rightColor, parameters.rightText, Overlays.ALIGN_RIGHT, true);
            }
        }
        if (parameters.leftOuterText != null) {
            if (flip) {
                Overlays.addStringRender(right + 2, top - 2, parameters.leftOuterColor, parameters.leftOuterText, Overlays.ALIGN_LEFT, true);
            } else {
                Overlays.addStringRender(left - 2, top - 2, parameters.leftOuterColor, parameters.leftOuterText, Overlays.ALIGN_RIGHT, true);
            }
        }
        if (parameters.rightOuterText != null) {
            if (flip) {
                Overlays.addStringRender(left - 2, top - 2, parameters.rightOuterColor, parameters.rightOuterText, Overlays.ALIGN_RIGHT, true);
            } else {
                Overlays.addStringRender(right + 2, top - 2, parameters.rightOuterColor, parameters.rightOuterText, Overlays.ALIGN_LEFT, true);
            }
        }
        drawDecorations(guiGraphics, left, top, right, bottom, parameters, flip);
    }

    protected abstract Parameters getParameters(Player player);

    protected abstract boolean shouldRender(Player player);

    public void setDefinedPosition(Overlays.Position position) {
        definedPosition = position;
    }

    public void addParametersProcessor(String key, BiConsumer<Player, Parameters> processor) {
        postProcessors.put(key, processor);
    }

    public void removeParametersProcessor(String key) {
        postProcessors.remove(key);
    }

    public void getAllParametersProcessors(Map<String, BiConsumer<Player, Parameters>> map) {
        map.putAll(postProcessors);
    }

    public void addLayer(String key, Layer layer) {
        layers.put(key, layer);
    }

    public void removeLayer(String key) {
        layers.remove(key);
    }

    public void getAllLayers(Map<String, Layer> map) {
        map.putAll(layers);
    }

    /**
     * Only takes effect when the bar's position is unspecified.
     * {@link Overlays.Position#UNSPECIFIED}
     */
    protected boolean isLeftSide() {
        return false;
    }

    @Deprecated
    protected boolean alwaysLow() {
        return false;
    }

    protected boolean canHide() {
        return true;
    }

    @Override
    public void renderOverlay(RenderGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        var position = definedPosition;
        if (position == null) {
            position = Overlays.Position.UNSPECIFIED;
        }
        renderAtPosition(gui, guiGraphics, partialTick, screenWidth, screenHeight, position);
    }

    public void renderAtPosition(RenderGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight, Overlays.Position position) {
        tick = gui.gui().getGuiTicks();
        for (var overrideOverlay : overrideOverlay) {
            if (overrideOverlay != null && overrideOverlay.shouldOverride()) {
                if (overrideOverlay instanceof SimpleBarOverlay simpleBarOverlay) {
                    simpleBarOverlay.renderAtPosition(gui, guiGraphics, partialTick, screenWidth, screenHeight, position);
                } else {
                    overrideOverlay.render(gui, guiGraphics, partialTick, screenWidth, screenHeight);
                }
                return;
            }
        }
        var player = gui.mc().player;
        if (player == null) return;
        if (!shouldRender(player)) return;
        var parameters = getParameters(player);
        if (parameters == null) return;
        postProcessors.forEach((key, processor) -> processor.accept(player, parameters));
        boolean recoverShaderColor = false;
        if (canHide()) {
            if (!parameters.valueEquals(lastParameters)) {
                lastChangeMillis = System.currentTimeMillis();
            }
            var wait = AsteorBar.config.hideUnchangingBarAfterSeconds() * 1000;
            if (wait > 0) {
                if (System.currentTimeMillis() - lastChangeMillis > wait + 1000) {
                    return;
                } else if (System.currentTimeMillis() - lastChangeMillis > wait) {
                    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F - (System.currentTimeMillis() - lastChangeMillis - wait) / 1000.0F);
                    recoverShaderColor = true;
                }
            }
        }
        int left;
        int top;
        int right;
        if (position == Overlays.Position.UNSPECIFIED) {
            switch (Overlays.style) {
                case Overlays.STYLE_ABOVE_HOT_BAR_LONG, Overlays.STYLE_ABOVE_HOT_BAR_SHORT ->
                        position = isLeftSide() ? Overlays.Position.HALF_BOTTOM_LEFT : Overlays.Position.HALF_BOTTOM_RIGHT;
                case Overlays.STYLE_TOP_BOTH_SIDES -> position = isLeftSide() ? Overlays.Position.TOP_LEFT : Overlays.Position.TOP_RIGHT;
                case Overlays.STYLE_BOTTOM_BOTH_SIDES ->
                        position = isLeftSide() ? Overlays.Position.BOTTOM_LEFT : Overlays.Position.BOTTOM_RIGHT;
                case Overlays.STYLE_TOP_LEFT -> position = Overlays.Position.TOP_LEFT;
                case Overlays.STYLE_TOP_RIGHT -> position = Overlays.Position.TOP_RIGHT;
                case Overlays.STYLE_BOTTOM_LEFT -> position = Overlays.Position.BOTTOM_LEFT;
                case Overlays.STYLE_BOTTOM_RIGHT -> position = Overlays.Position.BOTTOM_RIGHT;
            }
        }
        boolean flip = position.flip;
        switch (position) {
            case FULL_BOTTOM -> {
                left = screenWidth / 2 - 91;
                right = left + BOUND_FULL_WIDTH_LONG;
                int higher = Math.max(gui.leftHeight(), gui.rightHeight());
                top = screenHeight - higher + 4;
                higher += 6;
                gui.leftHeight(higher - gui.leftHeight());
                gui.rightHeight(higher - gui.rightHeight());
            }
            case HALF_BOTTOM_LEFT -> {
                left = screenWidth / 2 - 91;
                right = left + BOUND_FULL_WIDTH_SHORT;
                top = screenHeight - gui.leftHeight() + 4;
                gui.leftHeight(6);
            }
            case HALF_BOTTOM_RIGHT -> {
                left = screenWidth / 2 + 10;
                right = left + BOUND_FULL_WIDTH_SHORT;
                top = screenHeight - gui.rightHeight() + 4;
                gui.rightHeight(6);
            }
            case TOP_LEFT -> {
                top = Overlays.cornerLeftHeight;
                left = Overlays.horizontalOffset;
                right = left + Overlays.length;
                Overlays.cornerLeftHeight += 6;
            }
            case TOP_RIGHT -> {
                top = Overlays.cornerRightHeight;
                left = screenWidth - Overlays.length - Overlays.horizontalOffset;
                right = left + Overlays.length;
                Overlays.cornerRightHeight += 6;
            }
            case BOTTOM_LEFT -> {
                top = screenHeight - Overlays.cornerLeftHeight;
                left = Overlays.horizontalOffset;
                right = left + Overlays.length;
                Overlays.cornerLeftHeight += 6;
            }
            case BOTTOM_RIGHT -> {
                top = screenHeight - Overlays.cornerRightHeight;
                left = screenWidth - Overlays.length - Overlays.horizontalOffset;
                right = left + Overlays.length;
                Overlays.cornerRightHeight += 6;
            }
            default -> {
                return;
            }
        }
        draw(guiGraphics, left, top, right, top + 5, parameters, flip);
        layers.forEach((key, layer) -> layer.drawLayer(player, guiGraphics, left, top, right, top + 5, parameters, flip));
        lastParameters = parameters;
        if (recoverShaderColor) {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}
