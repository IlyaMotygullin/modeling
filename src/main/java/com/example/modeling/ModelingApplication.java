package com.example.modeling;

import com.example.modeling.service.role_service.RoleService;
import com.example.modeling.service.role_service.RoleServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModelingApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(ModelingApplication.class, args);
        RoleService service = context.getBean("roleService", RoleServiceImpl.class);
        System.out.println(service.findRoleByName("USER").toString());
    }

}
