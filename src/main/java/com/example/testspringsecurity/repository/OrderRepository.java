package com.example.testspringsecurity.repository;

import com.example.testspringsecurity.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
