package com.example.modeling.service.role_service;

import com.example.modeling.entity.Role;
import com.example.modeling.entity.User;

public interface RoleService {
    Role findRoleByName(String nameRole);
    void updateRole(Role role, User user);
}
