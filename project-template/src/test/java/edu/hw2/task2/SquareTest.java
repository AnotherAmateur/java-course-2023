package edu.hw2.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {
    Square square;

    @BeforeEach
    void setUp() {
        square = new Square(2);
    }

    @Test
    public void testSquareCtor() {
        assertEquals(2, square.width);
        assertEquals(2, square.height);
    }

    @Test
    public void testSquareArea() {
        assertEquals(4, square.area());
    }

    @Test
    public void testSquareSetWidth() {
        Rectangle newRectangle = square.setWidth(8);
        assertEquals(8, newRectangle.width);
        assertEquals(2, newRectangle.height);
    }

    @Test
    public void testSquareSetHeight() {
        Rectangle newRectangle = square.setHeight(8);
        assertEquals(2, newRectangle.width);
        assertEquals(8, newRectangle.height);
    }

    @Test
    public void testSquareSetSide() {
        Square newSquare = square.setSide(8);
        assertEquals(8, newSquare.width);
        assertEquals(8, newSquare.height);
    }
}
