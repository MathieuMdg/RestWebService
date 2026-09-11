package com.MdgCorp.RestWebService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Contract {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @SequenceGenerator(name="person_seq", sequenceName="person_id_seq",allocationSize=1)
    private Long contractID;

    @OneToMany(mappedBy = "contract", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Person> persons = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    //Getters
    public Long getId() {
        return contractID;
    }

    public Car getCar() {
        return car;
    }

    public List<Person> getPersons() {
        return persons;
    }


    //Setters
    public void setId(Long id) {
        this.contractID = id;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

}
