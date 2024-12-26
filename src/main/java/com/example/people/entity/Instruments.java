package com.example.people.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Instruments")
public class Instruments {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String instrumentId;

    @Column
    private String instrumentName;

    @Column
    private String instrumentType;

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }
}
