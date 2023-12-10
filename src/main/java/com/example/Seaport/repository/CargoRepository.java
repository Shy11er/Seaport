package com.example.Seaport.repository;

import com.example.Seaport.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CargoRepository extends JpaRepository<Cargo, Integer> { }
