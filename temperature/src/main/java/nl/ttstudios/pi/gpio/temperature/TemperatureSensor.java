package nl.ttstudios.pi.gpio.temperature;

import java.io.IOException;

import nl.ttstudios.pi.gpio.temperature.drivers.DS1820Dto;

public interface TemperatureSensor {
    public DS1820Dto readTemperature() throws IOException;

    public String printTemperature() throws IOException;
}
