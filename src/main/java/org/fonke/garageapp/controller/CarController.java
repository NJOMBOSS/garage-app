package org.fonke.garageapp.controller;

import org.fonke.garageapp.controller.api.CarApi;
import org.fonke.garageapp.dto.CarDTO;
import org.fonke.garageapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarController implements CarApi {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Override
    public CarDTO save(CarDTO carDTO) {
        return carService.save(carDTO);
    }

    @Override
    public CarDTO findById(Long idCar) {
        return carService.findById(idCar);
    }

    @Override
    public List<CarDTO> findAll() {
        return carService.findAll();
    }

    @Override
    public CarDTO updateCar(CarDTO carDTO) {
        return carService.updateCar(carDTO);
    }

    @Override
    public void delete(Long id) {
      carService.delete(id);
    }
}
