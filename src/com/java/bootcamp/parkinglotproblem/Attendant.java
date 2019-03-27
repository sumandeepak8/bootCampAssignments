package com.java.bootcamp.parkinglotproblem;

import java.util.ArrayList;
import java.util.List;

class Attendant {
    List<ParkingLot> parkingLots;
    Display display;

    Attendant(ParkingLot parkingLot, Display display) {
        this.display = display;
        this.parkingLots = new ArrayList<>();
        this.parkingLots.add(parkingLot);
    }

    void notifyAttendant(String message) {
        System.out.println(message);
    }

    void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    int totalParkingLots() {
        return this.parkingLots.size();
    }

}
