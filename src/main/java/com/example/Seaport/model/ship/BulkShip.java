package com.example.Seaport.model.ship;

import com.example.Seaport.model.Ship;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class BulkShip extends Ship {
    private Integer volume;

    public BulkShip(Integer volume) {
        super();
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getVolume() {
        return volume;
    }
}
