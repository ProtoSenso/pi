package com.ttstudios.pi;

import java.net.URISyntaxException;

import com.ttstudios.pi.behavior.StartReadingSensor;
import com.ttstudios.pi.behavior.common.Context;
import com.ttstudios.pi.temperature.TemperatureManager;
import com.ttstudios.pi.util.PiProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ttseng
 */
public class SensorApplication {

    private static final String TARGET_API_URL = "192.168.1.65";
    private static final int TARGET_API_PORT = 9080;
    private static final String TARGET_URL_POST = "http://" + TARGET_API_URL + ":" + TARGET_API_PORT+ "/api/temperature_reading";

    private static final String SENSOR_TYPE = TemperatureManager.SENSOR_TYPE_DS1820;

    private PiProperties properties = new PiProperties();

    @Autowired
    private StartReadingSensor application;

    public static void main(String[] args) {
            StartReadingSensor application =  new StartReadingSensor();
            application.execute(SENSOR_TYPE);
            //startReadingTemperatureSensor( SENSOR_TYPE );
    }

//    private static void startReadingTemperatureSensor(String sensorType) throws URISyntaxException {
//        Context context = new Context( new StartReadingSensor() );
//        System.out.println( context.executeStrategy( sensorType ) );
//    }
}
