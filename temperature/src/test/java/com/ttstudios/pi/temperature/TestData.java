package com.ttstudios.pi.temperature;

import com.ttstudios.pi.temperature.TemperatureDto;
import com.ttstudios.pi.temperature.drivers.DS1820Dto;

public class TestData {

    private static final String DEVICE_UID = "deviceUID";
    private static final String SENSOR_UID = "sensorUID";
    private static final double TEMPERATURE_CELSIUS = 38.003;
    private static final String TEMPERATURE_UNIT = TemperatureDto.CELSIUS;
    private static final String TEMPERATUE_CRC = "temperatureCRC";
    private static final boolean TEMPERATURE_OK = true;
    private static final String TEMPERATURE_UID = "uid";
    private static final String TIMESTAMP = "unixTimestamp";

    public static DS1820Dto createDS1820Dto() {
        return new DS1820Dto( TEMPERATURE_UID, SENSOR_UID, DEVICE_UID, TEMPERATURE_CELSIUS, TEMPERATURE_UNIT, TIMESTAMP, TEMPERATUE_CRC, TEMPERATURE_OK );
    }
}
