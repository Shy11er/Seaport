package com.example.Seaport.model.tap;

import com.example.Seaport.model.Tap;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.example.Seaport.model.Cargo.CargoType;

@Entity
@Table
public class Bulk extends Tap {
    @Id
    @GeneratedValue
    private Integer id;
    private CargoType BULK;
    private Integer work_speed;
    public Bulk(Integer work_speed) {
        this.work_speed = this.getWork_speed();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
