package com.afoxxvi.asteorbar.mixin;

import com.afoxxvi.asteorbar.network.NetworkHandler;
import com.mojang.authlib.GameProfile;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin extends Player {
    public ServerPlayerMixin(Level level, BlockPos blockPos, float f, GameProfile gameProfile) {
        super(level, blockPos, f, gameProfile);
    }

    @Inject(at = @At(value = "HEAD"), method = "tick")
    void onTick(CallbackInfo ci) {
        ServerPlayer player = (ServerPlayer) (Object) this;
        NetworkHandler.onPlayerTick(player);
    }
}
