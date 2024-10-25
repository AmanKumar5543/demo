package com.example.people.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "Students")
public class Students {

    @Id
    @GeneratedValue
    public int student_id ;

    @Column (name = "Name")
    public String name;

    @Column (name = "Roll_no")
    public int rollNo;

    @Column (name = "Address")
    public String student_address;

    public int getStudent_id() {
        return student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudent_address() {
        return student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }


    public static void main(String[] args) {

    }
}
