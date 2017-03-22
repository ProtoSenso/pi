package nl.ttstudios.pi.util;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.commons.io.FileUtils;
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
    private PiManager instance = new PiManager();

    @Before
    public void init() throws IOException, URISyntaxException {

        when( fileReader.readLines( any() ) ).thenReturn( mockCpuFile() );
    }

    @Test
    public void testGetPiSerialNumber() throws URISyntaxException, IOException {
        // prepare

        // action
        String serialNumber = instance.getPiSerialNumber();

        // verify
        assertThat( serialNumber ).isEqualTo( SERIAL_NUMBER );
    }

    private List<String> mockCpuFile() throws IOException {
        File file = new File( "src/test/resources/cpuinfo.log" );
        List<String> lines = FileUtils.readLines( file, "UTF-8" );

        return lines;
    }
}
