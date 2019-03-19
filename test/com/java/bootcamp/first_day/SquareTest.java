package com.java.bootcamp.first_day;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    @DisplayName("should return the area of square")
    void testToCheckArea() throws Exception {
        Dimension side = new Dimension(2);
        Square square = new Square(side.getValue());
        assertEquals(4, square.calculateArea());

    }

  @Test
    @DisplayName("should return the perimeter of square")
    void testToCheckPerimeter() throws Exception {
        Square square = new Square(new Dimension(2).getValue());
        assertEquals(8, square.calculatePerimeter());
    }

    @Test
    void shouldThrowError() {
        assertThrows(Exception.class,()->new Square(new Dimension(-2).getValue()));
    }
}