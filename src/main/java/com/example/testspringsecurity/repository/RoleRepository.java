package com.example.testspringsecurity.repository;

import com.example.testspringsecurity.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles, Long> {

    Optional<Roles> findByNameRole(String nameRole);
}
