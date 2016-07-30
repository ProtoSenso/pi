package nl.ttstudios.pi.gpio.temperature.drivers;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import nl.ttstudios.pi.gpio.temperature.TemperatureSensor;
import nl.ttstudios.pi.sys_io.Find;
import nl.ttstudios.pi.util.FileReader;

public class DS1820 implements TemperatureSensor {
    private static final Logger LOG = LogManager.getLogger( TemperatureSensor.class );

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final String PREFIX_TEMPERATURE_CELSIUS = "t=";
    private static final String PREFIX_TEMPERATURE_FAHRENHEIT = "crc=";

    private static final String baseDir = "/sys/bus/w1/devices/";

    private static String deviceFolder = null;
    private static String deviceFile = "/w1_slave";

    /**
     * read raw temperature and extract the raw temperature
     * 
     * @return
     * @throws IOException - when the temparatue sensor is nog configured
     */
    @Override
    public String[] readTemperature() throws IOException {
        LOG.info( "#### DS1820 readTemperature" );
        
        String[] temperature = null;

        getDeviceSpecifics();
        List<String> details = readTemperatureRaw();

        String rawTemperature = "";
        for ( String detail : details ) {
            LOG.debug( detail );
            rawTemperature = rawTemperature + detail;
        }
        temperature = getTemperatureFromDetail( rawTemperature );
        return temperature;
    }

    private void getDeviceSpecifics() throws IOException {
        String pattern = "28*";
        List<String> filesFound = Find.find( baseDir, pattern );
        deviceFolder = filesFound.get( 0 );
        deviceFile = deviceFolder + deviceFile;
    }

    /**
     * @param detail - the raw data from the sensor reading app
     * @return - an String array with the celsius value on index 1 and on index 2 the fahrenheit value
     */
    private String[] getTemperatureFromDetail(String detail) {
        String[] temperature = new String[3];
        String temperatureC = null;
        String temperatureF = null;

        boolean isTemperatureOK = false;
        String[] sentenceParts = detail.split( " " );

        for ( String part : sentenceParts ) {
            if ( part != null && part.contains( "=" ) ) {
                if ( part.length() > 4 && PREFIX_TEMPERATURE_FAHRENHEIT.equals( part.substring( 0, 4 ) ) ) {
                    temperatureF = part.substring( 4, part.length() );
                }
                if ( part.length() > 2 && PREFIX_TEMPERATURE_CELSIUS.equals( part.substring( 0, 2 ) ) ) {
                    temperatureC = part.length() > 2 ? part.substring( 2, part.length() ) : null;
                }
            }
            else if ( part.contains( YES ) ) {
                isTemperatureOK = true;
            }
        }
        temperature[0] = temperatureC;
        temperature[1] = temperatureF;
        temperature[2] = isTemperatureOK ? YES : NO;
        return temperature;
    }

    /**
     * returns a list of temperature details
     * 
     * @return
     * @throws IOException
     */
    private List<String> readTemperatureRaw() throws IOException {
        Path path = Paths.get( deviceFolder, "/w1_slave" );
        return FileReader.readLines( path );
    }

    @Override
    public String[] printTemperature() throws IOException {
        LOG.info( "#### DS1820 printTemperature" );
        
        String[] temperature = readTemperature();

        if ( temperature != null ) {
            LOG.debug( "The temperature (Celsius) is: " + temperature[0] );
            LOG.debug( "The temperature (Fahrenheit) is: " + temperature[1] );
            LOG.debug( "The temperature read is: " + temperature[2] );
        }
        return temperature;
    }
}
