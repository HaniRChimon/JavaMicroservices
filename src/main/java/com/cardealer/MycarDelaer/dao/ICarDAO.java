package com.cardealer.MycarDelaer.dao;

import com.cardealer.MycarDelaer.dto.Car;

import java.util.List;

public interface ICarDAO {
    Car save(Car car) throws Exception;

    List<Car> fetchAll();

    Car fetch(int id);

    void delete(int id);

}
