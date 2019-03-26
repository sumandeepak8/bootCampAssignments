package com.java.bootcamp.parkinglotproblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    void shouldParkACarToParkingLot() throws ParkingException {
        ParkingLot parkingLot = new ParkingLot(4);
        Car swift = new Car("swift");
        Car city = new Car("city");
        parkingLot.park(swift);
        parkingLot.park(city);

        assertEquals(2, parkingLot.totalCars());
    }

    @Test
    void shouldNotParkIfAlreadyInParking() throws ParkingException {
        ParkingLot parkingLot = new ParkingLot(2);
        Car swift = new Car("swift");
        parkingLot.park(swift);
        assertThrows(ParkingException.class, () -> parkingLot.park(swift));
        assertEquals(1, parkingLot.totalCars());
    }

    @Test
    void shouldNotParkIfParkingLotIsFullAndNotifyToAttendant() throws ParkingException {
        ParkingLot parkingLot = new ParkingLot(1);
        Attendant attendant = new Attendant();
        attendant.addParkingLot(parkingLot);
        parkingLot.registerAttendant(attendant);

        Car swift = new Car("swift");
        parkingLot.park(swift);

        assertEquals(1, parkingLot.totalCars());
        assertThrows(ParkingException.class, () -> parkingLot.park(swift));
    }

    @Test
    void shouldUnParkFromParkingLotAndNotifyAttendant() throws ParkingException {
        ParkingLot parkingLot = new ParkingLot(2);
        TestAttendant testAttendant = new TestAttendant();
        testAttendant.addParkingLot(parkingLot);
        parkingLot.registerAttendant(testAttendant);
        Car swift = new Car("swift");
        Car city = new Car("city");
        Token token = parkingLot.park(swift);
        parkingLot.park(city);

        assertTrue(testAttendant.isCalled);

        parkingLot.unPark(token);
        assertEquals(1, parkingLot.totalCars());
    }
}

class TestAttendant extends Attendant {
    boolean isCalled = false;

    @Override
    void notification(String message) {
        super.notification(message);
        this.isCalled = true;
    }
}