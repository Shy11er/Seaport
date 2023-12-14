package com.example.Seaport.model.ship;

import com.example.Seaport.model.Ship;
import jakarta.persistence.Entity;

@Entity
public class ContainerShip extends Ship {
    private Integer amount;

    public ContainerShip() {
        super();
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }
}
