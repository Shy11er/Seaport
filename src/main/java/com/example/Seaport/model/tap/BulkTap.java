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

    public BulkTap(Integer work_speed, CargoType cargoType, String status) {
        super(work_speed, cargoType, status);
//        this.cargoType = CargoType.Bulk;
    }

    public BulkTap() {}

}
