package com.example.people.controllers;

import com.example.people.entity.SetList;
import com.example.people.services.SetListService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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

    @PutMapping({"setListId"})
    public SetList updateSetList(@PathVariable("artistId") int artistId, @PathVariable("setListId") String id, @RequestParam SetList s) {
        Optional<SetList> setLists = this.setListService.getBySetListId(id);

        if (setLists.isEmpty()) {
            return null;
        }

        SetList updatedSetList = setLists.get();

        if (s.getTitle() != null) {
            updatedSetList.setTitle(s.getTitle());
        }
        if (s.getSongs() != null) {
            updatedSetList.setSongs(s.getSongs());
        }
        SetList updateSetlist = this.setListService.updateSetlist(artistId, id, s);
        return updateSetlist;

    }
}
