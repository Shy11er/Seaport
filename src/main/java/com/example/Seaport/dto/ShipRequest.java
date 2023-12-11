package com.example.Seaport.dto;

import com.example.Seaport.model.Cargo;
import com.example.Seaport.model.Ship;

public class ShipRequest {
    private String title;
    private Ship.ShipType type;
    private Cargo.CargoType cargoType;
    private Integer cargoAmount;
    private Integer weight;

    public Ship.ShipType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(Ship.ShipType type) {
        this.type = type;
    }

    public Cargo.CargoType getCargoType() {
        return cargoType;
    }

    public int getCargoAmount() {
        return cargoAmount;
    }

    public int getWeight() {
        return weight;
    }

    public void setCargoAmount(int cargoAmount) {
        this.cargoAmount = cargoAmount;
    }

    public void setCargoType(Cargo.CargoType cargoType) {
        this.cargoType = cargoType;
    }
}
