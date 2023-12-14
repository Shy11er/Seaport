package com.example.Seaport.repository;

import com.example.Seaport.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepositrory extends JpaRepository<Request, Integer> {
}
