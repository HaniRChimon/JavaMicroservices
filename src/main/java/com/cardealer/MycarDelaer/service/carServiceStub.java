package com.cardealer.MycarDelaer.service;

import com.cardealer.MycarDelaer.dao.ICarDAO;
import com.cardealer.MycarDelaer.dto.Car;
import org.springframework.stereotype.Component;

@Component
public class carServiceStub implements IcarService {

    private ICarDAO carDAO;

    public carServiceStub () {

    }

    public carServiceStub(ICarDAO carDAO){
        this.carDAO = carDAO;
    }
    @Override
    public Car fetchById(int id) {
        Car car = new Car();
        car.setDesc("Jeep SRT");
        car.setCarID("83");
        return car;
    }

    @Override
    public Car save(Car car) throws Exception {
        return carDAO.save(car);
    }
}
