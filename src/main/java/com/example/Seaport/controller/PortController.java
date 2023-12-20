package com.example.Seaport.controller;

import com.example.Seaport.dto.AccountingDto;
import com.example.Seaport.dto.RequestDto;
import com.example.Seaport.model.Request;
import com.example.Seaport.service.PortService;
import com.example.Seaport.service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping(path="port")
@AllArgsConstructor
public class PortController {
    private final PortService portService;

    @PostMapping("/work")
    public void work() {
        System.out.println("started");
        portService.init();
        portService.work();
    }

    @GetMapping("/queue")
    public ResponseEntity<List<Request>> getQueue() {
        List<Request> queue = portService.getRequestsQueue();
        return new ResponseEntity<>(queue, HttpStatus.OK);
    }

    @GetMapping("/accounting")
    public ResponseEntity<AccountingDto> getAccounting() {
        AccountingDto dto =  portService.Otchet();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}