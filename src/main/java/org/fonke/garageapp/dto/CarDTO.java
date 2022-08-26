package org.fonke.garageapp.dto;

import lombok.Builder;
import lombok.Data;
import org.fonke.garageapp.entity.Car;
import org.fonke.garageapp.entity.Color;

import java.util.Date;

@Builder
@Data
public class CarDTO {

    private Long id;
    private  String model;
    private String brand;
    private Date year;
    private Color color;

    public static CarDTO fromEntity(Car car){
        if(car == null){
            return null;
        }

        return CarDTO.builder()
                .id(car.getId())
                .model(car.getModel())
                .brand(car.getBrand())
                .year(car.getYear())
                .color(car.getColor())
                .build();
    }

    public static Car toEntity(CarDTO carDTO){
        if(carDTO == null){
            return  null ;
        }

        Car car= new Car();
        car.setId(carDTO.getId());
        car.setModel(carDTO.getModel());
        car.setBrand(carDTO.getBrand());
        car.setYear(carDTO.getYear());
        car.setColor(carDTO.getColor());

        return car;
    }
}
