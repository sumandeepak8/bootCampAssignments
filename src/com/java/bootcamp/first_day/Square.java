package com.java.bootcamp.first_day;

public class Square implements Shape {
    private double side;

    Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return this.side * this.side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * this.side;
    }
}
