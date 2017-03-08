package nl.ttstudios.pi.behavior;

import java.io.IOException;
import java.net.URISyntaxException;

import com.fasterxml.jackson.core.JsonProcessingException;

import nl.ttstudios.pi.common.behavior.BehaviorStrategy;
import nl.ttstudios.pi.gpio.temperature.TemperatureManager;
import nl.ttstudios.pi.gpio.temperature.drivers.DS1820Dto;
import nl.ttstudios.rest.client.RestClient;

public class StartReadingSensor implements BehaviorStrategy {

    private static final String TARGET = "192.168.1.185";//192.168.1.185
    private static final String TARGET_URL_POST = "http://" + TARGET + ":9080/api/temperature_reading";

    // TODO - Check what sensor is connected to the pi
    //private static final String SENSOR_TYPE = TemperatureManager.SENSOR_TYPE_DS1820;
    private static final long SLEEP_MILLIS = 1000;
    
    @Override
    public int execute(String sensorType) {
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
        catch ( URISyntaxException e ) {
            e.printStackTrace();
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        return 0;
    }

}
