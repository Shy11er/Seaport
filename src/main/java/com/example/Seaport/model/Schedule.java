package com.example.Seaport.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Schedule {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<Ship> ships;

    public Schedule() {}

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public List<Ship> getShips() {
        return ships;
    }
}
