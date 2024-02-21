package com.afoxxvi.asteorbar.mixin.third;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import com.bawnorton.mixinsquared.api.MixinCanceller;

import java.util.List;

public abstract class DehydrationMixin implements MixinCanceller {
    @Override
    public boolean shouldCancel(List<String> targetClassNames, String mixinClassName) {
        if (Overlays.style != Overlays.STYLE_NONE && AsteorBar.config.hookDehydration()) {
            return mixinClassName.equals("net.dehydration.mixin.client.InGameHudMixin");
        }
        return false;
    }
}
