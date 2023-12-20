package com.example.Seaport.controller;

import com.example.Seaport.dto.AccountingDto;
import com.example.Seaport.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "simulation")
public class SimulationController {
    private final SimulationService simulationService;

    @Autowired
    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @GetMapping("/start/{step}")
    public String startSimulation(@PathVariable("step") int step) {
        simulationService.startSimulation(step);
        return "Simulation started.";
    }
}
