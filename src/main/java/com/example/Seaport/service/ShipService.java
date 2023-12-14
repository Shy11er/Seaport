package com.example.Seaport.service;

//import com.example.Seaport.dto.ShipRequest;
import com.example.Seaport.model.Cargo;
import com.example.Seaport.model.Ship;
//import com.example.Seaport.model.User;
import com.example.Seaport.model.cargo.BulkCargo;
import com.example.Seaport.model.cargo.ContainerCargo;
import com.example.Seaport.model.cargo.LiquidCargo;
import com.example.Seaport.repository.CargoRepository;
import com.example.Seaport.repository.ShipRepository;
//import com.example.Seaport.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ShipService {
    private final ShipRepository shipRepository;
//    private final UserRepository userRepository;
    private final CargoRepository cargoRepository;


//    @Transactional
//    public Ship create(ShipRequest shipDto) {
//        Ship ship = new Ship();
//
//        Cargo.CargoType cargoType = shipDto.getCargoType();
//
//        ship.setTitle(shipDto.getTitle());
//        ship.setShip_type(shipDto.getType());
//        ship.setCargo_amount(shipDto.getCargoAmount());
//        ship.setCargo_type(cargoType);
////        ship.setUser(user);
//        shipRepository.save(ship);
//
//        for (int i = 0; i < shipDto.getCargoAmount(); i++) {
//            Cargo cargo;
//            switch (cargoType) {
//                case Bulk:
//                    cargo = new BulkCargo();
//                    break;
//                case Liqued:
//                    cargo = new LiquidCargo();
//                    break;
//                case Container:
//                    cargo = new ContainerCargo();
//                    break;
//                default:
//                    throw new IllegalArgumentException("Invalid cargo type: " + cargoType);
//            }
//
//            cargo.setCargo_type(cargoType);
//            cargo.setShip(ship);
//            cargo.setWeight(shipDto.getWeight());
//
//            cargoRepository.save(cargo);
//        }
////
////        ship.setCargos(cargos);
//        return ship;
//    }
//
//    public List<Ship> getAll() {
//        List<Ship> ships = shipRepository.findAll();
//
//        for (Ship ship : ships) {
//            List<Cargo> cargos = cargoRepository.findByShip(ship.getId());
////            System.out.println(ship.getCargos());
//            ship.setCargos(cargos);
////            shipRepository.save(ship);
//        }
//
//        return ships;
////        return shipRepository.findAllShipsWithCargos();
//    }

}
