package com.java.bootcamp.pizzaProblem;

import java.util.ArrayList;
import java.util.List;

class Toppings {
    List<Topping> toppings;

    Toppings() {
        this.toppings = new ArrayList<>();
    }

    void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    Price getTotalPriceOfToppings() {
        int accumulator = 0;
        for (Topping topping : toppings) {
            accumulator += topping.getPrice().getValue();
        }
        return new Price(accumulator);
    }

}
