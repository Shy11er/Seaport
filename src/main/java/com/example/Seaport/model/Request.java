package com.example.Seaport.model;

import jakarta.persistence.*;

@Entity
@Table
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(mappedBy = "request", cascade = CascadeType.ALL)
    private Ship ship;
}
