package com.java.bootcamp.pizzaProblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {

    @Test
    void shouldReturnTwentyAsPriceValue() {
        Price price = new Price(20);
        assertEquals(20, price.getValue());
    }
}