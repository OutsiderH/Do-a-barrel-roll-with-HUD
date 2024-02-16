package com.github.outsiderh.doabarrelrollwithhud.renderer;

import com.github.outsiderh.doabarrelrollwithhud.DoABarrelRollWithHud;
import com.github.outsiderh.doabarrelrollwithhud.utils.Vector2Int;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class AltitudeIndicator extends Renderer {
    @Override
    public void render(MinecraftClient client, MatrixStack mat) {
        Vector2Int altitudePos = new Vector2Int(hudEnd.x, (hudBegin.y + hudEnd.y) / 2);
        drawVerticalLine(mat, hudEnd.x, hudBegin.y, hudEnd.y, color);
        drawTextWithFixedBox(client.textRenderer, mat, String.format("%.1f", DoABarrelRollWithHud.fc.altitudeInUnit()), color, altitudePos, TextAlign.Left, "xxxx.x");
        if (DoABarrelRollWithHud.fc.radarEnable) {
            drawText(client.textRenderer, mat, String.format("%d", DoABarrelRollWithHud.fc.radarAltitude), color, new Vector2Int(hudEnd.x, hudEnd.y + 3), TextAlign.Up);
        }
    }
}
