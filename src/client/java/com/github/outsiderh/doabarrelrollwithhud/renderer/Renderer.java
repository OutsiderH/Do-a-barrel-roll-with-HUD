package com.github.outsiderh.doabarrelrollwithhud.renderer;

import com.github.outsiderh.doabarrelrollwithhud.utils.Vector2Int;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

public abstract class Renderer extends DrawableHelper {
    protected Vector2Int hudStart = new Vector2Int();
    protected Vector2Int hudEnd = new Vector2Int();
    protected void updateSize(MinecraftClient client) {
        Vector2Int windowSize = new Vector2Int(client.getWindow().getWidth(), client.getWindow().getHeight());
        hudStart.x = windowSize.x / 4;
        hudStart.y = windowSize.y / 4;
        hudEnd.x = hudStart.x * 3;
        hudEnd.y = hudStart.y * 3; 
    }
    protected void drawText(TextRenderer tr, MatrixStack mat, String text, int color, Vector2Int pos, TextAlign align) {
        switch (align) {
            case Left:
                break;
            case Middle:
                pos.x -= tr.getWidth(text) / 2;
                break;
            case Right:
                pos.x -= tr.getWidth(text);
                break;
            default:
                break;
        }
        tr.draw(mat, text, pos.x, pos.y, color);
    }
    protected void drawTextCenterY(TextRenderer tr, MatrixStack mat, String text, int color, Vector2Int pos, TextAlign align) {
        pos.y -= tr.fontHeight / 2;
        drawText(tr, mat, text, color, pos, align);
    }
    public abstract void render(MinecraftClient client, MatrixStack mat);
}
