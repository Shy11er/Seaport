package com.example.Seaport.service;

import com.example.Seaport.dto.ShipDto;
import com.example.Seaport.model.Cargo;
import com.example.Seaport.model.Ship;
import com.example.Seaport.model.cargo.BulkCargo;
import com.example.Seaport.model.cargo.ContainerCargo;
import com.example.Seaport.model.cargo.LiquidCargo;
import com.example.Seaport.repository.CargoRepository;
import com.example.Seaport.repository.ShipRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ShipService {
    private  ShipRepository shipRepository;
    private final CargoRepository cargoRepository;

    public List<Ship> getAll() {
        return shipRepository.findAll();
    }

    public Ship saveShip(Ship ship) {
        return shipRepository.save(ship);
    }

    public Ship create(ShipDto requestDto) {
        Ship ship = new Ship();
        Cargo.CargoType cargoType = requestDto.getCargoType();
        ship.setTitle(requestDto.getTitle());
        ship.setCargo_type(cargoType);
        ship.setShip_type(requestDto.getShipType());
        ship.setWeight(requestDto.getShipWeight());
        ship.setCargo_amount(requestDto.getCargoAmount());
        ship.setCargoWeight(requestDto.getCargoWeight());
        ship.setPlannedStayDays(requestDto.getDayStay());
        saveShip(ship);

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
        return ship;
    }

    public boolean deleteShip(Integer shipId) {
        shipRepository.deleteById(shipId);
        return true;
    }

    public Ship updateShip(Integer shipId, ShipDto updateDto) {
        Ship ship = shipRepository.findById(shipId).orElseThrow(null);

        if (ship != null) {
            ship.setTitle(updateDto.getTitle());

            shipRepository.save(ship);
        }

        return ship;
    }

}
