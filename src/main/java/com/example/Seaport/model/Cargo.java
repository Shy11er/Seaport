package com.example.Seaport.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Table
@Entity
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private CargoType cargo_type;
    private Integer weight;
    @ManyToOne
//    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.PERSIST})
    @JoinColumn(name="ship_id")
    private Ship ship;

    public enum CargoType {
        Bulk,
        Container,
        Liqued
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CargoType getCargo_type() {
        return cargo_type;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setCargo_type(CargoType cargo_type) {
        this.cargo_type = cargo_type;
    }

    public Ship getShip() {
        return ship;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
