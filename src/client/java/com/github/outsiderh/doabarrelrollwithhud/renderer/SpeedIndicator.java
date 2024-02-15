package com.github.outsiderh.doabarrelrollwithhud.renderer;

import com.github.outsiderh.doabarrelrollwithhud.DoABarrelRollWithHud;
import com.github.outsiderh.doabarrelrollwithhud.utils.Vector2Int;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class SpeedIndicator extends Renderer {
    @Override
    public void render(MinecraftClient client, MatrixStack mat) {
        Vector2Int airSpeedPos = new Vector2Int(hudBegin.x, (hudBegin.y + hudEnd.y) / 2);
        drawTextWithFixedBox(client.textRenderer, mat, String.format("%.1f", DoABarrelRollWithHud.fc.airSpeedInUnit()), color, airSpeedPos, TextAlign.Right, "xxx.x");
        drawVerticalLine(mat, hudBegin.x, hudBegin.y, hudEnd.y, color);
    }
}
