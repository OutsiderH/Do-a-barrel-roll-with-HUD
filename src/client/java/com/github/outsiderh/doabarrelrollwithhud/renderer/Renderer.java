package com.github.outsiderh.doabarrelrollwithhud.renderer;

import com.github.outsiderh.doabarrelrollwithhud.utils.Vector2Int;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3f;

public abstract class Renderer extends DrawableHelper {
    protected static final int color = 0xFF00FF00;
    protected static final Vector2Int windowSize = new Vector2Int();
    protected static final Vector2Int hudBegin = new Vector2Int();
    protected static final Vector2Int hudCenter = new Vector2Int();
    protected static final Vector2Int hudEnd = new Vector2Int();
    public static void updateSize(MinecraftClient client) {
        windowSize.x = client.getWindow().getScaledWidth();
        windowSize.y = client.getWindow().getScaledHeight();
        hudBegin.x = windowSize.x / 4;
        hudBegin.y = windowSize.y / 4;
        hudCenter.x = hudBegin.x * 2;
        hudCenter.y = hudBegin.y * 2;
        hudEnd.x = hudBegin.x * 3;
        hudEnd.y = hudBegin.y * 3;
    }
    protected int boxedHeight(TextRenderer tr) {
        return tr.fontHeight + 2;
    }
    protected void drawDot(MatrixStack mat, int color, Vector2Int pos) {
        fill(mat, pos.x, pos.y, pos.x + 1, pos.y + 1, color);
    }
    protected void drawText(TextRenderer tr, MatrixStack mat, String text, int color, Vector2Int pos, TextAlign align) {
        switch (align) {
            case UpLeft: {
                break;
            }
            case Up: {
                pos.x -= tr.getWidth(text) / 2;
                break;
            }
            case UpRight: {
                pos.x -= tr.getWidth(text);
                break;
            }
            case Left: {
                pos.y -= tr.fontHeight / 2;
                break;
            }
            case Central: {
                pos.x -= tr.getWidth(text) / 2;
                pos.y -= tr.fontHeight / 2;
                break;
            }
            case Right: {
                pos.x -= tr.getWidth(text);
                pos.y -= tr.fontHeight / 2;
                break;
            }
            case DownLeft: {
                pos.y -= tr.fontHeight;
                break;
            }
            case Down: {
                pos.x -= tr.getWidth(text) / 2;
                pos.y -= tr.fontHeight;
                break;
            }
            case DownRight: {
                pos.x -= tr.getWidth(text);
                pos.y -= tr.fontHeight;
                break;
            }
            default: {
                break;
            }
        }
        tr.draw(mat, text, pos.x, pos.y, color);
    }
    protected void drawTextWithFixedBox(TextRenderer tr, MatrixStack mat, String text, int color, Vector2Int pos, TextAlign align, String size) {
        Vector2Int begin = new Vector2Int();
        Vector2Int end = new Vector2Int();
        switch (align) {
            case UpLeft: {
                begin.x = pos.x;
                begin.y = pos.y;
                end.x = begin.x + tr.getWidth(size);
                end.y = begin.y + tr.fontHeight;
                pos.add(2);
                end.add(2);
                break;
            }
            case Up: {
                int width = tr.getWidth(size);
                begin.x = pos.x - width / 2;
                begin.y = pos.y;
                end.x = begin.x + width;
                end.y = begin.y + tr.fontHeight;
                pos.x += 1;
                pos.y += 2;
                begin.x -= 1;
                end.x += 1;
                end.y += 2;
                break;
            }  
            case UpRight: {
                begin.x = pos.x - tr.getWidth(size);
                begin.y = pos.y;
                end.x = pos.x;
                end.y = begin.y + tr.fontHeight;
                pos.y += 2;
                begin.x -= 2;
                end.y -= 2;
                break;
            }
            case Left: {
                begin.x = pos.x;
                begin.y = pos.y - tr.fontHeight / 2;
                end.x = begin.x + tr.getWidth(size);
                end.y = begin.y + tr.fontHeight;
                pos.x += 2;
                pos.y += 1;
                begin.y -= 1;
                end.x += 2;
                end.y +=1;
                break;
            }
            case Central: {
                int width = tr.getWidth(size);
                begin.x = pos.x - width / 2;
                begin.y = pos.y - tr.fontHeight / 2;
                end.x = begin.x + width;
                end.y = begin.y + tr.fontHeight;
                pos.add(1);
                begin.add(-1);
                end.add(1);
                break;
            }
            case Right: {
                begin.x = pos.x - tr.getWidth(size);
                begin.y = pos.y - tr.fontHeight / 2;
                end.x = pos.x;
                end.y = begin.y + tr.fontHeight;
                pos.y += 1;
                begin.x -= 2;
                begin.y -= 1;
                end.y += 1;
                break;
            }
            case DownLeft: {
                begin.x = pos.x;
                begin.y = pos.y - tr.fontHeight;
                end.x = begin.x + tr.getWidth(size);
                end.y = pos.y;
                pos.x += 2;
                begin.y -= 2;
                end.x += 2;
                break;
            }
            case Down: {
                int width = tr.getWidth(size);
                begin.x = pos.x - width / 2;
                begin.y = pos.y - tr.fontHeight;
                end.x = begin.x + width;
                end.y = pos.y;
                pos.x += 1;
                begin.x -= 1;
                begin.y -= 2;
                end.x += 1;
                break;
            }
            case DownRight: {
                begin.x = pos.x - tr.getWidth(size);
                begin.y = pos.y - tr.fontHeight;
                end.x = pos.x;
                end.y = pos.y;
                begin.add(-2);
                break;
            }
            default: {
                break;
            }
        }
        drawText(tr, mat, text, color, pos, align);
        drawHorizontalLine(mat, begin.x, end.x, begin.y, color);
        drawHorizontalLine(mat, begin.x, end.x, end.y, color);
        drawVerticalLine(mat, begin.x, begin.y, end.y, color);
        drawVerticalLine(mat, end.x, begin.y, end.y, color);
    }
    protected void rotate(MatrixStack mat, float angle) {
        Vector2Int halfSize = windowSize.copy().divAndGet(2);
        mat.translate(halfSize.x , halfSize.y, 0);
        mat.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(angle));
        mat.translate(-halfSize.x , -halfSize.y, 0);
    }
    public abstract void render(MinecraftClient client, MatrixStack mat);
}
