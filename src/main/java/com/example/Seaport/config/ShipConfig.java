package com.example.Seaport.config;

import com.example.Seaport.model.Ship;
import com.example.Seaport.repository.ShipRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.example.Seaport.model.Cargo.CargoType;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ShipConfig {
    @Bean
    CommandLineRunner commandLineRunnerShip(ShipRepository repository) {
		return args -> {
			Ship ship1 = new Ship("Dany", 123, LocalDate.of(2012, 12, 23), LocalDate.of(2013, 2, 23), CargoType.LIQUID);
			repository.saveAll(List.of(ship1));
		};
	}
}
