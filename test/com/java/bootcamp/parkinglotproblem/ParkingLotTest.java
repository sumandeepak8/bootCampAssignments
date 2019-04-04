package com.java.bootcamp.parkinglotproblem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    ParkingLot parkingLot;
    ParkingLot parkingLot1;
    Attendant attendant;
    Car swift;
    Car honda_city;

    @BeforeEach
    void executeIt() {
        parkingLot = new ParkingLot(2);
        parkingLot1 = new ParkingLot(2);

        attendant = new Attendant(parkingLot);

        parkingLot.registerAttendant(attendant);
        parkingLot1.registerAttendant(attendant);


        swift = new Car("swift");
        honda_city = new Car("honda_city");
    }


    @Test
    void shouldParkACarToParkingLot() throws CarAlreadyParkedException, ParkingLotFullException {
        parkingLot.park(swift);
        parkingLot.park(honda_city);
        assertEquals(2, parkingLot.totalCars());
    }

    @Test
    void shouldNotParkIfAlreadyInParking() throws CarAlreadyParkedException, ParkingLotFullException {
        parkingLot.park(swift);
        assertThrows(CarAlreadyParkedException.class, () -> parkingLot.park(swift));
        assertEquals(1, parkingLot.totalCars());
    }


    @Test
    void shouldNotParkIfParkingLotIsFullAndNotifyToAttendant() throws CarAlreadyParkedException, ParkingLotFullException {
        parkingLot.park(swift);
        parkingLot.park(honda_city);
        assertThrows(ParkingLotFullException.class, () -> parkingLot.park(swift));
    }

    @Test
    void shouldUnParkFromParkingLotAndNotifyAttendant() throws InvalidToken, CarAlreadyParkedException, ParkingLotFullException {

        TestAttendant testAttendant = new TestAttendant();
        testAttendant.addParkingLot(parkingLot);
        parkingLot.registerAttendant(testAttendant);
        Token token = parkingLot.park(swift);
        parkingLot.park(honda_city);

        assertTrue(testAttendant.isParked);
        parkingLot.unPark(token);
        assertEquals(1, parkingLot.totalCars());
    }

    @Test
    void shouldDisplayDetailsOfAllParkingLotsThatAttendantIsTakesCare() throws CarAlreadyParkedException, ParkingLotFullException {
        parkingLot.park(swift);
        parkingLot.park(honda_city);
        parkingLot1.park(swift);
        parkingLot1.park(honda_city);
        attendant.displayParkingLotsDetails();
    }


}

class TestAttendant extends Attendant {
    boolean isParked = false;
    boolean isUnParked = false;

    TestAttendant() {
        super(new ParkingLot(2));
    }

    @Override
    void notifyAboutParking(ParkingLot parkingLot) {
        super.notifyAboutParking(parkingLot);
        this.isParked = true;
    }

    @Override
    void notifyAboutUnParking(ParkingLot parkingLot) {
        super.notifyAboutUnParking(parkingLot);
        this.isUnParked = true;
    }
}