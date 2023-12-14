package com.example.Seaport;

import com.example.Seaport.model.Cargo;
import com.example.Seaport.model.Ship;
import com.example.Seaport.model.Tap;
import com.example.Seaport.model.ship.BulkShip;
import com.example.Seaport.model.ship.ContainerShip;
import com.example.Seaport.model.ship.Tanker;
import com.example.Seaport.model.tap.BulkTap;
import com.example.Seaport.model.tap.ContainerTap;
import com.example.Seaport.model.tap.LiquidTap;
import com.example.Seaport.repository.CargoRepository;
import com.example.Seaport.repository.ShipRepository;
import com.example.Seaport.repository.TapRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path="main")
public class Port {
    private final TapRepository tapRepository;
    private final ShipRepository shipRepository;
    private final CargoRepository cargoRepository;

    private List<Tap> bulkTaps = new ArrayList<>();
    private List<Tap> liquidTaps = new ArrayList<>();
    private List<Tap> containerTaps = new ArrayList<>();
    private List<Tap> taps = new ArrayList<>();

    private List<Ship> bulkShips = new ArrayList<>();
    private List<Ship> tankers = new ArrayList<>();
    private List<Ship> containerShips = new ArrayList<>();
    private List<Ship> ships = new ArrayList<>();

    public void init() {
//        bulkTaps = tapRepository.findAllByType(0);
//        liquidTaps = tapRepository.findAllByType(2);
//        containerTaps = tapRepository.findAllByType(1);
//        taps = tapRepository.findAll();
//
//        tankers = shipRepository.findAllByType(2);
//        bulkShips = shipRepository.findAllByType(0);
//        containerShips = shipRepository.findAllByType(1);

        ships = shipRepository.findAll();
        taps = tapRepository.findAll();
    }

    @PostMapping("/")
    public void main() {
        init();

        for (Tap tap : taps) {
            for (Ship ship : ships) {

                if (tap.getCargoType() == ship.getCargo_type() && tap.getShip_id() == null) {
                    Integer cargo_amount = ship.getCargo_amount();
//                    Integer cargo_weight = cargoRepository.findOneByShipId(ship.getId()).getWeight();
                    Integer cargo_weight = ship.getCargoWeight();
                    System.out.println(cargo_weight);
                    Integer tap_speed = tap.getWork_speed();
                    Integer cargoPerHour = (cargo_weight*cargo_amount) / tap_speed;
                    Integer cargoPerDay = cargoPerHour / 24;
                    String arrival = ship.getArrival();
                    System.out.println(arrival);
                    System.out.println(cargoPerDay);
                    System.out.println(cargoPerHour);
                }
            }
        }
    }
}
