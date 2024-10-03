package com.example.modeling.repository;

import com.example.modeling.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailUser(String emailUser);
}
