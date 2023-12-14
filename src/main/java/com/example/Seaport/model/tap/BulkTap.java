package com.example.Seaport.model.tap;

import com.example.Seaport.model.Tap;
import jakarta.persistence.Entity;

import com.example.Seaport.model.Cargo.CargoType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class BulkTap extends Tap {
    @Id
    @GeneratedValue
    private Integer id;

    public BulkTap(Integer work_speed, CargoType cargoType) {
        super(work_speed, cargoType);
//        this.cargoType = CargoType.Bulk;
    }

    public BulkTap() {}

}
