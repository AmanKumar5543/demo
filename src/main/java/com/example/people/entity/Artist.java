package com.example.people.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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

    @OneToMany(mappedBy = "artist", cascade = CascadeType.REMOVE)
    private List<SetList> setLists;

}
