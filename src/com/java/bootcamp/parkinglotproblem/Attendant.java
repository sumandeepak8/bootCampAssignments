package com.java.bootcamp.parkinglotproblem;

import java.util.*;

class Attendant {
    List<ParkingLot> parkingLots;

    Attendant(ParkingLot parkingLot) {
        this.parkingLots = new ArrayList<>();
        this.parkingLots.add(parkingLot);
    }

    void notifyAboutParking(ParkingLot parkingLot) {
        if (parkingLot.isFull())
            System.out.println("Parking lot is full now");
        System.out.println("Car is parked");
        Display.getInstance().updateDetails(parkingLot.toString(), parkingLot.totalCars());
    }

    void notifyAboutUnParking(ParkingLot parkingLot) {
        if (parkingLot.isFull())
            System.out.println("Parking lot is available now");
        System.out.println("Car is UnParked");
        Display.getInstance().updateDetails(parkingLot.toString(), parkingLot.totalCars());
    }


    void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    int totalParkingLots() {
        return this.parkingLots.size();
    }

    void displayParkingLotsDetails() {
        Map details = Display.getInstance().details;
//        for (int i = 0; i < details.size() ; i++) {
//            System.out.println(details.values().iterator().next());
//        }

        details.forEach((k, v) ->
                System.out.println(v)
        );
    }

}
