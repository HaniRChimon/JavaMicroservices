package com.cardealer.MycarDelaer.dao;

import com.cardealer.MycarDelaer.dto.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CarDAOStub implements ICarDAO {

    Map<Integer, Car> allCars = new HashMap<>();

    @Override
    public Car save(Car car) throws Exception {
        Integer carID = Integer.parseInt(car.CarId);
        allCars.put(carID, car);
        return car;
    }

    @Override
    public List<Car> fetchAll() {
        List<Car> returnCars = new ArrayList(allCars.values());
        return returnCars;
    }

    @Override
    public Car fetch(int id) {
        return allCars.get(id);
    }

    @Override
    public void delete(int id) {
        allCars.remove(id);

    }
}
