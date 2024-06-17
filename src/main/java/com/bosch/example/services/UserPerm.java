package com.bosch.example.services;

import com.bosch.example.model.Users;

public interface UserPerm {
    Users loginByUsername(String username);
    Users loginByEmail(String email);
}
