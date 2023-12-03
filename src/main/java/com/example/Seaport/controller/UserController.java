package com.example.Seaport.controller;

import com.example.Seaport.model.User;
import com.example.Seaport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/auth")
    public void create(@RequestBody User user) {
        userService.create(user);
    }
}


