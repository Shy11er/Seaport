package com.example.Seaport.service;

import com.example.Seaport.model.Ship;
import com.example.Seaport.repository.ScheduleRepository;
import com.example.Seaport.repository.ShipRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
//@NoArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final ShipRepository shipRepository;

    public List<Ship> getAll() {
        return shipRepository.findAll(Sort.by(Sort.Direction.ASC, "arrival"));
    }
}
