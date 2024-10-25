package com.example.people.controllers;

import com.example.people.entity.Artist;
import com.example.people.repositories.ArtistRepository;
import com.example.people.services.ArtistServices;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ArtistController {

    private final ArtistRepository artistRepository;

    public ArtistController(final ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @GetMapping("/Artist")
    public Iterable<Artist> getArtist() {
        return this.artistRepository.findAll();
    }

    @GetMapping("/Artist/{id}")
    public Optional<Artist> getArtistById(@PathVariable ("id") Integer id) {
        return this.artistRepository.findById(id);
    }
    @GetMapping("/Artist/search/{name}")
    public List<Artist> searchByName (@RequestParam ( name = "name",required = false)String name ){
        if (name != null){
            return this.artistRepository.findByName(name);
        }else {
            return new ArrayList<>();
        }
    }

    @GetMapping("/Artist/searchOne/{instrument}")
    public List<Artist> searchByInstrument (@RequestParam (name = "instrument", required = false)String instrument){
        if (instrument != null){
            return this.artistRepository.findByInstrument(instrument);
        }else {
            return new ArrayList<>();
        }

    }

    @PostMapping("/Artist")
    public Artist createArtist(@RequestBody Artist artist) {
        return artistRepository.save(artist);
    }

    @PutMapping("/Artist/{id}")
    public Artist updateArtist(@PathVariable ("id") Integer id, @RequestBody Artist a) {
        Optional<Artist> getArtistByOptional = this.artistRepository.findById(id);

        if (!getArtistByOptional.isPresent()) {
            return null;
        }
        Artist updatedArtist = getArtistByOptional.get();

        if (a.getName() != null) {
            updatedArtist.setName(a.getName());
        }

        if (a.getInstrument() != null) {
            updatedArtist.setInstrument((a.getInstrument()));
        }

        if (a.getBooking_Charges() != 0) {
            updatedArtist.setBooking_Charges(a.getBooking_Charges());
        }

        Artist updateArtist = this.artistRepository.save(updatedArtist);
        return updateArtist;
    }

    @DeleteMapping ("/Artist/{id}")
    public boolean deleteArtist(@PathVariable ("id") Integer id){
        Optional<Artist> deleteById = this.artistRepository.findById(id);
        if (!deleteById.isPresent()){
            return false;
        }
        this.artistRepository.deleteById(id);
        return true;
    }
    @GetMapping("/Artist/sort/{field}")
    public  List<Artist> sortingByField(@PathVariable ("field") String field){
        return ArtistServices.sortBySomeField(field);
    }

    @GetMapping("/Artist/page/{offset}/{pageSize}")
    public Page<Artist> paginationOf (@PathVariable ("offSet") Integer offSet, @PathVariable ("pageSize") Integer pageSize){
        return ArtistServices.pagination(offSet,pageSize);
    }
}