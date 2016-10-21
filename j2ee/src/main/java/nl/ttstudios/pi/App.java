package nl.ttstudios.pi;

import java.net.URISyntaxException;

import nl.ttstudios.pi.behavior.StartReadingSensor;
import nl.ttstudios.pi.common.behavior.Context;
import nl.ttstudios.pi.gpio.temperature.TemperatureManager;
import nl.ttstudios.pi.gpio.temperature.drivers.DS1820Dto;
import nl.ttstudios.pi.util.PiProperties;
import nl.ttstudios.rest.client.RestClient;

/**
 * @author ttseng
 */
public class App {

    private static final String TARGET_API_URL = "192.168.1.65";
    private static final int TARGET_API_PORT = 9080;
    private static final String TARGET_URL_POST = "http://" + TARGET_API_URL + ":" + TARGET_API_PORT+ "/api/temperature_reading";

    private static final String SENSOR_TYPE = TemperatureManager.SENSOR_TYPE_DS1820;

    private PiProperties properties = new PiProperties();

    public static void main(String[] args) {
        try {
            startReadingTemperatureSensor( SENSOR_TYPE );
        }
        catch ( URISyntaxException e ) {
            throw new UnsupportedOperationException( e );
        }
    }

    private static void startReadingTemperatureSensor(String sensorType) throws URISyntaxException {
        Context context = new Context( new StartReadingSensor() );
        System.out.println( context.executeStrategy( sensorType ) );
    }
}
