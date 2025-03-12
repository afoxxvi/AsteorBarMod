package com.afoxxvi.asteorbar.overlay.parts;

import com.afoxxvi.asteorbar.AsteorBar;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;

public class ThermooOverlays {
    public static class Independent extends SimpleBarOverlay {
        @Override
        protected Parameters getParameters(Player player) {
            var parameters = new Parameters();
            var value = player.thermoo$getTemperatureScale();
            if (value > 0) {
                parameters.value = value;
                parameters.capacity = 1.0;
                parameters.fillColor = 0xffdb6511;
                parameters.fillColor2 = 0xfff4de81;
                parameters.boundColor = 0xffb94d00;
            } else if (value < 0) {
                parameters.value = -value;
                parameters.capacity = 1.0;
                parameters.fillColor = 0xff4cbad8;
                parameters.fillColor2 = 0xff80e5ef;
                parameters.boundColor = 0xff073f5c;
            } else {
                return null;
            }
            return parameters;
        }

        @Override
        protected boolean shouldRender(Player player) {
            return AsteorBar.compatibility.thermoo && AsteorBar.config.hookThermoo();
        }

        @Override
        protected boolean isLeftSide() {
            return true;
        }
    }

    public static class Bound implements SimpleBarOverlay.Layer {
        private final SimpleBound simpleBound = new SimpleBound();

        @Override
        public void drawLayer(Player player, GuiGraphics guiGraphics, int left, int top, int right, int bottom, SimpleBarOverlay.Parameters parameters, boolean flip) {
            var parameters2 = simpleBound.getParameters(player);
            simpleBound.draw(guiGraphics, left, top, right, bottom, parameters2, flip);
        }
    }

    public static class SimpleBound extends SimpleBarOverlay {
        @Override
        protected Parameters getParameters(Player player) {
            var parameters = new Parameters();
            var value = player.thermoo$getTemperatureScale();
            if (value > 0) {
                parameters.boundValue = value;
                parameters.boundCapacity = 1.0;
                parameters.boundFillColor = 0xffdb6511;
                parameters.boundColor2 = 0xffb94d00;
                parameters.boundColor = 0xffd28108;
            } else if (value < 0) {
                parameters.boundValue = -value;
                parameters.boundCapacity = 1.0;
                parameters.boundFillColor = 0xff4cbad8;
                parameters.boundColor2 = 0xff073f5c;
                parameters.boundColor = 0xff045c89;
            } else {
                return null;
            }
            return parameters;
        }

        @Override
        protected boolean shouldRender(Player player) {
            return AsteorBar.compatibility.thermoo && AsteorBar.config.hookThermoo();
        }
    }
}
