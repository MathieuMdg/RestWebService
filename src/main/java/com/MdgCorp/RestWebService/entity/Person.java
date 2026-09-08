package com.MdgCorp.RestWebService.entity;

import jakarta.persistence.*;

@Entity
public class Person {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @SequenceGenerator(name="person_seq", sequenceName="person_id_seq",allocationSize=1)
    private Long id;

    private String name;
    private String surname;
    private String mail;

    //Constructor
    public Person(){}


    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    //Getters
    public Long getId() {
        return id;
    }
}
