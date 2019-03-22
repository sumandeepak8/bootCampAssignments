package com.java.bootcamp.fourth_day;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    @Test
    void shouldReturnTheValueInBaseUnitForFeet() {
        BigDecimal expected = BigDecimal.valueOf(new BigDecimal(144).floatValue());
        BigDecimal actual = Unit.FEET.valueInBaseUnit(new BigDecimal(12));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTheValueInBaseUnitForMILIMETER() {
        BigDecimal expected = BigDecimal.valueOf(new BigDecimal(0.04).floatValue());
        BigDecimal actual = Unit.MILLIMETER.valueInBaseUnit(new BigDecimal(1));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTheValueInBaseUnitForInches() {
        BigDecimal expected = BigDecimal.valueOf(new BigDecimal(12).floatValue());
        BigDecimal actual = Unit.INCH.valueInBaseUnit(new BigDecimal(12));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTheValueInBaseUnitForCentimeter() {
        BigDecimal expected = BigDecimal.valueOf(new BigDecimal(2).floatValue());
        BigDecimal actual = Unit.CENTIMETER.valueInBaseUnit(new BigDecimal(5));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTheValueInBaseUnitForCentimeter2() {
        BigDecimal expected = BigDecimal.valueOf(new BigDecimal(1.6).floatValue());
        BigDecimal actual = Unit.CENTIMETER.valueInBaseUnit(new BigDecimal(4));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTheValueInBaseUnitFor() {
        BigDecimal expected = BigDecimal.valueOf(new BigDecimal(3.78).floatValue());
        BigDecimal actual = Unit.LITRE.valueInBaseUnit(new BigDecimal(3.78));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTrueForSameTypeOfUnit() {
        assertTrue(Unit.FEET.isOfSameType(Unit.INCH));
    }
}