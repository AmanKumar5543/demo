package com.example.people.services;
import com.example.people.entity.Artist;
import com.example.people.controllers.ArtistController;
import com.example.people.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service

public class ArtistServices{

    @Autowired
    public static ArtistRepository artistRepository;

    public Iterable<Artist> getArtist() {
        return artistRepository.findAll();

    }
    public Optional<Artist> getArtistById(@PathVariable ("id") Integer id){
        return artistRepository.findById(id);
    }

    public List<Artist> searchByName (@RequestParam (name ="name" , required = false)String name){
        return artistRepository.findByName(name);
    }

    public List<Artist> searchByInstrument (@RequestParam (name = "instrument" , required = false)String instrument){
        return artistRepository.findByInstrument(instrument);
    }

    public Artist updateArtist (@PathVariable  ("id") Integer id, @RequestBody Artist artist){
        return artistRepository.save(artist);
    }

    public boolean deleteArtist (@PathVariable ("id") Integer id , @RequestBody Artist a){
        artistRepository.deleteById(id);
        return true;
    }

    public static List<Artist> sortBySomeField(String field){
       return artistRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public static Page<Artist> pagination(int offset, int pagesize){
        return artistRepository.findAll(PageRequest.of(offset, pagesize));

    }

}
