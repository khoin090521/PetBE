package com.example.petbe.repositories;

import com.example.petbe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByGmail(String gmail);
    Boolean existsByGmail(String username);
}
