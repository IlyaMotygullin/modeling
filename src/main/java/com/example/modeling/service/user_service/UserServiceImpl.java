package com.example.modeling.service.user_service;

import com.example.modeling.entity.Role;
import com.example.modeling.entity.User;
import com.example.modeling.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    final BCryptPasswordEncoder passwordEncoder;

    final UserRepository userRepository;
    @Override
    public void createUser(User user, Role role) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleList(new ArrayList<>(List.of(role)));
        userRepository.save(user);
    }
}
