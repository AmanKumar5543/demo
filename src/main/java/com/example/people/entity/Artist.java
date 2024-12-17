package com.example.people.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table
public class Artist {

    @Id
    @GeneratedValue
    int id;


    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    public Name name;

    @Column(name = "Instrument")
    String instrument;

    @Column(name = "Booking Price")
    private int bookingPrice;

    @OneToMany(mappedBy = "artist")
    private List<SetList> setLists;

    public List<SetList> getSetLists() {
        return setLists;
    }

    public void setSetLists(List<SetList> setLists) {
        this.setLists = setLists;
    }

    public int getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public int getBookingPrice() {
        return bookingPrice;
    }

    public void setBookingPrice(int bookingPrice) {
        this.bookingPrice = bookingPrice;
    }
}
