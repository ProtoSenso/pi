package com.ttstudios.pi.temperature;

import java.io.IOException;

import com.ttstudios.pi.temperature.drivers.DS1820Dto;

public interface TemperatureSensor {
    public DS1820Dto readTemperature() throws IOException;

    public String printTemperature() throws IOException;
}
