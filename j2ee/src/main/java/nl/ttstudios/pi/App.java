package nl.ttstudios.pi;

import java.net.URISyntaxException;

import nl.ttstudios.pi.behavior.StartReadingSensor;
import nl.ttstudios.pi.common.behavior.Context;
import nl.ttstudios.pi.gpio.temperature.TemperatureManager;

/**
 * @author ttseng
 */
public class App {

    private static final String SENSOR_TYPE = TemperatureManager.SENSOR_TYPE_DS1820;

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
