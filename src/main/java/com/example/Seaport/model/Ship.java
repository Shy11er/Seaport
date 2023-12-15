package com.example.Seaport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.Seaport.model.Cargo.CargoType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Table
@Entity
//@Builder
//@Data
public class Ship {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;

    private Integer cargo_amount;
    private Integer weight;
    private ShipType ship_type;
    private CargoType cargo_type;
    private LocalDateTime arrival;
    private LocalDateTime departure;
    private String status;
    private Integer cargoWeight;

    @OneToOne
    @JoinColumn(name="request_id")
    private Request request;
    @JsonIgnore
    @OneToMany(mappedBy = "ship", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cargo> cargos = new ArrayList<>();
    @ManyToOne()
    private Schedule schedule;
//    @ManyToOne()
//    private User user;

    public enum ShipType {
        Tanker,
        Bulk,
        Container
    }


    public Ship() {};
    public Ship(String title,
                Integer weight,
                ShipType cargoType,
                CargoType cargo_type,
                LocalDateTime arrival) {
        this.title = title;
        this.weight = weight;
        this.ship_type = cargoType;
        this.cargo_type = cargo_type;
        this.arrival = arrival;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }

    public Integer getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(Integer cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public ShipType getShip_type() {
        return ship_type;
    }

    public void setCargo_amount(Integer cargo_amount) {
        this.cargo_amount = cargo_amount;
    }

    public void setShip_type(ShipType ship_type) {
        this.ship_type = ship_type;
    }

    public Request getRequest() {
        return request;
    }

    public Schedule getSchedule() {
        return schedule;
    }

//    public User getUser() {
//        return user;
//    }

    public void setRequest(Request request) {
        this.request = request;
    }

//    public void setUser(User user) {
//        this.user = user;
//    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
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

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setCargo_type(CargoType cargo_type) {
        this.cargo_type = cargo_type;
    }

    public void setDeparture(LocalDateTime departure) {
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
        return cargo_amount;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public LocalDateTime getDeparture() {
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

    public void setCargos(Cargo cargos) {
        this.cargos.add(cargos);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
