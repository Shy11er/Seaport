package com.example.Seaport.controller;

import com.example.Seaport.dto.ShipDto;
import com.example.Seaport.model.Ship;
import com.example.Seaport.service.ShipService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;;

import java.util.List;

@RestController
@RequestMapping(path="ship")
@RequiredArgsConstructor
public class ShipController {
    private final ShipService service;

    @PostMapping("/create")
    public ResponseEntity<Ship> create(@RequestBody ShipDto shipDto) {
        Ship ship = service.create(shipDto);
        return new ResponseEntity<>(ship, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Ship> update(@RequestBody ShipDto shipDto) {
        Ship ship = service.updateShip(shipDto.getId(), shipDto);
        return new ResponseEntity<>(ship, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody ShipDto shipDto) {
        boolean isDeleted = service.deleteShip(shipDto.getId());

        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/get-all")
    public List<Ship> getAll() {
        return service.getAll();
    }
}