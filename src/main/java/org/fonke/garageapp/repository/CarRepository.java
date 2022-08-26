package org.fonke.garageapp.repository;

import org.fonke.garageapp.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
