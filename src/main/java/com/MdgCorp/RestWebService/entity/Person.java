package com.MdgCorp.RestWebService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Person {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @SequenceGenerator(name="person_seq", sequenceName="person_id_seq",allocationSize=1)
    private Long personID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private Contract contract;


    private String name;
    private String surname;
    private String mail;

    //Constructor
    public Person(){}


    //Setters
    public void setId(Long id) {
        this.personID = id;
    }

    public Contract getContract() {
        return contract;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getSurname() {
        return surname;
    }

    //Getters
    public Long getId() {
        return personID;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
