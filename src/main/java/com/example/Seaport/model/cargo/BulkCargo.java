package com.example.Seaport.model.cargo;

import com.example.Seaport.model.Cargo;
import jakarta.persistence.*;

@Table
@Entity
public class BulkCargo extends Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer volume;

    public BulkCargo(Integer volume) {
        this.volume = volume;
    }
    public BulkCargo() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
