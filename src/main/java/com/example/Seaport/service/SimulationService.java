package com.example.Seaport.service;

import com.example.Seaport.dto.AccountingDto;
import com.example.Seaport.dto.RequestDto;
import com.example.Seaport.dto.ShipDto;
import com.example.Seaport.model.Cargo;
import com.example.Seaport.model.Request;
import com.example.Seaport.model.Ship;
import com.example.Seaport.repository.RequestRepositrory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class SimulationService implements SimulationServiceInterface {
    private final ShipService shipService;
    private final RequestService requestService;
    private final PortService portService;
    private final RequestRepositrory requestRepositrory;


    private static final String[] PREFIXES = {"S.S.", "RMS", "USS", "HMS", "MV"};
    private static final String[] SHIP_TYPES = {"Cargo Ship", "Container Ship", "Oil Tanker", "Cruise Ship", "Fishing Boat"};
    private static final String[] SUFFIXES = {"Express", "Star", "Queen", "Voyager", "Discovery"};
    private static String[] shipTitles = generateRandomShipTitle(100);


    private static final long CREATION_INTERVAL = 100;
    private boolean simulationRunning = false;
    private int secondsElapsed = 0;
    private int step = 1;
    private LocalDateTime nowDate;



    @Autowired
    public SimulationService(ShipService shipService, RequestService requestService, PortService portService, RequestRepositrory requestRepositrory) {
        this.shipService = shipService;
        this.requestService = requestService;
        this.portService = portService;
        this.requestRepositrory = requestRepositrory;
    }


    @Scheduled(fixedRate = CREATION_INTERVAL)
    @Override
    public void simulation() {
        if (simulationRunning) {
            secondsElapsed += step;
            Ship.ShipType[] shipTypes = Ship.ShipType.values();

            int countShip = getRandomNumberInRange(1, 3);
            System.out.println(countShip);

            while (countShip > 0) {
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

                RequestDto requestDto = new RequestDto();
                requestDto.setArrival(nowDate);
                requestDto.setId(ship.getId());

                // Отклонение
                int rand = getRandomNumberInRange(1, 10);
                if (rand >= 8) {
                    int daysToAdd = new Random().nextInt(8) + 2;
                    LocalDateTime newArrival = nowDate.plusDays(daysToAdd);

                    requestDto.setNewArrival(newArrival);
                }

                requestService.create(requestDto);
                countShip--;
            }

//            portService.work();
            nowDate = nowDate.plusDays(step);
            if (secondsElapsed >= 30) {
                simulationRunning = false;
                System.out.println("Simulation completed.");
            }
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

    @Override
    public void startSimulation(int step) {
        simulationRunning = true;
        secondsElapsed = 0;
        this.step = step;
        this.nowDate = LocalDateTime.now();
        System.out.println("Simulation started.");
    }

    public int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
