package com.example.people.repositories;

import com.example.people.entity.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, Integer>, JpaRepository<Artist, Integer> {
    List<Artist> findByName_FirstNameIgnoreCase(String firstName);

    List<Artist> findByInstrumentIgnoreCase(String instrument);

    List<Artist> findByBookingPrice(double bookingPrice);

    List<Artist> findByBookingPriceLessThan(double bookingPrice);

    List<Artist> findByBookingPriceGreaterThan(double bookingPrice);

    @Query("SELECT a FROM Artist a WHERE a.bookingPrice BETWEEN :minBookingPrice AND :maxBookingPrice")
    List<Artist> findByBookingPriceBetween(@Param("minBookingPrice") double minBookingPrice, @Param("maxBookingPrice") double maxBookingPrice);

    List<Artist> findByInstrumentIgnoreCaseAndBookingPriceBetween(String instrument, double minBookingPrice, double maxBookingPrice);

    List<Artist> findByInstrumentAndBookingPriceLessThan(String instrument, double bookingPrice);

    List<Artist> findByInstrumentAndBookingPriceGreaterThan(String instrument, double bookingPrice);

    Page<Artist> findAll(Pageable pageable);

    List<Artist> findByName_FirstNameIgnoreCaseAndInstrumentIgnoreCase(String firstName, String instrument);

    List<Artist> findByName_firstNameAndInstrumentAndBookingPrice(String firstName, String instrument, double bookingPrice);

    List<Artist> findByName_firstNameIgnoreCaseAndName_lastNameIgnoreCase(String firstName, String lastName);

    List<Artist> findByInstrumentIgnoreCaseAndBookingPrice(String instrument, double bookingPrice);

    List<Artist> findByName_firstNameAndBookingPrice(String firstName, double bookingPrice);

    Page<Artist> findByName_firstNameAndName_lastNameContainingIgnoreCase(String firstName, String lastName, Pageable pageable);

    Page<Artist> findByName_firstNameContainingIgnoreCase(String firstName, Pageable pageable);

    Page<Artist> findByName_lastNameContainingIgnoreCase(String lastName, Pageable pageable);

    Page<Artist> findByInstrumentContainingIgnoreCase(String instrument, Pageable pageable);

//    List<Artist> findBySetList_titleIgnoreCase(String title);
}



