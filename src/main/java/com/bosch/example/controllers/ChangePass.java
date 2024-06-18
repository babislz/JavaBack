package com.bosch.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChangePass {

    @PatchMapping("changepassword")
    public ResponseEntity<String> changePassword(@RequestParam String username, @RequestParam String oldPwd, 
    @RequestParam String newPwd, @RequestParam String repeatNewPwd){
        
    } 
}
