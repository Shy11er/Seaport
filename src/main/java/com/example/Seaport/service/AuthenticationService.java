package com.example.Seaport.service;

import com.example.Seaport.controller.AuthenticationResponse;
import com.example.Seaport.controller.RegisterRequest;
import com.example.Seaport.model.User;
import com.example.Seaport.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;


    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder().username(request.getName()).email(request.getEmail()).password(request.getPassword()).build();
    }

//    public AuthenticationResponse login(AuthnticationRequest request) {
//    }
}
