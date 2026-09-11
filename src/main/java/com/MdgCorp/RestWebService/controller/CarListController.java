package com.MdgCorp.RestWebService.controller;

import com.MdgCorp.RestWebService.entity.Car;
import com.MdgCorp.RestWebService.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class CarListController {

    private final CarService carService;

    public CarListController(CarService carService) {
        this.carService = carService;
    }

    // Get List of cars
    @GetMapping("/view/cars")
    @ResponseStatus(HttpStatus.OK)
    public String ViewListOfCars() {

        StringBuilder html = new StringBuilder();

        html.append("<html>")
                .append("<a href='/'><-- Back</a>")
                .append("<h1 style=\"text-align: center;\">List Of Cars</h1>")
                .append("<body>")
                .append("<p><ul>");

        for (Car car : carService.getCars()) {
            html.append("<li>")
                    .append("<a href='/view/cars/")
                    .append(car.getPlateNumber())
                    .append("'>")
                    .append(car.getPlateNumber())
                    .append("</a>")
                    .append("</li>");
        }

        html.append("</ul></p>")
                .append("</body>")
                .append("</html>");

        return html.toString();
    }


    // Get a car by plateNumber
    @GetMapping("/view/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public String Print(@PathVariable("plateNumber") String plateNumber) throws Exception {

        for (Car car : carService.getCars()) {
            if (Objects.equals(car.getPlateNumber(), plateNumber)) {
                return "<html>" +
                        "<body>" +
                        "<a href='/view/cars'><-- Back</a>" +
                        "<p>" + car.toString() + "</p>" +
                        "</body>" +
                        "</html>";
            }
        }

        return "";
    }

    @PutMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rentOrGetBack(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value = "rent", required = true) boolean rent
    ) throws Exception {

        for (Car car : carService.getCars()) {
            if (Objects.equals(car.getPlateNumber(), plateNumber)) {
                car.toggleRent();
            }
        }
    }

}
