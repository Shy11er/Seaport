package com.example.Seaport.model.tap;

import com.example.Seaport.model.Cargo.CargoType;
import com.example.Seaport.model.Tap;
import jakarta.persistence.Entity;

@Entity
public class ContainerTap extends Tap {
    private CargoType Container;

    public ContainerTap() {}

    public void setContainer(CargoType container) {
        Container = container;
    }

    public CargoType getContainer() {
        return Container;
    }
}
