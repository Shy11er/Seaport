package com.example.Seaport.controller;

import com.example.Seaport.dto.ScheduleDto;
import com.example.Seaport.model.Request;
import com.example.Seaport.model.Schedule;
import com.example.Seaport.model.Ship;
import com.example.Seaport.service.PortService;
import com.example.Seaport.service.ScheduleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="schedule")
//@NoArgsConstructor
@AllArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final PortService portService;


    @RequestMapping("/get")
    public ResponseEntity<Schedule> get(@RequestParam(name = "sortBy", defaultValue = "arrival") String sortBy, @RequestParam(name = "dir", defaultValue = "ASC") String dir) {
        Schedule schedule = scheduleService.getAllS(sortBy, dir);
        portService.work();
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

//    @GetMapping("/")
//    public ResponseEntity<List<Request>> get() {
////    public ResponseEntity<List<Request>> get() {
//        List<Request> requests = scheduleService.getAllR();
////        List<Request> requests = scheduleService.getAll();
//        return new ResponseEntity<>(requests, HttpStatus.OK);
//    }
}