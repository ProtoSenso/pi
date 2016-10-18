package nl.ttstudios.pi.util;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
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
        
        when(FileReader.readLines( any() )).thenReturn( readDetailsRaw() );
    }
@Ignore
    @Test
    public void testGetPiSerialNumber() throws URISyntaxException, IOException {
        // prepare

        // action
        String serialNumber = instance.getPiSerialNumber();

        // verify
        assertThat( serialNumber ).isEqualTo( SERIAL_NUMBER );
    }

    public List<String> readDetailsRaw() throws URISyntaxException, IOException {
        String filePath = "/" + "cpuinfo.log";
        System.out.println( filePath );
        Path path = Paths.get( getClass().getResource( filePath ).toURI() );
        return readLines( path );
    }
    
    public List<String> readLines(Path pathToFile) throws IOException {
        Charset charset = Charset.forName( "ISO-8859-1" );
        List<String> lines = Files.readAllLines( pathToFile, charset );
        return lines;
    }

}
