package com.example.people.repositories;
import com.example.people.entity.Artist;
import com.example.people.controllers.ArtistController;
import com.example.people.services.ArtistServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist,Integer>, JpaRepository<Artist,Integer>, PagingAndSortingRepository<Artist,Integer> {
    List<Artist> findByName (String name);
    List<Artist> findByInstrument (String instrument);

}
