package com.java.bootcamp.parkinglotproblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendantTest {

    @Test
    void shouldAddParkingLot() {
        ParkingLot parkingLot = new ParkingLot(2);
        Attendant attendant = new Attendant(parkingLot, new Display());
        attendant.addParkingLot(parkingLot);
        assertEquals(2, attendant.totalParkingLots());

    }

    @Test
    void shouldDisplayAllParkingLotDetails() {
        ParkingLot parkingLot = new ParkingLot(4);
        Attendant attendant = new Attendant(parkingLot, new Display());
        attendant.addParkingLot(parkingLot);
    }
}
