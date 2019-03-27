package com.java.bootcamp.parkinglotproblem;

public class ParkingLotFullException extends Exception {

    public ParkingLotFullException() {
        super("Parking lot is full");
    }
}
