package com.bosch.example.repositories;

import com.bosch.example.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityJPARepository extends JpaRepository<City, Long> {
    List<City> findByNameContaining(String name);
}