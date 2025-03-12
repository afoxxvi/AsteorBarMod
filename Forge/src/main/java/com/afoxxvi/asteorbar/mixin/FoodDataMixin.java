package com.afoxxvi.asteorbar.mixin;

import net.minecraft.world.food.FoodData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = FoodData.class, remap = false)
public interface FoodDataMixin {
    @Accessor("exhaustionLevel")
    float getExhaustionLevel();

    @Accessor("exhaustionLevel")
    void setExhaustionLevel(float exhaustionLevel);
}
