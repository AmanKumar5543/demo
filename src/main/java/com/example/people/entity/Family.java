package com.example.people.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Family_Table")
public class Family {

    @Id
    @GeneratedValue
    public int id;

    @Column(name = "Name")
    public String name;
    @Column(name = "Designation")
    public String designation;
    @Column(name = "Age")
    public int age;
    @Column (name = "Role")
    public String role;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
