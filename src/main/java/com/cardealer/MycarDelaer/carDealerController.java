package com.cardealer.MycarDelaer;


import com.cardealer.MycarDelaer.dto.Car;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ResourceBundle;

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
    /**
     * Handle the root (/) endpoint and return a start page.
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "Start";
    }

    @GetMapping("/cars")
    public ResponseEntity fetchAllCars(){
        return new ResponseEntity(HttpStatus.OK);
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
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Create new car object, give the data provided
     *
     * return one of the following status codes:
     * 201: successfully created a new car.
     * 409: unable to create a car, because it already exists.
     * @param car a JSON represenation of a car object.
     * @return the newly created car object .
     */

    @PostMapping(value = "/createcar", consumes = "application/json", produces = "application/json")
    public Car createCar(@RequestBody Car car){
        int i = 1 + 1;
        return car;
    }

    @DeleteMapping("/car/{id}/")
    public ResponseEntity deleteCar (@PathVariable("id") String Id){
        return new ResponseEntity(HttpStatus.OK);
    }
}