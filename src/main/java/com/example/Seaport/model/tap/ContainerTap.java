package com.example.Seaport.model.tap;

import com.example.Seaport.model.Cargo.CargoType;
import com.example.Seaport.model.Tap;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ContainerTap extends Tap {
    @Id
    @GeneratedValue
    private Integer id;

    public ContainerTap() {}
    public ContainerTap(Integer work_speed, CargoType cargoType, String status) {
        super(work_speed, cargoType, status);
    }

}
