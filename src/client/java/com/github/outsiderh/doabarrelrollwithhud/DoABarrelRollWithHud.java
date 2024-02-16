package com.github.outsiderh.doabarrelrollwithhud;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.outsiderh.doabarrelrollwithhud.renderer.AltitudeIndicator;
import com.github.outsiderh.doabarrelrollwithhud.renderer.AttitudeIndicator;
import com.github.outsiderh.doabarrelrollwithhud.renderer.Renderer;
import com.github.outsiderh.doabarrelrollwithhud.renderer.SpeedIndicator;
import com.github.outsiderh.doabarrelrollwithhud.utils.FlightComputer;

import net.fabricmc.api.ClientModInitializer;

public class DoABarrelRollWithHud implements ClientModInitializer {
	/*  to do
	 *  add ground speed indicator.
	 */
	public static final String modId = "doabarrelrollwithhud";
	public static final Logger loggerSource = LoggerFactory.getLogger(modId);
	public static final List<Renderer> renderers = List.of(new SpeedIndicator(), new AltitudeIndicator(), new AttitudeIndicator());
	public static final FlightComputer fc = new FlightComputer();
	@Override
	public void onInitializeClient() {
		
	}
}