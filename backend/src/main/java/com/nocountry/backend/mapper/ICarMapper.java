package com.nocountry.backend.mapper;

import java.util.List;

import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.nocountry.backend.dto.CarDto;
import com.nocountry.backend.model.Car;

@Mapper(componentModel = "spring")
public interface ICarMapper {

    CarDto CarToCarDto(Car car);

    Car CarDtoToCar(CarDto carDto);

    List<CarDto> CarEntityListToCarDTOList(List<Car> allCar);

    @Mapping(target = "id", ignore = true)
    void updateCarFromDto(CarDto carDto, @MappingTarget Car car);

    @Condition
    default boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }
}