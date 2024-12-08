package com.example.people.repositories;

import com.example.people.entity.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist,Integer> , JpaRepository<Artist,Integer> {
    List<Artist>findByName_FirstName(String firstName);
    List<Artist>findByInstrument(String instrument);
    List<Artist>findByBookingPrice(double bookingPrice);
    List<Artist> findByBookingPriceLessThan(double bookingPrice);
    List<Artist> findByBookingPriceGreaterThan(double bookingPrice);
    @Query("SELECT a FROM Artist a WHERE a.bookingPrice BETWEEN :minBookingPrice AND :maxBookingPrice")
    List<Artist> findByBookingPriceBetween(@Param("minBookingPrice") double minBookingPrice, @Param("maxBookingPrice") double maxBookingPrice);
    List<Artist> findByInstrumentAndBookingPriceBetween(String instrument, double minBookingPrice, double maxBookingPrice);
    List<Artist> findByInstrumentAndBookingPriceLessThan(String instrument, double bookingPrice);
    List<Artist> findByInstrumentAndBookingPriceGreaterThan(String instrument, double bookingPrice);
    Page<Artist> findAll(Pageable pageable);
    List<Artist> findByName_FirstNameAndInstrument(String firstName, String instrument);
    List<Artist> findByName_firstNameAndInstrumentAndBookingPrice(String firstName , String instrument, double bookingPrice);
    List<Artist> findByName_firstNameAndName_lastName (String firstName ,String lastName);
    List<Artist> findByInstrumentAndBookingPrice (String instrument ,double bookingPrice);
    List <Artist> findByName_firstNameAndBookingPrice(String firstName,double bookingPrice);

}



