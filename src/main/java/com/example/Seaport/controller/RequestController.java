package com.example.Seaport.controller;

import com.example.Seaport.dto.RequestDto;
//import com.example.Seaport.dto.ShipRequest;
import com.example.Seaport.model.Request;
import com.example.Seaport.service.PortService;
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
    private final PortService portService;

    @PostMapping("/create")
    public ResponseEntity<Request> create(@RequestBody RequestDto requestDto) {
        Request request = requestService.create(requestDto);
//        portService.work();
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Request> update(@RequestBody RequestDto requestDto) {
        Request request = requestService.update(requestDto.getId(), requestDto);
//        portService.work();
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody RequestDto shipDto) {
        boolean isDeleted = requestService.deleteRequest(shipDto.getId());

        if (isDeleted) {
//            portService.work();
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}