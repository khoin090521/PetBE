package com.example.petbe.repositories;

import com.example.petbe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(
            "SELECT u FROM User u WHERE u.gmail = :gmail"
    )
    Optional<User> findByGmail(@Param("gmail") String gmail);

    Boolean existsByGmail(String gmail);
}
