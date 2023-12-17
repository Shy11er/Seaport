package com.example.Seaport.service;

import com.example.Seaport.dto.RequestDto;
import com.example.Seaport.model.Request;
import com.example.Seaport.model.Schedule;
import com.example.Seaport.model.Ship;
import com.example.Seaport.model.Tap;
import com.example.Seaport.repository.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TapService {
   private final TapRepository tapRepository;

   public List<Tap> getAll() {
       return tapRepository.findAll();
   }
}
