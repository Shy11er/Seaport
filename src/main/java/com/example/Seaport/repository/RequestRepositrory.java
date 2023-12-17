package com.example.Seaport.repository;

import com.example.Seaport.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RequestRepositrory extends JpaRepository<Request, Integer> {
    @Query("SELECT r FROM Request r JOIN FETCH r.ship")
    List<Request> findAllShip();

//    @Query("Select r from Request r where r.shipId = :shipId")
//    Optional<Request> findByShipId(@Param("shipId") Integer ship_id);
}
