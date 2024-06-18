package com.bosch.example.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.ReverseData;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


public class ReverseController {
    @GetMapping("reverse/{word}")
    public ReverseData reverseMethod(@PathVariable String word) {
        StringBuffer buffer = new StringBuffer(word);
        buffer.reverse();
        String data = buffer.toString();

        if (word.equals(data)) {
            return new ReverseData(data, true);
        }
        return new ReverseData(data, false);
    }
}
