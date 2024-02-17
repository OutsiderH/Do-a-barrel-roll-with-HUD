package com.github.outsiderh.doabarrelrollwithhud.config;

import static com.github.outsiderh.doabarrelrollwithhud.DoABarrelRollWithHud.modId;
import com.github.outsiderh.doabarrelrollwithhud.utils.FlightComputer.SpeedUnit;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = modId)
public class ModConfig implements ConfigData {
    public SpeedUnit speedUnit = SpeedUnit.kn;
}
