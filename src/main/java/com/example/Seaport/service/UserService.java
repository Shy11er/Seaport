package com.example.Seaport.service;

import com.example.Seaport.model.User;
import com.example.Seaport.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User userDto) {
        Optional<User> findUser = userRepository.findByEmail(userDto.getEmail());

        if (findUser.isPresent()) {
            throw new IllegalStateException("Email already is taken");
        }

        User user = new User();

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
//        String hashPassword = encoder.encode(user.getPassword());
        user.setPassword(userDto.getPassword());

        userRepository.save(user);
    }
}
