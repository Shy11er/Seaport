package com.example.Seaport.service;

import com.example.Seaport.model.Request;
import com.example.Seaport.model.Ship;
import com.example.Seaport.model.Tap;
import com.example.Seaport.repository.CargoRepository;
import com.example.Seaport.repository.RequestRepositrory;
import com.example.Seaport.repository.ShipRepository;
import com.example.Seaport.repository.TapRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PortService {
    private final TapRepository tapRepository;
    private final RequestRepositrory requestRepositrory;
    private final ShipRepository shipRepository;
    private final CargoRepository cargoRepository;

//    private List<Tap> bulkTaps = new ArrayList<>();
//    private List<Tap> liquidTaps = new ArrayList<>();
//    private List<Tap> containerTaps = new ArrayList<>();
    private List<Tap> taps = new ArrayList<>();

//    private List<Ship> bulkShips = new ArrayList<>();
//    private List<Ship> tankers = new ArrayList<>();
//    private List<Ship> containerShips = new ArrayList<>();
    private List<Ship> ships = new ArrayList<>();

    private List<Request> requests = new ArrayList<>();


    public void init() {
        ships = shipRepository.findAll();
        taps = tapRepository.findAll();
        requests = requestRepositrory.findAll();
    }

    public void work() {
        init();

        for (Tap tap : taps) {
            for (Request request : requests) {

                if (tap.getCargoType() == request.getShip().getCargo_type() && tap.getShip_id() == null) {
                    Ship ship = request.getShip();
                    Integer cargo_amount = ship.getCargo_amount();
                    Integer cargo_weight = ship.getCargoWeight();
                    System.out.println(cargo_weight);
                    Integer tap_speed = tap.getWork_speed();
                    Integer work_hours = (cargo_weight*cargo_amount) / tap_speed;
                    Integer work_days = work_hours / 24;

                    LocalDateTime arrival = request.getArrival();
                    LocalDateTime departure = request.getDeparture();
                    Duration duration = Duration.between(arrival, departure);
                    long durationDay = duration.getSeconds() * 60 * 60 * 24;

                    if (durationDay < work_days) {
                        long diff = work_days - durationDay;
                        long shipFine = diff * 2000;
                        ship.setFine(shipFine);
                        shipRepository.save(ship);
                    }

                    request.setStatus("Working");
                    tap.setStatus("Working");
                    tap.setShip_id(request.getShip().getId());
                    tapRepository.save(tap);
                    requestRepositrory.save(request);

                    System.out.println(work_hours);
                    System.out.println(work_days);
//                    System.out.println(LocalDateTime.of(mew LocalDateTime(arrival)));
                }
            }
        }
    }
}
