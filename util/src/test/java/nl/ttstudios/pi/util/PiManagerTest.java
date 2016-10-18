package nl.ttstudios.pi.util;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith( MockitoJUnitRunner.class )
public class PiManagerTest {

    private static final String SERIAL_NUMBER = "00000000463d34d5";

    @Mock
    private FileReader fileReader;

    @InjectMocks
    private PiManager instance;

    @Before
    public void init() throws IOException, URISyntaxException {
        instance = new PiManager();
    }

    @Test
    public void testGetPiSerialNumber() throws URISyntaxException, IOException {
        // prepare

        // action
        String serialNumber = instance.getPiSerialNumber();

        // verify
        assertThat( serialNumber ).isEqualTo( SERIAL_NUMBER );
    }

}
