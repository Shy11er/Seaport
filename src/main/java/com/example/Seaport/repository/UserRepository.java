package com.example.Seaport.repository;

import com.example.Seaport.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    @Query("SELECT u FROM users u WHERE u.email=:email")
//    Optional<User> findEmail(String email);

    Optional<User> findByEmail(String email);


}