package com.example.Seaport.controller;

import com.example.Seaport.dto.RequestDto;
import com.example.Seaport.model.Request;
import com.example.Seaport.service.PortService;
import com.example.Seaport.service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="port")
@AllArgsConstructor
public class PortController {
    private final PortService portService;

    @PostMapping("/work")
    public void work() {
      portService.work();
  }
}