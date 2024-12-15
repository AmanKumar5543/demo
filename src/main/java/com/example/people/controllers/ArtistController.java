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
    @GetMapping
    public Iterable getAllArtist(@RequestParam(name = "firstName", required = false) String firstName,
                                 @RequestParam(name = "instrument", required = false) String instrument,
                                 @RequestParam(defaultValue = "0", name = "bookingPrice", required = false) Double bookingPrice,
                                 @RequestParam(name = "lastName", required = false) String lastName,
                                 @RequestParam(defaultValue = "0", required = false) int page,
                                 @RequestParam(defaultValue = "10", required = false) int size,
                                 @RequestParam(defaultValue = "asc", required = false) String sortDir) {

        if (firstName != null && instrument != null && bookingPrice != 0) {
            return this.artistServices.getArtistByNameAndInstrumentAndBookingPrice(firstName, instrument, bookingPrice);
        }
        if (firstName != null && instrument != null) {
            return this.artistServices.getArtistByNameAndInstrument(firstName, instrument);
        }
        if (firstName != null && bookingPrice != 0) {
            return this.artistServices.getArtistByFirstNameAndBookingPrice(firstName, bookingPrice);
        }
        if (firstName != null && lastName != null && page != 0) {
            return this.artistServices.getArtistByFullName(firstName, lastName);
        }
        if (firstName != null && lastName != null) {
            return this.artistServices.getArtistByFullNameSortedByBookingPrice(firstName, lastName, page, size, sortDir);
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
        if (instrument != null && bookingPrice != 0) {
            return this.artistServices.getArtistByInstrumentAndBookingPrice(instrument, bookingPrice);
        }

        if (firstName != null) {
            return this.artistServices.getArtistByFirstName(firstName);
        }
        if (instrument != null) {
            return this.artistServices.getArtistByInstrument(instrument);
        }
        if (bookingPrice != 0) {
            return this.artistServices.getArtistByBookingPrice(bookingPrice);
        }
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

    @GetMapping("/price-range")
    public List<Artist> getArtistsByPriceRange(
            @RequestParam(name = "instrument", required = false) String instrument,
            @RequestParam(defaultValue = "0", name = "minValue", required = false) double minBookingPrice,
            @RequestParam(defaultValue = "0", name = "maxValue", required = false) double maxBookingPrice) {
        if (instrument != null && minBookingPrice != 0 && maxBookingPrice != 0) {
            return artistServices.getArtistsByInstrumentAndBookingPriceBetween(instrument, minBookingPrice, maxBookingPrice);
        }
        if (minBookingPrice != 0 && maxBookingPrice != 0) {
            return artistServices.getArtistsByPriceRange(minBookingPrice, maxBookingPrice);
        }
        {
            return new ArrayList<>();
        }
    }


    //Get the artist records with booking price less than some amount
    @GetMapping("/less-than")
    public List<Artist> getArtistsByPriceLessThan(@RequestParam(name = "instrument", required = false) String instrument,
                                                  @RequestParam(defaultValue = "0", name = "bookingPrice", required = false) double bookingPrice) {
        if (instrument != null && bookingPrice != 0) {
            return artistServices.getArtistsByInstrumentAndBookingPriceLessThan(instrument, bookingPrice);
        }
        if (bookingPrice != 0) {
            return artistServices.getArtistsByPriceLessThan(bookingPrice);
        }
        return new ArrayList<>();
    }


    //Get the artist records with booking price greater than some amount
    @GetMapping("/greater-than")
    public List<Artist> getArtistsByPriceGreaterThan(@RequestParam(name = "instrument", required = false) String instrument,
                                                     @RequestParam(defaultValue = "0", name = "bookingPrice", required = false) double bookingPrice) {
        if (instrument != null && bookingPrice != 0) {
            return artistServices.getArtistsByInstrumentAndBookingPriceGreaterThan(instrument, bookingPrice);
        }
        if (bookingPrice != 0) {
            return artistServices.getArtistsByPriceGreaterThan(bookingPrice);
        }
        {
            return new ArrayList<>();
        }
    }


    //Sorting and Pagination of artist records on the basis of some field
    @GetMapping("/sort-and-page")
    public Page<Artist> getPaginatedAndSortedArtists(
            @RequestParam(defaultValue = "0") int page,    // Page number (0-based index)
            @RequestParam(defaultValue = "10") int size,  // Page size
            @RequestParam(defaultValue = "name") String sortBy, // Sort field
            @RequestParam(defaultValue = "asc") String sortDir // Sort direction
    ) {
        if (page != 0 && size != 0 && sortBy != null && sortDir != null) {
            return artistServices.getPaginatedAndSortedArtists(page, size, sortBy, sortDir);
        }
        if (page != 0 && size != 0) {
            return artistServices.findByPage(page, size);
        }
        {
            return null;
        }
    }

    // Get records sorted by some field like their name or instrument or bookingPrice in asc or desc order
    @GetMapping("/sort")
    public List<Artist> sortByField(
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir,
            @RequestParam(name = "firstName", required = false) String firstName
    ) {
        if (firstName != null && sortDir != null) {
            Sort.Direction sortDirection = Sort.Direction.fromString(sortDir.toUpperCase());
            return artistServices.getArtistSortedByFirstName(sortDirection);
        }
        {
            Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
            return this.artistServices.sortBySomeField(sort);
        }

    }

}