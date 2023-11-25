package com.example.Seaport.model.ship;

import com.example.Seaport.model.Ship;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Tanker extends Ship {
    private Integer volume;

    public Tanker(Integer volume) {
        this.volume = volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getVolume() {
        return volume;
    }
}
