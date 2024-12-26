package com.example.people.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter


@Entity
@Table(name = "set_list")
public class SetList {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;
    private List<String> songs;

    @ManyToOne
    @JsonBackReference
    private Artist artist;


}

