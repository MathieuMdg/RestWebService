package com.MdgCorp.RestWebService.service;

import com.MdgCorp.RestWebService.entity.Car;
import com.MdgCorp.RestWebService.entity.Contract;
import com.MdgCorp.RestWebService.entity.Person;
import com.MdgCorp.RestWebService.exception.NotSavedInDatabase;
import com.MdgCorp.RestWebService.repository.CarRepository;
import com.MdgCorp.RestWebService.repository.ContractRepository;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContractService {

    //Attributes
    // Specify in logs
    private static final Logger log = LoggerFactory.getLogger(ContractService.class);

    // Service access ContractRepository
    private final ContractRepository contractRepository;
    private final CarRepository carRepository;

    //Constructors
    public ContractService(ContractRepository contractRepository, CarRepository carRepository){
        this.contractRepository = contractRepository;
        this.carRepository = carRepository;
    }

    //Methods
    public void addContract(Contract contract){
        try {
            if(contract.getEndDate() == null){
                Car car = contract.getCar();
                car.toggleRent();
                carRepository.save(car);
            }
            contractRepository.save(contract);
            log.warn("Contract added : {}", contract);
        }
        catch (Exception e) {
            throw new NotSavedInDatabase("Can't add contract in database : " + e.getMessage());
        }


    }
}
