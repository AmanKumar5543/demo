package com.example.people.services;

import com.example.people.entity.Artist;
import com.example.people.entity.SetList;
import com.example.people.repositories.ArtistRepository;
import com.example.people.repositories.SetListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<SetList> getByArtistId(int artistId) {
        return setListRepository.findByArtistId(artistId);
    }

    public boolean deleteSetList(int artistId) {
        List<SetList> deleteOptional = this.setListRepository.findByArtistId(artistId);

        if (!deleteOptional.isEmpty()) {
            setListRepository.deleteByArtistId(artistId);
            return true;
        }
        return false;


    }

    public SetList updateSetlist(int artistId, String id, SetList setList) {
        return setListRepository.save(setList);
    }

    public Optional<SetList> getBySetListId(String id) {
        return setListRepository.findById(id);
    }
}
