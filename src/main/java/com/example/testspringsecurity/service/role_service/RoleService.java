package com.example.testspringsecurity.service.role_service;

import com.example.testspringsecurity.entity.Roles;
import com.example.testspringsecurity.entity.Users;

public interface RoleService {

    Roles findRoleByName(String nameRole);

    void updateRole(Roles roles, Users users);
}
