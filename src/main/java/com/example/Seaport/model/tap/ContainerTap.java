package com.example.Seaport.model.tap;

import com.example.Seaport.model.Cargo.CargoType;
import com.example.Seaport.model.Tap;
import jakarta.persistence.Entity;

@Entity
public class ContainerTap extends Tap {
    private CargoType cargoType = CargoType.Container;

    public ContainerTap() {}
    public ContainerTap(Integer work_speed) {
        super(work_speed);
    }


    public CargoType getContainer() {
        return cargoType;
    }
}
