package com.github.outsiderh.doabarrelrollwithhud.renderer;

import static com.github.outsiderh.doabarrelrollwithhud.DoABarrelRollWithHud.fc;

import com.github.outsiderh.doabarrelrollwithhud.utils.Vector2Int;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class AttitudeIndicator extends Renderer {
    @Override
    public void render(MinecraftClient client, MatrixStack mat) {
        mat.push();
        rotate(mat, -fc.roll);
        float pitch = -fc.pitch;
        float mod = pitch % 10f;
        for (int n = (int)(pitch - (pitch < 0 ? mod + 10f : mod)), p = hudCenter.y + (int)((pitch < 0 ? 10f + mod : mod) * 5), c = 0; c < 3; n -= 10, p += 50, ++c) {
            drawHorizontalLine(mat, hudCenter.x - 75, hudCenter.x + 75, p, color);
            int numToShow = Math.abs(n);
            if (numToShow > 90) {
                numToShow = 180 - numToShow;
            }
            drawText(client.textRenderer, mat, String.valueOf(numToShow), color, new Vector2Int(hudCenter.x - 75, p), TextAlign.Right);
            drawText(client.textRenderer, mat, String.valueOf(numToShow), color, new Vector2Int(hudCenter.x + 75, p), TextAlign.Left);
        }
        for (int n = (int)(pitch + (pitch < 0 ? -mod : 10f - mod)), p = hudCenter.y - (int)((pitch < 0 ? -mod : 10 - mod) * 5), c = 0; c < 3; n += 10, p -= 50, ++c) {
            drawHorizontalLine(mat, hudCenter.x - 75, hudCenter.x + 75, p, color);
            int numToShow = Math.abs(n);
            if (numToShow > 90) {
                numToShow = 180 - numToShow;
            }
            drawText(client.textRenderer, mat, String.valueOf(numToShow), color, new Vector2Int(hudCenter.x - 75, p), TextAlign.Right);
            drawText(client.textRenderer, mat, String.valueOf(numToShow), color, new Vector2Int(hudCenter.x + 75, p), TextAlign.Left);
        }
        mat.pop();
        drawDot(mat, color, hudCenter);
        drawHorizontalLine(mat, hudCenter.x - 1, hudCenter.x - 9, hudCenter.y, color);
        drawHorizontalLine(mat, hudCenter.x + 1, hudCenter.x + 9, hudCenter.y, color);
    }
}
