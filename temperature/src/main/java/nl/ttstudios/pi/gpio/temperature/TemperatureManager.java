package nl.ttstudios.pi.gpio.temperature;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import nl.ttstudios.pi.gpio.temperature.drivers.DS1820;

public class TemperatureManager {
    private static final Logger LOG = LogManager.getLogger( TemperatureManager.class );

    public static final String SENSOR_TYPE_DS1820 = "DS1820";

    private TemperatureSensor sensor;

    public TemperatureManager() {
        LOG.debug( "#### TemperatureManager Sensor: NONE" );
    }

    public TemperatureManager(String sensorType) throws IOException {
        LOG.debug( "#### TemperatureManager Sensor: " + SENSOR_TYPE_DS1820 );

        if ( SENSOR_TYPE_DS1820.equals( sensorType ) ) {
            sensor = new DS1820();
        }

        printTemperature();
    }

    public String[] printTemperature() throws IOException {
        String[] temperature = sensor.printTemperature();
        return temperature;
    }
}
