package com.example.modeling.service.role_service;

import com.example.modeling.entity.Role;
import com.example.modeling.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleServiceImpl implements RoleService {

    final RoleRepository roleRepository;
    @Override
    public Role findByNameRole(String nameRole) {
        return roleRepository.findByNameRole(nameRole).orElse(null);
    }
}
