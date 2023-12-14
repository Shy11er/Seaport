package com.example.Seaport.model.tap;

import com.example.Seaport.model.Tap;
import jakarta.persistence.Entity;

import com.example.Seaport.model.Cargo.CargoType;

@Entity
public class LiquidTap extends Tap {

    private CargoType cargoType = CargoType.Liqued;

    public LiquidTap() {}
    public LiquidTap(Integer work_speed) {
        super(work_speed);
    }

    public CargoType getLIQUID() {
        return cargoType;
    }
}
