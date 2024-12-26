package com.example.people.controllers;

import com.example.people.entity.SetList;
import com.example.people.services.SetListService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@JsonFormat(with = {JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES})
@RequestMapping("/artists/{artistId}/set-lists")
public class SetListController {
    private final SetListService setListService;

    public SetListController(SetListService setListService) {
        this.setListService = setListService;
    }

    @PostMapping
    public SetList createSetList(@PathVariable("artistId") int artistId, @RequestBody SetList setList) {
        return setListService.create(artistId, setList);
    }

    @GetMapping
    public List<SetList> getAllSetLists(@PathVariable("artistId") int artistId) {
        return setListService.getByArtistId(artistId);
    }

    @DeleteMapping
    public boolean deleteById(@PathVariable("artistId") int artistId) {
        return setListService.deleteSetList(artistId);
    }

    @PutMapping
    public SetList updateSetList(@PathVariable("artistId") int artistId, @RequestBody SetList s) {
        List<SetList> getSetListOptional = this.setListService.getByArtistId(artistId);

        if (getSetListOptional.isEmpty()) {
            return null;
        }

        SetList updatedSetList = getSetListOptional.get(artistId);

        if (s.getTitle() != null) {
            updatedSetList.setTitle(s.getTitle());
        }
        if (s.getSongs() != null) {
            updatedSetList.setSongs(s.getSongs());
        }
        SetList updateSetlist = this.setListService.updateSetlist(artistId, updatedSetList);
        return updateSetlist;

    }
}
