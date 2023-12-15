package com.example.Seaport.controller;

import com.example.Seaport.dto.RequestDto;
//import com.example.Seaport.dto.ShipRequest;
import com.example.Seaport.model.Request;
import com.example.Seaport.service.RequestService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="request")
//@RequiredArgsConstructor
@AllArgsConstructor
public class RequestController {
    private final RequestService requestService;

    @PostMapping("/")
    public ResponseEntity<Request> create(@RequestBody RequestDto requestDto) {
        Request request = requestService.create(requestDto);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }
}