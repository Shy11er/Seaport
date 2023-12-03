package com.example.Seaport.model.cargo;

import com.example.Seaport.model.Cargo;
import jakarta.persistence.*;

@Entity
@Table
public class ContainerCargo extends Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer amount;

    public ContainerCargo(Integer amount) {
        this.amount = amount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
