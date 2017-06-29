package com.ttstudios.pi;

import java.io.IOException;
import java.net.URISyntaxException;

import com.ttstudios.pi.temperature.TemperatureManager;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws URISyntaxException, IOException {
        new TemperatureManager( TemperatureManager.SENSOR_TYPE_DS1820 );
    }
}
