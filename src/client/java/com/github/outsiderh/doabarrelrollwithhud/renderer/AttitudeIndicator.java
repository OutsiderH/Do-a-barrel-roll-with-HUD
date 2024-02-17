package com.github.outsiderh.doabarrelrollwithhud.renderer;

import static com.github.outsiderh.doabarrelrollwithhud.DoABarrelRollWithHud.fc;
import com.github.outsiderh.doabarrelrollwithhud.utils.Vector2Int;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class AttitudeIndicator extends Renderer {
    private final int groundColor = 0xFFB87325;
    private final int skyColor = 0xFF47A6CC;
    @Override
    public void render(MinecraftClient client, MatrixStack mat) {
        int halfSize = (hudEnd.x - hudBegin.x) / 4;
        Vector2Int aiBegin = hudCenter.copy().subAndGet(halfSize);
        Vector2Int aiEnd = hudCenter.copy().addAndGet(halfSize);
        int horizonLength = (int)((float)(aiEnd.x - aiBegin.x) * 0.75f);
        float horizonGap = (float)(Math.sqrt((double)(halfSize * halfSize)) / 3f);
        enableScissor(aiBegin.x, aiBegin.y, aiEnd.x, aiEnd.y);
        mat.push();
        rotate(mat, -fc.roll);
        float pitch = -fc.pitch;
        float mod = pitch % 10f;
        for (int n = (int)(pitch - (pitch < 0 ? mod + 10f : mod)), p = hudCenter.y + (int)((pitch < 0 ? 10f + mod : mod) * (horizonGap / 10f)), c = 0; c < 3; n -= 10, p += horizonGap, ++c) {
            int numToShow = Math.abs(n);
            if (numToShow > 90) {
                numToShow = 180 - numToShow;
            }
            int length = horizonLength / (numToShow == 0 ? 2 : 4);
            int posL = hudCenter.x - length;
            int posR = hudCenter.x + length;
            int color = n < 0 ? groundColor : n > 0 ? skyColor : Renderer.color;
            drawHorizontalLine(mat, posL, posR, p, color);
            drawVerticalLine(mat, posL, p, p + 3, color);
            drawVerticalLine(mat, posR, p, p + 3, color);
            drawText(client.textRenderer, mat, String.valueOf(numToShow), color, new Vector2Int(posL, p), TextAlign.Right);
            drawText(client.textRenderer, mat, String.valueOf(numToShow), color, new Vector2Int(posR + 2, p), TextAlign.Left);
        }
        for (int n = (int)(pitch + (pitch < 0 ? -mod : 10f - mod)), p = hudCenter.y - (int)((pitch < 0 ? -mod : 10 - mod) * (horizonGap / 10)), c = 0; c < 3; n += 10, p -= horizonGap, ++c) {
            int numToShow = Math.abs(n);
            if (numToShow > 90) {
                numToShow = 180 - numToShow;
            }
            int length = horizonLength / (numToShow == 0 ? 2 : 4);
            int posL = hudCenter.x - length;
            int posR = hudCenter.x + length;
            int color = n < 0 ? groundColor : n > 0 ? skyColor : Renderer.color;
            drawHorizontalLine(mat, posL, posR, p, color);
            drawVerticalLine(mat, posL, p, p + 3, color);
            drawVerticalLine(mat, posR, p, p + 3, color);
            drawText(client.textRenderer, mat, String.valueOf(numToShow), color, new Vector2Int(posL, p), TextAlign.Right);
            drawText(client.textRenderer, mat, String.valueOf(numToShow), color, new Vector2Int(posR + 2, p), TextAlign.Left);
        }
        mat.pop();
        disableScissor();
        drawDot(mat, color, hudCenter);
        drawHorizontalLine(mat, hudCenter.x - 2, hudCenter.x - 4, hudCenter.y, color);
        drawHorizontalLine(mat, hudCenter.x + 2, hudCenter.x + 4, hudCenter.y, color);
    }
}
