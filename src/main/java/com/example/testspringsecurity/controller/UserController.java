package com.example.testspringsecurity.controller;

import com.example.testspringsecurity.service.user_service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    final UserService userService;

    @GetMapping("/user/home")
    public String homeUser() {
        return "home_user";
    }
}
