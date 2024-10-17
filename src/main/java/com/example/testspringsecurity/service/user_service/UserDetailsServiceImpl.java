package com.example.testspringsecurity.service.user_service;

import com.example.testspringsecurity.entity.Users;
import com.example.testspringsecurity.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetailsServiceImpl implements UserDetailsService {

    final UserRepository userRepository;

    public Users findUserByEmail(String email) {
        return userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = findUserByEmail(username);
        return User
                .builder()
                .username(users.getEmail())
                .password(users.getPassword())
                .authorities(users
                        .getRolesSet()
                        .stream()
                        .map(roles -> new SimpleGrantedAuthority(roles.getNameRole()))
                        .collect(Collectors.toList()))
                .build();
    }
}
