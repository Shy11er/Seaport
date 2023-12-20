package com.example.Seaport.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String status;
    private Integer workDays;
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "request_id")
//    @JsonIgnoreProperties("tap")
//    private Request request;
    private Integer request_id = 0;

    public Tap(Integer work_speed, CargoType cargoType, String status) {
        this.work_speed = work_speed;
        this.cargoType = cargoType;
        this.status = status;
        this.workDays = 0;
    }

    public Tap() {}
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
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    public Integer getWorkDays() {
        return workDays;
    }
    public void setWorkDays(Integer workDays) {
        this.workDays = workDays;
    }
//    public void setRequest(Request request) {
//        this.request = request;
//    }
//    public Request getRequest() {
//        return request;
//    }
    public Integer getRequest_id() {
        return request_id;
    }
    public void setRequest_id(Integer request_id) {
        this.request_id = request_id;
    }
}
