package com.bosch.example.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bosch.example.model.City;
import com.bosch.example.repositories.CityJPARepository;
import com.bosch.example.services.CityService;

public class DatabaseCitiesIndex implements CityService{
    @Autowired
    CityJPARepository repo;

    @Override
    public void save(City name) {
        repo.save(name);
    }

    @Override
    public List<City> findByCity(String name) {
        if(name.equals(""))
            return repo.findAll();

        return repo.findByNameContaining(name);
    }

}
