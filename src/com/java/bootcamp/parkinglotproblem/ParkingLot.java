package com.java.bootcamp.parkinglotproblem;

import java.util.HashMap;
import java.util.Map;

class ParkingLot {
    Map<Token, Car> lots;
    Integer capacity;
    Attendant attendant;

    ParkingLot(Integer capacity) {
        this.capacity = capacity;
        this.lots = new HashMap<>();
    }

    void registerAttendant(Attendant attendant) {
        this.attendant = attendant;
        this.attendant.addParkingLot(this);
    }

    int totalCars() {
        return this.lots.size();
    }

    boolean isFull() {
        return this.lots.size() == this.capacity;
    }

    Token park(Car car) throws ParkingLotFullException, CarAlreadyParkedException {
        if (this.isFull())
            throw new ParkingLotFullException();
        if (!this.lots.containsValue(car)) {
            Token token = new Token();
            this.lots.put(token, car);
            this.attendant.notifyAboutParking(this);
            return token;
        }
        throw new CarAlreadyParkedException();
    }

    Car unPark(Token token) throws InvalidToken {
        if (this.lots.containsKey(token)) {
            this.attendant.notifyAboutUnParking(this);
            Car car = this.lots.get(token);
            this.lots.remove(token);
            return car;
        }
        throw new InvalidToken();
    }

}
