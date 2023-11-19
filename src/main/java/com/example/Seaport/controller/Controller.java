package com.example.Seaport.controller;

import com.example.Seaport.model.Post;
import com.example.Seaport.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/post")
public class Controller {
    private final Repository repository;

    @Autowired
    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Post> findAll() {
        return repository.findAll();
    }
}
