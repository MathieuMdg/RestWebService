package com.MdgCorp.RestWebService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Date;

@RestController
public class CarService {

    ///           ///
    ///   BASIC   ///
    ///           ///

    //Get List of cars
    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> listOfCars() {
        return Car.listCar;
    }

    //Get a car by plateNumber
    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception{
        for(int i = 0; i < Car.listCar.size(); i++){
            if(Objects.equals(Car.listCar.get(i).getPlateNumber(), plateNumber)){
                return Car.listCar.get(i);
            }
        }
        return null;
    }

    @PutMapping(value = "/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rentOrGetBack(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value="rent", required = true)boolean rent) throws Exception{
        System.out.println("non");
        for(Car car : Car.listCar){
            if(car.getPlateNumber().equals(plateNumber)){
                System.out.println("ouiiiiiiiiiiii");
                car.toggleRent();
            }
        }
    }

    ///          ///
    ///   VIEW   ///
    ///          ///

    //Get View List of cars
    @GetMapping("/view/cars")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String ViewListOfCars() {
        StringBuilder html = new StringBuilder();
        html.append("<html><body><ul>");
        for (Car car : Car.listCar) {
            html.append("<li><a href='/cars/").append(car.getPlateNumber()).append("'>").append(car.getPlateNumber()).append("</a></li>");
        }
        html.append("</ul></body></html>");
        return html.toString();
    }

}
