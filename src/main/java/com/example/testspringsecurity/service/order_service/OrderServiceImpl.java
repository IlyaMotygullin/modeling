package com.example.testspringsecurity.service.order_service;

import com.example.testspringsecurity.entity.Orders;
import com.example.testspringsecurity.entity.Users;
import com.example.testspringsecurity.repository.OrderRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderServiceImpl implements OrderService {

    final OrderRepository orderRepository;

    @Override
    public void createOrder(Orders orders) {
        orderRepository.save(orders);
    }

    @Override
    public void updateRole(Orders orders, Users users) {
        orders.setUsers(users);
        orderRepository.save(orders);
    }
}
