package com.java.bootcamp.first_day;

public class Rectangle implements Shape {
    private final Dimension width;
    private final Dimension length;

    public Rectangle(Dimension width, Dimension length) {
        this.width = width;
        this.length = length;
    }

    public double calculateArea() {
        return this.width.getValue() * this.length.getValue();
    }


    public double calculatePerimeter() {
        return 2 * (this.length.getValue() + this.width.getValue());
    }
}
