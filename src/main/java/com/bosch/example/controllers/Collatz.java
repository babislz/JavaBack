package com.bosch.example.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.CollatzData;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Collatz {
    @GetMapping("/collatz")
    public CollatzData collatzConjecture(@RequestParam int current, @RequestParam int step) {
        int new_current = current;
        for (int i = 0; i < step; i++) {
            if(new_current % 2 == 0){
                new_current = new_current / 2;
            } else {
                new_current = 3 * new_current + 1;
            }
        }
        return new CollatzData(new_current);
    }
}
