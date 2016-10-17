package nl.ttstudios.pi.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class PiManager {

    InputStream input = null;
    Properties prop = new Properties();

    private static final String PROPERTY_FILE = "pi.properties";

    protected static String BASE_DIR;
    protected static String FILE;

    public PiManager() throws IOException {

        this.prop = new Properties();
        this.prop.load( this.getClass().getClassLoader().getResourceAsStream( PROPERTY_FILE ) );

        BASE_DIR = prop.getProperty( getClass().getName() + "." + "BASE_DIR" );
        FILE = prop.getProperty( getClass().getName() + "." + "FILE" );
    }

    public static String getPiSerialNumber() throws IOException {
        String serialNumber = null;

        // read file
        List<String> details = readPiDetailsRaw();

        for ( String detail : details ) {
            // readline to figure out whether it is the serialNumber
            System.out.println( detail );
        }
        return serialNumber;
    }

    private static List<String> readPiDetailsRaw() throws IOException {
        Path path = Paths.get( BASE_DIR, FILE );
        return FileReader.readLines( path );
    }

}
