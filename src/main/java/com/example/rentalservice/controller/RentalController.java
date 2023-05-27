package com.example.rentalservice.controller;

import com.example.rentalservice.model.Movie;
import com.example.rentalservice.service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rental")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @PutMapping("/movies/return/{id}")
    public ResponseEntity<Movie> returnMovie(@PathVariable Long id) {
        Movie movie = rentalService.getMovie(id);
        if (movie != null) {
            rentalService.returnMovie(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/movies/rent/{id}")
    public ResponseEntity<Movie> rentMovie(@PathVariable Long id) {
        Movie movie = rentalService.getMovie(id);
        if (movie != null) {
            rentalService.rentMovie(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
