package com.example.Seaport.model;

import com.example.Seaport.service.RequestService;
import com.example.Seaport.service.ScheduleService;
import com.example.Seaport.service.ShipService;
import com.example.Seaport.service.TapService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//@AllArgsConstructor
public class Port {
    private Schedule schedule;
//    private Queue<Request> requestQueue = new LinkedList<>();
    private List<Request> requestQueue = new ArrayList<>();
    private List<Request> requestList = new ArrayList<>();
    private List<Cargo> cargos;
    private List<Ship> ships = new ArrayList<>();
    private List<Tap> taps = new ArrayList<>();
    private LocalDateTime nowDate;
//    private final ScheduleService scheduleService;
    private final ShipService shipService;
    private final TapService tapService;
    private final RequestService requestService;

    public Port(ShipService shipService, TapService tapService, RequestService requestService) {
//        this.scheduleService = scheduleService;
        this.shipService = shipService;
        this.tapService = tapService;
        this.requestService = requestService;
        this.ships = shipService.getAll();
        this.taps = tapService.getAll();
        this.requestList = requestService.getAll();
        this.requestList.addAll(requestList);
        nowDate = LocalDateTime.now().minusDays(5);
    }
    public List<Ship> getShips() {
        return ships;
    }
    public List<Tap> getTaps() {
        return taps;
    }
//    public Queue<Request> getRequestQueue() {
//        return requestQueue;
//    }
    public List<Request> getRequestQueue() {
        return requestQueue;
    }
    public List<Request> getRequestList() {
        return requestList;
    }
    public LocalDateTime getNowDate() {
        return nowDate;
    }
}
