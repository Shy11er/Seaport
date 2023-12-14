package com.example.Seaport.repository;

import com.example.Seaport.model.Cargo;
import com.example.Seaport.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    @Query(value = "SELECT * FROM cargo WHERE ship_id=:id", nativeQuery = true)
    public List<Cargo> findByShip(Integer id);
}
