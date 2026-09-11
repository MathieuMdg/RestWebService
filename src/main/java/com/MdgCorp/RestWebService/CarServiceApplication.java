package com.MdgCorp.RestWebService;

import com.MdgCorp.RestWebService.entity.Car;
import com.MdgCorp.RestWebService.service.CarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CarService carService) {
        return (args) -> {
        };
    };


}
