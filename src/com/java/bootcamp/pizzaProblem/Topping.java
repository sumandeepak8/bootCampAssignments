package com.java.bootcamp.pizzaProblem;

public enum Topping {
    VEGETABLE(new Price(20)), CHICKEN(new Price(30)),
    MOZZARELLA(new Price(10)), TOMATOSAUCE(new Price(5)),
    EXTRACHEESE(new Price(25)), JALAPENO(new Price(40));

    private final Price price;

    Topping(Price price) {
        this.price = price;
    }

    public Price getPrice() {
        return this.price;
    }

}
