package com.MdgCorp.RestWebService.controller;

import com.MdgCorp.RestWebService.entity.Car;
import com.MdgCorp.RestWebService.entity.Contract;
import com.MdgCorp.RestWebService.entity.Person;
import com.MdgCorp.RestWebService.service.CarService;
import com.MdgCorp.RestWebService.service.ContractService;
import com.MdgCorp.RestWebService.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.annotation.PostConstruct;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@RestController
public class MainPage {

    private final CarService carService;

    private final PersonService personService;

    private final ContractService contractService;

    public MainPage(CarService carService, PersonService personService, ContractService contractService) {
        this.carService = carService;
        this.personService = personService;
        this.contractService = contractService;
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
            carService.addCar(
                    new Car(plateNumber.toString(), brand, price)
            );
        }
    }

    // Generate Random Persons
    @PostConstruct
    public void initializePersons() {
        Random random = new Random();
        String[] names = {
                "Zaif",
                "Roland",
                "Marc",
                "Joseph",
                "Jacques",
                "Elise",
                "Clara",
                "Marin",
                "Jeanne",
                "Mathieu"
        };
        for (int i = 0; i < 10; i++) {

            personService.addPerson(
                    new Person(names[i])
            );
        }
    }

    @PostConstruct
    public void initializeContracts() {

        Random random = new Random();

        List<Person> persons = personService.getPersons();
        List<Car> cars = carService.getCars();

        for (int i = 0; i < 5; i++) {

            Person person = persons.get(random.nextInt(persons.size()));
            Car car = cars.get(random.nextInt(cars.size()));

            LocalDate startDate = LocalDate.now()
                    .minusDays(30 + random.nextInt(151));

            LocalDate endDate;

            if (random.nextInt(100) < 40) {
                endDate = null;
            } else {
                endDate = startDate.plusDays(1 + random.nextInt(30));
            }

            contractService.addContract(
                    new Contract(person, car, startDate, endDate)
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
