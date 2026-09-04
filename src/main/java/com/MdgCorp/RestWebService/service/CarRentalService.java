package com.MdgCorp.RestWebService.service;

import com.MdgCorp.RestWebService.entity.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarRentalService{

    //Attributs
    private final List<Car> listCar = new ArrayList<>();

    //Getters
    public List<Car> getListCar() {
        return listCar;
    }

    //Methods
    public void addCar(Car car){
        listCar.add(car);
    }
}
