package com.example.Seaport.repository;

import com.example.Seaport.model.Ship;
import com.example.Seaport.model.cargo.BulkCargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShipRepository extends JpaRepository<Ship, Integer> {
    @Query(value = "SELECT s.id AS shipId, s.title AS shipTitle, c.id AS cargoId, c.cargo_type AS cargoType FROM ship s JOIN cargo c ON s.id = c.ship_id", nativeQuery = true)
    List<Ship> findAllShipsWithCargos();
}
