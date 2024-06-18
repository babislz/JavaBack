package com.bosch.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bosch.example.impl.DatabaseCitiesIndex;
import com.bosch.example.impl.DftEmailValidator;
import com.bosch.example.impl.DftPwdValidator;
import com.bosch.example.impl.DftUsersPerm;
import com.bosch.example.services.CityService;
import com.bosch.example.services.EmailValidator;
import com.bosch.example.services.PwdValidator;
import com.bosch.example.services.UserPerm;

@Configuration
public class DependenciesConfiguration {
    
    @Bean
    @Scope("singleton")
    public CityService cityService() {
        return new DatabaseCitiesIndex();
    }

    @Bean
    @Scope("singleton")
    public UserPerm userPerm() {
        return new DftUsersPerm();
    }

    @Bean
    @Scope("singleton")
    public PwdValidator pwdValidator() {
        return new DftPwdValidator();
    }

    @Bean
    @Scope("singleton")
    public EmailValidator emailValidator() {
        return new DftEmailValidator();
    }
}