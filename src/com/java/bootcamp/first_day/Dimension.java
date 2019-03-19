package com.java.bootcamp.first_day;

public class Dimension {
    double value;

    public Dimension(double value) throws Exception{
        if(value < 0) throw new Exception("this is not valid value for this dimension");
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
