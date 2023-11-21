package com.example.Seaport.config;

import com.example.Seaport.model.Cargo.CargoType;
import com.example.Seaport.model.Tap;
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
            Tap tap1 = new Tap(
                    CargoType.BULK,
                    5
            );

            Tap tap2 = new Tap(
                    CargoType.CONTAINER,
                    12
            );

            Tap tap3 = new Tap(
                    CargoType.LIQUID,
                    2
            );

            repository.saveAll(List.of(tap1, tap2, tap3));
        };
    }
}
