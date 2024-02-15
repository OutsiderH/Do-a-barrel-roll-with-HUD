package com.github.outsiderh.doabarrelrollwithhud.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.github.outsiderh.doabarrelrollwithhud.DoABarrelRollWithHud;
import com.github.outsiderh.doabarrelrollwithhud.renderer.Renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
    @Shadow
    @Final
    public MinecraftClient client;
    @Inject(
        method = "render",
        at = @At("TAIL"))
	public void afterRender(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        if (!client.player.isFallFlying()) {
            return;
        }
        DoABarrelRollWithHud.fc.eval(client.player);
        for (final Renderer item : DoABarrelRollWithHud.renderers) {
            item.render(client, matrices);
        }
	}
}
