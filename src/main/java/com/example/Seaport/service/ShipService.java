package com.example.Seaport.service;

import com.example.Seaport.dto.ShipRequest;
import com.example.Seaport.model.Cargo;
import com.example.Seaport.model.Ship;
import com.example.Seaport.model.cargo.BulkCargo;
import com.example.Seaport.model.cargo.ContainerCargo;
import com.example.Seaport.model.cargo.LiquidCargo;
import com.example.Seaport.repository.CargoRepository;
import com.example.Seaport.repository.ShipRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ShipService {
    private final ShipRepository shipRepository;
    private final CargoRepository cargoRepository;

    @Autowired
    public ShipService(ShipRepository shipRepository, CargoRepository cargoRepository) {
        this.shipRepository = shipRepository;
        this.cargoRepository = cargoRepository;
    }

//    @Transactional
    public Ship create(ShipRequest shipDto) {
        Ship ship = new Ship();

        ArrayList<Cargo> cargos = new ArrayList<Cargo>();
        Cargo.CargoType cargoType = shipDto.getCargoType();

        ship.setTitle(shipDto.getTitle());
        ship.setShip_type(shipDto.getType());
        ship.setCargo_amount(shipDto.getCargoAmount());
        ship.setCargo_type(cargoType);
        shipRepository.save(ship);

        for (int i = 0; i < shipDto.getCargoAmount(); i++) {
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

            cargo.setCargo_type(cargoType);
            cargo.setShip(ship);
            cargo.setWeight(shipDto.getWeight());

            cargoRepository.save(cargo);
            cargos.add(cargo);
        }
//
//        ship.setCargos(cargos);
        return ship;
    }

    public List<Ship> getAll() {
        List<Ship> ships = shipRepository.findAll();
        return ships;
    }

}
