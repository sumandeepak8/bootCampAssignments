package com.java.bootcamp.taxproblem;

class NonTaxable implements Item {

    private String name;
    private double price;
    private double tax;

    NonTaxable(String name, double price) {
        this.name = name;
        this.price = price;
        this.tax = 0;
    }

    @Override
    public double totalPrice() {
        return this.price + this.totalTax();
    }

    @Override
    public double totalTax() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

}
