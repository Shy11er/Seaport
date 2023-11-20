package com.example.Seaport.model;

import jakarta.persistence.*;

@Entity
@Table
public class Cargo {
    @Id
    @GeneratedValue
    private Integer id;
    private CargoType cargo_type;
    private Integer weight;

    @ManyToOne
    @JoinColumn(name="ship_id")
    private Ship ship;

    public enum CargoType {
        BULK,
        CONTAINER,
        LIQUID
    }
}
