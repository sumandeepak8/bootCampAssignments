package com.java.bootcamp.parkinglotproblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    void shouldParkACarToParkingLot() throws CarAlreadyParkedException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(4);
        Car swift = new Car("swift");
        Car city = new Car("city");
        parkingLot.park(swift);
        parkingLot.park(city);

        assertEquals(2, parkingLot.totalCars());
    }

    @Test
    void shouldNotParkIfAlreadyInParking() throws CarAlreadyParkedException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(2);
        Car swift = new Car("swift");
        parkingLot.park(swift);
        assertThrows(CarAlreadyParkedException.class, () -> parkingLot.park(swift));
        assertEquals(1, parkingLot.totalCars());
    }

    @Test
    void shouldNotParkIfParkingLotsAreFull() throws CarAlreadyParkedException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1);
        Attendant attendant = new Attendant(parkingLot, new Display());
        parkingLot.registerAttendant(attendant);
        Car swift = new Car("swift");
        Car honda_city = new Car("honda_city");
        parkingLot.park(swift);
        assertThrows(ParkingLotFullException.class, () -> parkingLot.park(honda_city));
    }

    @Test
    void shouldNotParkIfParkingLotIsFullAndNotifyToAttendant() throws CarAlreadyParkedException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1);
        Display display = new Display();
        Attendant attendant = new Attendant(parkingLot, display);
        attendant.addParkingLot(parkingLot);
        parkingLot.registerAttendant(attendant);

        Car swift = new Car("swift");
        parkingLot.park(swift);

        assertEquals(1, parkingLot.totalCars());
        assertThrows(ParkingLotFullException.class, () -> parkingLot.park(swift));
    }

    @Test
    void shouldUnParkFromParkingLotAndNotifyAttendant() throws InvalidToken, CarAlreadyParkedException, ParkingLotFullException {
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

    TestAttendant() {
        super(new ParkingLot(2), new Display());
    }

    @Override
    void notifyAttendant(String message) {
        super.notifyAttendant(message);
        this.isCalled = true;
    }
}