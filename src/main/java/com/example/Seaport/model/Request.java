package com.example.Seaport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Request {
    @Id
    @GeneratedValue
    private Integer id;

}
