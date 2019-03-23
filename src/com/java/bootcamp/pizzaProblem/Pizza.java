package com.java.bootcamp.pizzaProblem;

class Pizza {

    private Price basePrice;
    private Toppings toppings;
    private Description description;

    Pizza() {
        this.basePrice = new Price(50);
        this.toppings = new Toppings();
        this.description = new Description();
        description.addDescription("Plain pizza price is 50\n");
    }

    Pizza addTopping(Topping topping) {
        this.toppings.addTopping(topping);
        this.addDescription(topping);
        return this;
    }

    Price getTotalPrice() {
        int basePrice = this.basePrice.getValue();
        int toppingsPrice = toppings.getTotalPriceOfToppings().getValue();
        int totalPrice = basePrice + toppingsPrice;
        return new Price(totalPrice);
    }

    private void addDescription(Topping topping) {
        if (toppings.toppings.size() == 0)
            this.description.addDescription("Toppings price => \n");
        String descriptionMessage = topping.name() + " price is " + topping.getPrice().getValue();
        this.description.addDescription(descriptionMessage);
    }

    Description getDescription() {
        return this.description;
    }

}
