package com.example.Seaport.dto;

import com.example.Seaport.model.Cargo;
import com.example.Seaport.model.Ship;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RequestDto {
    private Integer id;
    private LocalDateTime arrival;

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
}
