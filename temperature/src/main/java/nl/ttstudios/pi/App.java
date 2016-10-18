package nl.ttstudios.pi;

import java.io.IOException;
import java.net.URISyntaxException;

import nl.ttstudios.pi.gpio.temperature.TemperatureManager;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws URISyntaxException, IOException {
        new TemperatureManager( TemperatureManager.SENSOR_TYPE_DS1820 );
    }
}
