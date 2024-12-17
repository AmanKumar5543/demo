package com.example.people.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.people.entity.SetList;

public interface SetListRepository extends JpaRepository<SetList, String> {
    List<SetList> findByArtistId(int artistId);
}
