package com.hackathon.phishing_simulator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/")
    public String login() {
        return "login";
    }
    @GetMapping("/dashboard")
    public String dashboard() {
        return "index";
    }
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}