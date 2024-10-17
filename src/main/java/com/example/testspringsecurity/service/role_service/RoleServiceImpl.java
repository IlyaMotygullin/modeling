package com.example.testspringsecurity.service.role_service;

import com.example.testspringsecurity.entity.Roles;
import com.example.testspringsecurity.entity.Users;
import com.example.testspringsecurity.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleServiceImpl implements RoleService {

    final RoleRepository roleRepository;

    @Override
    public Roles findRoleByName(String nameRole) {
        return roleRepository
                .findByNameRole(nameRole)
                .get();
    }

    @Override
    public void updateRole(Roles roles, Users users) {
        roles.setUsersSet(new HashSet<>(List.of(users)));
        roleRepository.save(roles);
    }
}
