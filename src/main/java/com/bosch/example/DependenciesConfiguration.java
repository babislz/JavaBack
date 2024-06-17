package com.bosch.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bosch.example.impl.DatabaseCitiesIndex;
import com.bosch.example.services.CityService;

@Configuration
public class DependenciesConfiguration {
    
    @Bean
    @Scope("singleton")
    public CityService cityService() {
        return new DatabaseCitiesIndex();
    }
}