package com.java.bootcamp.first_day;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {
    @Test
    @DisplayName("should return the area of rectangle as 6.6 ")
    public void testToCheckArea() throws Exception {
        Rectangle rectangle = new Rectangle(new Dimension(2.2),new Dimension(3));
        double actualArea = rectangle.calculateArea();
        double expected = 6.6;

        assertEquals(expected,actualArea,0.1);
    }

    @Test
    @DisplayName("should return the perimeter of rectangle ")
    public void testToCheckPerimeter() throws Exception {
        Rectangle rectangle = new Rectangle(new Dimension(2.2),new Dimension(3));
        double actualPerimeter = rectangle.calculatePerimeter();
        double expected = 10.4;

        assertEquals(expected,actualPerimeter,0.1);
    }

    @Test
    @DisplayName("should throw an exception ")
    public void testToCheckException(){
        assertThrows(Exception.class,()->new Dimension(-2).getValue());
    }

}