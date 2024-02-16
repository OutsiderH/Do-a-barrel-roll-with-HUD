package com.github.outsiderh.doabarrelrollwithhud.utils;

import net.minecraft.util.math.Vec3d;

public class Vector2 {
    public float x;
    public float y;
    public Vector2() {
        x = 0f;
        y = 0f;
    }
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float distance(Vector2 val) {
        float gapX = val.x - x;
        float gapZ = val.y - y;
        return (float)Math.sqrt((double)(gapX * gapX + gapZ * gapZ));
    }
    public static Vector2 get_zero() {
        return new Vector2();
    }
    public static Vector2 asVector2(Vec3d val) {
        return new Vector2((float)val.x, (float)val.z);
    }
}
