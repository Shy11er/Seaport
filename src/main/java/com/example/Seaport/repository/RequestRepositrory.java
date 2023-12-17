package com.example.Seaport.repository;

import com.example.Seaport.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestRepositrory extends JpaRepository<Request, Integer> {
    @Query("SELECT r FROM Request r JOIN FETCH r.ship")
    List<Request> findAllShip();
}
