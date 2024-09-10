package com.example.people.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Bank")
public class Bank {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="Account_Number")
    private int accountNo;

    @Column(name = "Account_Holder_Name")
    private String name;

    @Column(name = "Account_Balance")
    private double balance;

    @Column(name = "Address")
    private String address;


    public int getId() {
        return id;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public static void main(String[] args) {

    }
}
