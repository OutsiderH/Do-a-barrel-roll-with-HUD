package com.github.outsiderh.doabarrelrollwithhud.renderer;

import com.github.outsiderh.doabarrelrollwithhud.DoABarrelRollWithHud;
import com.github.outsiderh.doabarrelrollwithhud.utils.Vector2Int;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class SpeedIndicator extends Renderer {
    @Override
    public void render(MinecraftClient client, MatrixStack mat) {
        updateSize(client);
        Vector2Int airSpeedPos = new Vector2Int((hudStart.x + hudEnd.x) / 4, (hudStart.y + hudEnd.y) / 4);
        drawTextCenterY(client.textRenderer, mat, String.format("%.1f", DoABarrelRollWithHud.fc.airSpeed), 0x0000FF00, airSpeedPos, TextAlign.Right);
    }
}
