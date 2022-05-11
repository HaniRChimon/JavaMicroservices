package com.cardealer.MycarDelaer.service;

import com.cardealer.MycarDelaer.dto.Car;

public interface IcarService {
    /**
     * fetch a car with a given ID.
     * @param id a unique identifier for a car.
     * @return the matching car or null if no car found.
     */

    Car fetchById(int id);

    Car save(Car car) throws Exception;

}
