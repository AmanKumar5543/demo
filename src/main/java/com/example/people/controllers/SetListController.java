package com.example.people.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.people.entity.SetList;
import com.example.people.services.SetListService;

@RestController
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
        return setListService.getAll(artistId);
    }
}
