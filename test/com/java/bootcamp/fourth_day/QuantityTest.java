package com.java.bootcamp.fourth_day;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

    @Test
    void shouldGiveTrueIfTheQuantitiesAreEqualForFeetAndInches() {
        Quantity oneFeet = new Quantity(new BigDecimal(1), Unit.FEET);
        Quantity twelveInches = new Quantity(new BigDecimal(12), Unit.INCH);
        assertTrue(oneFeet.equals(twelveInches));
    }

    @Test
    void shouldGiveTrueIfTheQuantitiesAreEqualForCentimeterAndMilimeter() {
        Quantity oneCentimeter = new Quantity(new BigDecimal(1), Unit.CENTIMETER);
        Quantity tenMilimeter = new Quantity(new BigDecimal(10), Unit.MILLIMETER);
        assertTrue(oneCentimeter.equals(tenMilimeter));
    }


    @Test
    void shouldGiveTrueIfTheQuantitiesAreEqualForCentimeterAndInches() {
        Quantity fiveCentimeter = new Quantity(new BigDecimal(5), Unit.CENTIMETER);
        Quantity twoInches = new Quantity(new BigDecimal(2), Unit.INCH);
        assertTrue(fiveCentimeter.equals(twoInches));
    }

    @Test
    void shouldGiveFalseIfTheQuantitiesAreDifferent() {
        Quantity twelveFeet = new Quantity(new BigDecimal(12), Unit.FEET);
        Quantity twelveInches = new Quantity(new BigDecimal(12), Unit.INCH);

        assertFalse(twelveFeet.equals(twelveInches));
    }

    @Test
    void shouldGiveTrueForComparingVolumeInGallonAndLiter() {
        Quantity oneGallon = new Quantity(new BigDecimal(1), Unit.GALLON);
        Quantity volumeInLiters = new Quantity(new BigDecimal(3.78), Unit.LITRE);

        assertTrue(oneGallon.equals(volumeInLiters));
    }

    @Test
    void shouldGiveFalseForComparingVolumeInGallonAndInch() {
        Quantity oneGallon = new Quantity(new BigDecimal(1), Unit.GALLON);
        Quantity volumeInLiters = new Quantity(new BigDecimal(3.78), Unit.INCH);

        assertFalse(oneGallon.equals(volumeInLiters));
    }

    @Test
    void shouldReturnTheSumOfTwoSameUnitOfSameType() throws QuantityUnitMismatchException {
        Quantity twoInch1 = new Quantity(new BigDecimal(2), Unit.INCH);
        Quantity twoInch2 = new Quantity(new BigDecimal(2), Unit.INCH);
        Quantity expected = new Quantity(new BigDecimal(4), Unit.INCH);

        assertEquals(expected, twoInch1.addWith(twoInch2));
    }


    @Test
    void shouldThrowAnException() {
        Quantity twoInch1 = new Quantity(new BigDecimal(2), Unit.INCH);
        Quantity twoInch2 = new Quantity(new BigDecimal(2), Unit.GALLON);
        assertThrows(QuantityUnitMismatchException.class, () -> twoInch1.addWith(twoInch2));
    }

    @Test
    void shouldReturnTheSumOfTwoQuantityInInches() throws QuantityUnitMismatchException {
        Quantity twoInch = new Quantity(new BigDecimal(2), Unit.INCH);
        Quantity twoAndHalfCentimeter = new Quantity(new BigDecimal(2.5), Unit.CENTIMETER);
        Quantity threeInches = new Quantity(new BigDecimal(3),Unit.INCH);
        assertEquals(threeInches,twoInch.addWith(twoAndHalfCentimeter));
    }

    @Test
    void shouldReturnTheSumOfTwoQuantityInLiter() throws QuantityUnitMismatchException {
        Quantity oneLiter = new Quantity(new BigDecimal(1), Unit.LITRE);
        Quantity oneGallon = new Quantity(new BigDecimal(1), Unit.GALLON);
        Quantity expected = new Quantity(new BigDecimal(5),Unit.LITRE);
        assertEquals(expected,oneGallon.addWith(oneLiter));
    }

}