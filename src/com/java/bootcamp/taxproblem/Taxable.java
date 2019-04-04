package com.java.bootcamp.taxproblem;

public class Taxable implements Item {
    private String name;
    private double price;

    public Taxable(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double totalTax() {
        double tax = this.price * 10 / 100;
        return Math.round(tax * 100) / 100.0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public double totalPrice() {
        return Math.round((price + this.totalTax()) * 100) / 100.0;
    }
}
