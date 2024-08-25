package com.example.people.entity;
import jakarta.persistence.*;

@Entity
@Table (name = "HOUSE")
public class House  {
    @Id
    @GeneratedValue
    private int houseId ;

    @Column (name = "HOUSE_LOCATION")
    private String houseLocation;

    @Column (name = "EXPORT_ACCESS")
    private boolean exportAccess;

    @Column (name = "PRICE")
    private double price;

    @Column (name = "GRADE")
    private char grade;

    public int getHouseId() {
        return houseId;
    }

    public String getHouseLocation() {
        return houseLocation;
    }

    public void setHouseLocation(String houseLocation) {
        this.houseLocation = houseLocation;
    }

    public boolean isExportAccess() {
        return exportAccess;
    }

    public void setExportAccess() {
        this.exportAccess = exportAccess;
    }

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

    public static void main(String[] args) {

    }

}
