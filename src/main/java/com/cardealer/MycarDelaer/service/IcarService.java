package com.cardealer.MycarDelaer.service;

import com.cardealer.MycarDelaer.dto.Car;

import java.util.List;

public interface IcarService {
    /**
     * fetch a car with a given ID.
     * @param id a unique identifier for a car.
     * @return the matching car or null if no car found.
     */

    Car fetchById(int id);

    void delete(int id) throws Exception;

    Car save(Car car) throws Exception;

    List<Car> fetchAll();

}
