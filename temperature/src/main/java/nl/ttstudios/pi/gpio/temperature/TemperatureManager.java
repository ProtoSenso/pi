package nl.ttstudios.pi.gpio.temperature;

import java.io.IOException;
import java.util.List;

import nl.ttstudios.pi.sys_io.Find;

public class TemperatureManager {
	private static final String baseDir = "/sys/bus/w1/devices/";

	public TemperatureManager() throws IOException {
		String pattern = "28*";
		List<String> filesFound = Find.find(baseDir, pattern);
	}
}
