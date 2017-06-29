package com.ttstudios.pi.temperature.drivers;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.ttstudios.pi.temperature.TemperatureDto;

public class DS1820Dto extends TemperatureDto {

    @NotBlank
    private String uID;

    @NotBlank
    private String sensorUID;

    @NotBlank
    private String deviceUID;

    @NotNull
    private double temperature;

    @NotBlank
    private String temperatureUnit;

    @NotBlank
    private String unixTimestamp;

    @NotBlank
    private String temperatureCRC;

    @NotNull
    private boolean isTemperatureOK;

    public DS1820Dto() {
        // empty constructor
    }

    public DS1820Dto(String uID, String sensorUID, String deviceUID, double temperature, String temperatureUnit, String unixTimestamp, String temperatureCRC, boolean isTemperatureOK) {
        super();
        this.uID = uID;
        this.sensorUID = sensorUID;
        this.deviceUID = deviceUID;
        this.temperature = temperature;
        this.temperatureUnit = temperatureUnit;
        this.unixTimestamp = unixTimestamp;
        this.temperatureCRC = temperatureCRC;
        this.isTemperatureOK = isTemperatureOK;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getSensorUID() {
        return sensorUID;
    }

    public void setSensorUID(String sensorUID) {
        this.sensorUID = sensorUID;
    }

    public String getDeviceUID() {
        return deviceUID;
    }

    public void setDeviceUID(String deviceUID) {
        this.deviceUID = deviceUID;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(String temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public String getUnixTimestamp() {
        return unixTimestamp;
    }

    public void setUnixTimestamp(String unixTimestamp) {
        this.unixTimestamp = unixTimestamp;
    }

    public String getTemperatureCRC() {
        return temperatureCRC;
    }

    public void setTemperatureCRC(String temperatureCRC) {
        this.temperatureCRC = temperatureCRC;
    }

    public boolean isTemperatureOK() {
        return isTemperatureOK;
    }

    public void setTemperatureOK(boolean isTemperatureOK) {
        this.isTemperatureOK = isTemperatureOK;
    }

    @Override
    public String toString() {
        return "DS1820Dto [uID=" + uID + ", sensorUID=" + sensorUID + ", deviceUID=" + deviceUID + ", temperature=" + temperature + ", temperatureUnit=" + temperatureUnit + ", unixTimestamp=" + unixTimestamp + ", temperatureCRC=" + temperatureCRC
            + ", isTemperatureOK=" + isTemperatureOK + "]";
    }

}
