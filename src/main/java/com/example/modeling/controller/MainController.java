package com.example.modeling.controller;

import com.example.modeling.entity.User;
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

    @GetMapping("/register")
    public String createUser(Model model) {
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register_user")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/";
    }
}
