package com.github.outsiderh.doabarrelrollwithhud.renderer;

import static com.github.outsiderh.doabarrelrollwithhud.DoABarrelRollWithHud.fc;

import com.github.outsiderh.doabarrelrollwithhud.utils.Vector2Int;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class YawIndicator extends Renderer {
    @Override
    public void render(MinecraftClient client, MatrixStack mat) {
        int leftEdge = hudCenter.x - 100;
        int rightEdge = hudCenter.x + 100;
        drawHorizontalLine(mat, leftEdge, rightEdge, hudBegin.y, color);
        drawText(client.textRenderer, mat, String.format("%.0f", fc.yaw), color, new Vector2Int(hudCenter.x, hudBegin.y), TextAlign.Down);
    }
}
