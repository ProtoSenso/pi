package com.ttstudios.pi.behavior;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ttstudios.pi.behavior.common.BehaviorStrategy;
import com.ttstudios.pi.rest.client.RestClient;
import com.ttstudios.pi.temperature.TemperatureManager;
import com.ttstudios.pi.temperature.drivers.DS1820Dto;
import com.ttstudios.pi.temperature.drivers.MeasurementDto;
import com.ttstudios.pi.transform.SensorToDtoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.net.URISyntaxException;

@ComponentScan({"com.ttstudios.pi"})
@EnableAutoConfiguration
public class StartReadingSensor implements BehaviorStrategy{


    private static final Logger LOG = LoggerFactory.getLogger(StartReadingSensor.class);

    private static final String TARGET = "192.168.0.101";//192.168.1.185
    private static final String TARGET_URL_POST = "http://" + TARGET + ":9080/api/temperature_reading";

    // TODO - Check what sensor is connected to the pi
    private static final String SENSOR_TYPE = TemperatureManager.SENSOR_TYPE_DS1820;
    private static final long SLEEP_MILLIS = 1000;

    @Autowired
    private static RestClient client;

    @Autowired
    private static SensorToDtoMapper mapper;

    public static int execute(String sensorType) {
        LOG.info("execute");
        TemperatureManager tempManager;
        try {
            tempManager = new TemperatureManager(sensorType);

            while (true) {
                // do reading
                DS1820Dto readingDto = tempManager.readTemperature();

                MeasurementDto measurement = mapper.toMeasurement(readingDto);

                // send to server
                client.doPost(TARGET_URL_POST, measurement);

                Thread.sleep(SLEEP_MILLIS);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        SpringApplication.run(StartReadingSensor.class, args);
        execute(SENSOR_TYPE);
    }

}
