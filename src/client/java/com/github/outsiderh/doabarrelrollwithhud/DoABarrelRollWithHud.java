package com.github.outsiderh.doabarrelrollwithhud;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.outsiderh.doabarrelrollwithhud.config.ModConfig;
import com.github.outsiderh.doabarrelrollwithhud.renderer.AltitudeIndicator;
import com.github.outsiderh.doabarrelrollwithhud.renderer.AttitudeIndicator;
import com.github.outsiderh.doabarrelrollwithhud.renderer.Renderer;
import com.github.outsiderh.doabarrelrollwithhud.renderer.SpeedIndicator;
import com.github.outsiderh.doabarrelrollwithhud.utils.FlightComputer;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class DoABarrelRollWithHud implements ClientModInitializer {
	public static final String modId = "doabarrelrollwithhud";
	public static final Logger loggerSource = LoggerFactory.getLogger(modId);
	public static final List<Renderer> renderers = List.of(new SpeedIndicator(), new AltitudeIndicator(), new AttitudeIndicator());
	public static final FlightComputer fc = new FlightComputer();
	public static ModConfig config;
	@Override
	public void onInitializeClient() {
		AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
	}
}