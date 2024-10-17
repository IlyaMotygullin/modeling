package com.example.testspringsecurity.service.order_service;

import com.example.testspringsecurity.entity.Orders;
import com.example.testspringsecurity.entity.Users;

public interface OrderService {

    void createOrder(Orders orders);

    void updateRole(Orders orders, Users users);
}
