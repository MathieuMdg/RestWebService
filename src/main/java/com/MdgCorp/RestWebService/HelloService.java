package com.MdgCorp.RestWebService;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.random.*;

@RestController
public class HelloService {
    @GetMapping("/")
    public String hello() {
        for(int i = 0; i<10; i++){
            Random random = new Random();
            Random r = new Random();
            String plateNumber = Integer.toString(random.nextInt(9000) + 1000);
            Car c = new Car(plateNumber, "MdgCar",r.nextDouble());
        }
        return "<h1 style=\"text-align: center;\">Welcome to the MDG Corp rent service</h1> <a href='/cars'><button>Cars List</button>";
    }
}