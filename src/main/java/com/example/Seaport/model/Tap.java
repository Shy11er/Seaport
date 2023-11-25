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

    public Tap() {;}

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
}
