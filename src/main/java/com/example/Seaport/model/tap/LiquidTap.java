package com.example.Seaport.model.tap;

import com.example.Seaport.model.Tap;
import jakarta.persistence.Entity;

import com.example.Seaport.model.Cargo.CargoType;

@Entity
public class LiquidTap extends Tap {

    private CargoType LIQUID;

    public LiquidTap() {}

    public void setLIQUID(CargoType LIQUID) {
        this.LIQUID = LIQUID;
    }

    public CargoType getLIQUID() {
        return LIQUID;
    }
}
