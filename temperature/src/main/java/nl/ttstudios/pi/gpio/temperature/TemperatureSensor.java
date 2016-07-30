package nl.ttstudios.pi.gpio.temperature;

import java.io.IOException;

public interface TemperatureSensor {
    public String[] readTemperature() throws IOException;

    public String[] printTemperature() throws IOException;
}
