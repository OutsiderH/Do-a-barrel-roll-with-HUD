package com.github.outsiderh.doabarrelrollwithhud.utils;

import org.apache.commons.lang3.NotImplementedException;
import com.github.outsiderh.doabarrelrollwithhud.DoABarrelRollWithHud;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;
import nl.enjarai.doabarrelroll.DoABarrelRollClient;
import nl.enjarai.doabarrelroll.flight.ElytraMath;
import net.minecraft.util.math.BlockPos.Mutable;

public class FlightComputer {
    public float airSpeed;
    public float groundSpeed;
    public float altitude;
    public int radarAltitude;
    public boolean radarEnable;
    public float pitch;
    public float yaw;
    public float roll;
    public float airSpeedInUnit() {
        switch (DoABarrelRollWithHud.config.speedUnit) {
            case mPerT: {
                return airSpeed;
            }
            case mPerS: {
               return airSpeed * 20f;
            }
            case kmPerH: {
                return airSpeed * 72f;
            }
            case kn: {
                return airSpeed * 38.877f;
            }
            default: {
                throw new NotImplementedException();
            }
        }
    }
    public float groundSpeedInUnit() {
        switch (DoABarrelRollWithHud.config.speedUnit) {
            case mPerT: {
                return groundSpeed;
            }
            case mPerS: {
                return groundSpeed * 20f;
            }
            case kmPerH: {
                return groundSpeed * 72f;
            }
            case kn: {
                return groundSpeed * 38.877f;
            }
            default: {
                throw new NotImplementedException();
            }
        }
    }
    public float altitudeInUnit() {
        return altitude - 63f;
    }
    public float airSpeedPercentage() {
        return airSpeed / 1.7f;
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
            radarAltitude = 0;
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
        pitch = client.player.getPitch();
        yaw = client.player.getYaw();
        roll = (float)ElytraMath.getRoll(yaw, DoABarrelRollClient.left);
    }
    public enum SpeedUnit {
        mPerT,
        mPerS,
        kmPerH,
        kn
    }
}
