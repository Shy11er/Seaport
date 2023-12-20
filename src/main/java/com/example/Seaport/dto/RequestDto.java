package com.example.Seaport.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

//@Data
//@Builder
public class RequestDto {
    private Integer id;
    private LocalDateTime arrival;
    private LocalDateTime newArrival;

    public RequestDto(LocalDateTime arrival, Integer id) {
        this.id = id;
        this.arrival = arrival;
    }
    public RequestDto() {}

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }
    public LocalDateTime getArrival() {
        return arrival;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDateTime getNewArrival() {
        return newArrival;
    }
    public void setNewArrival(LocalDateTime newArrival) {
        this.newArrival = newArrival;
    }
}
