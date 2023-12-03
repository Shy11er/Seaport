package com.example.Seaport.repository;

import com.example.Seaport.model.Ship;
import com.example.Seaport.model.cargo.BulkCargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipRepository extends JpaRepository<BulkCargo, Integer> { }
