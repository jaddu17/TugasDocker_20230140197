package com.example.praktikum6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private final String USERNAME = "admin";
    private final String PASSWORD = "20230140197";

    private static List<Map<String, String>> studentList = new ArrayList<>();

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Username atau Password salah!");
            return "login";
        }
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/submit")
    public String submit(@RequestParam String nama,
                         @RequestParam String nim,
                         @RequestParam String jk,
                         Model model) {

        Map<String, String> student = new HashMap<>();
        student.put("nama", nama);
        student.put("nim", nim);
        student.put("jk", jk);
        studentList.add(student);
        
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("students", studentList);
        return "home";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
