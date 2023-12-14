package com.example.Seaport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Schedule {
    @Id
    @GeneratedValue
    private Integer id;
    @JsonIgnore
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ship> ships = new ArrayList<>();

    public Schedule() {}

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setShips(Ship ship) {
        this.ships.add(ship);
    }

    public List<Ship> getShips() {
        return ships;
    }
}
