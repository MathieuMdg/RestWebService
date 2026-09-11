package com.MdgCorp.RestWebService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @SequenceGenerator(name="person_seq", sequenceName="person_id_seq",allocationSize=1)
    private Long personID;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Contract> contracts = new ArrayList<>();


    private String name;
    private String mail;

    //Constructor
    public Person(){}

    public Person(String name){this.name = name;}


    //Setters
    public void setId(Long id) {
        this.personID = id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }


    //Getters
    public Long getId() {
        return personID;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setName(String name) {
        this.name = name;
    }

}
