package nl.ttstudios.pi.util;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class PiManagerTest {

    private static final String BASE_DIR = "/proc/";
    private static final String FILE = "cpuinfo";

    private static final String SERIAL_NUMBER = "00000000463d34d5";

    @Mock
    private FileReader fileReader;

    @InjectMocks
    private PiManager instance;

    @Before
    public void init() throws IOException {
        instance = new PiManager();

        when( FileReader.readLines( any() ) ).thenReturn( readPiDetailsRaw() );
    }

    @Test
    public void testPropertyInitialization() {
        assertThat( PiManager.BASE_DIR ).isEqualTo( BASE_DIR );
        assertThat( PiManager.FILE ).isEqualTo( FILE );
    }

    @Ignore
    @Test
    public void testGetPiSerialNumber() throws IOException {
        // prepare

        // action
        String serialNumber = instance.getPiSerialNumber();

        // verify
        assertThat( serialNumber ).isEqualTo( SERIAL_NUMBER );
    }

    private List<String> readPiDetailsRaw() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream( FILE );
        

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File( classLoader.getResource( FILE ).getFile() );

        Path path = FileSystems.getDefault().getPath("cpuinfo", FILE);
        return FileReader.readLines( path );
    }
}
