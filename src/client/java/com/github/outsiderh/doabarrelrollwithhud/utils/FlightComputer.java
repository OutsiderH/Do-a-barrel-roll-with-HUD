package com.github.outsiderh.doabarrelrollwithhud.utils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class FlightComputer {
    public float airSpeed;
    public float altitude;
    public float airSpeedInUnit() {
        return airSpeed / 1.7f * 100f;
    }
    public float altitudeInUnit() {
        return altitude - 63f;
    }
    public void eval(PlayerEntity player) {
        airSpeed = (float)player.getVelocity().distanceTo(Vec3d.ZERO);
        altitude = (float)player.getPos().y;
    }
}
