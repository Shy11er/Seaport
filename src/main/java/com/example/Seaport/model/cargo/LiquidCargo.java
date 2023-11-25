package com.example.Seaport.model.cargo;

import com.example.Seaport.model.Cargo;
import jakarta.persistence.Entity;

@Entity
public class LiquidCargo extends Cargo {
    private Integer volume;

    public LiquidCargo(Integer volume) {
        this.volume = volume;
    }
    public LiquidCargo() {}

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
