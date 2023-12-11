//package com.example.Seaport.controller;
//
//import com.example.Seaport.dto.AuthnticationRequest;
//import com.example.Seaport.dto.JwtAuthenticationResponse;
//import com.example.Seaport.dto.RegisterRequest;
//import com.example.Seaport.service.AuthenticationService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
////@CrossOrigin
//@RestController
//@RequestMapping("/auth")
//@CrossOrigin
//@RequiredArgsConstructor
//public class AuthController {
//    private final AuthenticationService authService;
//
//    @PostMapping("/register")
//    public JwtAuthenticationResponse register(@RequestBody RegisterRequest request) {
//        return authService.register(request);
//    }
//
//    @PostMapping("/login")
//    public JwtAuthenticationResponse login(@RequestBody AuthnticationRequest request) {
//        return authService.login(request);
//    }
//}
//
//
