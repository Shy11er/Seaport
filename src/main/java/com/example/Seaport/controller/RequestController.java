package com.example.Seaport.controller;

import com.example.Seaport.dto.RequestDto;
//import com.example.Seaport.dto.ShipRequest;
import com.example.Seaport.model.Request;
import com.example.Seaport.model.Ship;
import com.example.Seaport.service.RequestService;
import com.example.Seaport.service.ShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="request")
@RequiredArgsConstructor
public class RequestController {
    private final ShipService shipService;
    private final RequestService requestService;

    @PostMapping("/")
    public ResponseEntity<Request> create(@RequestBody RequestDto requestDto) {
        Request request = requestService.create(requestDto);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }
}