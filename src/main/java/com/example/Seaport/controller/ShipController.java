package com.example.Seaport.controller;

import com.example.Seaport.model.Ship;
import com.example.Seaport.model.cargo.BulkCargo;
import com.example.Seaport.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="ship")
public class ShipController {
    private static ShipRepository repository;

    @Autowired
    public ShipController(ShipRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<String> hell() {
        return ResponseEntity.ok("asd");
    }
}