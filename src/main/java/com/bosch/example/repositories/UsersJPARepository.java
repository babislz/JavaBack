package com.bosch.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bosch.example.model.Users;

@Repository
public interface UsersJPARepository extends JpaRepository<Users, Long>{
    List<Users> findByUsername(String username);
    List<Users> findByEmail(String email);
}
