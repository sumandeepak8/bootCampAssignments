package com.java.bootcamp.parkinglotproblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Map;

class Display {
    private static Display ourInstance = new Display();
    Map<String, String> details;

    static Display getInstance() {
        return ourInstance;
    }

    private Display() {
        this.details = new HashMap<>();
    }

    void updateDetails(String parkingLot, Integer totalCars) {
        this.details.put(parkingLot,parkingLot + "   " + totalCars);
    }
}
