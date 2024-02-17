package com.github.outsiderh.doabarrelrollwithhud.utils;

public class Vector2Int {
    public int x;
    public int y;
    public Vector2Int() {
        x = 0;
        y = 0;
    }
    public Vector2Int(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Vector2Int(Vector2Int val) {
        x = val.x;
        y = val.y;
    }
    public void add(int val) {
        x += val;
        y += val;
    }
    public void div(int val) {
        x /= val;
        y /= val;
    }
    public Vector2Int addAndGet(int val) {
        x += val;
        y += val;
        return this;
    }
    public Vector2Int subAndGet(int val) {
        x -= val;
        y -= val;
        return this;
    }
    public Vector2Int subAndGet(Vector2Int val) {
        x -= val.x;
        y -= val.y;
        return this;
    }
    public Vector2Int divAndGet(int val) {
        x /= val;
        y /= val;
        return this;
    }
    public Vector2Int copy() {
        return new Vector2Int(this);
    }
}
