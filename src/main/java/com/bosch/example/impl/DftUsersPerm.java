package com.bosch.example.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bosch.example.model.Users;
import com.bosch.example.repositories.UsersJPARepository;
import com.bosch.example.services.UserPerm;

@Component
public class DftUsersPerm implements UserPerm {
    
    @Autowired
    UsersJPARepository repo;

    @Override
    public Users loginByUsername(String username) {
        var users = repo.findByUsername(username);
        if (users.size() == 0)
            return null;
        
        return users.get(0);
    }

    @Override
    public Users loginByEmail(String email) {
        var users = repo.findByEmail(email);
        if (users.size() == 0)
            return null;
        
        return users.get(0);
    }
}

