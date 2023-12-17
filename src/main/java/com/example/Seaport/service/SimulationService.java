package com.example.Seaport.service;

import com.example.Seaport.dto.RequestDto;
import com.example.Seaport.dto.ShipDto;
import com.example.Seaport.model.Cargo;
import com.example.Seaport.model.Request;
import com.example.Seaport.model.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
//@AllArgsConstructor
//@NoArgsConstructor
public class SimulationService {
    private static final String[] PREFIXES = {"S.S.", "RMS", "USS", "HMS", "MV"};
    private static final String[] SHIP_TYPES = {"Cargo Ship", "Container Ship", "Oil Tanker", "Cruise Ship", "Fishing Boat"};
    private static final String[] SUFFIXES = {"Express", "Star", "Queen", "Voyager", "Discovery"};

    private static final long DURATION = 30 * 1000;
    private static final long CREATION_INTERVAL = 1000;

    private static String[] shipTitles = generateRandomShipTitle(100);

    private final ShipService shipService;
    private final RequestService requestService;
    private final PortService portService;

    private long startTime;

    @Autowired
    public SimulationService(ShipService shipService, RequestService requestService, PortService portService, long startTime) {
        this.shipService = shipService;
        this.requestService = requestService;
        this.portService = portService;
        this.startTime = startTime;
    }


    @Scheduled(fixedRate = CREATION_INTERVAL)
    public void simulation() {
        long current_time = System.currentTimeMillis();
        long elapsedTime = current_time - startTime;

        if (elapsedTime <= DURATION) {
            Ship.ShipType[] shipTypes = Ship.ShipType.values();

            int randomShipType = new Random().nextInt(shipTypes.length);
            int randomShipTitle = new Random().nextInt(100);

            Cargo.CargoType cargoType = shipTypes[randomShipType] == Ship.ShipType.Tanker ? Cargo.CargoType.Liqued : shipTypes[randomShipType] == Ship.ShipType.Bulk ? Cargo.CargoType.Bulk : Cargo.CargoType.Container;

            ShipDto shipDto = ShipDto.builder()
                    .title(shipTitles[randomShipTitle])
                    .cargoAmount(new Random().nextInt(10, 100))
                    .shipWeight(new Random().nextInt(900, 2000))
                    .dayStay(new Random().nextInt(1, 10))
                    .cargoType(cargoType)
                    .cargoWeight(new Random().nextInt(10, 100))
                    .shipType(shipTypes[randomShipType])
                    .build();

            Ship ship = shipService.create(shipDto);

            RequestDto requestDto = RequestDto.builder()
                    .arrival(LocalDateTime.now().plusDays(elapsedTime))
                    .id(ship.getId())
                    .build();

            Request request = requestService.create(requestDto);
            portService.work();
            System.out.println("Creating request for ship at " + current_time);
        } else {
            System.out.println("Simulation is over");
        }
    }

    public static String[] generateRandomShipTitle(int count) {
        String[] titles = new String[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            String prefix = PREFIXES[random.nextInt(PREFIXES.length)];
            String type = SHIP_TYPES[random.nextInt(SHIP_TYPES.length)];
            String suffix = SUFFIXES[random.nextInt(SUFFIXES.length)];

            titles[i] = prefix + " " + type + " " + suffix;
        }

        return titles;
    }

}
