package com.nocountry.backend.service.impl;

import com.nocountry.backend.dto.CarDto;
import com.nocountry.backend.mapper.ICarMapper;
import com.nocountry.backend.model.Car;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.ObjectDeletedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nocountry.backend.repository.ICarRepository;
import com.nocountry.backend.service.ICarService;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements ICarService {

    private final ICarRepository repository;

    @Autowired
    ICarMapper carMapper;

    public CarServiceImpl(ICarRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CarDto> getCars(){
        return carMapper.CarEntityListToCarDTOList(repository.findAll());
    }

    @Override
    public CarDto saveCar(CarDto carDto) {
        return carMapper.CarToCarDto(repository.save(carMapper.CarDtoToCar(carDto)));
    }
    @Override
    public CarDto getCarById(Long id){
        Optional<Car> carEntity = repository.findById(id);
        if (carEntity.isPresent()) {
            return carMapper.CarToCarDto(carEntity.get());
        } else {
            throw new EntityNotFoundException("Car not found with id: " + id);
        }

    }

    @Override
    public CarDto updateCarById(Long id,CarDto carDetailsDto){
        Optional<Car> carEntity = repository.findById(id);
        if (carEntity.isPresent()) {
            Car car = carEntity.get();
            carMapper.updateCarFromDto(carDetailsDto,car);
            Car updatedCar = repository.save(car);
            return carMapper.CarToCarDto(updatedCar);
        } else {
            throw new EntityNotFoundException("Car not found with id: " + id);
        }
    }

    @Override
    public void deleteCar(Long id) {
        Optional<Car> car = repository.findById(id);
        if (car.isPresent()) {
            repository.delete(car.get());
        } else {
            throw new ObjectDeletedException("car with ID " + id + " can't be deleted.", id, "Car");
        }
    }

}