package com.example.people.repositories;

import com.example.people.entity.SetList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SetListRepository extends JpaRepository<SetList, String> {
    List<SetList> findByArtistId(int artistId);

    boolean deleteByArtistId(int artistId);
}
