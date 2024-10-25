package com.example.people.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Artist")
public class Artist {

    @Id
    @GeneratedValue
    int id;

    @Column (name = "name")
    String name;

    @Column (name= "Instrument")
    String instrument;

    @Column (name = "Booking_Charges")
    int booking_Charges;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public int getBooking_Charges() {
        return booking_Charges;
    }

    public void setBooking_Charges(int booking_Charges) {
        this.booking_Charges = booking_Charges;
    }
}
