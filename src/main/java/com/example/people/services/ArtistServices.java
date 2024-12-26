package com.example.people.services;

import com.example.people.entity.Artist;
import com.example.people.repositories.ArtistRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@JsonFormat(with = {JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES})
@Service
public class ArtistServices {

    public final ArtistRepository artistRepository;

    @Autowired
    public ArtistServices(final ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Iterable getAllArtist() {
        return artistRepository.findAll();
    }


    public List getArtistByFirstName(String firstName) {
        return artistRepository.findByName_FirstNameIgnoreCase(firstName);
    }

    public List getArtistByInstrument(String instrument) {
        return artistRepository.findByInstrumentIgnoreCase(instrument);
    }

    public List<Artist> getArtistByBookingPrice(double bookingPrice) {
        return artistRepository.findByBookingPrice(bookingPrice);
    }


    public Page<Artist> findByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return artistRepository.findAll(pageable);
    }


    public Artist updateArtist(Integer id, Artist a) {
        return artistRepository.save(a);
    }


    public List<Artist> getArtistsByPriceLessThan(double bookingPrice) {
        return artistRepository.findByBookingPriceLessThan(bookingPrice);
    }

    public List<Artist> getArtistsByPriceGreaterThan(double bookingPrice) {
        return artistRepository.findByBookingPriceGreaterThan(bookingPrice);

    }

    public List<Artist> getArtistsByPriceRange(double minBookingPrice, double maxBookingPrice) {
        return artistRepository.findByBookingPriceBetween(minBookingPrice, maxBookingPrice);
    }

    public List<Artist> getArtistsByInstrumentAndBookingPriceBetween(String instrument, double minBookingPrice, double maxBookingPrice) {
        return artistRepository.findByInstrumentIgnoreCaseAndBookingPriceBetween(instrument, minBookingPrice, maxBookingPrice);
    }

    public List<Artist> getArtistsByInstrumentAndBookingPriceLessThan(String instrument, double bookingPrice) {
        return artistRepository.findByInstrumentAndBookingPriceLessThan(instrument, bookingPrice);
    }

    public List<Artist> getArtistsByInstrumentAndBookingPriceGreaterThan(String instrument, double bookingPrice) {
        return artistRepository.findByInstrumentAndBookingPriceGreaterThan(instrument, bookingPrice);
    }

    public Page<Artist> getPaginatedAndSortedArtists(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return artistRepository.findAll(pageable);
    }


    public List<Artist> getArtistByNameAndInstrument(String firstName, String instrument) {
        return artistRepository.findByName_FirstNameIgnoreCaseAndInstrumentIgnoreCase(firstName, instrument);
    }

    public List<Artist> getArtistByInstrumentAndBookingPrice(String instrument, double bookingPrice) {
        return artistRepository.findByInstrumentIgnoreCaseAndBookingPrice(instrument, bookingPrice);
    }

    public List<Artist> getArtistByFirstNameAndBookingPrice(String firstName, double bookingPrice) {
        return artistRepository.findByName_firstNameAndBookingPrice(firstName, bookingPrice);
    }

    public List<Artist> getArtistByNameAndInstrumentAndBookingPrice(String firstName, String instrument, double bookingPrice) {
        return artistRepository.findByName_firstNameAndInstrumentAndBookingPrice(firstName, instrument, bookingPrice);
    }

    public List<Artist> getArtistByFullName(String firstName, String lastName) {
        return artistRepository.findByName_firstNameIgnoreCaseAndName_lastNameIgnoreCase(firstName, lastName);
    }

    public List<Artist> getArtistSortedByFirstName(Sort.Direction direction) {
        return artistRepository.findAll(Sort.by(direction, "name.firstName"));
    }

    public List<Artist> sortBySomeField(Sort sort) {
        return artistRepository.findAll(sort);
    }

    public Page<Artist> getArtistsByFirstNameAndSortByBookingPrice(String firstName, int page, int size, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by("bookingPrice").ascending() :
                Sort.by("bookingPrice").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return artistRepository.findByName_firstNameContainingIgnoreCase(firstName, pageable); // Use repository method
    }

    public Page<Artist> getArtistByLastNameAndSortByBookingPrice(String lastName, int page, int size, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by("bookingPrice").ascending() :
                Sort.by("bookingPrice").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return artistRepository.findByName_lastNameContainingIgnoreCase(lastName, pageable);
    }

    public Page<Artist> getArtistByInstrumentAndSortByBookingPrice(String instrument, int page, int size, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by("bookingPrice").ascending() :
                Sort.by("bookingPrice").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return artistRepository.findByInstrumentContainingIgnoreCase(instrument, pageable);
    }

    public Page<Artist> getArtistByFullNameSortedByBookingPrice(String firstName, String lastName, int page, int size, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by("bookingPrice").ascending() :
                Sort.by("bookingPrice").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return artistRepository.findByName_firstNameAndName_lastNameContainingIgnoreCase(firstName, lastName, pageable);
    }
//    public List<Artist> getArtistBySetListTitle(String title){
//        return artistRepository.findBySetList_titleIgnoreCase(title);
//    }


}
