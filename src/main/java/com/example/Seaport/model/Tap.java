package com.example.Seaport.model;

import jakarta.persistence.*;

import com.example.Seaport.model.Cargo.CargoType;

@Table
@Entity
public class Tap {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer work_speed;
    private CargoType cargoType;
    private Integer ship_id;


    public Tap(Integer work_speed, CargoType cargoType) {
        this.work_speed = work_speed;
        this.cargoType = cargoType;
    }

    public Tap() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setWork_speed(Integer work_speed) {
        this.work_speed = work_speed;
    }

    public Integer getWork_speed() {
        return work_speed;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public Integer getShip_id() {
        return ship_id;
    }

    public void setShip_id(Integer ship_id) {
        this.ship_id = ship_id;
    }
}
