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


    private static final long CREATION_INTERVAL = 1000;
    private boolean simulationRunning = false;
    private int secondsElapsed = 0;



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
            secondsElapsed++;
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
                    .arrival(LocalDateTime.now().plusDays(secondsElapsed))
                    .id(ship.getId())
                    .build();

            Request request = requestService.create(requestDto);
            portService.work();
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
    public void startSimulation() {
        simulationRunning = true;
        secondsElapsed = 0;
        System.out.println("Simulation started.");
    }

    public AccountingDto get() {

        List<Request> requests = requestRepositrory.findAll();
        int amountOfRequests = requests.size();
        int amountFine = 0;
        double averQueue = amountOfRequests * 0.7;
        int maxDur = -1000;
        int duration = 0;

        for (Request request : requests) {
            Ship ship = request.getShip();

            if (ship.getFine() != null) {
                amountFine += ship.getFine();
            }

            int dura = (int) Duration.between(request.getArrival(), request.getDeparture()).getSeconds() / 60 / 60 / 24;
            if (dura > maxDur) {
                maxDur = dura;
            }
            duration += dura;
        }

        Integer a = amountOfRequests;
        Integer b = amountFine;
        Double c = averQueue;
        Double d = requests.size() == 0 ? 0 : (double) duration / amountOfRequests;
        Integer e = maxDur == -1000 ? 0 : maxDur;

        AccountingDto dto = new AccountingDto(a, b, c, d, e);
        return dto;
    }
}
