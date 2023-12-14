package com.example.Seaport.controller;

import com.example.Seaport.model.Request;
import com.example.Seaport.model.Schedule;
import com.example.Seaport.model.Ship;
import com.example.Seaport.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping("/")
    public ResponseEntity<List<Ship>> get() {
        List<Ship> ships = scheduleService.getAll();
        return new ResponseEntity<>(ships, HttpStatus.OK);
    }
}