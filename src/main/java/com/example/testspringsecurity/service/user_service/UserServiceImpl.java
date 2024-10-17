package com.example.testspringsecurity.service.user_service;

import com.example.testspringsecurity.entity.Orders;
import com.example.testspringsecurity.entity.Roles;
import com.example.testspringsecurity.entity.Users;
import com.example.testspringsecurity.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void createUser(Users users, Roles roles) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        users.setRolesSet(new HashSet<>(List.of(roles)));
        userRepository.save(users);
    }

    @Override
    public Users findUserById(long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public void updateUsers(Users users, Orders orders) {
        users.getOrdersList().add(orders);
        userRepository.save(users);
    }
}
