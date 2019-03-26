package com.java.bootcamp.parkinglotproblem;

import java.util.ArrayList;
import java.util.List;

class Attendant {
    List<ParkingLot> parkingLots;

    Attendant() {
        this.parkingLots = new ArrayList<>();
    }

     void notification(String message) {
         System.out.println(message);
    }

    void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }
}
