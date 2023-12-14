//package com.example.Seaport.controller;
//
//import com.example.Seaport.dto.ShipRequest;
//import com.example.Seaport.model.Ship;
//import com.example.Seaport.service.ShipService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
////import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.*;
////import org.springframework.security.core.context.SecurityContextHolder;
////import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//
//
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path="ship")
//@RequiredArgsConstructor
//public class ShipController {
//    private final ShipService service;
//
//    @PostMapping("/")
//    public ResponseEntity<Ship> create(@RequestBody ShipRequest shipDto) {
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////
////        // Extract the username from the principal
////        String email = null;
////        if (authentication instanceof UsernamePasswordAuthenticationToken) {
////            UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
////            email = token.getName();
////        }
//
//
//        Ship ship = service.create(shipDto);
//        return new ResponseEntity<>(ship, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/get-all")
//    public List<Ship> getAll() {
////    public String getAll() {
//        return service.getAll();
////        return "POST";
//    }
//}