package com.MdgCorp.RestWebService.entity;

import jakarta.persistence.*;

@Entity
public class Car {

    // Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
    @SequenceGenerator(name = "car_seq", sequenceName = "car_id_seq", allocationSize = 1)
    private Long id;

    private String plateNumber;
    private String brand;
    private double price;
    private boolean rent = false;

    //Constructor
    public Car(){}

    public Car(String plateNumber, String brand, double price){
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
    }

    //Getters
    public String getPlateNumber() {
        return plateNumber;
    }
    public String getBrand() {
        return brand;
    }
    public double getPrice() {
        return price;
    }
    public boolean isRent() {
        return rent;
    }
    public Long getId() {
        return id;
    }

    //Setters
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setRent(boolean rent) {
        this.rent = rent;
    }
    public void setId(Long id) {
        this.id = id;
    }

    //Methods
    public void toggleRent(){
        this.rent = !this.rent;
    }

    @Override
    public String toString(){
        return "<p>{<br>" +
                "<span> Platenumber : " + this.plateNumber +
                "<br><span> Brand : " + this.brand +
                "<br><span> Price : " + this.price +
                "<br><span> Rent : " + this.rent +
                "<br>}</p>";
    }

}
