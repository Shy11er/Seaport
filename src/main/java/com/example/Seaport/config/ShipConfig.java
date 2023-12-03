package com.example.Seaport.config;

import com.example.Seaport.model.Ship;
import com.example.Seaport.model.cargo.BulkCargo;
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
			BulkCargo cargo1 = new BulkCargo(123);
			repository.saveAll(List.of(cargo1));
		};
	}
}
