package com.example.modeling.service.user_service;

import com.example.modeling.exception.UserNotFound;
import com.example.modeling.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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
public class UserDetailServiceImpl implements UserDetailsService {

    final UserRepository userRepository;

    public com.example.modeling.entity.User findUserByEmail(String email) throws UserNotFound {
        return userRepository
                .findByEmailUser(email)
                .orElseThrow(() -> new UserNotFound("Пользователь: " + email + " не найден"));
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.modeling.entity.User findUser = findUserByEmail(username);
        return new User(findUser.getEmailUser(), findUser.getPassword(), findUser
                .getRoleList()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNameRole()))
                .collect(Collectors.toList()));
    }
}
