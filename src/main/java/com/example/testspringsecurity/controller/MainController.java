package com.example.testspringsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/custom_login")
    public String login() {
        return "custom_login";
    }

    @GetMapping("/custom_logout")
    public String logout() {
        return "custom_logout";
    }
}
