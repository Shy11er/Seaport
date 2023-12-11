package com.example.Seaport.service;

import com.example.Seaport.controller.ShipRequest;
import com.example.Seaport.model.Cargo;
import com.example.Seaport.model.Ship;
import com.example.Seaport.model.cargo.BulkCargo;
import com.example.Seaport.model.cargo.ContainerCargo;
import com.example.Seaport.model.cargo.LiquidCargo;
import com.example.Seaport.repository.CargoRepository;
import com.example.Seaport.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ShipService {
    private static ShipRepository shipRepository;
    private static CargoRepository cargoRepository;

    @Autowired
    public ShipService(ShipRepository shipRepository, CargoRepository cargoRepository) {
        this.shipRepository = shipRepository;
        this.cargoRepository = cargoRepository;
    }

    public Ship create(ShipRequest shipDto) {
        Ship ship = new Ship();

        ship.setTitle(shipDto.getTitle());
        ship.setShip_type(shipDto.getType());
        ship.setCargo_amount(shipDto.getCargoAmount());

        ArrayList<Cargo> cargos = new ArrayList<Cargo>();
        Cargo.CargoType cargoType = shipDto.getCargoType();

        for (int i = 0; i < shipDto.getCargoAmount(); i++) {
            if (cargoType == Cargo.CargoType.Bulk) {
                Cargo cargo = new BulkCargo(shipDto.getWeight());
                cargos.add(cargo);
            } else if (cargoType == Cargo.CargoType.Liqued) {
                Cargo cargo = new LiquidCargo(shipDto.getWeight());
                cargos.add(cargo);
            } else {
                Cargo cargo = new ContainerCargo(shipDto.getWeight());
                cargos.add(cargo);
            }
        }

        ship.setCargos(cargos);
        cargoRepository.saveAll(cargos);
        shipRepository.save(ship);

        return ship;
    }

    public List<Ship> getAll() {
        List<Ship> ships = shipRepository.findAll();
        return ships;
    }
}
