package com.example.Seaport.model.cargo;

import com.example.Seaport.model.Cargo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table
@Entity
public class BulkCargo extends Cargo {
    private Integer volume;

    public BulkCargo(Integer volume) {
        this.volume = volume;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
