package com.java.bootcamp.taxproblem;

public class Imported implements Item {
    private Item item;

    public Imported(Item item) {
        this.item = item;
    }

    double additionalTax() {
        double basePrice = item.totalPrice() - item.totalTax();
        double additionalTax = (basePrice * 5) / 100;
        return additionalTax;
    }

    @Override
    public double totalTax() {
        return item.totalTax() + this.additionalTax();
    }

    @Override
    public double totalPrice() {
        System.out.println("additional tax " + this.additionalTax() + item.totalPrice());
        return item.totalPrice() + this.additionalTax();
    }

    @Override
    public String getName() {
        return this.item.getName();
    }

    @Override
    public double getPrice() {
        return this.getPrice();
    }

}
