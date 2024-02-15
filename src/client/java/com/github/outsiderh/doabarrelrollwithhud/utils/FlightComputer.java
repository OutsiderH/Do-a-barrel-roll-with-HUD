package com.github.outsiderh.doabarrelrollwithhud.utils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class FlightComputer {
    public double airSpeed;
    public void eval(PlayerEntity player) {
        airSpeed = player.getVelocity().distanceTo(Vec3d.ZERO);
    }
}
