package nl.ttstudios.pi.logicimpl;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

import nl.ttstudios.pi.gpio.temperature.TemperatureDto;
import nl.ttstudios.pi.gpio.temperature.TemperatureManager;
import nl.ttstudios.pi.gpio.temperature.drivers.DS1820Dto;
import nl.ttstudios.rest.client.RestClient;

/**
 * @author ttseng
 */
public class App {

    private static final String TARGET_URL_GET = "http://localhost:9080/api/temperature_readings";
    private static final String TARGET_URL_POST = "http://localhost:9080/api/temperature_reading";

    private static final String SENSOR_TYPE = TemperatureManager.SENSOR_TYPE_DS1820;
    private static final long SLEEP_MILLIS = 1000;

    
    // test
    private static final String DEVICE_UID = "deviceUID";
    private static final String SENSOR_UID = "sensorUID";
    private static final double TEMPERATURE_CELSIUS = 38.003;
    private static final String TEMPERATURE_UNIT = TemperatureDto.CELSIUS;
    private static final String TEMPERATUE_CRC = "temperatureCRC";
    private static final boolean TEMPERATURE_OK = true;
    private static final String TEMPERATURE_UID = "uid";
    private static final String TIMESTAMP = "unixTimestamp";

    
    
    
    public static void main(String[] args) {
        startReadingTemperatureSensor( SENSOR_TYPE );
    }

    private static void startReadingTemperatureSensor(String sensorType) {
        //TemperatureManager tempManager;
        try {
            //tempManager = new TemperatureManager( sensorType );

            while ( true ) {
                // do reading
                // DS1820Dto readingDto = tempManager.readTemperature();

                // test
                DS1820Dto readingDto = new DS1820Dto( TEMPERATURE_UID, SENSOR_UID, DEVICE_UID, TEMPERATURE_CELSIUS, TEMPERATURE_UNIT, TIMESTAMP, TEMPERATUE_CRC, TEMPERATURE_OK );
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
