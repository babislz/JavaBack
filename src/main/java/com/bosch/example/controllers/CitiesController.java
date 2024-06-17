package com.bosch.example.controllers;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bosch.example.model.City;
// import com.bosch.example.repositories.CityJPARepository;
import com.bosch.example.services.CityService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CitiesController {

    @Autowired
    CityService repo;

    @GetMapping("/cities/{query}")
    public List<City> getSearch(@PathVariable String query) {
        if (query == null)
            throw new ResponseStatusException(
               HttpStatus.BAD_REQUEST, "The search query must be non-null."
            );
        
        return repo.findByCity(query);
    }

    @GetMapping("/cities")
    public List<City> getAll() {
        return repo.findByCity("");
    }
}