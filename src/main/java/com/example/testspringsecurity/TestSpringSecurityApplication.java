package com.example.testspringsecurity;

import com.example.testspringsecurity.service.role_service.RoleService;
import com.example.testspringsecurity.service.role_service.RoleServiceImpl;
import com.example.testspringsecurity.service.user_service.UserService;
import com.example.testspringsecurity.service.user_service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestSpringSecurityApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(TestSpringSecurityApplication.class, args);

        UserService userService = context.getBean(UserServiceImpl.class);
        RoleService roleService = context.getBean(RoleServiceImpl.class);
    }

}
