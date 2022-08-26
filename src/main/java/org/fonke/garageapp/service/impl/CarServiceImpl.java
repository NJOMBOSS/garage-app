package org.fonke.garageapp.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.fonke.garageapp.dto.CarDTO;
import org.fonke.garageapp.entity.Car;
import org.fonke.garageapp.exception.EntityNotFoundException;
import org.fonke.garageapp.exception.ErrorCodes;
import org.fonke.garageapp.exception.InvalidEntityException;
import org.fonke.garageapp.repository.CarRepository;
import org.fonke.garageapp.service.CarService;
import org.fonke.garageapp.validator.CarValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarDTO save(CarDTO carDTO) {
        List<String> errors = CarValidator.validate(carDTO);
        if(!errors.isEmpty()){
            log.error("Car is not valid{}",carDTO);
            throw new InvalidEntityException("the car is not valid", ErrorCodes.CAR_NOT_VALID, errors);
        }
        return CarDTO.fromEntity(carRepository.save(
               CarDTO.toEntity(carDTO)));
    }

    @Override
    public CarDTO findById(Long id) {
        if(id==null){
            log.error("Car ID is null");
            return  null;
        }
        Optional<Car> car = carRepository.findById(id);
        return Optional.of(CarDTO.fromEntity(car.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "No article with ID =" + id + "was not found in the DB",
                        ErrorCodes.CAR_NOT_FOUND)
        );
    }

    @Override
    public List<CarDTO> findAll() {
        return carRepository.findAll().stream()
                .map(CarDTO ::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CarDTO updateCar(CarDTO carDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("Car ID is null");
            return;
        }
        carRepository.deleteById(id);
    }

}
