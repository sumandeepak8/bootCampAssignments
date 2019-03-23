package com.java.bootcamp.fourth_day;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    @Test
    void shouldReturnTheValueInBaseUnitForFeet() {
        BigDecimal expected = BigDecimal.valueOf(144);
        BigDecimal actual = Ratio.FEET.valueInBaseUnit(new BigDecimal(12));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTheValueInBaseUnitForMILIMETER() {
        BigDecimal expected = BigDecimal.valueOf(new BigDecimal(0.04).floatValue());
        BigDecimal actual = Ratio.MILLIMETER.valueInBaseUnit(new BigDecimal(1));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTheValueInBaseUnitForInches() {
        BigDecimal expected = BigDecimal.valueOf(12);
        BigDecimal actual = Ratio.INCH.valueInBaseUnit(new BigDecimal(12));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTheValueInBaseUnitForCentimeter() {
        BigDecimal expected = BigDecimal.valueOf(2);
        BigDecimal actual = Ratio.CENTIMETER.valueInBaseUnit(new BigDecimal(5));
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTheValueInBaseUnitForCentimeter2() {
        BigDecimal expected = BigDecimal.valueOf(new BigDecimal(1.6).floatValue());
        BigDecimal actual = Ratio.CENTIMETER.valueInBaseUnit(new BigDecimal(4));
        assertEquals(Math.round(expected.floatValue()), Math.round(actual.floatValue()));
    }

    @Test
    void shouldReturnTheValueInBaseUnitFor() {
        BigDecimal expected = BigDecimal.valueOf(4);
        BigDecimal actual = Ratio.LITRE.valueInBaseUnit(new BigDecimal(3.78));
        int actualValueInInt = Math.round(actual.floatValue());
        assertEquals(expected, new BigDecimal(actualValueInInt));
    }

    @Test
    void shouldReturnTrueForSameTypeOfUnit() {
        assertTrue(Ratio.FEET.isOfSameType(Ratio.INCH));
    }
}