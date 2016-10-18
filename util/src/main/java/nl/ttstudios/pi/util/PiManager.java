package nl.ttstudios.pi.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PiManager {

    private Properties prop = new Properties();

    private static final String PROPERTY_FILE = "pi.properties";

    protected static String BASE_DIR;
    protected static String FILE;

    public PiManager() throws IOException {

        this.prop = new Properties();
        this.prop.load( this.getClass().getClassLoader().getResourceAsStream( PROPERTY_FILE ) );

        BASE_DIR = prop.getProperty( getClass().getName() + "." + "BASE_DIR" );
        FILE = prop.getProperty( getClass().getName() + "." + "FILE" );
    }

    public String getPiSerialNumber() throws URISyntaxException, IOException {
        String serialNumber = null;

        // read file
        List<String> details = readPiDetailsRaw();

        Pattern p = Pattern.compile( "(Serial[ ]*): ([0-9a-f]{16})$" );

        for ( String detail : details ) {
            serialNumber = matchKeyValuePairWithRegex( serialNumber, p, detail.replace( '\t', ' ' ).trim() );
        }
        return serialNumber;
    }

    private String matchKeyValuePairWithRegex(String serialNumber, Pattern p, String detail) {
        Matcher m = p.matcher( detail );

        while ( m.find() ) {

            serialNumber = m.group( 2 );
        }
        return serialNumber;
    }

    private List<String> readPiDetailsRaw() throws URISyntaxException, IOException {
        String filePath = "/" + BASE_DIR + FILE;
        System.out.println( filePath );
        Path path = Paths.get( getClass().getResource( filePath ).toURI() );
        return FileReader.readLines( path );
    }

}
