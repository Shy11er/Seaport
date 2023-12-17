package com.example.Seaport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Schedule {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("schedule")
    private List<Request> requests = new ArrayList<>();

    public Schedule() {}
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public List<Request> getRequests() {
        return requests;
    }
    public void addRequests(Request request) {
        this.requests.add(request);
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
