package com.example.Seaport.model.tap;

import com.example.Seaport.model.Tap;
import jakarta.persistence.Entity;

import com.example.Seaport.model.Cargo.CargoType;

@Entity
public class BulkTap extends Tap {
    private CargoType cargoType = CargoType.Bulk;
    public BulkTap(Integer work_speed) {
        super(work_speed);
    }

    public BulkTap() {}

    public CargoType getBULK() {
        return cargoType;
    }
}
