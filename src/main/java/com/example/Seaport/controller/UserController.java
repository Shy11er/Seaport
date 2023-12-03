package com.example.Seaport.controller;

import com.example.Seaport.model.User;
import com.example.Seaport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth/register")
    public void create(@RequestBody() User user) {
//        System.out.println("asd");

        userService.create(user);
    }

    @GetMapping("/auth")
    public List<Integer> get() {
        return List.of(1, 2,3);
    }
}


