package com.example.people.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter

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

}
