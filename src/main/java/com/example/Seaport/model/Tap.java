package com.example.Seaport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Tap {
    @Id
    @GeneratedValue
    private Integer id;
    private Type type;

    public enum Type {
        BULK,
        CONTAINER,
        LIQUID
    }

    public Tap(Type type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
