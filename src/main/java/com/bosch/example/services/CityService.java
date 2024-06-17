package com.bosch.example.services;

import java.util.List;

import com.bosch.example.model.City;

public interface CityService {
    void save(City name);
    List<City> findByCity(String name);
}