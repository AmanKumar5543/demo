package com.example.people.entity;

import jakarta.persistence.*;
import com.example.people.controllers.EmployeeController;
import com.example.people.repositories.EmployeeRepository;
import com.example.people.services.EmployeeServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Entity
@Table

@SpringBootApplication
public class Employee {
    public static void main(String[] args) {
        SpringApplication.run(Employee.class, args);
    }


        @Id
        @GeneratedValue
        int id;

        @Column(name = "name")
        String name;

        @Column(name = "department")
        String department;

        @Column(name = "Salary")
        int salary;

        public int getId () {
            return id;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public String getDepartment () {
            return department;
        }

        public void setDepartment (String department){
            this.department = department;
        }

        public int getSalary () {
            return salary;
        }

        public void setSalary ( int salary){
            this.salary = salary;
        }
    }
