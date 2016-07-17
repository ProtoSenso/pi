package nl.ttstudios.pi;

import java.io.IOException;

import nl.ttstudios.pi.gpio.temperature.TemperatureManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
        //ListenGpioExample.listenGpioExample();
    	TemperatureManager tempManager = new TemperatureManager();
    }
}
