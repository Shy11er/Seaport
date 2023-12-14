package com.example.Seaport.config;

import com.example.Seaport.model.Schedule;
import com.example.Seaport.repository.ScheduleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScheduleConfig {
    @Bean
    CommandLineRunner commandLineRunnerSchedule(ScheduleRepository scheduleRepository){
        return args -> {
            scheduleRepository.save(new Schedule());
        };
    }
}
