package com.example.Seaport.repository;

import com.example.Seaport.model.Cargo;
import com.example.Seaport.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    @Query(value = "SELECT c FROM Cargo c WHERE c.ship_id = :ship_id", nativeQuery = true)
    Cargo findOneByShipId(@Param("ship_id") Integer ship_id);
}
