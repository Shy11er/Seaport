package com.example.Seaport.service;

import com.example.Seaport.dto.RequestDto;
import com.example.Seaport.model.Cargo;
import com.example.Seaport.model.Request;
import com.example.Seaport.model.Schedule;
import com.example.Seaport.model.Ship;
import com.example.Seaport.model.cargo.BulkCargo;
import com.example.Seaport.model.cargo.ContainerCargo;
import com.example.Seaport.model.cargo.LiquidCargo;
import com.example.Seaport.repository.CargoRepository;
import com.example.Seaport.repository.RequestRepositrory;
import com.example.Seaport.repository.ScheduleRepository;
import com.example.Seaport.repository.ShipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class RequestService {
    private final RequestRepositrory requestRepositrory;
    private final ShipRepository shipRepository;
    private final CargoRepository cargoRepository;
    private final ScheduleRepository scheduleRepository;

    public Request create(RequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(1).orElseThrow(() -> new RuntimeException("undefined schedule"));
        Cargo.CargoType cargoType = requestDto.getCargoType();
//        Ship ship = Ship.builder()
//                .title(requestDto.getTitle())
//                .arrival(requestDto.getArrival())
//                .weight(requestDto.getShipWeight())
//                .cargo_type(cargoType)
//                .ship_type(requestDto.getShipType())
//                .cargo_amount(requestDto.getCargoAmount())
//                .build();

        Ship ship = new Ship();
        ship.setTitle(requestDto.getTitle());
        ship.setCargo_type(cargoType);
        ship.setShip_type(requestDto.getShipType());
        ship.setArrival(requestDto.getArrival());
        ship.setWeight(requestDto.getShipWeight());
        ship.setCargo_amount(requestDto.getCargoAmount());
        ship.setSchedule(schedule);
        ship.setStatus("Waiting");
        ship.setCargoWeight(requestDto.getCargoWeight());
        shipRepository.save(ship);

        for (int i = 0; i < requestDto.getCargoAmount(); i++) {
            Cargo cargo;
            switch (cargoType) {
                case Bulk:
                    cargo = new BulkCargo();
                    break;
                case Liqued:
                    cargo = new LiquidCargo();
                    break;
                case Container:
                    cargo = new ContainerCargo();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid cargo type: " + cargoType);
            }

            cargo.setShip(ship);
            cargoRepository.save(cargo);
        }

        Request request = new Request("pending");
        request.setShip(ship);
        request.setStatus("pending");
        requestRepositrory.save(request);

        return request;
    }

}
