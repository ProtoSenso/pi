package com.ttstudios.pi.temperature;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ttstudios.pi.temperature.TemperatureDto;
import com.ttstudios.pi.temperature.TemperatureManager;
import com.ttstudios.pi.temperature.TemperatureSensor;
import com.ttstudios.pi.temperature.drivers.DS1820Dto;

@RunWith( MockitoJUnitRunner.class )
public class TemperatureManagerTest {

    private static final String SENSOR_DTO_CLASS = "com.ttstudios.pi.temperature.drivers.DS1820Dto";
    private static final String DEVICE_UID = "deviceUID";
    private static final String SENSOR_UID = "sensorUID";
    private static final double TEMPERATURE_CELSIUS = 38.003;
    private static final String TEMPERATURE_UNIT = TemperatureDto.CELSIUS;
    private static final String TEMPERATUE_CRC = "temperatureCRC";
    private static final boolean TEMPERATURE_OK = true;
    private static final String TEMPERATURE_UID = "uid";
    private static final String TIMESTAMP = "unixTimestamp";

    @Mock
    private TemperatureSensor sensor;

    @InjectMocks
    private TemperatureManager instance = new TemperatureManager();

    @Before
    public void init() throws IOException {

        DS1820Dto dto = TestData.createDS1820Dto();

        when( sensor.printTemperature() ).thenReturn( dto.toString() );
        when( sensor.readTemperature() ).thenReturn( dto );
    }

    @Test
    public void testReadTemperature() throws IOException {
        // prepare

        // action
        DS1820Dto result = (DS1820Dto) instance.readTemperature();

        // verify
        assertThat( result.getClass().getName() ).isEqualTo( SENSOR_DTO_CLASS );
        assertThat( result.getDeviceUID()).isEqualTo( DEVICE_UID );
        assertThat( result.getSensorUID() ).isEqualTo( SENSOR_UID );
        assertThat( result.getTemperature() ).isEqualTo( TEMPERATURE_CELSIUS );
        assertThat( result.getTemperatureUnit() ).isEqualTo( TEMPERATURE_UNIT );
        assertThat( result.getTemperatureCRC() ).isEqualTo( TEMPERATUE_CRC );
        assertThat( result.getuID() ).isEqualTo( TEMPERATURE_UID );
        assertThat( result.getUnixTimestamp() ).isEqualTo( TIMESTAMP );
        assertThat( result.isTemperatureOK()).isEqualTo( TEMPERATURE_OK );
    }

    @Test
    public void testPrintTemperature() throws IOException {
        // prepare

        // action
        String result = instance.printTemperature();

        // verify
        assertThat( result ).isEqualTo( 
            "DS1820Dto ["
            + "uID=" + TEMPERATURE_UID + ", "
            + "sensorUID=" + SENSOR_UID + ", "
            + "deviceUID=" + DEVICE_UID + ", "
            + "temperature=" + TEMPERATURE_CELSIUS + ", "
            + "temperatureUnit=" + TEMPERATURE_UNIT + ", "
            + "unixTimestamp=" + TIMESTAMP + ", "
            + "temperatureCRC=" + TEMPERATUE_CRC + ", "
            + "isTemperatureOK=" + TEMPERATURE_OK
            + "]" );
    }
}
