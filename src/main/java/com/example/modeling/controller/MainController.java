package com.example.modeling.controller;

import com.example.modeling.entity.Role;
import com.example.modeling.entity.User;
import com.example.modeling.service.role_service.RoleService;
import com.example.modeling.service.user_service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MainController {

    final User user = new User();

    final UserService userService;

    final RoleService roleService;

    @GetMapping("/register")
    public String createUser(Model model) {
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register_user")
    public String createUser(@ModelAttribute User user) {
        Role roleUser = roleService.findRoleByName("USER");

        userService.createUser(user, roleUser);
        roleService.updateRole(roleUser, user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user")
    public String userPage() {
        return "user";
    }
}
