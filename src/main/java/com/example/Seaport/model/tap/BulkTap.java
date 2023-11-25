package com.example.Seaport.model.tap;

import com.example.Seaport.model.Tap;
import jakarta.persistence.Entity;

import com.example.Seaport.model.Cargo.CargoType;

@Entity
public class BulkTap extends Tap {
    private CargoType BULK;
    public BulkTap() {}

    public void setBULK(CargoType BULK) {
        this.BULK = BULK;
    }

    public CargoType getBULK() {
        return BULK;
    }
}
