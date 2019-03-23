package com.java.bootcamp.pizzaProblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToppingsTest {
    @Test
    void shouldAddToppingsAndIncreasePrice() {
        Toppings toppings = new Toppings();
        toppings.addTopping(Topping.EXTRACHEESE);
        toppings.addTopping(Topping.MOZZARELLA);

        assertEquals(2, toppings.toppings.size());
        int actual = toppings.getTotalPriceOfToppings().getValue();

        assertEquals(35, actual);
    }
}