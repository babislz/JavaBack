package com.bosch.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bosch.example.model.Users;

public interface UsersJPARepository extends JpaRepository<Users, Long>{
    List<Users> findByUsername(String username);
    List<Users> findByEmail(String email);
}
