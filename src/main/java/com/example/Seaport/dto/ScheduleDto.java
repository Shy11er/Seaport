package com.example.Seaport.dto;


import com.example.Seaport.model.Request;
import com.example.Seaport.model.Schedule;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ScheduleDto {
    @Getter @Setter
    private String sortBy;
    @Getter @Setter
    private String dir;
}