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
    }

    Token park(Car car) throws ParkingException {
        if (this.attendant != null) {
            if (this.lots.size() + 1 == this.capacity)
                this.attendant.notification(this.toString() + " is full");
            if (this.lots.size() == this.capacity)
                throw new ParkingException("lots is full");
        }
        if (!this.lots.containsValue(car)) {
            Token token = new Token();
            this.lots.put(token, car);
            return token;
        }
        throw new ParkingException("This is already parked");
    }

    int totalCars() {
        return this.lots.size();
    }

    Car unPark(Token token) {
        if (this.lots.size() == this.capacity) {
            if (this.attendant != null)
                this.attendant.notification("Parking lot is available now");
        }
        Car car = this.lots.get(token);
        this.lots.remove(token);
        return car;
    }
}
