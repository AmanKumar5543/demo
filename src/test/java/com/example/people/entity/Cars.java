package com.example.people.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Cars")
public class Cars {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "Car_Model" )
    private String carModel;

    @Column(name = "HorsePower")
    private int horsePower;

//    @Column(name = "Fast_Car")
//    private boolean isFast;

    @Column(name = "Price")
    private double price;

    @Column (name = "Gerade")
    private char grade;

    public int getId() {
        return id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

//    public boolean isFast() {
//        return isFast;
//    }
//    public void setFast(boolean fast) {
//        isFast = fast;
//    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}
