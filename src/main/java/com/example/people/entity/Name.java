package com.example.people.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "name")
public class Name {

    @Id
    @GeneratedValue
    int nameId;

    @Column(name = "firstName")
    String firstName;

    @Column(name = "lastName")
    String lastName;

    @OneToOne(mappedBy = "name")
    @JsonBackReference
    public Artist artist;

    public int getNameId() {
        return nameId;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
