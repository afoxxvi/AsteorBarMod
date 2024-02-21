package com.afoxxvi.asteorbar.mixin.third;

import com.afoxxvi.asteorbar.AsteorBar;
import com.afoxxvi.asteorbar.overlay.Overlays;
import net.dehydration.thirst.ThirstHudRender;
import net.dehydration.thirst.ThirstManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ThirstHudRender.class, remap = false)
public abstract class DehydrationMixin {
    @Redirect(at = @At(value = "INVOKE", target = "Lnet/dehydration/thirst/ThirstManager;hasThirst()Z"), method = "renderThirstHud")
    private static boolean hasThirst(ThirstManager thirstManager) {
        if (Overlays.style == Overlays.STYLE_NONE || !AsteorBar.config.hookDehydration()) {
            return thirstManager.hasThirst();
        }
        return false;
    }
}
