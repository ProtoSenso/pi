package nl.ttstudios.pi.gpio.temperature;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import nl.ttstudios.pi.sys_io.Find;
import nl.ttstudios.pi.util.FileReader;

public class TemperatureManager {
	private static final String baseDir = "/sys/bus/w1/devices/";
	private static String deviceFolder;
	private static String deviceFile;

	public TemperatureManager() throws IOException {
		String pattern = "28*";
		List<String> filesFound = Find.find(baseDir, pattern);
		deviceFolder = filesFound.get(0);
		deviceFile = deviceFolder + "/w1_slave";

		List<String> lines = readTemperatureRaw();
		for (String line : lines) {
			System.out.println(line);
		}
	}

	public List<String> readTemperatureRaw() throws IOException {
		Path path = Paths.get(deviceFolder, "/w1_slave");
		return FileReader.readLines(path);
	}
}
