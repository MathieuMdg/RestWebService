package com.MdgCorp.RestWebService.service;

import com.MdgCorp.RestWebService.entity.Car;
import com.MdgCorp.RestWebService.entity.Person;
import com.MdgCorp.RestWebService.exception.NotSavedInDatabase;
import com.MdgCorp.RestWebService.repository.CarRepository;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    //Attributes
    // Specify in logs
    private static final Logger log = LoggerFactory.getLogger(CarService.class);

    // Service access UserRepository
    private final CarRepository carRepository;

    //Constructors
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }


    //Methods
    public void addCar(Car car){
        try {
            car.toggleRent();
            carRepository.save(car);
            log.warn("Car added : {}", car);
        }
        catch (Exception e) {
            throw new NotSavedInDatabase("Can't add car in database : " + e.getMessage());
        }
    }

    public List<Car> getCars(){
        return (List<Car>) carRepository.findAll();
    }

    public void carToggleRent(Car car, Boolean rent){
        try {
            car.setRent(rent);
            carRepository.save(car);
            log.warn("Car rent toggled : {}", car);
        }
        catch (Exception e) {
            throw new NotSavedInDatabase("Can't toggle rent : " + e.getMessage());
        }
    }
}
