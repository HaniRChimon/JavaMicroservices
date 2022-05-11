package com.cardealer.MycarDelaer.dao;

import com.cardealer.MycarDelaer.dto.Car;

public interface ICarDAO {
    Car save(Car car) throws Exception;

}
