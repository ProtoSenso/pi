package nl.ttstudios.pi.gpio.temperature;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import nl.ttstudios.pi.gpio.temperature.drivers.DS1820;
import nl.ttstudios.pi.gpio.temperature.drivers.DS1820Dto;

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

    public DS1820Dto readTemperature() throws IOException {
        return sensor.readTemperature();
    }
    
    public String printTemperature() throws IOException {
        return sensor.printTemperature();
    }
}
