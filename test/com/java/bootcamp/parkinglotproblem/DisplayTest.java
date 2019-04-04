package com.java.bootcamp.parkinglotproblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTest {
    @Test
    void shouldDisplayParkingLotDetails() throws CarAlreadyParkedException, ParkingLotFullException {

        ParkingLot parkingLot1 = new ParkingLot(4);
        ParkingLot parkingLot2 = new ParkingLot(3);
        Attendant attendant = new Attendant(parkingLot1);
        parkingLot1.registerAttendant(attendant);
        attendant.addParkingLot(parkingLot2);
        Car swift = new Car("swift");
        Car city = new Car("city");
        parkingLot1.park(swift);
        parkingLot1.park(city);
        Display display = Display.getInstance();

        assertEquals("", display.toString());

    }



}