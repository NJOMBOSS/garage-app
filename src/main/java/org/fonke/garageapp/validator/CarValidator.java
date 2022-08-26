package org.fonke.garageapp.validator;

import org.fonke.garageapp.dto.CarDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CarValidator {
    public static List<String> validate(CarDTO carDTO){
        List<String> errors =new ArrayList<>();

        if(carDTO== null){
            errors.add("Please inquire model car");
            errors.add("Please inquire brand car");
            errors.add("Please inquire year car");
            errors.add("Please inquire color car");

            return  errors;
        }

        if(!StringUtils.hasLength(carDTO.getModel())){
            errors.add("Please inquire model car");
        }

        if(!StringUtils.hasLength(carDTO.getBrand())){
            errors.add("Please inquire brand car");
        }

        if(carDTO.getYear()==null){
            errors.add("Please inquire year car");
        }

        if(carDTO.getColor()==null){
            errors.add("Please inquire color car");
        }


        return errors;
    }
}
