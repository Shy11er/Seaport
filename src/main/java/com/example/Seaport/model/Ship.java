package com.example.Seaport.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.List;

import com.example.Seaport.model.Cargo.CargoType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

public class Ship {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    @Transient
    private Integer cargo_amount;
    private Integer weight;
    private ShipType ship_type;
    private CargoType cargo_type;
    private LocalDate arrival;
    private LocalDate departure;

    @OneToMany(mappedBy = "ship")
    private List<Cargo> cargos;


    public enum ShipType {
        TANKER,
        BULK
    }


    public Ship(String title,
                Integer weight,
                LocalDate arrival,
                LocalDate departure,
                CargoType cargo_type) {
        this.title = title;
        this.weight = weight;
        this.arrival = arrival;
        this.departure = departure;
        this.cargo_type = cargo_type;
    }

    public void setType(ShipType type) {
        this.ship_type = type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArrival(LocalDate arrival) {
        this.arrival = arrival;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setCargo_type(CargoType cargo_type) {
        this.cargo_type = cargo_type;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getCargo_amount() {
        return cargos.size();
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public ShipType getType() {
        return ship_type;
    }

    public CargoType getCargo_type() {
        return cargo_type;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }
}
