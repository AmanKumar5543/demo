package com.example.people.controllers;

import com.example.people.entity.Artist;

import com.example.people.services.ArtistServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtistController {


    public final ArtistServices artistServices;

    @Autowired
    public ArtistController(final ArtistServices artistServices) {
        this.artistServices = artistServices;
    }
    // Get all records of artists
    @GetMapping()
    public Iterable getAllArtist() {
        return this.artistServices.getAllArtist();
    }
    // Get Artist as per their id.
    @GetMapping("/{id}")
    public Optional getArtistById(@PathVariable("id") Integer id) {
        return this.artistServices.getArtistById(id);
    }

    // Get Artist by their names.
    @GetMapping("/by-firstName")
    public List getArtistByName(@RequestParam(name = "n" ,required = false) String firstName) {
        if (firstName != null){
            return this.artistServices.getArtistByName(firstName);
        }else{
            return new ArrayList<>();
        }
    }
    //Get Artist by their instruments
    @GetMapping("/instrument")
    public List getArtistByInstrument(@RequestParam(name = "instrument",required = false)String instrument ){
        if (instrument != null){
            return this.artistServices.getArtistByInstrument(instrument);
        }else{
            return new ArrayList<>();
        }
    }
    //Get Artist by their name and instruments
    @GetMapping("/filterone")
    public List<Artist> getArtistByNameAndInstrument(@RequestParam String firstName ,
                                                     @RequestParam String instrument){
        return artistServices.getArtistByNameAndInstrument(firstName, instrument);
    }

    //Create a new artists Record
    @PostMapping()
    public Artist createArtist(@RequestBody Artist artist) {
        return this.artistServices.createArtist(artist);
    }
    //Update an artists record
    @PutMapping("/{id}")
    public Artist updateArtist(@PathVariable("id") Integer id, @RequestBody Artist a) {
        Optional<Artist> getArtistOptional = this.artistServices.getArtistById(id);

        if (!getArtistOptional.isPresent()) {
            return null;
        }
        Artist updatedArtist = getArtistOptional.get();

        if (a.getName().getFirstName() != null) {
            updatedArtist.getName().setFirstName(a.getName().getFirstName());
        }

        if (a.getName().getLastName() != null){
            updatedArtist.getName().setLastName(a.getName().getLastName());
        }
        if (a.getInstrument() != null) {
            updatedArtist.setInstrument(a.getInstrument());

        }
        if (a.getBookingPrice() != 0) {
            updatedArtist.setBookingPrice(a.getBookingPrice());
        }

        Artist updateArtist = this.artistServices.createArtist(updatedArtist);
        return updateArtist;
    }

    //Get artists records in the form of pages
    @GetMapping("/page")
    public Page<Artist> findByPage (
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2")int size){
        return this.artistServices.findByPage(page, size);
    }

    // Get records sorted by some field like their name or instrument or bookingPrice in asc or desc order
    @GetMapping("/sort")
    public List<Artist> sortByField (
            @RequestParam(defaultValue = "name")String sortBy,
            @RequestParam(defaultValue = "asc") String order
    )
    {
        Sort sort = order.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        return  this.artistServices.sortBySomeField(sort);
    }

    //Delete a record of artist from artists record
    @DeleteMapping("/{id}")
    public boolean deleteArtist (@PathVariable ("id") Integer id) {
        this.artistServices.deleteArtist(id);
        return true;
    }

    //Get the artist records with booking price less than some amount
    @GetMapping("/less-than")
    public List<Artist> getArtistsByPriceLessThan(@RequestParam double bookingPrice) {
        return artistServices.getArtistsByPriceLessThan(bookingPrice);
    }

    //Get the artist records with booking price greater than some amount
    @GetMapping("/greater-than")
    public List<Artist> getArtistsByPriceGreaterThan(@RequestParam double bookingPrice) {
        return artistServices.getArtistsByPriceGreaterThan(bookingPrice);
    }

    //Get the artist records with booking price in range of some amount
    @GetMapping("/price-range")
    public List<Artist> getArtistsByPriceRange(@RequestParam double minBookingPrice, @RequestParam double maxBookingPrice) {
        return artistServices.getArtistsByPriceRange(minBookingPrice, maxBookingPrice);
    }

    //Get the artist record by instrument and booking price
    @GetMapping("/filter")
    public List<Artist> getArtistsByInstrumentAndBookingPrice(
            @RequestParam String instrument,
            @RequestParam double minBookingPrice,
            @RequestParam double maxBookingPrice) {
        return artistServices.getArtistsByInstrumentAndBookingPrice(instrument, minBookingPrice, maxBookingPrice);
    }

    //Get the artist record by instrument and booking price less than some amount
    @GetMapping("/filter/less-than")
    public List<Artist> getArtistsByInstrumentAndBookingPriceLessThan(
            @RequestParam String instrument,
            @RequestParam double bookingPrice) {
        return artistServices.getArtistsByInstrumentAndBookingPriceLessThan(instrument, bookingPrice);
    }

    //Get the artist record by instrument and booking price greater than some amount
    @GetMapping("/filter/greater-than")
    public List<Artist> getArtistsByInstrumentAndBookingPriceGreaterThan(
            @RequestParam String instrument,
            @RequestParam double bookingPrice) {
        return artistServices.getArtistsByInstrumentAndBookingPriceGreaterThan(instrument, bookingPrice);
    }

    //Sorting and Pagination of artist records on the basis of some field
    @GetMapping("/sort-and-page")
    public Page<Artist> getPaginatedAndSortedArtists(
            @RequestParam(defaultValue = "0") int page,    // Page number (0-based index)
            @RequestParam(defaultValue = "10") int size,  // Page size
            @RequestParam(defaultValue = "name") String sortBy, // Sort field
            @RequestParam(defaultValue = "asc") String sortDir // Sort direction
    ) {
        return artistServices.getPaginatedAndSortedArtists(page, size, sortBy, sortDir);
    }

    //Getting records based on artist name , instrument and booking price
    @GetMapping("/filterTwo")
    public List<Artist> getArtistByNameAndInstrumentAndBookingPrice(@RequestParam String firstName,
                                                                    @RequestParam String instrument,
                                                                    @RequestParam double bookingPrice){
        return artistServices.getArtistByNameAndInstrumentAndBookingPrice(firstName, instrument, bookingPrice);
    }

    @GetMapping("/by-fullName")
    public List<Artist> getArtistByFullName (@RequestParam (name = "f",required = false)  String firstName,
                                             @RequestParam  (name = "l" ,required = false)String lastName){
        return artistServices.getArtistByFullName(firstName,lastName);
    }
    @GetMapping("/sort-by-firstName")
    public List<Artist> getArtistsSorted(
            @RequestParam(defaultValue = "ASC") String direction) {
        Sort.Direction sortDirection = Sort.Direction.fromString(direction.toUpperCase());
        return artistServices.getArtistSortedByFirstName(sortDirection);
    }


}
