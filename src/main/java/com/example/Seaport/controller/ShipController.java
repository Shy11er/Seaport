package com.example.Seaport.controller;

import com.example.Seaport.dto.ShipRequest;
import com.example.Seaport.model.Ship;
import com.example.Seaport.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="ship")
public class ShipController {
    private static ShipService service;

    @Autowired
    public ShipController(ShipService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<Ship> create(@RequestBody ShipRequest shipDto) {
        Ship ship = service.create(shipDto);
        return new ResponseEntity<>(ship, HttpStatus.CREATED);
    }


    @GetMapping("/")
    public List<Ship> getAll() {
//    public String getAll() {
        return service.getAll();
//        return "POST";
    }
}