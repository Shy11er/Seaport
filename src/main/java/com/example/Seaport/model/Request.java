package com.example.Seaport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ship_id")
    @JsonIgnoreProperties("request")
    private Ship ship;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    @JsonIgnore
    private Schedule schedule;

    private String status;
    private LocalDateTime arrival;
    private LocalDateTime departure;

    public Request(){}
    public Request(Integer id, String status, LocalDateTime arrival, LocalDateTime departure, Ship ship){
        this.id = id;
        this.status = status;
        this.arrival = arrival;
        this.departure = departure;
        this.ship = ship;
    }
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

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }
    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }
    public LocalDateTime getArrival() {
        return arrival;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
