package nl.ttstudios.pi.temperature;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import nl.ttstudios.pi.gpio.temperature.TemperatureManager;
import nl.ttstudios.pi.gpio.temperature.TemperatureSensor;

@RunWith( MockitoJUnitRunner.class )
public class TemperatureManagerTest {

    @Mock
    private TemperatureSensor sensor;

    @InjectMocks
    private TemperatureManager instance = new TemperatureManager();

    @Before
    public void init() throws IOException {
        when( sensor.printTemperature() ).thenReturn( new String[] { "21", "6" } );
        when( sensor.readTemperature() ).thenReturn( new String[] { "21", "6" } );
    }

    @Test
    public void testPrintTemperature() throws IOException {
        // prepare

        // action
        String[] result = instance.printTemperature();

        // verify
        assertThat( result[0] ).isEqualTo( "21" );
        assertThat( result[1] ).isEqualTo( "6" );
    }
}
