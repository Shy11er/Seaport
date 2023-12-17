package com.example.Seaport.controller;

import com.example.Seaport.dto.RequestDto;
import com.example.Seaport.model.Request;
import com.example.Seaport.model.Tap;
import com.example.Seaport.repository.TapRepository;
import com.example.Seaport.service.RequestService;
import com.example.Seaport.service.TapService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="tap")
//@RequiredArgsConstructor
@AllArgsConstructor
public class CraneController {
//    private final RequestService requestService;
    private final TapService tapService;
    @GetMapping("/get-all")
    public ResponseEntity<List<Tap>> getAll() {
        List<Tap> taps = tapService.getAll();
        return new ResponseEntity<>(taps, HttpStatus.OK);
    }
}