package com.example.modeling.service.role_service;

import com.example.modeling.entity.Role;
import com.example.modeling.entity.User;
import com.example.modeling.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "roleService")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleServiceImpl implements RoleService {

    final RoleRepository roleRepository;
    @Override
    public Role findRoleByName(String nameRole) {
        return roleRepository.findByNameRole("USER").orElse(null);
    }

    @Override
    public void updateRole(Role role, User user) {
        role.setUserList(new ArrayList<>(List.of(user)));
        roleRepository.save(role);
    }
}
