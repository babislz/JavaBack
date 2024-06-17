package com.bosch.example.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.ImaginaryExpoData;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ImaginaryExponential {
    @GetMapping("/imaexp")
    public ImaginaryExpoData imaginaryExponential(@RequestParam double A, @RequestParam double b) {
        double Re = A * Math.sin(b);
        double Im = A * Math.cos(b);
        
        return new ImaginaryExpoData(Re, Im);
    }
    
}
