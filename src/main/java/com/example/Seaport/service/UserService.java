//package com.example.Seaport.service;
//
////import com.example.Seaport.model.User;
//import com.example.Seaport.model.User;
//import com.example.Seaport.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//    private final UserRepository userRepository;
//
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
//            }
//        };
//    }
//
//    public User save(User user) {
//        if (user.getId() == null) {
//            user.setCreatedAt(LocalDateTime.now());
//        }
//
//        user.setUpdatedAt(LocalDateTime.now());
//        return userRepository.save(user);
//    }
//}
