package com.java.bootcamp.parkinglotproblem;

class CarAlreadyParkedException extends Throwable {
    CarAlreadyParkedException() {
        super("This is already parked");
    }
}
