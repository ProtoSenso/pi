package nl.ttstudios.pi.gpio.temperature;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.apispark.webapi.Config;
import net.apispark.webapi.representation.Pet;
import net.apispark.webapi.resource.client.CreateUsersWithListClientResource;
import nl.ttstudios.pi.gpio.temperature.drivers.DS1820;

public class TemperatureManager {
    private static final Logger LOG = LogManager.getLogger( TemperatureManager.class );

    // list all sensortypes here
    public static final String SENSOR_TYPE_DS1820 = "DS1820";

    private TemperatureSensor sensor;

    public TemperatureManager() {
        LOG.debug( "#### TemperatureManager Sensor: NONE" );
    }

    /**
     * Constructs a Sensor of a specific temperature driver like DS1820
     * @param sensorType - the specific temperature driver
     * @throws IOException
     */
    public TemperatureManager(String sensorType) throws IOException {
        LOG.debug( "#### TemperatureManager Sensor: " + SENSOR_TYPE_DS1820 );

        if ( SENSOR_TYPE_DS1820.equals( sensorType ) ) {
            sensor = new DS1820();
            String[] temperatureDetails = sensor.readTemperature();
            
            // send the temperature to the backend
            update(temperatureDetails);
        }

        printTemperature();
    }
    
    /**
     * prints the temperatures on screen 
     * 
     * @return
     * @throws IOException
     */
    public String[] printTemperature() throws IOException {
        String[] temperature = sensor.printTemperature();
        return temperature;
    }
    
    private void update(String[] temperatureDetails){
    	Pet pet = new Pet();
    	pet.setName("DS1820");
    	pet.setStatus(temperatureDetails.toString());
    	
    	Config config = new Config();
    	System.out.println("basePath: " + config.getBasePath()) ;
    	CreateUsersWithListClientResource restFunction = new CreateUsersWithListClientResource(config);

    }
}
