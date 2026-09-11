package com.MdgCorp.RestWebService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contract {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @SequenceGenerator(name="person_seq", sequenceName="person_id_seq",allocationSize=1)
    private Long contractID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    LocalDate startDate;
    LocalDate endDate;


    //Constructors
    public Contract(){}

    public Contract(Person person, Car car, LocalDate startDate, LocalDate endDate){
        this.person = person;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    //Getters
    public Long getId() {
        return contractID;
    }

    public Car getCar() {
        return car;
    }

    public Person getPersons() {
        return person;
    }


    //Setters
    public void setId(Long id) {
        this.contractID = id;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setPersons(Person persons) {
        this.person = persons;
    }

}
