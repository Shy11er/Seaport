package com.example.Seaport.model.cargo;

import com.example.Seaport.model.Cargo;
import jakarta.persistence.*;

@Entity
@Table
public class LiquidCargo extends Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer volume;

    public LiquidCargo(Integer volume) {
        this.volume = volume;
    }
    public LiquidCargo() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
