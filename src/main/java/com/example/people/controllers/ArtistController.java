package com.example.people.controllers;

import com.example.people.entity.Artist;
import com.example.people.services.ArtistServices;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Data
@Getter
@Setter

@RestController

@RequestMapping("/artists")
public class ArtistController {

    @JsonFormat(with = {JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES})

    public final ArtistServices artistServices;

    @Autowired
    public ArtistController(final ArtistServices artistServices) {
        this.artistServices = artistServices;
    }

    // Get all records of artists
    @GetMapping
    public Iterable getAllArtist(@RequestParam(name = "firstName", required = false) String firstName,
                                 @RequestParam(name = "instrument", required = false) String instrument,
                                 @RequestParam(defaultValue = "0", name = "bookingPriceMin", required = false) Double bookingPriceMin,
                                 @RequestParam(name = "bookingPriceMax", required = false) Double bookingPriceMax,
                                 @RequestParam(name = "lastName", required = false) String lastName,
                                 @RequestParam(defaultValue = "0", required = false) int page,
                                 @RequestParam(defaultValue = "10", required = false) int size,
                                 @RequestParam(defaultValue = "asc", required = false) String sortDir,
                                 @RequestParam(name = "Title", required = false) String title) {

//        if (firstName != null && instrument != null && bookingPrice != 0) {
//            return this.artistServices.getArtistByNameAndInstrumentAndBookingPrice(firstName, instrument, bookingPrice);
//        }

//        if (firstName != null && bookingPrice != 0) {
//            return this.artistServices.getArtistByFirstNameAndBookingPrice(firstName, bookingPrice);
//        }

        if (instrument != null && bookingPriceMin != null && bookingPriceMax != null) {
            return artistServices.getArtistsByInstrumentAndBookingPriceBetween(instrument, bookingPriceMin, bookingPriceMax);
        }

        if (firstName != null && lastName != null && page != 0) {
            return artistServices.getArtistByFullNameSortedByBookingPrice(firstName, lastName, page, size, sortDir);


        }
        if (firstName != null && lastName != null) {
            return artistServices.getArtistByFullName(firstName, lastName);
        }
        {
            if (firstName != null && page != 0) {
                return this.artistServices.getArtistsByFirstNameAndSortByBookingPrice(firstName, page, size, sortDir);
            }
        }
        if (lastName != null && page != 0) {
            return this.artistServices.getArtistByLastNameAndSortByBookingPrice(lastName, page, size, sortDir);
        }
        if (instrument != null && page != 0) {
            return this.artistServices.getArtistByInstrumentAndSortByBookingPrice(instrument, page, size, sortDir);
        }
        if (firstName != null && instrument != null) {
            return this.artistServices.getArtistByNameAndInstrument(firstName, instrument);
        }
//        if (instrument != null && bookingPrice != 0) {
//            return this.artistServices.getArtistByInstrumentAndBookingPrice(instrument, bookingPrice);
//        }

        if (firstName != null) {
            return this.artistServices.getArtistByFirstName(firstName);
        }
        if (instrument != null) {
            return this.artistServices.getArtistByInstrument(instrument);
        }
//        if(title != null){
//            return this.artistServices.getArtistBySetListTitle(title);
//        }
//        if (bookingPrice != 0) {
//            return this.artistServices.getArtistByBookingPrice(bookingPrice);
//        }
        return this.artistServices.getAllArtist();
    }

    // Get Artist as per their id.
    @GetMapping("/{id}")
    public Optional getArtistById(@PathVariable("id") Integer id) {
        return this.artistServices.artistRepository.findById(id);
    }


    //Create a new artists Record
    @PostMapping
    public Artist createArtist(@RequestBody Artist artist) {
        return this.artistServices.artistRepository.save(artist);
    }


    //Update an artists record
    @PutMapping("/{id}")
    public Artist updateArtist(@PathVariable("id") Integer id, @RequestBody Artist a) {
        Optional<Artist> getArtistOptional = this.artistServices.artistRepository.findById(id);

        if (!getArtistOptional.isPresent()) {
            return null;
        }
        Artist updatedArtist = getArtistOptional.get();

        if (a.getName().getFirstName() != null) {
            updatedArtist.getName().setFirstName(a.getName().getFirstName());
        }

        if (a.getName().getLastName() != null) {
            updatedArtist.getName().setLastName(a.getName().getLastName());
        }
        if (a.getInstrument() != null) {
            updatedArtist.setInstrument(a.getInstrument());

        }
        if (a.getBookingPrice() != 0) {
            updatedArtist.setBookingPrice(a.getBookingPrice());
        }

        return this.artistServices.artistRepository.save(updatedArtist);
    }


    //Delete a record of artist from artists record
    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable("id") Integer id) {
        this.artistServices.artistRepository.deleteById(id);

    }
}