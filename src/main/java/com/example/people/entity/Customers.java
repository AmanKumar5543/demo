package com.example.people.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Service;

@Entity
@Table (name = "Customers")
public class Customers {

    @Id
    @GeneratedValue
    int id ;

    @Column (name = "Name")
    String name;

    @Column (name = "Address")
    String address;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
