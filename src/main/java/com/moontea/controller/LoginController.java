package com.moontea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.moontea.dto.UserForm;
import com.moontea.entity.User;
import com.moontea.repo.UserRepository;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


    @PostMapping("/register")
    public String register(UserForm userForm) {
        User user = userForm.convertToUser();
        userRepository.save(user);
        return "redirect:/login";
    }


}
