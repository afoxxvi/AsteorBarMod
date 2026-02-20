package com.afoxxvi.asteorbar.mixin;

import com.afoxxvi.asteorbar.render.IHealthBarFeature;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(LivingEntityRenderState.class)
public abstract class LivingEntityRenderStateMixin implements IHealthBarFeature {
    @Unique
    private double asteorBar$health = 0.0;
    @Unique
    private double asteorBar$maxHealth = 0.0;
    @Unique
    private double asteorBar$absorptionAmount = 0.0;
    @Unique
    private boolean asteorBar$inInventory = false;

    @Override
    public void asteorBar$setHealth(double health) {
        this.asteorBar$health = health;
    }

    @Override
    public double asteorBar$getHealth() {
        return asteorBar$health;
    }

    @Override
    public void asteorBar$setMaxHealth(double maxHealth) {
        this.asteorBar$maxHealth = maxHealth;
    }

    @Override
    public double asteorBar$getMaxHealth() {
        return asteorBar$maxHealth;
    }

    @Override
    public void asteorBar$setAbsorptionAmount(double absorptionAmount) {
        this.asteorBar$absorptionAmount = absorptionAmount;
    }

    @Override
    public double asteorBar$getAbsorptionAmount() {
        return asteorBar$absorptionAmount;
    }

    @Override
    public void asteorBar$setInInventory(boolean inInventory) {
        this.asteorBar$inInventory = inInventory;
    }

    @Override
    public boolean asteorBar$inInventory() {
        return asteorBar$inInventory;
    }
}
