package com.example.Seaport.service;

import com.example.Seaport.dto.ScheduleDto;
import com.example.Seaport.model.Request;
import com.example.Seaport.model.Schedule;
import com.example.Seaport.repository.RequestRepositrory;
import com.example.Seaport.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.query.SortDirection;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
//@NoArgsConstructor
@Transactional
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
//    private final ShipRepository shipRepository;
    private final RequestRepositrory requestRepositrory;


    public Schedule getAllS(String sortBy, String dir) {
//        return scheduleRepository.findByIdWithRequests(1).orElseThrow(() -> new RuntimeException("asdasf"));
//        Schedule schedule = scheduleRepository.findById(1).orElseThrow(() -> new RuntimeException("asdasf"));
//        List<Request> requests = requestRepositrory.findAll();
//
////        scheduleRepository.save(schedule);
//        ScheduleDto dto = new ScheduleDto(requests, schedule.getId());
//        return dto;
//        Sort.Direction direction = dir == "ASC" ? Sort.Direction.ASC : Sort.Direction.DESC;
        return scheduleRepository.findSchedule(sortBy ,dir);
    }

    public List<Request> getAllR() {
        return requestRepositrory.findAllShip();
    }
}
