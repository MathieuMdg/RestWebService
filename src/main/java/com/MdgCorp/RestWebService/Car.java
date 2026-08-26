package com.MdgCorp.RestWebService;

import java.util.List;
import java.util.ArrayList;

public class Car {

    // Attributs
    private String plateNumber;
    private String brand;
    private double price;
    private boolean rent = false;
    static List<Car> listCar = new ArrayList<Car>();

    public Car(){Car.listCar.add(this);}

    public Car(String plateNumber, String brand, double price){
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        Car.listCar.add(this);
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
    public static List<Car> getListCar() {
        return listCar;
    }
    public boolean isRent() {
        return rent;
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

    //Methods
    static List<Car> listOfCars(){
        return Car.listCar;
    }

    public void toggleRent(){
        this.rent = !this.rent;
    }

}
