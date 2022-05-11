package com.cardealer.MycarDelaer.service;

import com.cardealer.MycarDelaer.dao.ICarDAO;
import com.cardealer.MycarDelaer.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class carServiceStub implements IcarService {

    @Autowired
    private ICarDAO carDAO;

    public carServiceStub () {

    }

    public carServiceStub(ICarDAO carDAO){
        this.carDAO = carDAO;
    }
    @Override
    public Car fetchById(int id) {
      Car foundCar = carDAO.fetch(id);
        return foundCar;
    }

    @Override
    public void delete(int id) throws Exception{
        carDAO.delete(id);
    }

    @Override
    public Car save(Car car) throws Exception {
        return carDAO.save(car);
    }

    @Override
    public List <Car> fetchAll() {
        return carDAO.fetchAll();

    }
}
