package nl.ttstudios.pi.gpio.temperature;

import java.io.IOException;

public interface TemperatureSensor {

    /**
     * reads the raw temperature and extracts the temperature details
     * 
     * @return - an String array with 4 values
     * temperature[0] = temperatureC
     * temperature[1] = temperatureCRC
     * temperature[2] = isTemperatureOK ? YES : NO
     * temperature[3] = "" + unixTimestamp
     * @throws IOException - when the temparatue sensor is nog configured
     */
    public String[] readTemperature() throws IOException;

    /**
     * prints the temperature and extracts the temperature details
     * 
     * @return - an String array with 4 values
     * temperature[0] = temperatureC
     * temperature[1] = temperatureCRC
     * temperature[2] = isTemperatureOK ? YES : NO
     * temperature[3] = "" + unixTimestamp
     * @throws IOException - when the temparatue sensor is nog configured
     */
    public String[] printTemperature() throws IOException;
}
