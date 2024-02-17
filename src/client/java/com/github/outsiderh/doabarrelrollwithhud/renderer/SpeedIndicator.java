package com.github.outsiderh.doabarrelrollwithhud.renderer;

import static com.github.outsiderh.doabarrelrollwithhud.DoABarrelRollWithHud.fc;
import com.github.outsiderh.doabarrelrollwithhud.utils.Vector2Int;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class SpeedIndicator extends Renderer {
    @Override
    public void render(MinecraftClient client, MatrixStack mat) {
        drawVerticalLine(mat, hudBegin.x, hudBegin.y, hudEnd.y, color);
        float airSpeedPercentage = fc.airSpeedPercentage();
        int halfHeight = boxedHeight(client.textRenderer) / 2;
        int posLimitHigh = hudBegin.y + halfHeight;
        int posLimitLow = hudEnd.y - halfHeight;
        drawTextWithFixedBox(
            client.textRenderer,
            mat, String.format("%.1f", fc.airSpeedInUnit()),
            color,
            new Vector2Int(hudBegin.x, fc.airSpeedPercentage() > 1f ? posLimitHigh : posLimitHigh + (int)((posLimitLow - posLimitHigh) * ((1f - airSpeedPercentage) / 1f))),
            TextAlign.Right,
            "xxx.x"
        );
        drawText(client.textRenderer, mat, String.format("%.1f", fc.groundSpeedInUnit()), color, new Vector2Int(hudBegin.x, hudEnd.y + 3), TextAlign.Up);
    }
}
