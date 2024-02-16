package com.github.outsiderh.doabarrelrollwithhud.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;

public class FlightComputer {
    public float airSpeed; // m per tick
    public float groundSpeed; // m per tick
    public float altitude; // diff with y63
    public int radarAltitude; // diff with ground
    public boolean radarEnable;
    public float airSpeedInUnit() {
        return airSpeed / 1.7f * 100f;
    }
    public float groundSpeedInUnit() {
        return groundSpeed / 1.7f * 100f;
    }
    public float altitudeInUnit() {
        return altitude - 63f;
    }
    public void eval(MinecraftClient client) {
        if (client.player.getVelocity().dotProduct(client.player.getRotationVector()) < 0d) {
            airSpeed = 0f;
        }
        else {
            airSpeed = (float)client.player.getVelocity().distanceTo(Vec3d.ZERO);
        }
        groundSpeed = Vector2.asVector2(client.player.getVelocity()).distance(Vector2.get_zero());
        altitude = (float)client.player.getPos().y;
        radarEnable = altitude <= 520;
        if (radarEnable) {
            radarAltitude = 1;
            Mutable curCheck = client.player.getBlockPos().mutableCopy();
            while (curCheck.getY() > -65 && client.world.isAir(curCheck)) {
                curCheck.setY(curCheck.getY() - 1);
                ++radarAltitude;
                if (radarAltitude > 200) {
                    radarEnable = false;
                    break;
                }
            }
        }
    }
}
