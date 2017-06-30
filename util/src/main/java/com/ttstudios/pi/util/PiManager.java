package com.ttstudios.pi.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PiManager {

    private static final String PATTERN_SERIAL_NUMBER = "(Serial[ ]*): ([0-9a-f]{16})$";

    private static final int GROUP_INDEX_VALUE_SERIAL_NUMBER = 2;

    private static final String KEY_OS_NAME = "os.name";
    private static final String LINUX = "Linux";
    private static final String WINDOWS_10 = "Windows 10";

    private static final String PROPERTY_FILE = "pi.properties";

    protected static String VALUE_BASE_DIR;
    protected static String VALUE_FILE;
    protected static String KEY_CPU_INFO_BASE_DIR;
    protected static String KEY_CPU_INFO_FILE;

    private Properties prop = new Properties();
    private FileReader fileReader = new FileReader();

    public PiManager() {
    }

    public String getPiSerialNumber() throws URISyntaxException, IOException {
        String serialNumber = null;

        // read file
        List<String> details = readPiDetailsRaw();

        Pattern p = Pattern.compile( PATTERN_SERIAL_NUMBER );

        for ( String detail : details ) {
            serialNumber = matchKeyValuePairWithRegex( serialNumber, p, detail.replace( '\t', ' ' ).trim() );
        }
        return serialNumber;
    }

    private String matchKeyValuePairWithRegex(String serialNumber, Pattern p, String detail) {
        Matcher m = p.matcher( detail );

        while ( m.find() ) {

            serialNumber = m.group( GROUP_INDEX_VALUE_SERIAL_NUMBER );
        }
        return serialNumber;
    }

    private List<String> readPiDetailsRaw() throws IOException {
        loadProperties();
        Path path = null;

        String os = System.getProperty( KEY_OS_NAME );
        System.err.println( "-----> " + os );
        if ( LINUX.equals( os ) ) {
            System.out.println(  File.separator + VALUE_BASE_DIR + " : " + VALUE_FILE  );
            path = Paths.get( File.separator + VALUE_BASE_DIR, VALUE_FILE );
        }
        else if(WINDOWS_10.equals( os )) {
            System.out.println(  File.separator + VALUE_BASE_DIR + " : " + VALUE_FILE  );
            path = Paths.get( File.separator + VALUE_BASE_DIR, VALUE_FILE );
        }
        return fileReader.readLines( path );
    }

    public void loadProperties() throws IOException {
        this.prop = new Properties();
        this.prop.load( this.getClass().getClassLoader().getResourceAsStream( PROPERTY_FILE ) );

        // keys
        KEY_CPU_INFO_BASE_DIR = getClass().getName() + "." + "KEY_CPU_INFO_BASE_DIR";
        KEY_CPU_INFO_FILE = getClass().getName() + "." + "KEY_CPU_INFO_FILE";

        // values
        VALUE_BASE_DIR = prop.getProperty( KEY_CPU_INFO_BASE_DIR );
        VALUE_FILE = prop.getProperty( KEY_CPU_INFO_FILE );
    }

}
