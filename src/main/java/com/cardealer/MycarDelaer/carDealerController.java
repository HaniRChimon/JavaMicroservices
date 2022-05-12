package com.cardealer.MycarDelaer;


import com.cardealer.MycarDelaer.dto.Car;
import com.cardealer.MycarDelaer.service.IcarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller for carDealer endpoints and web UI.
 * <p>
 *     this class handle the CRUD operations for My Car Dealer , via HTTP actions.
 * <p>
 *     this class also servers HTML based web pages, for UI interactions with car model.
 * </p>
 * </p>
 * @author Hani Chimon
 */

@Controller
public class carDealerController {

    public String id;
    @Autowired
    IcarService carService;


    /**
     * Handle the root (/) endpoint and return a start page.
     * @return
     */

    @RequestMapping("/")
    public String index(Model model) {
        Car car = new Car();
        car.setDescription("SRT package HEMI V6.7");
        car.setYear("2014");
        car.setModel("Jeep");
        car.setColor("Black");
        car.setCity("Chicago");
        car.setCarId("1003");
        model.addAttribute(car);
        return "start";
    }

    @GetMapping("/cars")
    @ResponseBody
    public List<Car> fetchAllCars(){
        return carService.fetchAll();
    }

    /**
     * Fetch a car with the given ID.
     *
     * Given paramenter id, find a car that corresponds to this unique ID.
     *
     * returns one of the following status code:
     * 200 - car found
     * 400 - car not found
     * @param id a unique identifier for this car
     * @return
     */
    @GetMapping("/car/{id}/")
    public ResponseEntity fetchCarById(@PathVariable("id") String id){
        Car foundCar = carService.fetchById(Integer.parseInt(id));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(foundCar, headers, HttpStatus.OK);
    }

    /**
     * Create new car object, give the data provided
     *
     * return one of the following status codes:
     * 201: successfully created a new car.
     * 409: unable to create a car, because it already exists.
     * @param car a JSON representation of a car object.
     * @return the newly created car object .
     */

    @PostMapping(value = "/createCar", consumes = "application/json", produces = "application/json")
    public Car createCar(@RequestBody Car car){
        Car newCar = null;
        try {
            newCar = carService.save(car);
        } catch (Exception e) {
            //TODO add Logging
        }
        return newCar;
    }

    @RequestMapping("/saveCar")
    public String saveCar (Car car){
        try {
            carService.save(car);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "start";
    }

    @DeleteMapping("/car/{id}/")
    public ResponseEntity deleteCar (@PathVariable("id") String Id){
        try {

            carService.delete(Integer.parseInt(id));
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/model")
    public ResponseEntity searchCars(@RequestParam(value = "searchTerm", required=false, defaultValue = "None") String searchTerm){
        return new ResponseEntity(HttpStatus.OK);
    }


}