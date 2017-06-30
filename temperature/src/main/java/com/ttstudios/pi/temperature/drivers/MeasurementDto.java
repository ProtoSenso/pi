package com.ttstudios.pi.temperature.drivers;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ttseng on 5/6/17.
 */
public class MeasurementDto implements Serializable {

    private static final long serialVersionUID = 2624246646193210300L;

    private double measurement;

    private String measurementUnit;

    private String unixTimestamp;

    private String sensorUid;

    public double getMeasurement() {
        return measurement;
    }

    public void setMeasurement(double measurement) {
        this.measurement = measurement;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public String getUnixTimestamp() {
        return unixTimestamp;
    }

    public void setUnixTimestamp(String unixTimestamp) {
        this.unixTimestamp = unixTimestamp;
    }

    public String getSensorUid() {
        return sensorUid;
    }

    public void setSensorUid(String sensorUid) {
        this.sensorUid = sensorUid;
    }
}
