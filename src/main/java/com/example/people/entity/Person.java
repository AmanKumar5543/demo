package com.example.people.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ROLL_NUMBER")
    private int rollNo ;

    @Column(name = "INFORMATION")
    private String info;

    @Column (name = "CLASS_NUMBER")
    private int  classNo ;

    public int getId (){
        return id ;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = this.name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

}
