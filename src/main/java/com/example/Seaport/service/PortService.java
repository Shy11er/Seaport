package com.example.Seaport.service;

import com.example.Seaport.dto.AccountingDto;
import com.example.Seaport.model.Port;
import com.example.Seaport.model.Request;
import com.example.Seaport.model.Ship;
import com.example.Seaport.model.Tap;
import com.example.Seaport.repository.RequestRepositrory;
import com.example.Seaport.repository.TapRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class PortService {
    private final TapRepository tapRepository;
    private final RequestRepositrory requestRepositrory;
    private final ShipService shipService;
    private final TapService tapService;
    private final RequestService requestService;
    private Port port;
    private List<Long> queue_size = new ArrayList<>();
    private List<Tap> taps = new ArrayList<>();
    private List<Request> requestsList = new ArrayList<>();
    @Getter
    private List<Request> requestsQueue = new ArrayList<>();
//    private Queue<Request> requestsQueue = new LinkedList<>();
    private LocalDateTime nowDate;

    public PortService(TapRepository tapRepository, RequestRepositrory requestRepositrory,
                       ShipService shipService,
                       TapService tapService, RequestService requestService) {
        this.tapRepository = tapRepository;
        this.requestRepositrory = requestRepositrory;
        this.shipService = shipService;
        this.tapService = tapService;
        this.requestService = requestService;
    }

    public void init() {
        this.port = new Port(shipService, tapService, requestService);
        taps = port.getTaps();
        requestsList = port.getRequestList();
        requestsQueue = port.getRequestQueue();
        nowDate = LocalDateTime.now();
    }

    public void work() {
        System.out.println("working");
        int simulationDays = 200;
        try {
            while (simulationDays > 0) {
                updateRequestsQueue();
                processTaps();
                nowDate = nowDate.plusDays(1);
//            System.out.println(nowDate);
                simulationDays--;

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateRequestsQueue() {
        for (Request request : requestsList) {
            if (!requestsQueue.contains(request) && request.getStatus().equals("Waiting")) {
                if (request.getNewArrival() != null && request.getNewArrival().getDayOfMonth() == nowDate.getDayOfMonth()) {
                    requestsQueue.add(request);
                } else if (request.getNewArrival() == null && request.getArrival().getDayOfMonth() == nowDate.getDayOfMonth()) {
                    requestsQueue.add(request);
                }

                if (!queue_size.contains(requestsQueue.size())) {
                    queue_size.add((long)requestsQueue.size());
                }
            }
        }
    }

    private void processTaps() {
        for (Tap tap : taps) {
            for (Request request : requestsQueue) {
                if (request != null && tap.getRequest_id() == 0 && tap.getCargoType().equals(request.getShip().getCargo_type()) && request.getTap_id() == 0) {
                    processRequestWithTap(tap, request);
                }
            }
            finishUnboardingIfCompleted(tap);
        }
    }

    private void processRequestWithTap(Tap tap, Request request) {
        Ship ship = request.getShip();
        tap.setStatus("Working");
        tap.setRequest_id(request.getId());

        int cargo_amount = ship.getCargo_amount();
        int cargo_weight = ship.getCargoWeight();
        int tap_speed = tap.getWork_speed();
        int amount_speed = (cargo_amount * cargo_weight) / tap_speed / 24;

        Duration dur = (request.getNewArrival() != null) ?
                Duration.between(request.getNewArrival(), request.getDeparture()) :
                Duration.between(request.getArrival(), request.getDeparture());

        tap.setWorkDays(amount_speed);

        long durDay = dur.getSeconds() / 60 / 60 / 24;
        if (amount_speed > durDay) {
            ship.setFine((amount_speed - durDay) * 2000);
        }

        request.setStartUnboard(nowDate);
        request.setTap_id(tap.getId());
        request.setStatus("Working");

        tapRepository.save(tap);
        requestRepositrory.save(request);
    }

    private void finishUnboardingIfCompleted(Tap tap) {
        Request req = requestRepositrory.findById(tap.getRequest_id()).orElse(null);
        if (req != null) {
            LocalDateTime expectedFinishUnboard = req.getStartUnboard().plusDays(tap.getWorkDays());

            long daysSinceStartUnboarding = Duration.between(expectedFinishUnboard, nowDate).toDays();

            if (daysSinceStartUnboarding >= 0) {
                tap.setRequest_id(0);
                tap.setStatus("Waiting");
                req.setStatus("Done");
                req.setTap_id(0);
                req.setFinishUnboard(nowDate);
                requestRepositrory.save(req);
                tapRepository.save(tap);
                if (requestsQueue.contains(req)) {
                    requestsQueue.remove(req);
                }
            }
        }
    }

    public AccountingDto Otchet() {
        AccountingDto list = new AccountingDto();
        List<Ship> ships = shipService.getAll();
        List<Request> requests = requestService.getAll();
        List<Long> queue_delay = new ArrayList<>();
        long sum = 0, sum_delay = 0, max_delay = 0, amount_fine = 0;

        for (Ship ship : ships) {
            amount_fine += ship.getFine() == null ? 0 : ship.getFine();
        }

        for (Request request: requests) {
            if (request.getNewArrival() != null) {
                long dur = (long) Duration.between(request.getNewArrival(), request.getStartUnboard()).toDays();
                if (dur > max_delay) {
                    max_delay = dur;
                }
                queue_delay.add(dur);
                sum_delay += dur;
            } else {
                long dur = (long) Duration.between(request.getArrival(), request.getStartUnboard()).toDays();
                if (dur > max_delay) {
                    max_delay = dur;
                }
                queue_delay.add(dur);
                sum_delay += dur;
            }
        }

        for (Long sd : queue_size) {
            sum += sd;
        }

        double averQueue = sum / queue_size.size();
        list.setAverQueue(averQueue);
//        list.setMaxDur(max);
        list.setAmountFine(amount_fine);
        list.setDuration((double) sum_delay / queue_delay.size());
        list.setAmountOfRequests((long) requests.size());
        list.setMaxDur(max_delay);

        return list;
    }
}