package com.java.bootcamp.pizzaProblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    void shouldReturnFiftyAsTotalPriceOfPizzaWithoutToppings() {
        Pizza pizza = new Pizza();
        assertEquals(50, pizza.getTotalPrice().getValue());
    }

    @Test
    void shouldReturnNinetyAsTotalPriceOfPizzaWithToppings() {
        Pizza pizza = new Pizza();
        pizza.addTopping(Topping.EXTRACHEESE);
        pizza.addTopping(Topping.MOZZARELLA);
        pizza.getDescription().print();
        assertEquals(85, pizza.getTotalPrice().getValue());
    }

    @Test
    void shouldReturnCompleteDescription() {
        Pizza pizza = new Pizza();
        Description expectedDescription = new Description();
        expectedDescription.addDescription("Plain pizza price is 50\n");
        assertEquals(expectedDescription, pizza.getDescription());

        pizza.addTopping(Topping.VEGETABLE);
        pizza.addTopping(Topping.CHICKEN);
        pizza.addTopping(Topping.EXTRACHEESE);

        expectedDescription.addDescription("VEGETABLE price is 20");
        expectedDescription.addDescription("CHICKEN price is 30");
        expectedDescription.addDescription("EXTRACHEESE price is 25");
        assertEquals(expectedDescription, pizza.getDescription());
    }
}