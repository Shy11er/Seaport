package com.example.Seaport.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Ship {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private Integer cargo_amount;
    private Integer weight;
}
