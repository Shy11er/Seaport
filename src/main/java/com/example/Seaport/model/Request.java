package com.example.Seaport.model;

import jakarta.persistence.*;

@Entity
@Table
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(mappedBy = "request", cascade = CascadeType.ALL, orphanRemoval = true)
    private Ship ship;
    private String status;

    public Request(){}
    public Request(String status) {
        this.status = status;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Ship getShip() {
        return ship;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
