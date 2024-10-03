package com.example.modeling.service.user_service;

import com.example.modeling.entity.Role;
import com.example.modeling.entity.User;
import com.example.modeling.repository.RoleRepository;
import com.example.modeling.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    final RoleRepository roleRepository;

    final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void createUser(User user) {
        Role role = roleRepository.findByNameRole("USER").get();
        user.setRoleList(List.of(role));
        role.setUserList(List.of(user));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        roleRepository.save(role);
        userRepository.save(user);
    }
}
