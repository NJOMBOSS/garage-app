package org.fonke.garageapp.service;

import org.fonke.garageapp.dto.CarDTO;

import java.util.List;

public interface CarService {


    CarDTO save(CarDTO carDTO );

    CarDTO  findById(Long id);

    List<CarDTO> findAll();

    CarDTO updateCar(CarDTO carDTO);

    void delete(Long id);
}
