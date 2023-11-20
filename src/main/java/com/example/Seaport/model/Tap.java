package com.example.Seaport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.example.Seaport.model.Cargo.CargoType;

@Entity
@Table
public class Tap {
    @Id
    @GeneratedValue
    private Integer id;
    private CargoType cargo_type;
    private Integer work_speed;

    public Tap(CargoType cargo_type, Integer work_speed) {
        this.cargo_type = cargo_type;
        this.work_speed = work_speed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CargoType getType() {
        return cargo_type;
    }

    public void setType(CargoType cargo_type) {
        this.cargo_type = cargo_type;
    }

    public void setWork_speed(Integer work_speed) {
        this.work_speed = work_speed;
    }

    public Integer getWork_speed() {
        return work_speed;
    }
}
