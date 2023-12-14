package com.example.Seaport.dto;

import com.example.Seaport.model.Cargo;
import com.example.Seaport.model.Ship;

import java.time.LocalDateTime;

public class RequestDto {
    private String title;
    private Ship.ShipType shipType;
    private Cargo.CargoType cargoType;
    private Integer cargoAmount;
    private Integer shipWeight;
    private Integer cargoWeight;
    private String arrival;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setShipType(Ship.ShipType shipType) {
        this.shipType = shipType;
    }

    public void setCargoType(Cargo.CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public void setCargoAmount(Integer cargoAmount) {
        this.cargoAmount = cargoAmount;
    }

    public void setShipWeight(Integer shipWeight) {
        this.shipWeight = shipWeight;
    }

    public void setCargoWeight(Integer cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getTitle() {
        return title;
    }

    public Ship.ShipType getShipType() {
        return shipType;
    }

    public Cargo.CargoType getCargoType() {
        return cargoType;
    }

    public Integer getCargoAmount() {
        return cargoAmount;
    }

    public Integer getShipWeight() {
        return shipWeight;
    }

    public Integer getCargoWeight() {
        return cargoWeight;
    }

    public String getArrival() {
        return arrival;
    }
}
