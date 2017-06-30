package com.ttstudios.pi.transform;

import com.ttstudios.pi.temperature.drivers.DS1820Dto;
import com.ttstudios.pi.temperature.drivers.MeasurementDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

/**
 * Created by ttseng on 5/6/17.
 */
@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public abstract class SensorToDtoMapper {

    @Mapping(target = "measurementUnit", source = "temperatureUnit")
    @Mapping(target = "sensorUid", source = "sensorUID")
    @Mapping(target = "measurement", source = "temperature")
    public abstract MeasurementDto toMeasurement(DS1820Dto dto);

}
