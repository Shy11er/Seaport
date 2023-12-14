package com.example.Seaport.repository;

import com.example.Seaport.model.Cargo;
import com.example.Seaport.model.Tap;
import com.example.Seaport.model.tap.BulkTap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TapRepository extends JpaRepository<Tap, Integer> {
    @Query("SELECT t FROM Tap t WHERE t.cargoType = :cargoType")
    List<Tap> findAllByType(@Param("cargoType") Integer cargoType);
}