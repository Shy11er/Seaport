package com.example.Seaport.repository;

import com.example.Seaport.model.Ship;
import com.example.Seaport.model.cargo.BulkCargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShipRepository extends JpaRepository<Ship, Integer> {
//    @Query(value = "SELECT DISTINCT s FROM ship s LEFT JOIN FETCH Cargo cargo s.cargo", nativeQuery = true)
//    List<Ship> findAllShipsWithCargos();

    @Query("SELECT s FROM Ship s WHERE s.ship_type = :shipType")
    List<Ship> findAllByType(@Param("shipType") Integer shipType);
}
