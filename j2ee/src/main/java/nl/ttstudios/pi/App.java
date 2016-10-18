package nl.ttstudios.pi;

import java.io.IOException;
import java.net.URISyntaxException;

import com.fasterxml.jackson.core.JsonProcessingException;

import nl.ttstudios.pi.gpio.temperature.TemperatureManager;
import nl.ttstudios.pi.gpio.temperature.drivers.DS1820Dto;
import nl.ttstudios.rest.client.RestClient;

/**
 * @author ttseng
 */
public class App {

    private static final String TARGET_URL_POST = "http://localhost:9080/api/temperature_reading";

    private static final String SENSOR_TYPE = TemperatureManager.SENSOR_TYPE_DS1820;
    private static final long SLEEP_MILLIS = 1000;

    public static void main(String[] args) {
        try {
            startReadingTemperatureSensor( SENSOR_TYPE );
        }
        catch ( URISyntaxException e ) {
            throw new UnsupportedOperationException(e);
        }
    }

    private static void startReadingTemperatureSensor(String sensorType) throws URISyntaxException {
        TemperatureManager tempManager;
        try {
            tempManager = new TemperatureManager( sensorType );

            while ( true ) {
                // do reading
                DS1820Dto readingDto = tempManager.readTemperature();

                // send to server
                RestClient.doPost( TARGET_URL_POST, readingDto );

                Thread.sleep( SLEEP_MILLIS );
            }
        }
        catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        catch ( JsonProcessingException e ) {
            e.printStackTrace();
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }

    }
}
