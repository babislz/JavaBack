package com.bosch.example.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.impl.DftEmailValidator;
import com.bosch.example.impl.DftPwdValidator;
import com.bosch.example.model.Users;
import com.bosch.example.repositories.UsersJPARepository;
import com.bosch.example.services.UserPerm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

    @Autowired
    DftPwdValidator pwdValidator;

    @Autowired
    DftEmailValidator emailValidator;
    
    @Autowired
    UserPerm userPerm;

    @Autowired
    UsersJPARepository repo;

    @PostMapping("create")
    public ResponseEntity<String> createEntity(@RequestBody Users user){
   
        String username = user.getUsername();
        String email = user.getEmail();
        // String pwd = user.getPassword();

        if(username == null || username.length() < 4) {
            return ResponseEntity.badRequest()
                .body("This username is too short.");
        }

        if(!emailValidator.validate(email)) {
            return ResponseEntity.badRequest()
                .body("Invalid email address.");
        }

        if(userPerm.loginByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest()
                .body("This username already exists.");
        }

        if(!pwdValidator.validate(user.getPassword())) {
            return ResponseEntity.badRequest()
                .body("Invalid password!");
        }

        repo.save(user);

        return ResponseEntity.ok("User created successfully");
    }
}
