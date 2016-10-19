package nl.ttstudios.pi.gpio.temperature.drivers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import nl.ttstudios.pi.gpio.temperature.TemperatureDto;
import nl.ttstudios.pi.gpio.temperature.TemperatureSensor;
import nl.ttstudios.pi.sys_io.Find;
import nl.ttstudios.pi.util.FileReader;
import nl.ttstudios.pi.util.PiManager;

public class DS1820 implements TemperatureSensor {
    private static final Logger LOG = LogManager.getLogger( TemperatureSensor.class );

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final String PREFIX_TEMPERATURE_CELSIUS = "t=";
    private static final String TEMPERATURE_UNIT = TemperatureDto.CELSIUS;
    private static final String PREFIX_CRC = "crc=";

    private static final String BASE_DIR = "/sys/bus/w1/devices/";

    private static final int TEMPERATURE_UID_INDEX = 0;
    private static final int TEMPERATURE_CELSIUS_INDEX = 1;
    private static final int CRC_INDEX = 2;
    private static final int TEMPERATURE_OK_INDEX = 3;
    private static final int TIMESTAMP_INDEX = 4;

    private String deviceFolder = null;
    private String deviceFile = "/w1_slave";
    private String devicePath = null;
    private String deviceSerialNumber;
    
    private FileReader fileReader = new FileReader();
    private PiManager piManager = new PiManager();

    public DS1820() throws URISyntaxException, IOException {
        deviceSerialNumber = piManager.getPiSerialNumber();
    }

    /**
     * read raw temperature and extract the raw temperature
     * 
     * @return
     * @throws IOException - when the temparatue sensor is nog configured
     */
    @Override
    public DS1820Dto readTemperature() throws IOException {
        LOG.info( "#### DS1820 readTemperature" );

        String[] temperatureDetails = null;

        getDeviceSpecifics();
        List<String> details = readTemperatureRaw();

        String rawTemperature = "";
        for ( String detail : details ) {
            LOG.debug( detail );
            rawTemperature = rawTemperature + detail;
        }
        temperatureDetails = getTemperatureFromDetail( rawTemperature, System.currentTimeMillis() );

        DS1820Dto dto = new DS1820Dto();
        dto.setuID( temperatureDetails[TEMPERATURE_UID_INDEX] );
        dto.setDeviceUID( deviceSerialNumber );
        dto.setSensorUID( deviceFolder );
        dto.setTemperature( Double.valueOf( temperatureDetails[TEMPERATURE_CELSIUS_INDEX] ) );
        dto.setTemperatureUnit( TEMPERATURE_UNIT );
        dto.setTemperatureCRC( temperatureDetails[CRC_INDEX] );
        dto.setTemperatureOK( temperatureDetails[TEMPERATURE_OK_INDEX].equals( YES ) ? true : false );
        dto.setUnixTimestamp( temperatureDetails[TIMESTAMP_INDEX] );

        return dto;
    }

    private void getDeviceSpecifics() throws IOException {
        String pattern = "28*";
        List<String> filesFound = Find.find( BASE_DIR, pattern );
        deviceFolder = filesFound.get( 0 );
        devicePath = deviceFolder + deviceFile;
    }

    /**
     * @param detail - the raw data from the sensor reading app
     * @return - an String array with the celsius value on index 1 and on index 2 the fahrenheit value
     */
    private String[] getTemperatureFromDetail(String detail, long unixTimestamp) {
        String[] temperature = new String[5];
        String temperatureC = null;
        String temperatureCRC = null;

        boolean isTemperatureOK = false;
        String[] sentenceParts = detail.split( " " );

        for ( String part : sentenceParts ) {
            if ( part != null && part.contains( "=" ) ) {
                if ( part.length() > 4 && PREFIX_CRC.equals( part.substring( 0, 4 ) ) ) {
                    temperatureCRC = part.substring( 4, part.length() );
                }
                if ( part.length() > 2 && PREFIX_TEMPERATURE_CELSIUS.equals( part.substring( 0, 2 ) ) ) {
                    temperatureC = part.length() > 2 ? part.substring( 2, part.length() ) : null;
                }
            }
            else if ( part.contains( YES ) ) {
                isTemperatureOK = true;
            }
        }
        temperature[TEMPERATURE_UID_INDEX] = UUID.randomUUID().toString();
        temperature[TEMPERATURE_CELSIUS_INDEX] = temperatureC;
        temperature[CRC_INDEX] = temperatureCRC;
        temperature[TEMPERATURE_OK_INDEX] = isTemperatureOK ? YES : NO;
        temperature[TIMESTAMP_INDEX] = "" + unixTimestamp;
        return temperature;
    }

    /**
     * returns a list of temperature details
     * 
     * @return
     * @throws IOException
     */
    private List<String> readTemperatureRaw() throws IOException {
        Path path = Paths.get( deviceFolder, deviceFile );
        return fileReader.readLines( path );
    }

    @Override
    public String printTemperature() throws IOException {
        LOG.info( "#### DS1820 printTemperature" );

        DS1820Dto dto = readTemperature();

        if ( dto != null ) {
            LOG.debug( "The temperature (Celsius) is: " + dto.getTemperature() );
            LOG.debug( "The temperature (crc) is: " + dto.getTemperatureCRC() );
            LOG.debug( "The temperature read is OK?: " + dto.isTemperatureOK() );
            LOG.debug( "The unix-timestamp is: " + dto.getUnixTimestamp() );
        }
        return dto.toString();
    }
}
