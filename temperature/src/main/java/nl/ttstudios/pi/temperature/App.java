package nl.ttstudios.pi.temperature;

import nl.ttstudios.pi.temperature.gpio.ListenGpioExample;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        ListenGpioExample.listenGpioExample();
    }
}
