package com.example.testspringsecurity.service.user_service;

import com.example.testspringsecurity.entity.Orders;
import com.example.testspringsecurity.entity.Roles;
import com.example.testspringsecurity.entity.Users;

public interface UserService {

    void createUser(Users users, Roles roles);

    Users findUserById(long id);

    void updateUsers(Users users, Orders orders);
}
