package com.example.rentalservice.service;

import com.example.rentalservice.model.Movie;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {

    private final RestTemplate restTemplate;
    private final String movieServiceAPIUrl = "http://localhost:8080/movieService/movies/";

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id) {
        return restTemplate.getForObject(movieServiceAPIUrl + id, Movie.class);
    }

    public void returnMovie(Long id) {
        restTemplate.put(movieServiceAPIUrl + "setAvailable/" + id, HttpEntity.EMPTY);
    }

    public void rentMovie(Long id) {
        restTemplate.put(movieServiceAPIUrl + "setUnavailable/" + id, HttpEntity.EMPTY);
    }
}
