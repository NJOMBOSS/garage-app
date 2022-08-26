package org.fonke.garageapp.controller.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.fonke.garageapp.dto.CarDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.fonke.garageapp.controller.util.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/car")
@Tag(name = "CAR")
public interface CarApi {

    @PostMapping("/create")
    CarDTO save(@RequestBody CarDTO carDTO);


    @GetMapping("/{idCar}")
    CarDTO findById(@PathVariable("idCar") Long idCar);


    @GetMapping("/all")
    List<CarDTO> findAll();

    @PutMapping("/update")
    CarDTO updateCar(@RequestBody CarDTO carDTO);

    @DeleteMapping("/delete/{idCar}")
    void delete(@PathVariable("idCar") Long id);
}
