package com.MdgCorp.RestWebService.controller;

import com.MdgCorp.RestWebService.entity.Car;
import com.MdgCorp.RestWebService.service.CarRentalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.annotation.PostConstruct;

import java.util.Random;

@RestController
public class MainPage {

    private final CarRentalService carRentalService;

    public MainPage(CarRentalService carRentalService) {
        this.carRentalService = carRentalService;
    }

    // Generate Random Cars
    @PostConstruct
    public void initializeCars() {
        Random random = new Random();
        String[] brands = {
                "Toyota",
                "BMW",
                "Mercedes",
                "Audi",
                "Renault",
                "Peugeot",
                "Citroen",
                "Ford",
                "Tesla",
                "Volkswagen"
        };
        for (int i = 0; i < 10; i++) {
            String brand = brands[random.nextInt(brands.length)];
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String numbers = "0123456789";
            StringBuilder plateNumber = new StringBuilder();
            for (int j = 0; j < 2; j++) {
                plateNumber.append(
                        characters.charAt(random.nextInt(characters.length()))
                );
            }
            plateNumber.append("-");
            for (int j = 0; j < 3; j++) {
                plateNumber.append(
                        numbers.charAt(random.nextInt(numbers.length()))
                );
            }
            plateNumber.append("-");
            for (int j = 0; j < 2; j++) {
                plateNumber.append(
                        characters.charAt(random.nextInt(characters.length()))
                );
            }
            double price = 10 + (90 * random.nextDouble());
            carRentalService.addCar(
                    new Car(plateNumber.toString(), brand, price)
            );
        }
    }

    // Main Page
    @GetMapping("/")
    public String hello() {
        return "<html>" +
                    "<h1 style=\"text-align: center;\">Welcome to MDG Corp rent service</h1>" +
                    "<a href='/view/cars'>" +
                        "<button>Cars List</button>" +
                    "</a>" +
                "</html>";
    }
}
