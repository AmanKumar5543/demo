package com.example.people.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/artists/instruments")
public class InstrumentController {

    // Predefined list of instruments
    private static final List<String> INSTRUMENTS = Arrays.asList("Guitar", "Piano", "Violin", "Drums", "Flute");

    /**
     * Endpoint to get the list of available instruments
     *
     * @return List of instruments
     */
    @GetMapping("/options")
    public ResponseEntity<List<String>> getAvailableInstruments() {
        return ResponseEntity.ok(INSTRUMENTS);
    }

    /**
     * Endpoint to select an instrument
     *
     * @param selectedInstrument The instrument chosen by the user
     * @return Confirmation message or error
     */
    @PostMapping("/choose")
    public ResponseEntity<String> chooseInstrument(@RequestParam String selectedInstrument) {
        if (INSTRUMENTS.contains(selectedInstrument)) {
            return ResponseEntity.ok("You have selected: " + selectedInstrument);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid instrument. Please choose from the available options.");
        }
    }
}
