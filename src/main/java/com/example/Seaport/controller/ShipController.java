package com.example.Seaport.controller;

import com.example.Seaport.model.Ship;
import com.example.Seaport.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api")
public class ShipController {
    private static ShipRepository repository;

    @Autowired
    public ShipController(ShipRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public static List<Ship> getAll() {
        return repository.findAll();
    }
}