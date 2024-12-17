package com.example.people.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.people.entity.Artist;
import com.example.people.entity.SetList;
import com.example.people.repositories.ArtistRepository;
import com.example.people.repositories.SetListRepository;

@Service
public class SetListService {
    private final SetListRepository setListRepository;
    private final ArtistRepository artistRepository;

    public SetListService(SetListRepository setListRepository, ArtistRepository artistRepository) {
        this.setListRepository = setListRepository;
        this.artistRepository = artistRepository;
    }

    public SetList create(int artistId, SetList setList) {
        Artist artist = artistRepository
            .findById(artistId)
            .orElseThrow(() -> new RuntimeException("Artist not found"));

        setList.setArtist(artist);

        return setListRepository.save(setList);
    }

    public List<SetList> getAll(int artistId) {
        return setListRepository.findByArtistId(artistId);
    }
}
