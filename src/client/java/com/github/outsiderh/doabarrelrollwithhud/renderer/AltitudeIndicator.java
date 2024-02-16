package com.github.outsiderh.doabarrelrollwithhud.renderer;

import static com.github.outsiderh.doabarrelrollwithhud.DoABarrelRollWithHud.fc;
import com.github.outsiderh.doabarrelrollwithhud.utils.Vector2Int;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class AltitudeIndicator extends Renderer {
    @Override
    public void render(MinecraftClient client, MatrixStack mat) {
        drawVerticalLine(mat, hudEnd.x, hudBegin.y, hudEnd.y, color);
        drawTextWithFixedBox(client.textRenderer, mat, String.format("%.1f", fc.altitudeInUnit()), color, new Vector2Int(hudEnd.x, hudCenter.y), TextAlign.Left, "xxxx.x");
        if (fc.radarEnable) {
            drawText(client.textRenderer, mat, String.format("%d", fc.radarAltitude), color, new Vector2Int(hudEnd.x, hudEnd.y + 3), TextAlign.Up);
        }
    }
}
