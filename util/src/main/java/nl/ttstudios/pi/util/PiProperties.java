package nl.ttstudios.pi.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PiProperties {

    private static final String PROPERTY_FILE = "pi.properties";

    private Properties configProp;

    private void loadProperties() {
        InputStream in = this.getClass().getResourceAsStream( PROPERTY_FILE );
        try {
            configProp = new Properties();
            configProp.load( in );
        }
        catch ( IOException e ) {
            configProp = null;
        }
    }

    public String getProperty(String key){
        if(configProp == null){
            loadProperties();
        }
        return configProp.getProperty(key);
    }
}