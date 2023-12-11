package com.example.Seaport.service;

import com.example.Seaport.controller.AuthenticationResponse;
import com.example.Seaport.controller.AuthnticationRequest;
import com.example.Seaport.controller.RegisterRequest;
import com.example.Seaport.model.User;
import com.example.Seaport.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService(JwtService jwtService, UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.repository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) {
        Optional<User> findUser = repository.findByEmail(request.getEmail());

        if (findUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User with same email already exist");
        }

        User user = new User(request.getName(), request.getEmail(), passwordEncoder.encode(request.getPassword()));
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse login(AuthnticationRequest request) {

//        return new AuthenticationResponse("asfasdasdfuser");
        User user = repository.findByEmail(request.getEmail()).orElseThrow();
        if (user == null) {
            throw new BadCredentialsException("1000");
        }
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("1000");
        }
//        User updater = new User("ioapsfiopaskf", request.getEmail(), request.getPassword());
        var jwtToken = jwtService.generateToken(user);
//        repository.save(updater);
        return new AuthenticationResponse(jwtToken);
    }
}
