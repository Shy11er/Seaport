package com.example.Seaport.config;

import com.example.Seaport.model.Cargo.CargoType;
import com.example.Seaport.model.Tap;
import com.example.Seaport.model.tap.BulkTap;
import com.example.Seaport.model.tap.ContainerTap;
import com.example.Seaport.model.tap.LiquidTap;
import com.example.Seaport.repository.TapRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TapConfig {
    @Bean
    CommandLineRunner commandLineRunnerTap(TapRepository repository){
        return args -> {
            Tap tap1 = new BulkTap(
                    5, CargoType.Bulk, "Waiting"
            );

            Tap tap2 = new LiquidTap(
                    12, CargoType.Liqued, "Waiting"
            );

            Tap tap3 = new ContainerTap(
                    2, CargoType.Container, "Waiting"
            );

            repository.saveAll(List.of(tap1, tap2, tap3));
        };
    }
}
