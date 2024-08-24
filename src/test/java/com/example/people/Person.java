package com.example.people;

import jakarta.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ROLL_NUMBER")
    private Integer rollNo;

    @Column(name = "IS_AVERAGE")
    private boolean isAverage;

    public Integer getId (){
        return this.getId();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }
    public Boolean getIsAverage(){
        return isAverage;
    }

    public void setIsAverage(boolean isAverage) {
        this.isAverage = isAverage;
    }
}

