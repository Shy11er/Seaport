//package com.example.Seaport.service;
//
//import com.example.Seaport.dto.AuthnticationRequest;
//import com.example.Seaport.dto.RegisterRequest;
//import com.example.Seaport.dto.JwtAuthenticationResponse;
//import com.example.Seaport.model.User;
//import com.example.Seaport.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class AuthenticationService {
//    private final UserService userService;
//    private final UserRepository repository;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtService jwtService;
//    private final AuthenticationManager authenticationManager;
//
//    public JwtAuthenticationResponse register(RegisterRequest request) {
//        var user = User
//                .builder()
//                .name(request.getName())
//                .email(request.getEmail())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .build();
//
//        user = userService.save(user);
//        var jwt = jwtService.generateToken(user);
//        return JwtAuthenticationResponse.builder().token(jwt).build();
//    }
//
//    public JwtAuthenticationResponse login(AuthnticationRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
//        var user = repository.findByEmail(request.getEmail())
//                .orElseThrow(() -> new IllegalStateException("Invalid email or password"));
//        var jwt = jwtService.generateToken(user);
//        return JwtAuthenticationResponse.builder().token(jwt).build();
//    }
//}
